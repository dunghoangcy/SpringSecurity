package com.dhacode.demo.services;

import com.dhacode.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

@Service
public class JwtService {
    private String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

    private long jwtExpiration = 86400000;

    private long refreshExpiration = 604800000;
    public String extractUserEmail(String token) {
        return extractClaim(token , Claims::getSubject);
    }


    private <T> T extractClaim(String token, Function<Claims , T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(UserDetails userDetails)
    {
        return generateToken(new HashMap<>() , userDetails);
    }

    private String generateToken(
            HashMap<String,Object> extractClaims,
            UserDetails userDetails
    ){
        return buildToken(extractClaims, userDetails , jwtExpiration);
    }

    private String buildToken(
            HashMap<String, Object> extractClaims,
            UserDetails userDetails,
            long jwtExpiration
    ) {
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public boolean isTokenValid(String token ,UserDetails userDetails)
    {
        final String username = extractUserEmail(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token , Claims::getExpiration);
    }


    public String generateRefreshToken( UserDetails userDetails) {
        return  buildToken(new HashMap<>(), userDetails , refreshExpiration);
    }
}
