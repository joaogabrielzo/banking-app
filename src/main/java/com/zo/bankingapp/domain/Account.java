package com.zo.bankingapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "account")
@Data
public class Account {

    @Id
    @Column(unique = true)
    private String username;

    private final double balance = 0.0;

}
