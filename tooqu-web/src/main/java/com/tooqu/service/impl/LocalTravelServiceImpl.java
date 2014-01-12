/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.LocalTravelDao;
import com.tooqu.dao.UserDao;
import com.tooqu.entity.LocalTravel;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;
import com.tooqu.service.LocalTravelService;
import java.util.List;

/**
 *
 * @author Dxg
 */
public class LocalTravelServiceImpl implements LocalTravelService{
    
    private LocalTravelDao localTravelDao;
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public LocalTravelDao getLocalTravelDao() {
        return localTravelDao;
    }

    public void setLocalTravelDao(LocalTravelDao localTravelDao) {
        this.localTravelDao = localTravelDao;
    }

    @Override
    public List<LocalTravel> getLocalTravelListByPage(PageContext page) {
        return localTravelDao.listLocalTravelByPage(page.getStart(), page.getLength());
    }

    @Override
    public LocalTravel findLocalTravelById(long lctrvId) {
        return localTravelDao.getLocalTravelById(lctrvId);//需要对Userlist 初始化
    }

    @Override
    public boolean createLocalTravel(long userId, String title, int maxpeople, int vehicletype, int feetype, Place place, String arrangement, String notice, String bookrule) {
        LocalTravel lctrvl=new LocalTravel();
        User user=userDao.getUserById(userId);
        lctrvl.setCreator(user);
        lctrvl.setTitle(title);
        lctrvl.setMaxpeople(maxpeople);
        lctrvl.setVehicletype(vehicletype);
        lctrvl.setFeetype(feetype);
        lctrvl.setPlace(place);
        lctrvl.setArrangement(arrangement);
        lctrvl.setNotice(notice);
        lctrvl.setBookrule(bookrule);
        
        return localTravelDao.insertLocalTravel(lctrvl);
        
    }   

    @Override
    public boolean deleteLocalTravel(LocalTravel lctrv) {
        return localTravelDao.deleteLocalTravel(lctrv);
    }

    @Override
    public boolean modifyLocalTravel(long lctrvId, String title, int maxpeople, int vehicletype, int feetype, Place place, String arrangement, String notice, String bookrule) {
        LocalTravel lctrvl=localTravelDao.getLocalTravelById(lctrvId);
        lctrvl.setTitle(title);
        lctrvl.setMaxpeople(maxpeople);
        lctrvl.setVehicletype(vehicletype);
        lctrvl.setFeetype(feetype);
        lctrvl.setPlace(place);
        lctrvl.setArrangement(arrangement);
        lctrvl.setNotice(notice);
        lctrvl.setBookrule(bookrule);
        
        return localTravelDao.updateLocalTravel(lctrvl);
    }
    
}   
