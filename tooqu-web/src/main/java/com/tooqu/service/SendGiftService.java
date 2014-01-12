/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.Gift;
import com.tooqu.entity.SendGift;
import java.util.List;

/**
 *赠送礼物的服务
 * @author Administrator
 */
public interface SendGiftService {
    /**
     * 送出一个礼物
     * @param from
     * 赠送者
     * @param to
     * 接收者
     * @param gift
     * 礼物
     * @return 
     * 赠送礼物操作信息
     */
    public String sendGift(long from,long to,Gift gift);
    
    /**
     * 送出多个礼物
     * @param from
     * 赠送者
     * @param toList
     * 接收者列表
     * @param gift
     * 礼物
     * @return 
     * 赠送礼物操作信息
     */
    public String sendMultiGift(long from,List<Long> toList,Gift gift);
    
    /**
     * 获得某用户赠送出去的礼物
     * @param from
     * 用户
     * @return
     * 赠送礼物列表
     */
    public List<SendGift> getSendGiftBySender(long from);
    
    /**
     * 获得某个用户收到的礼物列表
     * @param to
     * 用户
     * @return 
     * 收到礼物列表
     */
    public List<SendGift> getSendGiftByReceiver(long to);
    
        /**
     * 获得某用户赠送出去的礼物
     * @param from
     * 用户
     * @return
     * 赠送礼物列表
     */
    public List<SendGift> getSendGiftBySender(long from,PageContext pageContext);
    
    /**
     * 获得某个用户收到的礼物列表
     * @param to
     * 用户
     * @return 
     * 收到礼物列表
     */
    public List<SendGift> getSendGiftByReceiver(long to,PageContext pageContext);
    
    /**
     * 获取礼物列表
     * @param pageContext
     * @return 
     */
    public List<SendGift> getSendGifts(PageContext pageContext);
    
}
