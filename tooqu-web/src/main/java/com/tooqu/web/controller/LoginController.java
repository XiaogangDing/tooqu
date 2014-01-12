/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.tooqu.encryption.MD5;
import com.tooqu.entity.User;
import com.tooqu.mailer.LocalMailSender;
import com.tooqu.service.UserService;
import com.tooqu.web.ControllerBase;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dxg
 */
@Controller
public class LoginController extends ControllerBase {
    private static String GETBACK_PASSWORD_URL="http://localhost:8084/tooqu/getBackPassword";
    
    @Autowired
    private UserService userService;
    
    private LocalMailSender mailSender;
    
    @Autowired
    public void setMailSender(LocalMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    @RequestMapping(value = "/jumpToLogin", method = RequestMethod.GET)
    public String actionJumpToLogin(Model model, HttpServletResponse response) throws Exception {
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String actionLogout(Model model, HttpServletResponse response) throws Exception {
        request.getSession().removeAttribute("user_id");
        request.getSession().removeAttribute("user_name");
        request.getSession().removeAttribute("user_photo");
        request.getSession().setAttribute("status", "logout");
        request.getSession().removeAttribute("pre_page");
        return "homepage";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String actionLogin(Model model, HttpServletResponse response) throws Exception {

        String email = request.getParameter("email");
        User user = userService.getUserByEmail(email);

        if (user == null) {
            model.addAttribute("msg", "账号不存在！");
            return "login";
        }

        String password = request.getParameter("password");
        password=MD5.encryption(password);

        if (!password.equals(user.getPassword())) {
            model.addAttribute("msg", "密码错误！");
            return "login";
        }
        if(!user.isIsActive()) {
             model.addAttribute("msg", "账号未激活！");
            return "login";
        
        }

        request.getSession().setAttribute("user_id", user.getUserId());
        request.getSession().setAttribute("user_name", user.getName());
        request.getSession().setAttribute("user_photo", user.getPortrait());
        request.getSession().setAttribute("status", "login");
        if(request.getSession().getAttribute("pre_page")==null||request.getSession().getAttribute("pre_page")=="")
        return "homepage";
        else 

            return request.getSession().getAttribute("pre_page").toString();
        
    }
    
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.GET)
    public String actionPassword(Model model, HttpServletResponse response) throws Exception {
        return "";
    }
    
    @RequestMapping(value = "/getBackPassword", method = RequestMethod.POST)
    public String actionGetPassword(Model model, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        User user = userService.getUserByEmail(email);

        if (user != null) {
            //发邮件
            String uuid=UUID.randomUUID().toString();
            user.setUUID(uuid);
            userService.updateUser(user);
            
            GETBACK_PASSWORD_URL=GETBACK_PASSWORD_URL+"?UUID="+uuid+"&email="+email;
            
            mailSender.sendHtml("noreply@tooqu.com", email, "途趣网密码修改", "<a href='"+GETBACK_PASSWORD_URL+"'>重置密码</a>");
            
        }
        model.addAttribute("msg", "已发送信息至指定邮箱。");
        return "login";
    }
    
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String actionChangePassword(Model model, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        User user = userService.getUserByEmail(email);

        String uuid = request.getParameter("uuid");
        if (user.getUUID().equals(uuid)) {
            String newPswd = request.getParameter("password");
            user.setPassword(newPswd);

            //防止多次篡改
            user.setUUID("");
            userService.updateUser(user);
            model.addAttribute("msg", "密码已修改。");
            request.getSession().setAttribute("user_id", user.getUserId());
            return "homepage";
        }
        model.addAttribute("msg", "账号不匹配，修改失败！");
        return "login";
    }
    
}
