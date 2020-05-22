package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.Transaction;

import java.util.List;

public interface TransactionService {

    public void deposit(Float amount);

    public void withdraw(Float amount);

    public void transfer(Float amount, String toUser);

    public void pay(Float amount, String to);

    public List<Transaction> getTransactionsFromUser(String user);


}
