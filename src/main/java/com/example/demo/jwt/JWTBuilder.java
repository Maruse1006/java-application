package com.example.demo.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTBuilder {

    private static final Long EXPIRATION_TIME = 1000L * 60L * 60L * 1L; // 1時間

    @Autowired
    private Hash secret;

    // セッショントークン生成するメソッド
    public String build(String userEmail) {

        // 生成のため、日時データを取得する
        Date issuedAt = new Date();
        Date notBefore = new Date(issuedAt.getTime());
        Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);

        String secretKey = secret.getSecretKey();

        // ヘッダー部へのアルゴリズムとハッシュ値を指定する
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        // トークンの生成
        String token = JWT.create()
                .withIssuer(secret.getTokenIssuer())  // トークン発行者情報
                .withSubject(secret.getTokenSubject()) // トークンの主体
                .withAudience(userEmail)    // トークンの利用者（メールアドレスを用いてトークンを一意にする）
                .withIssuedAt(issuedAt)     // 発行日時
                .withNotBefore(notBefore)   // トークンの有効期間開始時間
                .withExpiresAt(expiresAt)   // トークンの有効期間終了時間
                .sign(algorithm);           // アルゴリズム指定して、署名を行う
        return token;
    }
}
