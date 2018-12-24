package ua.nure.kn.kuchinskiy.usermanagement.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.nure.kn.kuchinskiy.usermanagement.User;

public class ManageUser {
    private Session session;
    public ManageUser() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    /* Method to CREATE a user in the database */
    public Integer create(User newUser){
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
        }
        return userID;
    }

    /* Method to UPDATE user */
    public void update(Integer userId, User editedUser){
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User user = session.get(User.class, userId);
            user.clone(editedUser);
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    public User find(Integer userId) {
        Transaction tx = null;
        User user = null;
        try {
            tx = session.beginTransaction();
            user = session.get(User.class, userId);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
        return user;
    }

    public List findAll(){
        Transaction tx = null;
        List users = new ArrayList();
        try {
            tx = session.beginTransaction();
            users = session.createQuery("FROM User").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return users;
    }

    public void destroy(Integer userId) {
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User user = session.get(User.class, userId);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Long countAll() {
        Transaction tx = null;
        Long count = null;
        try {
            tx = session.beginTransaction();
            count = (Long) session.createQuery("SELECT COUNT(*) FROM User").uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return count;
    }

    public Collection<User> find(String firstName, String lastName) throws DatabaseException {
        Transaction tx = null;
        Collection<User> users = new LinkedList<>();
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("SELECT id, first_name, last_name, birthday FROM TEST.USERS WHERE first_name = :firstName AND last_name = :lastName");
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);
            users = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        return users;
    }

    public void finalize() {
        session.close();
    }
}
