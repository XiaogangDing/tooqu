/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.AccompanyDao;
import com.tooqu.dao.PlaceDao;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.Place;
import com.tooqu.service.AccompanyService;
import java.util.List;

/**
 *
 * @author Dxg
 */
public class AccompanyServiceImpl implements AccompanyService{


    private AccompanyDao accompanyDao;
    private PlaceDao placeDao;

    public PlaceDao getPlaceDao() {
        return placeDao;
    }

    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }
    public AccompanyDao getAccompanyDao() {
        return accompanyDao;
    }

    public void setAccompanyDao(AccompanyDao accompanyDao) {
        this.accompanyDao = accompanyDao;
    }

    @Override
    public List<Accompany> getSearchAccompanyByPage(Place from, Place to, PageContext page) {
       return accompanyDao.listAccompanyByPlace(from, to, page.getStart(), page.getLength());
    }

    @Override
    public List<Accompany> getExistAccompanyList(Place from, Place to) {
        return accompanyDao.listAccompanyByPlace(from, to, 0,20);
    }
    @Override
    public boolean addAccompany(Accompany ac){

        return accompanyDao.insertAccompany(ac);
    }
    @Override
    public Accompany findAccompanyByAccompany(Accompany ac) {
       return accompanyDao.getAccompany(ac);
    }

    @Override
    public List<Accompany> getAccompanyListByPage(PageContext page) {
       return accompanyDao.listAccompanyByPage(page.getStart(), page.getLength());
    }

    @Override
    public Accompany findAccompanyById(long ac_id) {
        return accompanyDao.getAccompanyById(ac_id);//需要对Userlist 初始化
    }

    @Override
    public boolean deleteAccompany(Accompany ac) {
        return accompanyDao.deleteAccompany(ac);
    }

    @Override
    public boolean containUser(long accId, long userId) {
        boolean result=false;
        Accompany accompany=accompanyDao.getAccompanyById(accId);
        for(int i=0;i<accompany.getUserlist().size();++i)
            if(accompany.getUserlist().get(i).getUserId()==userId)
                result=true;
        return result;
    }

    @Override
    public boolean modifyAccompany(Accompany temp) {
       return accompanyDao.updateAccompany(temp);
    }

    @Override
    public long getAccompanyId(Accompany temp) {
        Accompany acc= accompanyDao.getAccompany(temp);
        return acc.getAid();
    }
    
    
    
    
}
