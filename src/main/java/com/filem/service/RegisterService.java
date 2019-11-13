package com.filem.service;

import com.filem.accounts.UserProfile;
import com.filem.db.UserDAOHib;


import java.io.File;

public class RegisterService {
    public UserProfile Register( String login, String password, String email) {
        UserDAOHib base = new UserDAOHib();


        if (!base.containsLogin(login)) {
            UserProfile user = new UserProfile(login, password, email);
            base.addUser(user);
            System.out.println(login);
            File folder = new File("H:\\" + login);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            return new UserProfile( login, password, email);

        } else {
            System.out.println("incorrect login in Registration");
        }
        return null;
    }
}
