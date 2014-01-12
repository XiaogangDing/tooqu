/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.entity.Gift;

/**
 *
 * @author Administrator
 */
public interface GiftService {
    public boolean insertGift(Gift gift);
    /**
     * 删除一个礼物
     * @param 
     * 礼物
     * @return
     * 删除操作成功与否
     */
    public boolean deleteGift(Gift gift);
    
    /**
     * 根据礼物的ID获取礼物
     * @param gid
     * 礼物ID
     * @return 
     * 礼物
     */
    public Gift getGiftByGid(long gid);
    
     /**
     * 更新礼物的信息
     * @param gift
     * 礼物
     * @return 
     * 删除操作成功与否
     */
    public boolean updateGift(Gift gift);
}
