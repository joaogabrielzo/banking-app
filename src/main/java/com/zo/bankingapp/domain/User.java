package com.zo.bankingapp.domain;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "user")
@Data
public class User {

    @Id
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;


}
