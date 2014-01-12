/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.AccompanyParticipateRecordDao;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.AccompanyComment;
import com.tooqu.entity.AccompanyParticipateRecord;
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
public class AccompanyParticipateRecordDaoImpl extends HibernateDaoSupport implements AccompanyParticipateRecordDao{
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public void insertAPR(AccompanyParticipateRecord apr) {
       Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            session.merge(apr);

            tx.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    @Override
    public List<AccompanyParticipateRecord> getAPRListByAcc(Accompany ac) {
    Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<AccompanyParticipateRecord> result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from AccompanyParticipateRecord a where a.accompany="+ac.getAid();
            Query query = session.createQuery(hql);
           
            result = query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public boolean isExist(AccompanyParticipateRecord apr) {
          Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from AccompanyParticipateRecord a where a.user="+apr.getUser().getUserId()+"and a.accompany="+apr.getAccompany().getAid();
            Query query = session.createQuery(hql);
           
            List list = query.list();
            if(list.size()>0)
                result=true;
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
       return result;
    }

   
    
}
