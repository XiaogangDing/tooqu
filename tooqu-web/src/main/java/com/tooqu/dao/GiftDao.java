/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Gift;

/**
 *
 * @author Administrator
 */
public interface GiftDao {
   /**
    * 增加一个礼物
    * @param gift
    * 礼物
    * @return 
    * 新增操作成功与否
    */
    
    public boolean insertGift(Gift gift);
    /**
     * 删除一个礼物
     * @param gift
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
     * @return 
     */
    public boolean updateGift(Gift gift);
}
