package com.example.demo.security;

import com.example.demo.jwt.JWTBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(SimpleAuthenticationSuccessHandler.class);
    private final JWTBuilder jwtBuilder;

    public SimpleAuthenticationSuccessHandler(JWTBuilder jwtBuilder) {
        this.jwtBuilder = jwtBuilder;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        org.springframework.security.core.Authentication authentication) throws IOException {
        String userEmail = authentication.getName();
        String token = jwtBuilder.build(userEmail);

        logger.info("Authentication successful for user: {}", userEmail);
        logger.info("Generated JWT token: {}", token);

        response.setHeader("Authorization", "Bearer " + token);
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/homepage");
    }
}
