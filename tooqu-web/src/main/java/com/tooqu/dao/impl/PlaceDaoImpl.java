/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.PlaceDao;
import com.tooqu.entity.Place;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author hds09
 */
public class PlaceDaoImpl extends HibernateDaoSupport implements PlaceDao{

    @Override
    public Place findPlaceById(long id) {
         Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        Place result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from Place p where p.pid="+id;

                        
			Query query = session.createQuery(hql);	
	         
			List list = query.list();
                        if(list.size()!=0){
                        result=(Place)list.get(0);
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
    public Place getPlace(Place place) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        Place result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from Place p where p.country="
					+ "'"+place.getCountry()+"' and p.province='"+place.getProvince()+"' and p.city='"+place.getCity()+"' and p.county='"+place.getCounty()+"'";
                        
			Query query = session.createQuery(hql);	
	         
			List list = query.list();
                        if(list.size()!=0){
                        result=(Place)list.get(0);
                        }
           
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public List<Place> getPlaceListByCountry(String country) {
      Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<Place> result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from Place p where p.country="
					+ "'"+country+"'";
                        
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
    public List<Place> getPlaceListByProvince(String province) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<Place> result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from Place p where p.province="
					+ "'"+province+"'";
                        
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
    public List<Place> getPlaceListByCity(String city) {
       Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<Place> result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from Place p where p.city="
					+ "'"+city+"'";
                        
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
    public Place findPlaceByProvinceCityCounty(String province,String city, String county) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        Place result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from Place p where p.province="
					+ "'"+province+"' and p.city='"+city+"' and p.county='"+county+"'";
                        
			Query query = session.createQuery(hql);	
	         
			List list = query.list();
                        System.out.println(list.size());
                        if(list.size()!=0){
                        result=(Place)list.get(0);
                        }
           
	       tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }
    
}
