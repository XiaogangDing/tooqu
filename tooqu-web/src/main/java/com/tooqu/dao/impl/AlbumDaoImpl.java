/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.AlbumDao;
import com.tooqu.entity.Album;
import com.tooqu.entity.Picture;
import com.tooqu.entity.User;
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
public class AlbumDaoImpl extends HibernateDaoSupport implements AlbumDao{
 private LocalSessionFactoryBean sessionFactory; 
    @Override
    public List<Album> getAlbumByUser(long userid) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<Album> result=null;
    
        try {	
			Transaction tx=session.beginTransaction();
                       
                        String  hql = "from Album a where a.user="+userid;
                        
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
    public List<Album> listAlbumByUserByPage(long userid, int start, int length) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<Album> result=null;
    
        try {	
			Transaction tx=session.beginTransaction();
                       
                        String  hql = "from Album a where a.user="+userid;
                        
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
    public boolean insertAlbum(Album album) {
       Session session=this.getHibernateTemplate().getSessionFactory().openSession();
       boolean result=false;
        try {	
			Transaction tx=session.beginTransaction();
                      session.save(album);			
                tx.commit();
                result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
         return result;
    }

    @Override
    public List<Picture> listPictureByAlbum(long albumid) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<Picture> result=null;
    
        try {	
			Transaction tx=session.beginTransaction();
                       
                        String  hql = "from Album a where a.aid="+albumid;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                      if(list.size()!=0){
                      Album tmp=(Album)list.get(0);
                      result=tmp.getPicturelist();
                      }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public List<Picture> listPictureByAlbumByPage(long albumid, int start, int length) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<Picture> result=null;
    
        try {	
			Transaction tx=session.beginTransaction();
                       
                        String  hql = "from Album a where a.aid="+albumid;
                        
			Query query = session.createQuery(hql);	
	               query.setCacheable(true);
	               query.setMaxResults(length);
                       query.setFirstResult(start);
			List list= query.list();
                      if(list.size()!=0){
                      Album tmp=(Album)list.get(0);
                      result=tmp.getPicturelist();
                      }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public boolean deleteAlbum(long album) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result=false;
        try {	
			Transaction tx=session.beginTransaction();
                        Album tmp=null;
                        String  hql = "from Album a where a.aid="+album;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                      if(list.size()!=0){
                       tmp=(Album)list.get(0);
                      }
                      session.delete(tmp);			
                tx.commit();
                result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
         return result;
    }

    @Override
    public Album getAlbumByIdInitialPic(long albumid) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
       Album result=null;
    
        try {	
			Transaction tx=session.beginTransaction();
                       
                        String  hql = "from Album a where a.aid="+albumid;
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                      if(list.size()!=0){
                     result=(Album)list.get(0);
                     Hibernate.initialize(result.getPicturelist());
                      }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public void updateAlbum(Album album) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
