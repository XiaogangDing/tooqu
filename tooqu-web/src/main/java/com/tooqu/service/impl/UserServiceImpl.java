/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.service.impl;

import com.tooqu.common.dao.PageContext;
import com.tooqu.dao.AccompanyDao;
import com.tooqu.dao.UserDao;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;
import com.tooqu.entity.UserAuthority;
import com.tooqu.entity.UserInfo;
import com.tooqu.service.UserService;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dxg
 */
public class UserServiceImpl implements UserService{

  

    
    private UserDao userDao;
    private AccompanyDao accDao;
    public AccompanyDao getAccDao() {
        return accDao;
    }

    public void setAccDao(AccompanyDao accDao) {
        this.accDao = accDao;
    }
    
    
    
    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public User getUserById(long id) {
       return userDao.getUser(id);
    }

    @Override
    public void addFollowAccompany(long Uid,long accId) {
       
       User user=userDao.getUserById(Uid);//需要对follow_accompanylist 初始化
       Accompany acc=accDao.getAccompanyById(accId);
       boolean isexists=false;
       for(int i=0;i<acc.getUserlist().size();++i)
       {
           if(acc.getUserlist().get(i).getUserId()==user.getUserId())
               for(int j=0;j<user.getFollow_accompanylist().size();++j)
                   if(user.getFollow_accompanylist().get(i).getAid()==acc.getAid())
                       isexists=true;
       }
       if(isexists)
           return;
       else{
       acc.getUserlist().add(user);
       user.getFollow_accompanylist().add(acc);
       accDao.updateAccompany(acc);
       }
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public User createUser(int type, String email, String name, String password) {
        User u=new User();
        u.setType(type);
        u.setEmail(email);
        u.setName(name);
        u.setPassword(password);
        
        UserInfo uinfo=new UserInfo();
        uinfo.setUser(u);
        if(userDao.insertUserByUserInfo(uinfo))
        return u;
        else return null;
      
    }

    @Override
    public User getUserByEmail(String email) {
       return userDao.getUserByemail(email);
    }

    @Override
    public boolean setUserAttribute(long uid,int sex, Date birthday, Place location, String hometown, double height, String education, String job, String user_language, String intro, String qq, String phonenum, String passport, String license) {
        User user=userDao.getUserByIdInitialUserInfo(uid);
        user.setSex(sex);
         user.setLocation(location);
     
        UserInfo userinfo=user.getUinfo();
        userinfo.setBirthday(birthday);
        userinfo.setHeight(height);
        userinfo.setEducation(education);
        userinfo.setHometown(hometown);
        userinfo.setJob(job);
        userinfo.setUser_language(user_language);
        userinfo.setIntro(intro);
        userinfo.setQq(qq);
        userinfo.setPhonenum(phonenum);
        userinfo.setPassport(passport);
        userinfo.setLicense(license);
        userDao.updateUser(user);
        if(userDao.updateUserInfo(userinfo))//需不需要save？
        return true;
        else return false;
    }

    @Override
    public User getUserByQQ(String qq) {
        UserInfo userinfo = userDao.getUserInfoByQQ(qq);
        return userDao.getUserByUserInfo(userinfo);
    }

    @Override
    public User getUserByPhone(String phonenum) {
        UserInfo userinfo = userDao.getUserInfoByPhone(phonenum);
        return userDao.getUserByUserInfo(userinfo);
    }
    
    //
    @Override
    public List<User> getUserList(int type, int sex, Place place) {
       return userDao.getUserList(type, sex, place);
    }

    @Override
    public List<UserInfo> getUserInfoList(List<User> userList) {
        List<UserInfo> result = new LinkedList<UserInfo>();
        if(userList != null){
            for(int i = 0; i < userList.size(); ++i){
                long uid = userList.get(i).getUserId();
                result.add(userDao.getUserInfoByUid(uid));
            }
        }
        return result;
    }

    @Override
    public List<User> getUserList(int type, int sex, Place place, int yearFrom, int yearTo, double heightFrom, double heightTo, String education, String job, String language, String passport, String license) {
        List<UserInfo> userinfolist = null;
        List<User> userlist = new ArrayList<User>();
        java.sql.Date DateFrom = strToDate(Integer.toString(yearFrom),"1","1");
        java.sql.Date DateTo = strToDate(Integer.toString(yearTo),"12","31");
        userinfolist = userDao.getUserInfoList(DateFrom, DateTo, heightFrom, heightTo, education, job, language, passport, license);
        for(int i = 0; i < userinfolist.size(); ++i)
        {
            long uid = userinfolist.get(i).getUid();
            if(userDao.isExist(type, sex, place, uid))
                userlist.add(userDao.getUser(uid));       
        }
        return userlist;
    }

    @Override
    public List<User> getUserListByPage(int type, int sex, Place place, PageContext pageContext) {
        List<User> userlist=null;
        userlist=userDao.getUserList(type, sex, place,pageContext.getStart(),pageContext.getLength());
        return userlist;
    }
   private  Date strToDate(String year, String month, String day) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = year + "-" + month + "-" + day;
        java.util.Date toDate = new java.util.Date();
        
        try {
            // toDate = dateFormat.parse("2008-12-12");
            toDate = dateFormat.parse(s);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        java.sql.Date sqlDate=new java.sql.Date(toDate.getTime());
        return sqlDate;
    }

    @Override
    public void updateUser(User u) {
      userDao.updateUser(u);
    }

    @Override
    public UserInfo getUserInfoByUserId(long userid) {
     return userDao.getUserInfoByUserid(userid);
    }

    @Override
    public User getUserByIdInitAlbumlocation(long id) {
        return userDao.getUserByIdInitAlbumlocation(id);
    }

    @Override
    public UserAuthority getUserAuthorityByUserId(long userid) {
       return userDao.getUserAuthorityByUserId(userid);
    }

    @Override
    public User getUserByIdInitlocation(long id) {
        return userDao.getUserByIdInitlocation(id);
    }

    @Override
    public boolean updateUserByBaseInfo(long theUserId, Place location, String job, String language, String license, String passport, String selfintro, String phonenum, String qq) {
       UserInfo userinfo=userDao.getUserInfoByUserid(theUserId);
       userinfo.setIntro(selfintro);
       userinfo.setJob(job);
       userinfo.setLicense(license);
       userinfo.setUser_language(language);
       userinfo.setPassport(passport);
       userinfo.setPhonenum(phonenum);
       userinfo.setQq(qq);
       User user=userDao.getUserById(theUserId);
       user.setLocation(location);
       if(userDao.updateUserInfo(userinfo)&&userDao.updateUser(user))
           return true;
       else 
           return false;
    }

    @Override
    public boolean updateUserByPwd(long theUserId, String password) {
       User user=userDao.getUserById(theUserId);
       user.setPassword(password);
       return userDao.updateUser(user);
    }

    @Override
    public List<User> getAdvanceUserByPage(PageContext pageContext) {
       return    userDao.getAdvanceUserList(pageContext.getStart(),pageContext.getLength());
    }
    
    @Override
    public User getUserByIdInitialFollowAndFollowerList(long uid){
        return userDao.getUserByIdInitialFollowAndFollowerList(uid);
    }
   
}
