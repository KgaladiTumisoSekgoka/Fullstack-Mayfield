package com.mayfield.Mayfield.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.mayfield.Mayfield.model.User;
import com.mayfield.Mayfield.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}   