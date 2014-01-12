/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.User;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface FollowService {
    /**
     * 关注服务，增加对于某个人的关注
     * @param follower
     * 执行关注的主体，关注者
     * @param follow
     * 被关注者
     * @return 操作是否成功
     */
    public boolean addFollow(long follower , long follow);
    
    /**
     * 取消关注服务，取消对于某个人的关注
     * @param follower
     * 取消关注者
     * @param follow
     * 被取消关注者
     * @return 操作是否成功
     */
    public boolean cancelFollow(long follower ,  long follow);
    
    /**
     * 批量关注服务，提供对某些人的进行批量关注
     * @param followerId
     * 关注者ID
     * @param followIds
     * 被关注者的ID列表
     * @return 
     * 操作是否成功
     */
    public boolean addFollowers(long followerId , List<Long> followIds);
    
    /**
     * 批量取消关注服务，提供对某些人的进行批量取消关注
     * @param followerId
     * 关注者ID
     * @param followIds
     * 被取消关注者的ID列表
     * @return 
     * 操作是否成功
     */
    public boolean cancelFollowers(long followerId , List<Long> followIds);
  
        /**
     * 根据被关注着获取所有的关注者（获取某人的粉丝）
     * @param followId
     * 被关注者ID
     * @param pageContext
     * 分页
     * @return 
     * 关注者列表
     */
    public List<User> getFollowerListByFollowId(long followId ,PageContext pageContext);
    
    /**
     * 根据关注者获得其关注的用户
     * @param followerid
     * 关注者ID
     * @param pageContext
     * 分页
     * @return 
     * 被关注者列表
     */
    public List<User> getFollowListByFollowerId(long followerid,PageContext pageContext);
    /**
     * 根据被关注着获取所有的关注者（获取某人的粉丝）
     * @param followId
     * 被关注者ID
     * @return 
     * 关注者列表
     */
    public List<User> getFollowerListByFollowId(long followId);
    
    /**
     * 根据关注者获得其关注的用户
     * @param followerid
     * 关注者ID
     * @return 
     * 被关注者列表
     */
    public List<User> getFollowListByFollowerId(long followerid);
}
