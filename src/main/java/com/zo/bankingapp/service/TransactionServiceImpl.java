package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.*;
import com.zo.bankingapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository repo;

    @Override
    public List<Transaction> getTransactionsFromUser(String user) {

        return repo.findByFromUser(user);
    }

    @Override
    public void addTransaction(Transaction transaction) {

        repo.save(transaction);
    }

}
