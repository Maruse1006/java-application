package com.example.demo.config;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.SimpleUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    private final UserRepository userRepository;

    public AppConfig(@Lazy UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    @Lazy
    public UserDetailsService customUserDetailsService() {
        return new SimpleUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public String secretKey() {
        return "YourSecretKey"; // 実際のシークレットキーに置き換えてください
    }
}
