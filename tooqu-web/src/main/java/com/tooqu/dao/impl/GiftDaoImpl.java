/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.GiftDao;
import com.tooqu.entity.Album;
import com.tooqu.entity.Gift;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 *
 * @author Administrator
 */
public class GiftDaoImpl extends HibernateDaoSupport implements GiftDao{

    @Override
    public boolean insertGift(Gift gift) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        try{
            Transaction tx = session.beginTransaction();
            session.save(gift);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        session.close();
        return true;
    }

    @Override
    public boolean deleteGift(Gift gift) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        try{
            Transaction tx = session.beginTransaction();
            session.delete(gift);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        session.close();
        return true;
    }

    @Override
    public Gift getGiftByGid(long gid) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
       Gift result=null;
        try {	
            Transaction tx=session.beginTransaction();
            String hql = "from Gift where gid="+gid;
            Query query = session.createQuery(hql);	
	    List list= query.list();
            if(list.size()!=0){
                result=(Gift)list.get(0);
            }
            tx.commit();
        } catch (Exception e) {
                e.printStackTrace();
        }
         session.close();
        return result;
    }
    
    @Override
    public boolean updateGift(Gift gift) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        try{
            Transaction tx = session.beginTransaction();
            session.update(gift);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        session.close();
        return true;
    }
}
