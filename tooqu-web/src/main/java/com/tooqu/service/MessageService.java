/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.Message;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface MessageService {

    public List<Message> getSentMessageListByPage(Long userId, PageContext pageContext);

    public List<Message> getReceiveMessageListByPage(Long userId, PageContext pageContext);

    public long createMessage(Long userId, String content,Long toUserId);

    public Message getMessageById(long addResult);

    public boolean deleteMessage(long mid);

    public boolean deleteMessage(List<Long> midList);

    public boolean emptyMySentMessage(Long userId);

    public boolean emptyMyReceiveMessage(Long userId);

    public List<Message> getSentMessageList(Long userId);

    public List<Message> getReceiveMessageList(Long userId);
    
}
