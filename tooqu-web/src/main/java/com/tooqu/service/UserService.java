/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service;

import com.tooqu.common.dao.PageContext;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;
import com.tooqu.entity.UserAuthority;
import com.tooqu.entity.UserInfo;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Dxg
 */
public interface UserService {
    public User getUserById(long id);
    public User getUserByIdInitAlbumlocation(long id);
    public User getUserByIdInitlocation(long id);
    
    public User createUser(int type,String email,String name,String password);
    
    public void addFollowAccompany(long Uid,long accId);
    public User getUserByEmail(String email);
    public User getUserByQQ(String qq);
    public User getUserByPhone(String phone);

    public boolean setUserAttribute(long userId, int sex, Date birthday, Place location, String hometown, double height, String education, String job, String user_language, String intro, String qq, String phonenum, String passport, String license);

    public List<User> getUserList(int type, int sex, Place place);

    public List<UserInfo> getUserInfoList(List<User> userList);

    public List<User> getUserList(int type, int sex, Place place, int yearFrom, int yearTo, double heightFrom, double heightTo, String education, String job, String language, String passport, String license);

    public List<User> getUserListByPage(int type, int sex, Place place, PageContext pageContext);

    public void updateUser(User u);
    public boolean updateUserByBaseInfo(long theUserId,Place location,String job,String language,String license,String passport,String selfintro,String phonenum,String qq);
    public boolean updateUserByPwd(long theUserId,String password);
    
    public UserInfo getUserInfoByUserId(long userid);
    public UserAuthority getUserAuthorityByUserId(long userid);
    public List<User> getAdvanceUserByPage(PageContext pageContext);
    
    public User getUserByIdInitialFollowAndFollowerList(long uid);
}
