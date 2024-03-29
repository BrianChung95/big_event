package com.brian;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Brian");
        String token = JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(new Date(System.currentTimeMillis() + 100 * 60 * 60 * 12))
                .sign(Algorithm.HMAC256("fdsklfjsadlkjalsdkfj"));

        System.out.println(token);
    }

    @Test
    public void testParse() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IkJyaWFuIn0sImV4cCI6MTcwOTY2ODU4OX0" +
                ".rHXSIdr5kUNaHfdvcMSZGYJkBwU0goYRIvqVCJv1uA4";

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("fdsklfjsadlkjalsdkfj")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        System.out.println(decodedJWT.getClaims().get("user"));
    }
}
