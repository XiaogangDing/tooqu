/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.SendGiftDao;
import com.tooqu.entity.SendGift;
import com.tooqu.entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class SendGiftDaoImpl extends HibernateDaoSupport implements SendGiftDao {

    @Override
    public boolean insertSendGift(SendGift sendgift) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        try{
            Transaction tx = session.beginTransaction();
            session.merge(sendgift);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        session.close();
        return true;
    }

    @Override
    public boolean delete(SendGift sendgift) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        try{
            Transaction tx = session.beginTransaction();
            session.delete(sendgift);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        session.close();
        return true;
    }

    @Override
    public List<SendGift> getGiftListBySender(long from) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<SendGift> result=null;
        try {	
                Transaction tx=session.beginTransaction();
                String hql = "from SendGift where from_user="+ from;
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
    public List<SendGift> getGiftListByReceiver(long to) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<SendGift> result=null;
        try {	
                Transaction tx=session.beginTransaction();
                String hql = "from SendGift where to_user="+ to;
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
    public List<SendGift> getGiftListBySender(long from,int start,int length) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<SendGift> result=null;
        try {	
                Transaction tx=session.beginTransaction();
                String hql = "from SendGift where from_user="+ from;
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
    public List<SendGift> getGiftListByReceiver(long to,int start,int length) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<SendGift> result=null;
        try {	
                Transaction tx=session.beginTransaction();
                String hql = "from SendGift where to_user="+ to;
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
    public List<SendGift> getGiftList(int start,int length) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<SendGift> result=null;
        try {	
                Transaction tx=session.beginTransaction();
                String hql = "from SendGift";
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
}
