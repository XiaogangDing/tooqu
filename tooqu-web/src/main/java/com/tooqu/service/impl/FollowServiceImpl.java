/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.UserDao;
import com.tooqu.dao.impl.UserDaoImpl;
import com.tooqu.entity.User;
import com.tooqu.service.FollowService;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class FollowServiceImpl implements FollowService{

    private Logger log = Logger.getLogger(FollowServiceImpl.class);
    
    UserDao userDao;
    @Override
    public boolean addFollow(long followerId, long followId) {
        User follower = userDao.getUserByIdInitialFollowAndFollowerList(followerId);
        User follow = userDao.getUserByIdInitialFollowAndFollowerList(followId);
        log.info("进入添加关注服务");
        for(User u : follower.getFollowlist()){
           if(u.getUserId() == follow.getUserId())
              return false;
       }
        for(User u : follow.getFollowerlist()){
           if(u.getUserId() == follower.getUserId())
              return false;
       }
        boolean gz = follower.getFollowlist().add(follow);
        boolean bgz = follow.getFollowerlist().add(follower);
        log.info("进入添加关注服务 "+gz+bgz);
        boolean updateFollower = userDao.updateUser(follower);
        return gz && bgz && updateFollower;
    }

    @Override
    public boolean cancelFollow(long followerId, long followId) {
        User follower = userDao.getUserByIdInitialFollowAndFollowerList(followerId);
        User follow = userDao.getUserByIdInitialFollowAndFollowerList(followId);
        log.info("进入取消关注服务");
        User removeFollow = null;
        User removeFollower = null;
         for(User u : follower.getFollowlist()){
               if(u.getUserId() == follow.getUserId())
                   removeFollow = u;
         }
         for(User u : follow.getFollowerlist()){
               if(u.getUserId() == follower.getUserId())
                  removeFollower = u;
         }
        boolean qxgz = follower.getFollowlist().remove(removeFollow);
        boolean bqxgz = follow.getFollowerlist().remove(removeFollower);
        log.info("进入取消关注服务 "+qxgz);
        boolean updateFollower = userDao.updateUser(follower);
        return qxgz && bqxgz && updateFollower;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean addFollowers(long followerId, List<Long> followIds) {
        //User follower = userDao.getUserByIdInitialFollowAndFollowerList(followerId);
        //List<User> follows = new ArrayList<User>();
        for(long id : followIds){
            //User follow = userDao.getUserByIdInitialFollowAndFollowerList(id);
            addFollow(followerId, id);
        }
        return true;
    }

    @Override
    public boolean cancelFollowers(long followerId, List<Long> followIds) {
        for(long followId : followIds){
            cancelFollow(followerId, followId);
        }
        return true;    
    }

    @Override
    public List<User> getFollowerListByFollowId(long followId) {
        User follow = userDao.getUserByIdInitialFollowAndFollowerList(followId);
        return follow.getFollowerlist();
    }

    @Override
    public List<User> getFollowListByFollowerId(long followerId) {
       User follower = userDao.getUserByIdInitialFollowAndFollowerList(followerId);
        return follower.getFollowlist();
    }
    
        @Override
    public List<User> getFollowerListByFollowId(long followId,PageContext pageContext) {
        User follow = userDao.getUserByIdInitialFollowAndFollowerList(followId);
        return follow.getFollowerlist().subList(pageContext.getStart(), pageContext.getStart()+pageContext.getLength());
    }

    @Override
    public List<User> getFollowListByFollowerId(long followerId,PageContext pageContext) {
       User follower = userDao.getUserByIdInitialFollowAndFollowerList(followerId);
        return follower.getFollowlist().subList(pageContext.getStart(), pageContext.getStart()+pageContext.getLength());
    }
}
