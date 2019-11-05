//package com.filem.db;
//
//import com.filem.accounts.UserProfile;
//
//
//import java.io.*;
//import java.sql.*;
//
//
//public class UserProfileDAOImpl implements UserDAO {
//    private String url = "jdbc:sqlite:myDataBase.db";
//
//    @Override
//    public void addUser(String login, String mail, String pass) {
//        String sql = "INSERT INTO userprofile VALUES(?, ?, ?);";
//
//        try (Connection conn = DriverManager.getConnection(url)) {
//            PreparedStatement pStatement = conn.prepareStatement(sql);
//            pStatement.setString(1, login);
//            pStatement.setString(2, pass);
//            pStatement.setString(3, mail);
//            pStatement.executeUpdate();
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    @Override
//    public Boolean containsLogin(String login) {
//        String sql = "SELECT COUNT(login) FROM userprofile WHERE login = '" + login + "';";
//
//        try (Connection conn = DriverManager.getConnection(url);
//             Statement st = conn.createStatement();
//             ResultSet rs = st.executeQuery(sql)) {
//            rs.next();
//            int i = rs.getInt(1);
//            return i > 0;
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return null;
//    }
//
//    @Override
//    public UserProfile getUser(String login) {
//        String sql = "SELECT * FROM userprofile WHERE login = '" + login + "';";
//
//        try (Connection conn = DriverManager.getConnection(url);
//             Statement st = conn.createStatement();
//             ResultSet rs = st.executeQuery(sql)) {
//            rs.next();
//
//            String username = rs.getString(1);
//            String password = rs.getString(2);
//            String email = rs.getString(3);
//
//
//            return new UserProfile(username, email, password);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//    }
//}
