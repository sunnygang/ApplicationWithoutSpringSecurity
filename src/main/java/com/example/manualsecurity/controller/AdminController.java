package com.example.manualsecurity.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String admin(HttpSession session) {
        String role = (String) session.getAttribute("role");
        if(role != null && role.equals("ADMIN")) {
            return "Welcome, Admin!";
        }
        return "Access denied to non-admin!";
    }
}
