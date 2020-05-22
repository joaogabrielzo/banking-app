package com.zo.bankingapp.repository;

import com.zo.bankingapp.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
