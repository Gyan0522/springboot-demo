package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import com.example.exceptions.UserNotFoundException;

@RestController
public class UserController {

    // Autowire the userService
    @Autowired
    private UserService userService;

    // getAllUsers Method
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getallUsers();
    }

    // Create user
    // @PostMapping Annotation
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    // getUserById
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }

    // updateUserById
    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUserById(id, user);
    }

    // deleteUserById
    @DeleteMapping("users/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);

    }

    // getUserByUsername
    @GetMapping("/users/byusername/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return userService.getUserByUsername(username);
    }
}
