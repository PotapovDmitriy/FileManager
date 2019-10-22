package com.filem.db;

import com.filem.accounts.UserProfile;

public interface UserDAO {
    void addUser(String login, String mail, String pass);
    Boolean containsLogin (String login);
    UserProfile getUser (String login);
}
