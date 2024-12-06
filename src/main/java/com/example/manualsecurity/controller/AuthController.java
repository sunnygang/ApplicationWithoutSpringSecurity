package com.example.manualsecurity.controller;

import com.example.manualsecurity.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if(authService.authenticate(username, password)) {
            session.setAttribute("username", username);
            session.setAttribute("role", authService.getRole(username));
            return "Login Successful!";
        } else {
            return "Invalid credentials!";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "You have been logged out";
    }
}
