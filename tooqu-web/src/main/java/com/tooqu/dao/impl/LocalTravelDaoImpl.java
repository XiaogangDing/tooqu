/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.LocalTravelDao;
import com.tooqu.entity.LocalTravel;
import java.util.List;
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
public class LocalTravelDaoImpl extends HibernateDaoSupport implements LocalTravelDao {
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<LocalTravel> listLocalTravelByPage(int start, int length) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<LocalTravel> result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from LocalTravel l ";
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

    @Override
    public LocalTravel getLocalTravelById(long lctrvId) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        LocalTravel result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from LocalTravel l where l.id="+lctrvId;
            Query query = session.createQuery(hql);
            List list = query.list();
           if(list.size()!=0){
           result=(LocalTravel)list.get(0);
           Hibernate.initialize(result.getRecordlist());
           }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public boolean insertLocalTravel(LocalTravel lctrvl) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
          
            session.merge(lctrvl);

            tx.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public boolean deleteLocalTravel(LocalTravel lctrv) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            session.delete(lctrv);

            tx.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public boolean updateLocalTravel(LocalTravel lctrvl) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            session.merge(lctrvl);
            tx.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }
    
}
