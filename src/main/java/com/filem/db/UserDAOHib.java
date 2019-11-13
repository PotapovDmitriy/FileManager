package com.filem.db;

import com.filem.accounts.UserProfile;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserDAOHib implements UserDAO {


    @Override
    public void addUser(UserProfile user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public Boolean containsLogin(String login) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("FROM UserProfile where login = :login");
            query.setParameter("login", login);
            UserProfile user = (UserProfile) query.getSingleResult();

            return user != null;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public UserProfile findByLogin(String login) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Query query = session.createQuery("FROM UserProfile where login = :login");
            query.setParameter("login", login);
            return (UserProfile) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }


    }
}
