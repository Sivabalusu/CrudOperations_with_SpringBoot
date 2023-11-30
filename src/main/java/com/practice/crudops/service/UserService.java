package com.practice.crudops.service;

import com.practice.crudops.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    User updateUser(User user);
    User deleteUser(int id);

}
