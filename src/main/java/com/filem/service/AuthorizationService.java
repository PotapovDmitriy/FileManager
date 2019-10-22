package com.filem.service;


import com.filem.accounts.UserProfile;
import com.filem.db.UserProfileDAOImpl;

public class AuthorizationService {
    public UserProfile Login(String login, String pass) {
        UserProfileDAOImpl base = new UserProfileDAOImpl();
        if (base.containsLogin(login)) {
            UserProfile user = base.getUser(login);

            if (user.getPass().equals(pass)) {
                return user;
            } else {
                System.out.println("incorrect pass");
            }
        } else {
            System.out.println("incorrect login ");
        }
        return null;
    }
}