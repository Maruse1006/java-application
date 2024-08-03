package com.example.demo.security;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final String secretKey;

    public SimpleAuthenticationSuccessHandler(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
                                        org.springframework.security.core.Authentication authentication) throws IOException {
        // トークン生成やその他の処理をここに追加
        response.setStatus(HttpServletResponse.SC_OK);

        // ログイン成功後にリダイレクトするURLを指定
        response.sendRedirect("/homepage"); // ここをリダイレクト先のURLに変更
    }
}
