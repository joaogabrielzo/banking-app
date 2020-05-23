package com.zo.bankingapp.repository;

import com.zo.bankingapp.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByFromUser(String user);
}
