/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Gift;
import com.tooqu.entity.SendGift;
import com.tooqu.entity.User;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface SendGiftDao {

    /**
     * 插入一条赠送礼物的记录
     * @param sendgift
     * 赠送礼物的记录
     * @return 
     * 操作成功与否
     */
    public boolean insertSendGift(SendGift sendgift);
    
    /**
     * 删除一条赠送礼物的记录
     * @param sendgift
     * 赠送礼物的记录
     * @return 
     * 操作成功与否
     */
    public boolean delete(SendGift sendgift);
    
    /**
     * 根据送出礼物的用户搜索其送出的礼物
     * @param from
     * 送出礼物的用户
     * @return 
     * 送出的礼物列表
     */
    public List<SendGift> getGiftListBySender(long from);
    
    /**
     *根据收到礼物的用户搜索其受到的礼物
     * @param to
     * 收到礼物的用户ID
     * @return 
     * 收到礼物的列表
     */
    public List<SendGift> getGiftListByReceiver(long to);
    
    /**
     * 根据送出礼物的用户搜索其送出的礼物
     * @param from
     * 送出礼物的用户
     * @param start
     * 起始位置
     * @param length
     * 数据长度
     * @return 
     * 送出的礼物列表
     */
    public List<SendGift> getGiftListBySender(long from,int start, int length);
    
    /**
     *根据收到礼物的用户搜索其受到的礼物
     * @param to
     * 收到礼物的用户ID
     * @param start
     * 起始位置
     * @param length
     * 数据长度
     * @return 
     * 收到礼物的列表
     */
    public List<SendGift> getGiftListByReceiver(long to,int start,int length);
    /**
     * 获取礼物列表
     * @param start
     * @param length
     * @return 
     */
    public List<SendGift> getGiftList(int start,int length);
}
