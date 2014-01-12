/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tooqu.dao.impl;

import com.tooqu.dao.AccountDao;
import com.tooqu.entity.User;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 *
 * @author guo
 */
public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao {

    private LocalSessionFactoryBean sessionFactory; 
    
    @Override
    public void addUser(User user) {
        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        Transaction tx = null;
        try{
            System.out.println("gag++++++++++++++++++++++===");
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
          
        }catch(Exception e){
            tx.rollback();
        }
          session.close();
    }


}
