/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.dao.GiftDao;
import com.tooqu.entity.Gift;
import com.tooqu.service.GiftService;

/**
 *
 * @author Administrator
 */
public class GiftServiceImpl implements GiftService{

    private GiftDao giftDao; 
    @Override
    public boolean insertGift(Gift gift) {
       return giftDao.insertGift(gift);
    }

    @Override
    public boolean deleteGift(Gift gift) {
       return giftDao.deleteGift(gift);
    }

    @Override
    public Gift getGiftByGid(long gid) {
       return giftDao.getGiftByGid(gid);
    }

    @Override
    public boolean updateGift(Gift gift) {
       return giftDao.updateGift(gift);
    }

    public void setGiftDao(GiftDao giftDao) {
        this.giftDao = giftDao;
    }
    
}
