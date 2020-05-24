package com.zo.bankingapp.api;

import com.zo.bankingapp.domain.User;
import com.zo.bankingapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserServiceImpl service;
    AccountServiceImpl account;

    @GetMapping("/{username}")
    public ResponseEntity getUserInfo(@PathVariable("username") String username) {

        Optional<User> userInfo = service.getUser(username);

        return userInfo.map(u -> ResponseEntity.ok(u.getUsername())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{username}")
    public ResponseEntity changePassword(@PathVariable("username") User user) {

        User newPassword = service.changePassword(user);

        return ResponseEntity.ok("Password changed.");
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteUser(@PathVariable("username") String username) {

        service.deleteUser(username);
        account.endAccount(username);

        return ResponseEntity.ok("User deleted");
    }


}
