/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.tooqu.encryption.MD5;
import com.tooqu.entity.Album;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;
import com.tooqu.entity.UserAuthority;
import com.tooqu.entity.UserInfo;
import com.tooqu.service.AlbumService;
import com.tooqu.service.PlaceService;
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
 * @author Dxg
 */
@Controller
public class PersonalCenterController extends ControllerBase {
    @Autowired
    private UserService userService;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private PlaceService placeService;
    
    @RequestMapping(value = "/modifyPersonalInfo", method = RequestMethod.GET)
    public String actionJumpToModifyPersonalInfo(Model model, HttpServletResponse response) throws Exception {
         long theUserId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
         
         User user=userService.getUserById(theUserId);
         model.addAttribute("user", user);
         
         List<Album> myalbum=albumService.listAlbumByUser(theUserId);
         model.addAttribute("myalbum", myalbum);
         
         Place location=userService.getUserByIdInitlocation(theUserId).getLocation();
         model.addAttribute("location", location);
         
         UserInfo ui=userService.getUserInfoByUserId(theUserId);
         model.addAttribute("userinfo", ui);
        
         UserAuthority ua=userService.getUserAuthorityByUserId(theUserId);
         model.addAttribute("userauthority", ua);

         return "";
    }
    
     @RequestMapping(value = "/modifyPersonalInfo/baseInfo", method = RequestMethod.POST)
     public String ajaxmodifyBaseInfo(Model model, HttpServletResponse response) throws Exception {
         long theUserId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
         
         String province=request.getParameter("province");
         String city=request.getParameter("city");
         String county=request.getParameter("county");
         Place location=placeService.findPlaceByProvinceCityCounty(province,city,county);
         String job=request.getParameter("job");
         String language=request.getParameter("language");
         String license=request.getParameter("license");
         String passport=request.getParameter("passport");
         String selfintro=request.getParameter("intro");
         String phonenum=request.getParameter("phonenum");
         String qq=request.getParameter("qq");
         
         if(userService.updateUserByBaseInfo(theUserId,location,job,language,license,passport,selfintro,phonenum,qq))         
             return ajaxResponse("OK");
         else 
             return ajaxResponse("修改失败!");
     }
    
     @RequestMapping(value = "/modifyPersonalInfo/password", method = RequestMethod.POST)
     public String ajaxmodifyPassword(Model model, HttpServletResponse response) throws Exception {
         long theUserId=Long.parseLong(request.getSession().getAttribute("user_id").toString());
         User user=userService.getUserById(theUserId);
         
         String password=request.getParameter("raw_password");
         password=MD5.encryption(password);

        if (!password.equals(user.getPassword())) {
            //model.addAttribute("msg", "密码错误！");
            return ajaxResponse("密码错误!");
        }
        String newpassword=request.getParameter("new_password");
        newpassword=MD5.encryption(newpassword);
         
         if(userService.updateUserByPwd(theUserId,newpassword))
             return ajaxResponse("OK");
         else 
             return ajaxResponse("修改失败!");
     }
     
     @RequestMapping(value = "/OthersInfo", method = RequestMethod.GET)
     public String actionOthersInfo(Model model, HttpServletResponse response) throws Exception {
         long theUserId=Long.parseLong(request.getParameter("other_user_id").toString());
         
         User user=userService.getUserById(theUserId);
         model.addAttribute("user", user);
         
         List<Album> myalbum=albumService.listAlbumByUser(theUserId);
         model.addAttribute("myalbum", myalbum);
         
         Place location=userService.getUserByIdInitlocation(theUserId).getLocation();
         model.addAttribute("location", location);
         
         UserInfo ui=userService.getUserInfoByUserId(theUserId);
         model.addAttribute("userinfo", ui);
        
         UserAuthority ua=userService.getUserAuthorityByUserId(theUserId);
         model.addAttribute("userauthority", ua);

         return "";
    }
     
}
