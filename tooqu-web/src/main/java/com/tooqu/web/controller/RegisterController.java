/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.google.code.kaptcha.Constants;
import com.tooqu.encryption.MD5;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;
import com.tooqu.mailer.LocalMailSender;
import com.tooqu.service.PlaceService;
import com.tooqu.service.UserService;
import com.tooqu.web.ControllerBase;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Dxg
 */
@Controller
public class RegisterController extends ControllerBase {
    
    private static String EMAIL_ACTIVE_URL = "http://localhost:8084/tooqu/checkEmail";
    
    private MimetypesFileTypeMap mime = new MimetypesFileTypeMap();
    @Autowired
    private UserService userService;
    @Autowired
    private PlaceService placeService;
    
    private LocalMailSender mailSender;
    
    @Autowired
    public void setMailSender(LocalMailSender mailSender) {
        this.mailSender = mailSender;
    }
        

    @RequestMapping(value = "/jumpToRegister", method = RequestMethod.GET)
    public String actionJumpToRegister(Model model, HttpServletResponse response) throws Exception {
        return "register-step1";
    }
    @RequestMapping(value = "/testUpload", method = RequestMethod.GET)
    public String actionTestUpload(Model model, HttpServletResponse response) throws Exception {
        model.addAttribute("target", "/register/43/upload");
        return "file-upload";
    }

    @RequestMapping(value = "/registerStep1", method = RequestMethod.POST)
    public String actionCreateUser(Model model, HttpServletResponse response) throws Exception {
        //检验验证码
        String userCheckword = request.getParameter("checkword");
        String trueWord = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();

        if (!userCheckword.equals(trueWord)) {
            model.addAttribute("msg", "验证码不符!");
            return "register-step1";
        } else {
            String email = request.getParameter("email");
            if (userService.getUserByEmail(email) != null) {
                model.addAttribute("msg", "该邮箱已存在!");
                return "register-step1";
            }

            int type = Integer.parseInt(request.getParameter("type"));
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            password = MD5.encryption(password);

            User u = userService.createUser(type, email, name, password);
            request.getSession().setAttribute("user_id", u.getUserId());
        }
        return "register-step2";
    }

    @RequestMapping(value = "/registerStep2", method = RequestMethod.POST)
    public String actionDetailUserInfo(Model model, HttpServletResponse response) throws Exception {
        long userId = Long.parseLong(request.getSession().getAttribute("user_id").toString());

        String qq = request.getParameter("qq");
        if (userService.getUserByQQ(qq) != null) {
            model.addAttribute("msg", "该QQ/Skipe/雅虎通已存在!");
            return "register-step2";
        }
        String phonenum = request.getParameter("phonenum");
        if (userService.getUserByPhone(phonenum) != null) {
            model.addAttribute("msg", "该电话已存在!");
            return "register-step2";
        }

        int sex = Integer.parseInt(request.getParameter("sex"));
        Date birthday = strToDate(request.getParameter("year"), request.getParameter("month"), request.getParameter("day"));
        //String portrait = request.getParameter("portrait");

        Place temp = new Place();
        temp.setCountry(request.getParameter("country"));
        temp.setProvince(request.getParameter("province"));
        temp.setCity(request.getParameter("city"));
        temp.setCounty(request.getParameter("county"));
        Place location = placeService.findPlaceByPlace(temp);

        String hometown = request.getParameter("hometown");
        double height = Double.parseDouble(request.getParameter("height"));
        String education = request.getParameter("education");
        String job = request.getParameter("job");
        String user_language = request.getParameter("user_language");
        String intro = request.getParameter("intro");

        String passport = request.getParameter("passport");
        String license = request.getParameter("license");

        userService.setUserAttribute(userId, sex, birthday, location, hometown,
                height, education, job, user_language, intro, qq, phonenum, passport, license);

        //logger.debug("++++++++++++++" + userId);
        model.addAttribute("userId", userId);
        return "register-image-upload";
    }

    @RequestMapping(value = "/register/{userId}/upload", method = RequestMethod.POST)
    public String actionUploadPhoto(@PathVariable("userId") long userId, @RequestParam("file") MultipartFile file,
     HttpServletResponse response) throws IOException {
        
        
        if (file == null || file.isEmpty()) {
            response.getWriter().append("No file uploaded!!!");
        }
        try {
            if (!file.isEmpty()) {
                File destfile = new File(String.format("/tmp/user-photo/"+userId+"/%d.jpg", System.currentTimeMillis()));
                String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                if (suffix.equalsIgnoreCase(".jpg")) {
                    String portrait=destfile.getAbsolutePath();
                    User u=userService.getUserById(userId);
                    u.setPortrait(portrait);
                    userService.updateUser(u);
                    destfile.getParentFile().mkdirs();
                    file.transferTo(destfile);
                    response.getWriter().append("/tmp/user-photo/"+userId +"/" + destfile.getName());
                } else {
                    response.getWriter().append("incorrect format!");
                }
            } else {
                response.getWriter().append("unknow error!");
            }
        } catch (Exception e) {
            logger.debug(e);
        }
        return null;
    }
    

    @RequestMapping(value = "/register/uploaded/catch", method = RequestMethod.GET)
    public String actionGetUploadedImage(HttpServletResponse response) throws IOException {
        String desdir = (String) request.getParameter("imagePath");
        File tempFile = new File(desdir);
        logger.debug("=========" + desdir + tempFile.exists()+ tempFile.isFile()+ (tempFile !=null)+ "--");
        if (tempFile != null && tempFile.exists() && tempFile.isFile()) {
            setCacheSeconds(0);
            setUseCacheControlNoStore(true);
            response.setContentType(mime.getContentType(tempFile));
            FileUtils.copyFile(tempFile, response.getOutputStream());
        } else {
            response.sendError(404);
        }
        return null;
    }
    
    @RequestMapping(value = "/emailActive", method = RequestMethod.GET)
    public String actionEmailActive(Model model, HttpServletResponse response) throws Exception {
        long userId = Long.parseLong(request.getSession().getAttribute("user_id").toString());
        User user = userService.getUserById(userId);
        String email = user.getEmail();


        //发邮件
        String uuid = UUID.randomUUID().toString();
        user.setUUID(uuid);
        userService.updateUser(user);
        
        EMAIL_ACTIVE_URL = EMAIL_ACTIVE_URL + "?UUID=" + uuid + "&email=" + email;

        mailSender.sendHtml("noreply@tooqu.com", email, "途趣网账号激活", "<a href='" + EMAIL_ACTIVE_URL + "'>激活账号</a>");

        return "email-active";
    }
    
    
    
    @RequestMapping(value = "/checkEmail", method = RequestMethod.GET)
    public String actionCheckEmail(Model model, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        User user = userService.getUserByEmail(email);

        String uuid = request.getParameter("UUID");
        if (user.getUUID().equals(uuid)) {
            user.setIsActive(true);
            //防止多次篡改
            user.setUUID("");
            userService.updateUser(user);
            request.getSession().setAttribute("user_id", user.getUserId());
            return "register-success";
        }
        model.addAttribute("msg", "账号不匹配，修改失败！");
        return "login";
    }
    
}
