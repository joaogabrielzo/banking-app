package com.zo.bankingapp.api;

import com.zo.bankingapp.domain.Transaction;
import com.zo.bankingapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.Timestamp;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/v1/account")
public class AccountController {

    final URI location = URI.create("http://localhost:8080/v1/account");

    @Autowired
    AccountActionsImpl action;
    TransactionServiceImpl transactionService;

    @GetMapping()
    public ResponseEntity getAccount() {

        String username = currentUsername();

        return ResponseEntity.ok(action.getBalance(username));
    }

    @PostMapping("/deposit")
    public ResponseEntity makeDeposit(@RequestBody double amount) {

        String username = "@"+currentUsername();

        action.deposit(username, amount);

        Thread addTransaction = new Thread(() -> addTransaction(username, username, "deposit", amount));

        addTransaction.start();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/withdraw")
    public ResponseEntity makeWithdraw(@RequestBody double amount) {

        String username = "@"+currentUsername();

        action.withdraw(username, amount);

        Thread addTransaction = new Thread(() -> addTransaction(username, username, "withdraw", amount));

        addTransaction.start();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/transfer")
    public ResponseEntity makeTransfer(@RequestBody String toUser, double amount) {

        String username = "@"+currentUsername();

        action.transfer(username, amount, toUser);

        Thread addTransaction = new Thread(() -> addTransaction(username, toUser, "transfer", amount));

        addTransaction.start();

        return ResponseEntity.created(location).build();
    }

    private String currentUsername() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return principal instanceof UserDetails ?
                ((UserDetails) principal).getUsername() :
                principal.toString();
    }

    private void addTransaction(String fromUser, String toUser, String type, double amount) {

        Transaction newTransaction = new Transaction();
        newTransaction.setFromUser(fromUser);
        newTransaction.setToUser(toUser);
        newTransaction.setAmount(amount);
        newTransaction.setTransactionType(type);
        newTransaction.setTransactionDate(new Timestamp(System.currentTimeMillis()));

        transactionService.addTransaction(newTransaction);
    }

}
