/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.web.controller;

import com.tooqu.entity.Gift;
import com.tooqu.service.GiftService;
import com.tooqu.service.SendGiftService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Controller
public class SendGiftController {
    private SendGiftService sendGiftService;
    private GiftService giftService;
    
    @RequestMapping(value = "/sendMultiGifts.aj", method = RequestMethod.POST)
    public String sendMultiGifts(HttpServletRequest request,
                    HttpServletResponse response, ModelMap model){
        long fromUser = Long.parseLong(request.getParameter("from"));
        String to = request.getParameter("to");
        String []toUsersStr = to.split(",");
        List<Long> toUsers = new ArrayList<Long>();
        for(String s : toUsersStr){
            long to_user = Long.parseLong(s);
            toUsers.add(to_user);
        }
        long gid = Long.parseLong(request.getParameter("gid"));
        Gift gift = giftService.getGiftByGid(gid);
        String information = sendGiftService.sendMultiGift(fromUser, toUsers, gift);
        model.addAttribute("information", information);
        return "pop/information";
    } 
    @RequestMapping(value = "/sendGift", method = RequestMethod.POST)
    public String sendGift(HttpServletRequest request,
                    HttpServletResponse response, ModelMap model) throws Exception {
        long Uid=Long.parseLong(request.getSession().getAttribute("user_id").toString());
        long from_user = Long.parseLong(request.getParameter("from"));
        long to_user = Long.parseLong(request.getParameter("to"));
        long gid = Long.parseLong(request.getParameter("gid"));
        Gift gift = giftService.getGiftByGid(gid);
        String information = sendGiftService.sendGift(from_user, to_user, gift);
        model.addAttribute("information", information);
        return "pop/information";
    }      
}
