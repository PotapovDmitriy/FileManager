package com.filem.db;

import com.filem.accounts.UserProfile;

public interface UserDAO {
    void addUser(UserProfile user);
    Boolean containsLogin (String login);
    UserProfile findByLogin(String login);
}
