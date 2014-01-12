/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.SendGiftDao;
import com.tooqu.dao.UserDao;
import com.tooqu.entity.Gift;
import com.tooqu.entity.SendGift;
import com.tooqu.entity.User;
import com.tooqu.service.SendGiftService;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class SendGiftServiceImpl implements SendGiftService{

    private SendGiftDao sendGiftDao;
    private UserDao userDao;
           
    @Override
    public String sendGift(long from, long to, Gift gift) {
        User fromUser = userDao.getUserById(from);
        User toUser = userDao.getUserById(to);
        if(gift.getPrice() > fromUser.getMoney())
            return "账户余额不足";
        fromUser.setMoney(fromUser.getMoney()-gift.getPrice());
        userDao.updateUser(fromUser);
        SendGift sendGift = new SendGift();
        sendGift.setFrom_user(fromUser);
        java.util.Date toDate=new java.util.Date();
        java.sql.Date sqlDate=new java.sql.Date(toDate.getTime());
        sendGift.setTime(sqlDate);
        sendGift.setContent("内容");
        sendGift.setTo_user(toUser);
        sendGift.setGift(gift);
        sendGiftDao.insertSendGift(sendGift);
        return "成功送出礼物'";
    }

    @Override
    public List<SendGift> getSendGiftBySender(long from) {
        List<SendGift> sendGiftList = new ArrayList<SendGift>();
        sendGiftList = sendGiftDao.getGiftListBySender(from);
        return sendGiftList;
    }

    @Override
    public List<SendGift> getSendGiftByReceiver(long to) {
        List<SendGift> sendGiftList = new ArrayList<SendGift>();
        sendGiftList = sendGiftDao.getGiftListByReceiver(to);
        return sendGiftList;
    }
    
    @Override
    public List<SendGift> getSendGiftBySender(long from,PageContext pageContext) {
        List<SendGift> sendGiftList = new ArrayList<SendGift>();
        sendGiftList = sendGiftDao.getGiftListBySender(from,pageContext.getStart(),pageContext.getLength());
        return sendGiftList;
    }

    @Override
    public List<SendGift> getSendGiftByReceiver(long to,PageContext pageContext) {
        List<SendGift> sendGiftList = new ArrayList<SendGift>();
        sendGiftList = sendGiftDao.getGiftListByReceiver(to,pageContext.getStart(),pageContext.getLength());
        return sendGiftList;
    }

    @Override
    public String sendMultiGift(long from, List<Long> toList, Gift gift) {
        User fromUser = userDao.getUserById(from);
        double totalPrice = (gift.getPrice()) * (toList.size());
        
        
        if(totalPrice > fromUser.getMoney())
            return "账户余额不足";
        fromUser.setMoney(fromUser.getMoney()-gift.getPrice());
        userDao.updateUser(fromUser);
        for(long to : toList){
            java.util.Date toDate=new java.util.Date();
            java.sql.Date sqlDate=new java.sql.Date(toDate.getTime());
            User toUser = userDao.getUserById(to);
            SendGift sendGift = new SendGift();
            sendGift.setFrom_user(fromUser);
            sendGift.setTime(sqlDate);
            sendGift.setContent("内容");
            sendGift.setTo_user(toUser);
            sendGift.setGift(gift);
            sendGiftDao.insertSendGift(sendGift);
        }
        return "成功送出礼物'";
    }
    
     public List<SendGift> getSendGifts(PageContext pageContext){
        List<SendGift> sendGiftList = new ArrayList<SendGift>();
        sendGiftList = sendGiftDao.getGiftList(pageContext.getStart(),pageContext.getLength());
        return sendGiftList;
     }
    
    public void setSendGiftDao(SendGiftDao sendGiftDao) {
        this.sendGiftDao = sendGiftDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
