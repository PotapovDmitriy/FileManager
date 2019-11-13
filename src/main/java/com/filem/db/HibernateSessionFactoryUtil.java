package com.filem.db;

import com.filem.accounts.UserProfile;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(UserProfile.class);
                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {
                System.out.println("EXCEPTION!!!   " + e);
            }
        }
        return sessionFactory;
    }
}
