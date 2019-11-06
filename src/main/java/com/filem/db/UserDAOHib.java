package com.filem.db;

import com.filem.accounts.UserProfile;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        if (HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UserProfile.class, login) != null)
            return true;
        return false;
    }

    @Override
    public UserProfile findByLogin(String login) {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UserProfile.class, login);
    }
}
