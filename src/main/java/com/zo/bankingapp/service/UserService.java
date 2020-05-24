package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.User;

import java.util.Optional;

public interface UserService {

    public Optional<User> getUser(String username);

    public User createUser(User user);

    public User changePassword(User user);

    public void deleteUser(String user);

}
