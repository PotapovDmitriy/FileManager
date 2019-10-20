package com.filem.accounts;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private static final Map<String, UserProfile> usersMap = new HashMap<>();
    private static final Map<String, UserProfile> sessionsMap = new HashMap<>();

    public static void addNewUser(UserProfile userProfile) {
        if (!usersMap.containsKey(userProfile.getLogin())){
            usersMap.put(userProfile.getLogin(), userProfile);
        }
    }

    public static UserProfile getUserByLogin(String login) {
        return usersMap.get(login);
    }

    public static UserProfile getUserBySessionId(String sessionId) {
        return sessionsMap.get(sessionId);
    }

    public static void addSession(String sessionId, UserProfile userProfile) {
        sessionsMap.put(sessionId, userProfile);
    }

    public static void deleteSession(String sessionId) {
        sessionsMap.remove(sessionId);
    }
}