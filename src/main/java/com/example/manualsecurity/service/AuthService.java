package com.example.manualsecurity.service;

import com.example.manualsecurity.model.User;
import com.example.manualsecurity.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .isPresent();
    }

    public String getRole(String username) {
        return userRepository.findByUsername(username)
                .map(User::getRole)
                .orElse(null);
    }
}
