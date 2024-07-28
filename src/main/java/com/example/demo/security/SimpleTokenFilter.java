package com.example.demo.security;

import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleTokenFilter extends OncePerRequestFilter {
    private final UserRepository userRepository;
    private final String secretKey;

    public SimpleTokenFilter(UserRepository userRepository, @Value("${security.secret-key}") String secretKey) {
        this.userRepository = userRepository;
        this.secretKey = secretKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // トークンの検証ロジックをここに追加
        filterChain.doFilter(request, response);
    }
}
