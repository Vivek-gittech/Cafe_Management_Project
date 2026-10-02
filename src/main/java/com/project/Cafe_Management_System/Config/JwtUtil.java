package com.project.Cafe_Management_System.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class JwtUtil {

    // Overload validateToken to accept a single String parameter
    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    // Original two-argument validateToken method
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // Single-argument claim extractors expected by JwtFilter
    public String getEmail(String token) {
        return extractClaim(token, claims -> claims.get("email", String.class));
    }

    public String getRole(String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private Boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new java.util.Date());
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }
}