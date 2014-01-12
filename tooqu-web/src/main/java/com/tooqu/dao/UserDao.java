/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao;

import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyParticipateRecord;
import com.tooqu.entity.Place;
import com.tooqu.entity.Report;
import com.tooqu.entity.User;
import com.tooqu.entity.UserAuthority;
import com.tooqu.entity.UserInfo;
import com.tooqu.entity.Visit;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface UserDao {
       

        public User getUserByUserInfo(UserInfo userInfo);

        public boolean   insertUserByUserInfo(UserInfo userInfo);//注册

        public User getUser(long userId);
        public User getUserById(long userId);//已经对user.follow_accompany初始化
        public User getUserByIdInitAlbumlocation(long userId);
        public User getUserByIdInitlocation(long userId);
        
        public User getUserByemail(String email);
        public UserInfo getUserInfoByQQ(String qq);
        public UserInfo getUserInfoByPhone(String phonenum);
    
       
        public boolean updateUser(User user);//也可用于申请高端趣友,旅游币操作
        public boolean updateUserInfo(UserInfo userInfo);//个人详细信息
  

        public List<User> getUserList(int type, int sex, Place place);
        public List<User> getUserList(int type, int sex, Place place,int start,int length);
        public List<UserInfo> getUserInfoList(Date DateFrom, Date DateTo, double heightFrom, double heightTo, String education, String job, String language, String passport, String license);
        public UserInfo getUserInfoByUid(long uid);
        public UserInfo getUserInfoByUserid(long userid);
         public User  getUserByIdInitialUserInfo(long uid);       
         public User  getUserByIdInitialArticleCommentList(long uid);       
         public User  getUserByIdInitialArticleList(long uid);
         public  List<User>  getAdvanceUserList(int start,int length);
        public boolean isExist(int type,int sex,Place place,long uid);
        
        public User getUserByIdInitialFollowAndFollowerList(long uid);
        public UserAuthority getUserAuthorityByUserId(long userid);
        
        
}
