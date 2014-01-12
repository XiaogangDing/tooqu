
package com.tooqu.test;

import com.tooqu.dao.impl.AccompanyDaoImpl;
import com.tooqu.entity.Accompany;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author guo
 */
public class TestUnit1 {

    public static void main(String args[]) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        List<Accompany> result = null;
        try {
            Transaction tx = session.beginTransaction();
            String hql = "from Accompany a ";
            Query query = session.createQuery(hql);
            query.setCacheable(true);
            query.setFirstResult(0);
            query.setMaxResults(20);
            result = query.list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        System.out.println(result.size());
         session.close();
    }
}
