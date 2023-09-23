package com.teamthree.common.jwt;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

public class JwtHelper {
    private static long tokenExpiration = 365 * 24 * 60 * 60 * 1000;
    private static String tokenSignKey = "5211677";

    public static String createToken(Long userId, String username) {
        String token = Jwts.builder()
                .setSubject("AUTH-LOGIN-USER")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))

                .claim("userId", userId)
                .claim("username", username)

                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    public static Long getUserId(String token) {
        try {
            if (StringUtils.isEmpty(token)) return null;

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            Integer userId = (Integer) claims.get("userId");
            return userId.longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUsername(String token) {
        try {
            if (StringUtils.isEmpty(token)) return "";

            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            return (String) claims.get("username");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String token = JwtHelper.createToken(6L, "lisa");
        System.out.println(token);
        Long userId = JwtHelper.getUserId(token);
        String username = JwtHelper.getUsername(token);
        System.out.println(userId);
        System.out.println(username);
    }
}
