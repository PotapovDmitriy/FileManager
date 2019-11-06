package com.filem.service;


import com.filem.accounts.UserProfile;
import com.filem.db.UserDAOHib;

public class AuthorizationService {
    public UserProfile login(String login, String pass) {
        UserDAOHib base = new UserDAOHib();
        UserProfile user = base.findByLogin(login);
        if (base.containsLogin(login)) {
            if (user.getPassword().equals(pass)) {
                return user;
            } else {
                System.out.println("incorrect pass in Authorization ");
            }
        } else {
            System.out.println("incorrect login in Authorization");
        }
        return null;
    }
}