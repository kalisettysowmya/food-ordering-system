package com.example.foodordering.controller;


import com.example.foodordering.dto.LoginRequest;
import com.example.foodordering.dto.LoginResponse;
import com.example.foodordering.entity.User;
import com.example.foodordering.repository.UserRepository;
import com.example.foodordering.security.JwtService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthController(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request) {


        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(
                    () -> new RuntimeException(
                        "User not found"
                    )
                );


        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {


            return ResponseEntity
                    .badRequest()
                    .body("Invalid password");
        }


        String token =
                jwtService.generateToken(
                        user.getEmail()
                );


        return ResponseEntity.ok(
                new LoginResponse(token)
        );
    }
}