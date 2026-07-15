package com.example.foodordering.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;


@Service
public class JwtService {


    private final String SECRET_KEY =
            "myverysecretkeymyverysecretkey123456";


    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );
    }


    public String generateToken(String email) {


        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                    new Date(
                       System.currentTimeMillis()
                       + 1000 * 60 * 60
                    )
                )
                .signWith(
                    getSigningKey(),
                    SignatureAlgorithm.HS256
                )
                .compact();
    }
}