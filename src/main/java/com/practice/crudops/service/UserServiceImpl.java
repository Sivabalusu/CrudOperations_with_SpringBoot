package com.practice.crudops.service;

import com.practice.crudops.domain.User;
import com.practice.crudops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optional = userRepository.findById(user.getUserId());
        if(optional.isEmpty()) {
            return null;
        }
        else {
            return userRepository.save(user);
        }
    }

    @Override
    public User deleteUser(int id) {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        else {
            user=optional.get();
        }
        return user;
    }

    @Override
    public User get(int id) {
        User user = null;
        Optional<User> optional = userRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }
        else {
            user=optional.get();
        }
        return user;
    }
}
