package com.filem.accounts;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public int getId() {
        return id;
    }
    private int id;


    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    public UserProfile() {
    }

    public UserProfile( String login, String password, String email) {
//        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }



    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}