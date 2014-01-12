/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.AccompanyCommentDao;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyComment;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



/**
 *
 * @author hao
 */
public class AccompanyCommentDaoImpl  extends HibernateDaoSupport implements AccompanyCommentDao{

    @Override
    public List<AccompanyComment> getAccCmtListByAcc(Accompany ac, int start, int length) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<AccompanyComment> result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from AccompanyComment a where a.accompany="+ac.getAid();
            Query query = session.createQuery(hql);
            query.setCacheable(true);
            query.setFirstResult(start);
            query.setMaxResults(length);
            result = query.list();
            
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }
    
    private LocalSessionFactoryBean sessionFactory;
    
  

    @Override
    public void insertAccompanyComment(AccompanyComment comment) {
       Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            session.merge(comment);

            tx.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Override
    public boolean deleteAccompanyComment(AccompanyComment comment) {
      Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            session.delete(comment);

            tx.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public AccompanyComment findAccompanyCmtById(long id) {
      Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        AccompanyComment result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from AccompanyComment a whrer a.ac_id="+id;
            Query query = session.createQuery(hql);
             List list=query.list();
             if(list.size()!=0){
             result=(AccompanyComment)list.get(0);
             }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;

    }

    @Override
    public List<AccompanyComment> getAccCmtListByAcc(Accompany ac) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<AccompanyComment> result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from AccompanyComment a where a.accompany="+ac.getAid();
            Query query = session.createQuery(hql);
           
            result = query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }
    
}
