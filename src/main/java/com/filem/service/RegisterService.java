package com.filem.service;

import com.filem.accounts.UserProfile;
import com.filem.db.UserDAOHib;


import java.io.File;

public class RegisterService {
    public UserProfile Register( String login, String pass, String mail) {
        UserDAOHib base = new UserDAOHib();
        if (!base.containsLogin(login)) {
            base.addUser(login, pass, mail);
            System.out.println(login);
            File folder = new File("E:\\" + login);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            return new UserProfile( login, pass, mail);

        } else {
            System.out.println("incorrect login in Registration");
        }
        return null;
    }
}
