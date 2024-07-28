package com.example.demo.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JWTDecoder {

    @Autowired
    private Hash secret;

    // セッショントークン情報に含まれたメールアドレスを取得する処理
    public String decodeJwt(String token) {
        DecodedJWT decodedJWT;

        String secretKey = secret.getSecretKey();
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(secret.getTokenIssuer())
                .withSubject(secret.getTokenSubject())
                .build();

        decodedJWT = verifier.verify(token);
        List<String> userEmailList = decodedJWT.getAudience();
        return userEmailList.get(0);
    }
}
