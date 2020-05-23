package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactionsFromUser(String user);

    void addTransaction(Transaction transaction);

}
