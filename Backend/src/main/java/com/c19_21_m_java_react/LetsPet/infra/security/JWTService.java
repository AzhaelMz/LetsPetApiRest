package com.c19_21_m_java_react.LetsPet.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

    @Value("${api.security.secret}")
    private String apiSecret;
    try {
        Algorithm algorithm = Algorithm.HMAC256(apiSecret);
        return JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);
    } catch (
    JWTCreationException exception){
        // Invalid Signing configuration / Couldn't convert Claims.
    }
}
