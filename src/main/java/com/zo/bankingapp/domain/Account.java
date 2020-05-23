package com.zo.bankingapp.domain;

import lombok.*;

import javax.persistence.*;

@Entity(name = "account")
public class Account {

    @Id
    @Column(unique = true)
    private String username;

    private double balance;

    public Account(String user, double newBalance) {

    }

    public double getBalance() {

        return balance;
    }

}
