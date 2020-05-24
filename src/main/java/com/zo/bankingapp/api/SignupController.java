package com.zo.bankingapp.api;

import com.zo.bankingapp.domain.User;
import com.zo.bankingapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    UserServiceImpl service;
    AccountServiceImpl account;

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {

        URI location = generateURI(user.getUsername());

        service.createUser(user);
        account.createAccount(user.getUsername());

        return ResponseEntity.created(location).build();
    }

    private URI generateURI(String username) {

        return URI.create("http://localhost:8080/v1/user/" + username);
    }
}
