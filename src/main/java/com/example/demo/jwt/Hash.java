package com.example.demo.jwt;

import org.springframework.stereotype.Component;

@Component
public class Hash {

    private static final String secretKey = "lkhapsjf[jtpqu959qy34jlroqhefa"; // 任意の文字列
    private static final String tokenIssuer = "your_name"; // 発行者の名前
    private static final String tokenSubject = "service_token"; // 任意のトークン名

    public String getSecretKey() {
        return secretKey;
    }

    public String getTokenIssuer() {
        return tokenIssuer;
    }

    public String getTokenSubject() {
        return tokenSubject;
    }
}
