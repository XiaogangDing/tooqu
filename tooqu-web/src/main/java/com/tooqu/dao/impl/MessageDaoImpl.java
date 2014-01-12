/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.MessageDao;
import com.tooqu.entity.Message;
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
public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao{

    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Message> getSentMessageListByPage(Long userId, int start, int length) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<Message> result = null;
        
         try {
            Transaction tx = session.beginTransaction();
            String hql = "from Message m where m.from="+userId;
            
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
    public List<Message> getReceiveMessageListByPage(Long userId, int start, int length) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<Message> result = null;
        
         try {
            Transaction tx = session.beginTransaction();
            String hql = "from Message m where m.to="+userId;
            
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
    public boolean insertMessage(Message m) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession(); 
        
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
          
            session.merge(m);
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
    public Message getMessage(Message m) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        Message result = null;
        try {
            Transaction tx = session.beginTransaction();
            
            String hql = "from Message m where m.content='"+ m.getContent()
                    +"' and m.from="+m.getFrom().getUserId()
                    + "and m.to="+m.getTo().getUserId();

            Query query = session.createQuery(hql);
            int size=query.list().size();

            result = (Message) query.list().get(size-1);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public Message getMessageById(long mid) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        Message result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from Message m where m.mid="+mid;
            Query query = session.createQuery(hql);
            List list = query.list();
           if(list.size()!=0){
           result=(Message)list.get(0);
           Hibernate.initialize(result.getFrom());
           Hibernate.initialize(result.getTo());
           }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public boolean deleteMessage(Message m) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();

            session.delete(m);
            result = true;
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public boolean deleteMessage(List<Message> msgList) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        boolean result = false;
        try {
            Transaction tx = session.beginTransaction();
            int i=0;
            Message m;
            while(i<msgList.size()){
                m=msgList.get(i);
                session.delete(m);
                i++;
            }
            
            result = true;
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    @Override
    public List<Message> getMySentMessageList(Long userId) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<Message> result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from Message m where m.from="+userId;
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
    public List<Message> getMyReceiveMessageList(Long userId) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        List<Message> result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from Message m where m.to="+userId;
            Query query = session.createQuery(hql);
            result= query.list();
           
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return result;
    }

    
    
}
