package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.exceptions.UserNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // getallUsers method
    public List<User> getallUsers() {
        return userRepository.findAll();
    }

    // CreateUser Method
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // getUserById
    public Optional<User> getUserById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User not found in user repository");
        }
        return user;
    }

    // updateUserById
    public User updateUserById(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    // deleteUswerById
    public void deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    // getUserByUsername
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
