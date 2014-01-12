/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.ArticleDao;
import com.tooqu.entity.Article;
import com.tooqu.entity.ArticleComment;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author hao
 */
public class ArticleDaoImpl extends HibernateDaoSupport implements ArticleDao{
    private LocalSessionFactoryBean sessionFactory; 
    @Override
    public Article getArticleByIdInitialArticleCommentList(long aid) {
     Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        Article result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from Article a where a.aid="+aid+"";
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                        if(list.size()!=0){
                        result=(Article)list.get(0);
                        Hibernate.initialize(result.getArticlecommentlist());
                        Hibernate.initialize(result.getUser());
                        
                        }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public Article getArticleById(long aid) {
      Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        Article result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from Article a where a.aid="+aid+"";
                        
			Query query = session.createQuery(hql);	
	               
			List list= query.list();
                        if(list.size()!=0){
                        result=(Article)list.get(0);
                        }
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public boolean update(Article article) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result=false;
        try {	
			Transaction tx=session.beginTransaction();
                       
                       session.merge(article);
                    result=true;
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public boolean insertArticle(Article article) {
         Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result=false;
        try {	
			Transaction tx=session.beginTransaction();
                       
                       session.save(article);
                    result=true;
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public boolean delete(Article article) {
         Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result=false;
        try {	
			Transaction tx=session.beginTransaction();
                       
                       session.delete(article);
                    result=true;
                tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
         session.close();
        return result;
    }

    @Override
    public List<Article> getArticleListByUserId(long uid, int start, int length) {
      Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        List<Article> result=null;
        try {	
			Transaction tx=session.beginTransaction();
                       
                      String  hql = "from Article a where a.user="+uid+"";
                        
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
    public long getArticleId(long user_id, String title, String content) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        long result = -1;
        try{
            Transaction tx = session.beginTransaction();
            String hql = "from Article a where a.title='" + title + 
                    "' and a.content='" + content + "' and a.user.userId=" + user_id;
            Query query = session.createQuery(hql);
            result = ((Article)query.list().get(0)).getAid();
            
            tx.commit();
        } catch(Exception e){
            e.printStackTrace();
        }
        session.close();
        return result;
    }
}
