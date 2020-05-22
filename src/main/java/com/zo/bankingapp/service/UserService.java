package com.zo.bankingapp.service;

import com.zo.bankingapp.domain.User;

public interface UserService {

    public void createUser(User user);

    public void changePassword(User user, String newPassword);

    public void deleteUser(String user);

}
