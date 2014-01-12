/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Message;
import com.tooqu.entity.User;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface MessageDao {

    public List<Message> getSentMessageListByPage(Long userId, int start, int length);

    public List<Message> getReceiveMessageListByPage(Long userId, int start, int length);

    public boolean insertMessage(Message m);

    public Message getMessage(Message m);

    public Message getMessageById(long mid);

    public boolean deleteMessage(Message m);

    public boolean deleteMessage(List<Message> msgList);

    public List<Message> getMySentMessageList(Long userId);

    public List<Message> getMyReceiveMessageList(Long userId);

   
        
}
