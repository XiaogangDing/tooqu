/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.ArticleCommentDao;
import com.tooqu.entity.ArticleComment;
import com.tooqu.entity.User;
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
public class ArticleCommentDaoImpl extends HibernateDaoSupport implements ArticleCommentDao{
    
    private LocalSessionFactoryBean sessionFactory; 
    
    @Override
    public boolean insertArticleComment(ArticleComment articlecomment) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            
            session.merge(articlecomment);
            result = true;
            tx.commit();
	} catch (Exception e) {
            e.printStackTrace();
	}
        session.close();
        return result;
    }

    @Override
    public ArticleComment getArticleCommentById(long id) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        ArticleComment result = null;
        try {	
            Transaction tx=session.beginTransaction();
                       
            String hql = "from ArticleComment a where a.article_comment_id=" + id;
                        
            Query query = session.createQuery(hql);	
	               
            List list = query.list();
            if(!list.isEmpty()){
                result = (ArticleComment)list.get(0);
            }
            tx.commit();
        } catch (Exception e) {
	}
        session.close();
        return result;
    }

    @Override
    public boolean deleteArticleComment(ArticleComment articlecomment) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {	
            Transaction tx = session.beginTransaction();
                       
            session.delete(articlecomment);
            result = true;
            tx.commit();
	} catch (Exception e) {
	}
        session.close();
        return result;
    }

    @Override
    public List<ArticleComment> getArticleCmtListByArticleId(long ArticleId, int start, int length) {       
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<ArticleComment> result = null;
        try {	
            Transaction tx = session.beginTransaction();
                       
            String hql = "from ArticleComment a where a.article=" + ArticleId + "";
                        
            Query query = session.createQuery(hql);	
            query.setCacheable(true);
	    query.setMaxResults(length);
            query.setFirstResult(start);
            result= query.list();
                    
            tx.commit();
	} catch (Exception e) {
	}
        session.close();
        return result;
    }
    
    @Override
    public int getArticleCommentNumber(long atcId) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        int result = 0;
        try {	
            Transaction tx = session.beginTransaction();
                       
            String hql = "from ArticleComment a where a.article=" + atcId + "";
                        
            Query query = session.createQuery(hql);	
            result= query.list().size();
                    
            tx.commit();
	} catch (Exception e) {
	}
        session.close();
        return result;
    }
}
