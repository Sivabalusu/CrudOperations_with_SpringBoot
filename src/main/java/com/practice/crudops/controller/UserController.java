package com.practice.crudops.controller;

import com.practice.crudops.domain.User;
import com.practice.crudops.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("app/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> usersList = userService.getAllUsers();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(int userId) {
        User user = userService.get(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        if(savedUser == null) {
            return new ResponseEntity<>("Invalid User", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        User deletedUser = userService.deleteUser(id);
        if(deletedUser == null) {
            return new ResponseEntity<>("Invalid User", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }
}
