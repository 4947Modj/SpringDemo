package com.example.demo.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    private static final String signKey = "SpringbootVueDemoHelloWordSpringbootVueDemoHelloWord"; // 签名密钥
    private static final long expireTime = 3600000; // 过期时间，单位为毫秒，这里设置为1小时

    public static String createJwtToken(String username) {

        // 生成JWT Token
        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))
                .signWith(SignatureAlgorithm.HS512, signKey)
                .compact();

        return jwtToken;
    }

    public static Claims parseJwtToken(String jwtToken) {

        // 解析JWT Token
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwtToken)
                .getBody();

        return claims;
    }
}
