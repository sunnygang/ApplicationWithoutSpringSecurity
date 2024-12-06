package com.example.manualsecurity.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String user(HttpSession session) {
        String role = (String) session.getAttribute("role");
        if(role != null && (role.equals("USER") || role.equals("ADMIN"))) {
            return "Welcome, User!";
        }
        return "Access Denied!";
    }
}
