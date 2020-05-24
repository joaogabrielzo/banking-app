package com.zo.bankingapp.domain;

import javax.persistence.*;
import java.sql.Timestamp;

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

    private double amount;

    @Column(name = "transaction_date")
    private Timestamp transactionDate;

    public Transaction() {

    }

    public void setFromUser(String fromUser) {

        this.fromUser = fromUser;
    }

    public void setToUser(String toUser) {

        this.toUser = toUser;
    }

    public void setTransactionType(String transactionType) {

        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    public void setTransactionDate(Timestamp transactionDate) {

        this.transactionDate = transactionDate;
    }

}
