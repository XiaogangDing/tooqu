/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.tooqu.entity.Gift;
import com.tooqu.entity.SendGift;
import com.tooqu.entity.User;
import com.tooqu.service.FollowService;
import com.tooqu.service.GiftService;
import com.tooqu.service.SendGiftService;
import com.tooqu.service.UserService;
import com.tooqu.web.json.ResponseBuilder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Controller
public class FollowController {
    @Autowired
    FollowService followService;
    @Autowired
    UserService userService;
    @Autowired
    SendGiftService sendGiftService;
    @Autowired
    GiftService giftService;
    
    @RequestMapping(value="/Follow",method=RequestMethod.GET)
    public String testFollowService(){
        ResponseBuilder rb = new ResponseBuilder();

        return "follow";
    }
    @RequestMapping(value = "/sendMultiGifts", method = RequestMethod.POST)
    public String sendMultiGifts(HttpServletRequest request,
                    HttpServletResponse response, ModelMap model){
        return "pop/information";
    }
    
    @RequestMapping(value = "/addFollow", method = RequestMethod.POST)
    public String addFollow(HttpServletRequest request,
                    HttpServletResponse response, ModelMap model){
        
        return "pop/information";
    }
    
    @Autowired
    public void setFollowService(FollowService followService) {
        this.followService = followService;
    }
    @Autowired
    public void setUserSercie(UserService userService) {
        this.userService = userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setSendGiftService(SendGiftService sendGiftService) {
        this.sendGiftService = sendGiftService;
    }

    public void setGiftService(GiftService giftService) {
        this.giftService = giftService;
    }
    
}
