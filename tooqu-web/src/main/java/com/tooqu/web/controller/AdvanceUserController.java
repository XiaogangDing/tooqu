/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.tooqu.entity.User;
import com.tooqu.service.UserService;
import com.tooqu.web.ControllerBase;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hao
 */
@Controller
public class AdvanceUserController extends ControllerBase{
     @Autowired
    private UserService userService;
     @RequestMapping(value = "/advanceUser", method = RequestMethod.GET)
     public String actionGetAdvanceUserListByPage(Model model, HttpServletResponse response) throws Exception {
         List<User> userlist=null;
         userlist=userService.getAdvanceUserByPage(getPageContext());
         model.addAttribute("advanceuserlist",userlist);
         return "advance-user";
     }
     
     
}
