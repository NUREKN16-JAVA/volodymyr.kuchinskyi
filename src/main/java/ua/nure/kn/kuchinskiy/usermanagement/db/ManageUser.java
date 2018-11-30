package ua.nure.kn.kuchinskiy.usermanagement.db;

import java.time.LocalDate;
import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ua.nure.kn.kuchinskiy.usermanagement.User;

public class ManageUser {
    private static HibernateUtil hibernateUtil;

    public ManageUser() {
        try {
            HibernateUtil hibernateUtil = new HibernateUtil();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /* Method to CREATE a user in the database */
    public static Integer create(User newUser){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer userID = null;

        try {
            tx = session.beginTransaction();
            User user = new User(newUser.getFirstName(), newUser.getLastName(), newUser.getDateOfBirth());
            userID = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userID;
    }
}
