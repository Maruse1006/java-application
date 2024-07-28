package com.example.demo.controller;

import com.example.demo.jwt.JWTBuilder;
import com.example.demo.jwt.JWTDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {

    @Autowired
    private JWTBuilder jwtBuilder;

    @Autowired
    private JWTDecoder jwtDecoder;

    @GetMapping("/generate-token")
    public String generateToken(@RequestParam String email) {
        return jwtBuilder.build(email);
    }

    @GetMapping("/decode-token")
    public String decodeToken(@RequestParam String token) {
        return jwtDecoder.decodeJwt(token);
    }
}
