package com.example.demo.controller;

import com.example.demo.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String username,
            @RequestParam String password) {

        if ("admin".equals(username)
                && "password".equals(password)) {

            String token =
                    jwtUtil.generateToken(username);

            return Map.of(
                    "token", token
            );
        }

        throw new RuntimeException("Invalid Credentials");
    }
}