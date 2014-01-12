/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.MessageDao;
import com.tooqu.dao.UserDao;
import com.tooqu.entity.Message;
import com.tooqu.service.MessageService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dxg
 */
public class MessageServiceImpl implements MessageService{
    private MessageDao  messageDao;
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<Message> getSentMessageListByPage(Long userId, PageContext pageContext) {
        return messageDao.getSentMessageListByPage(userId,pageContext.getStart(),pageContext.getLength());
    }

    @Override
    public List<Message> getReceiveMessageListByPage(Long userId, PageContext pageContext) {
        return messageDao.getReceiveMessageListByPage(userId,pageContext.getStart(),pageContext.getLength());
    }

    @Override
    public long createMessage(Long userId, String content,Long toUserId) {
        java.util.Date toDate = new java.util.Date();
        Date sqlDate=new Date(toDate.getTime());
        
        Message m=new Message();
        m.setContent(content);
        m.setSendtime(sqlDate);
        m.setFrom(userDao.getUserById(userId));
        m.setTo(userDao.getUserById(toUserId));
        
        boolean insertResult=messageDao.insertMessage(m);
        if(!insertResult) return 0;
        Message newMessage =messageDao.getMessage(m);
        return newMessage.getMid();
    }

    @Override
    public Message getMessageById(long mid) {
        return messageDao.getMessageById(mid);
    }

    @Override
    public boolean deleteMessage(long mid) {
        Message m=messageDao.getMessageById(mid);
        return messageDao.deleteMessage(m);
    }

    @Override
    public boolean deleteMessage(List<Long> midList) {
        int i =0;
        List<Message> msgList=new ArrayList<Message>();
        Message m;
        while(midList.size()>i){
            long mid=midList.get(i);
            m =messageDao.getMessageById(mid);
            msgList.add(m);
            i++;
        }
       
        return messageDao.deleteMessage(msgList);
    }

    @Override
    public boolean emptyMySentMessage(Long userId) {
        List<Message> msgList=messageDao.getMySentMessageList(userId);
        return messageDao.deleteMessage(msgList);
        
    }

    @Override
    public boolean emptyMyReceiveMessage(Long userId) {
        List<Message> msgList=messageDao.getMyReceiveMessageList(userId);
        return messageDao.deleteMessage(msgList);
    }

    @Override
    public List<Message> getSentMessageList(Long userId) {
        return messageDao.getMySentMessageList(userId);
    }

    @Override
    public List<Message> getReceiveMessageList(Long userId) {
        return messageDao.getMyReceiveMessageList(userId);
    }
    
}
