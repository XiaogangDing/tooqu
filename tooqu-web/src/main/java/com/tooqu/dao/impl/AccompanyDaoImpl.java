/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.AccompanyDao;
import com.tooqu.dao.PlaceDao;
import com.tooqu.entity.Accompany;
import com.tooqu.entity.Place;
import com.tooqu.entity.User;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Dxg
 */
public class AccompanyDaoImpl extends HibernateDaoSupport implements AccompanyDao {

    @Override
    public List<Accompany> getAccompanyByName(String ac_name) {
          Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<Accompany> result = null;
        try {
            Transaction tx = session.beginTransaction();

            String hql = "from Accompany a where a.name='"
                    + ac_name + "'";

            Query query = session.createQuery(hql);
            List list = query.list();
           if(list.size()!=0){
           result=(List<Accompany>)list;
           for(int i=0;i<list.size();++i)
           Hibernate.initialize(result.get(i).getUserlist());
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
    public boolean insertAccompany(Accompany acc) {
        //  System.out.println(startPlace.getProvince());
        Session session = this.getHibernateTemplate().getSessionFactory().openSession(); 
        
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
          
            session.merge(acc);
            //session.save(acc);

            tx.commit();
            
            result=true;
                
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        session.close();
        
        return result;
    }

    @Override
    public boolean deleteAccompany(Accompany acc) {
          Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            session.delete(acc);

            tx.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
       }

    @Override
    public boolean updateAccompany(Accompany acc) {
              Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            session.merge(acc);
            tx.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public Accompany getAccompany(Accompany ac) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        Accompany result = null;
        try {
            Transaction tx = session.beginTransaction();

            String hql = "from Accompany a where a.name='"
                    + ac.getName() + "' and a.type="
                    + ac.getType() + " and a.accType="
                    + ac.getAccType() + " and a.accSex="
                    + ac.getAccSex() + " and a.travelduration="
                    + ac.getTravelduration() + " and a.accountAmount="
                    + ac.getAccountAmount()+" and a.accHeight='"
                    + ac.getAccHeight() + "' and a.accWeight='"
                    + ac.getAccWeight() + "' and a.accEducation='"
                    + ac.getAccEducation() + "' and a.isReview="
                    + ac.isIsReview() + " and a.accAge='"
                    + ac.getAccAge() + "' and a.accLanguage='"
                    + ac.getAccLanguage() + "' and a.accPassport='"
                    + ac.getAccPassport() + "' and a.accLicense='"
                    + ac.getAccLicense() + "' and a.accPick='"
                    + ac.getAccPick() + "' and a.accCar='"
                    + ac.getAccCar() + "' and a.remark='"
                    + ac.getRemark()  + "' and a.feeType='"
                    + ac.getFeeType() + "' and a.businessRequirement='"
                    + ac.getBusinessRequirement() + "'";

            Query query = session.createQuery(hql);

            result = (Accompany) query.list().get(0);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public Accompany getAccompanyById(long id) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        Accompany result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from Accompany a where a.aid="+id;
            Query query = session.createQuery(hql);
            List list = query.list();
           if(list.size()!=0){
           result=(Accompany)list.get(0);
           Hibernate.initialize(result.getUserlist());
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
    public List<Accompany> listAccompanyByPage(int start, int length) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<Accompany> result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from Accompany a ";
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
    public List<Accompany> listAccompanyByPlace(Place startPlace, Place desPlace, int start, int length) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<Accompany> result = null;
        try {
            Transaction tx = session.beginTransaction();

            String hql = "from Accompany a where a.departure="
                    + startPlace.getPid() + " and a.destination=" + desPlace.getPid();

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

    


}
