package com.exmple.Auth;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
  private final String secret = "secretkey123456";

  public String generateToken(String username) {
    return Jwts.builder()
      .setSubject(username)
      .setExpiration(new Date(System.currentTimeMillis() + 86400000))
      .signWith(SignatureAlgorithm.HS256, secret)
      .compact();
  }

  public String extractUsername(String token) {
    return Jwts.parser().setSigningKey(secret)
      .parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validate(String token) {
    try {
      extractUsername(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
