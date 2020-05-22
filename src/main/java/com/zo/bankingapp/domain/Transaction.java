package com.zo.bankingapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String from_user;

    private String to_user;

    private String transaction_type;

    private Float amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp transaction_date;
}
