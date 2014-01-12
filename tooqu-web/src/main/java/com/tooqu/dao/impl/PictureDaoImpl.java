/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.PictureDao;
import com.tooqu.entity.Album;
import com.tooqu.entity.Picture;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author softwware
 */
public class PictureDaoImpl extends HibernateDaoSupport implements PictureDao{
 private LocalSessionFactoryBean sessionFactory; 
    @Override
    public void insertPicture(Picture picture) {
      Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        try {	
			Transaction tx=session.beginTransaction();
                      session.save(picture);			
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
    }

    @Override
    public Picture getPictureById(long id) {
       Session session=this.getHibernateTemplate().getSessionFactory().openSession();
       Picture result=null;
    
        try {	
			Transaction tx=session.beginTransaction();
                       
                        String  hql = "from Picture a where a.pid="+id;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                      if(list.size()!=0){
                     result=(Picture)list.get(0);
                      Hibernate.initialize(result.getAlbum());
                      }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
         return result;
    }

    @Override
    public void deletePicture(Picture picture) {
          Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        try {	
			Transaction tx=session.beginTransaction();
                      session.delete(picture);			
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
    }
    
}
