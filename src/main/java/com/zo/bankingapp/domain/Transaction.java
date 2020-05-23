package com.zo.bankingapp.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.*;

@Entity(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, name = "from_user")
    private String fromUser;

    @Column(name = "to_user")
    private String toUser;

    @Column(name = "transaction_type")
    private String transactionType;

    private Float amount;

    private Timestamp transaction_date;

    public Transaction(Long id,
                       String fromUser,
                       String toUser,
                       String transactionType,
                       Float amount,
                       Timestamp transaction_date) {

        this.id               = id;
        this.fromUser         = fromUser;
        this.toUser           = toUser;
        this.transactionType  = transactionType;
        this.amount           = amount;
        this.transaction_date = transaction_date;
    }

}
