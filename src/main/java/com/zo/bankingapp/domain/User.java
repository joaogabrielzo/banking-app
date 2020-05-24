package com.zo.bankingapp.domain;

import javax.persistence.*;

@Entity(name = "user")
public class User {

    @Id
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


    public String getUsername() {

        return username;
    }

    public String getPassword() {

        return password;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setPassword(String password) {

        this.password = password;
    }

}
