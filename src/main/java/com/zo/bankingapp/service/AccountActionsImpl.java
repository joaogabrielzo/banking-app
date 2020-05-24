package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.*;
import com.zo.bankingapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Optional;

@Service
public class AccountActionsImpl implements AccountActions {

    @Autowired
    AccountRepository repo;

    @Override
    public double getBalance(String user) {

        String username = "@"+user;

        Optional<Account> account = repo.findById(username);

        if (account.isPresent()) {
            return account.get().getBalance();
        } else throw new RuntimeException("Account not found");
    }

    @Override
    public void deposit(String user, double amount) {

        String username = "@"+user;

        Thread depositAction = new Thread(() -> {
            increaseBalance(username, amount);
        }, "deposit");

        depositAction.start();
    }

    @Override
    public void withdraw(String user, double amount) {

        String username = "@"+user;

        Thread withdrawAction = new Thread(() -> {
            decreaseBalance(username, amount);
        }, "withdraw");

        withdrawAction.start();
    }

    @Override
    public void transfer(String user, double amount, String toUser) {

        String username = "@"+user;

        Thread decreaseAction = new Thread(() -> {
            decreaseBalance(username, amount);
        }, "decrease");

        Thread increaseAction = new Thread(() -> {
            increaseBalance(toUser, amount);
        }, "increase");

        decreaseAction.start();
        increaseAction.start();

    }

    private synchronized void increaseBalance(String user, double amount) {

        double actualBalance = getBalance(user);

        double newBalance = actualBalance + amount;

        repo.save(new Account(user, newBalance));
    }

    private synchronized void decreaseBalance(String user, double amount) {

        double actualBalance = getBalance(user);

        double newBalance = actualBalance - amount;

        repo.save(new Account(user, newBalance));
    }

}
