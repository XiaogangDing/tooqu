/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.UserDao;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyParticipateRecord;
import com.tooqu.entity.Place;
import com.tooqu.entity.Report;
import com.tooqu.entity.User;
import com.tooqu.entity.UserAuthority;
import com.tooqu.entity.UserInfo;
import com.tooqu.entity.Visit;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Dxg
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

    private Logger log = Logger.getLogger(UserDaoImpl.class);
    
    @Override
    public User getUserByUserInfo(UserInfo userInfo) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        User result = null;
        if(userInfo != null){
            try {	
                Transaction tx=session.beginTransaction();
                       
                String  hql = "from User a where a.uinfo=" + userInfo.getUid();
                        
		Query query = session.createQuery(hql);	
	               
		List list = query.list();
                if(!list.isEmpty()){
                    result = (User)list.get(0);
                }
                tx.commit();
            } catch (Exception e) {
		e.printStackTrace();
            }
        }
        session.close();
        return result;
    }

    @Override
    public UserInfo getUserInfoByQQ(String qq) {  
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        UserInfo result = null;
        try {	
            Transaction tx = session.beginTransaction();
                       
            String hql = "from UserInfo a where a.qq='" + qq + "'";
                        
            Query query = session.createQuery(hql);	
	               
            List list = query.list();
            if(!list.isEmpty()){
                result = (UserInfo)list.get(0);
            }
            tx.commit();
        } catch (Exception e) {
	}
        session.close();
        return result;
    }

    @Override
    public UserInfo getUserInfoByPhone(String phonenum) {
         Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        UserInfo result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                        String  hql = "from UserInfo a where a.phonenum='"+phonenum+"'";
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                        if(list.size()!=0){
                        result=(UserInfo)list.get(0);
                        }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public boolean insertUserByUserInfo(UserInfo userInfo) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result=false;
        try {	
			Transaction tx=session.beginTransaction();
                       
                       session.save(userInfo);
                    result=true;
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public User getUserByemail(String email) {
       Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        User result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.email='"+email+"'";
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                        if(list.size()!=0){
                        result=(User)list.get(0);
                        }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

 

    @Override
    public List<User> getUserList(int type, int sex, Place place) {
         Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<User> result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.type="
					+type+" and a.sex="+sex+"and a.location="+place.getPid();
                        
			Query query = session.createQuery(hql);	
	               
			result= query.list();
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    

    @Override
    public UserInfo getUserInfoByUid(long uid) {
       Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        UserInfo result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from UserInfo a where a.uid="+uid;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                       
                        if(list.size()!=0){
                        result=(UserInfo)list.get(0);
                        }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public UserInfo getUserInfoByUserid(long userid) {
              Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        UserInfo result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from UserInfo a where a.user="+userid;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                       
                        if(list.size()!=0){
                        result=(UserInfo)list.get(0);
                        }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public User getUserById(long userId) {
      Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        User result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.userId="
					+userId;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                       
                        if(list.size()!=0){
                        result=(User)list.get(0);
                         Hibernate.initialize(result.getFollow_accompanylist());
                        }
           
	                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }
    private LocalSessionFactoryBean sessionFactory; 

 



    @Override
    public User getUser(long userId) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        User result = null;
        try {	
            Transaction tx = session.beginTransaction();
                       
            String hql = "from User a where a.userId=" + userId;
                        
            Query query = session.createQuery(hql);	
	               
            List list = query.list();
            if(list.size() != 0){
            result = (User)list.get(0);
        }
           
	tx.commit();
	} catch (Exception e) {
            e.printStackTrace();
	}
        session.close();
        return result;
    }

 

    @Override
    public boolean updateUser(User user) {
              Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result=false;
        try {	
            log.info("进入更新用户操作");
			Transaction tx=session.beginTransaction();
                        session.merge(user);
	                tx.commit();
                        result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
         return result;
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
             Session session=this.getHibernateTemplate().getSessionFactory().openSession();
               boolean result=false;
        try {	
			Transaction tx=session.beginTransaction();
                        session.merge(userInfo);
	                tx.commit();
                        result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
         return result;
    }



    //imple


   



    @Override
    public List<UserInfo> getUserInfoList(Date DateFrom, Date DateTo, double heightFrom, double heightTo, String education, String job, String language, String passport, String license) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<UserInfo> result = new ArrayList<UserInfo>();
        try {	
            Transaction tx=session.beginTransaction();
            
            String hql = "from UserInfo a where a.birthday>='" + DateFrom + "' and a.birthday<='" + 
                    DateTo + "' and a.height>=" + heightFrom + " and a.height<=" + heightTo + 
                    " and a.education='" + education + "' and a.job='" + job + "' and a.user_language='" + 
                    language + "' and a.passport='" + passport + "' and a.license='" + license + "'";
            
            Query query = session.createQuery(hql);
	               
            result= query.list();
                       
	    tx.commit();
	} catch (Exception e) {
	}
        session.close();
        return result;
    }
    @Override
    public boolean isExist(int type, int sex, Place place, long uid) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {	
            Transaction tx=session.beginTransaction();
            
            String hql = "from User a where a.userId=" + uid + 
                    " and a.type=" + type + " and a.sex=" + sex + 
                    " and a.location=";
            if(place == null)
                hql += "null";
            else
                hql += place.getPid();
                        
            Query query = session.createQuery(hql);		               
            List list= query.list();
            if(list.size()!=0){
                result = true;
            }
	    tx.commit();
            } catch (Exception e) {
		e.printStackTrace();
            }
        session.close();
        return result;
    }

    @Override
    public User getUserByIdInitialUserInfo(long uid) {
      Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        User result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.userId="
					+uid;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                        if(list.size()!=0){
                        result=(User)list.get(0);
                        Hibernate.initialize(result.getUinfo());
                        }
           
	                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public User getUserByIdInitialArticleCommentList(long uid) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        User result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.userId="
					+uid;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                        if(list.size()!=0){
                        result=(User)list.get(0);
                        Hibernate.initialize(result.getArticlecommentlist());
                        }
           
	                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public User getUserByIdInitialArticleList(long uid) {
       Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        User result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.userId="
					+uid;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                        if(list.size()!=0){
                        result=(User)list.get(0);
                        Hibernate.initialize(result.getArticlelist());
                        }
           
	                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }
    @Override
    public User getUserByIdInitialFollowAndFollowerList(long uid) {
       Session session = this.getHibernateTemplate().getSessionFactory().openSession();
       User result = null;
       try{
           Transaction tx = session.beginTransaction();
           String hql = "from User a where a.userId="+uid;
           Query query = session.createQuery(hql);
           List list = query.list();
           if(list.size() != 0){
               result = (User)list.get(0);
               Hibernate.initialize(result.getFollowlist());
               Hibernate.initialize(result.getFollowerlist());
           }
           tx.commit();
           if(log.isInfoEnabled()){
               log.info("已经提交获取用户关注和粉丝的事物");
           }
       }catch(Exception e){      
               log.error("获取用户的所有关注和所有粉丝失败");
           e.printStackTrace();
       }
       return result;
    }
    
    @Override
    public User getUserByIdInitAlbumlocation(long userId) {
            Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        User result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.userId="
					+userId;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                        if(list.size()!=0){
                        result=(User)list.get(0);
                        Hibernate.initialize(result.getAlbumlist());
                        Hibernate.initialize(result.getLocation());
                        }
           
	                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public UserAuthority getUserAuthorityByUserId(long userid) {
         Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        UserAuthority result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from UserAuthority a where a.user="+userid;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                       
                        if(list.size()!=0){
                        result=(UserAuthority)list.get(0);
                        }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public User getUserByIdInitlocation(long userId) {
            Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        User result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.userId="
					+userId;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                        if(list.size()!=0){
                        result=(User)list.get(0);
                        Hibernate.initialize(result.getLocation());
                        }
           
	                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public List<User> getAdvanceUserList(int start, int length) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<User> result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.isAdvance=1";
                        
			Query query = session.createQuery(hql);	
                        query.setCacheable(true);
	               query.setMaxResults(length);
                       query.setFirstResult(start);
			result= query.list();
                    
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public List<User> getUserList(int type, int sex, Place place, int start, int length) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<User> result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from User a where a.type="
					+type+" and a.sex="+sex+"and a.location="+place.getPid();
                        
			Query query = session.createQuery(hql);	
                        query.setCacheable(true);
	               query.setMaxResults(length);
                       query.setFirstResult(start);
			result= query.list();

                         if(result.size()!=0){
                             for(int i=0;i<result.size();++i)
                        Hibernate.initialize(result.get(i).getUinfo());
                        }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }
    
}
