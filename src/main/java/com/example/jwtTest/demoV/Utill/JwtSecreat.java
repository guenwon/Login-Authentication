package com.example.jwtTest.demoV.Utill;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.security.*;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

@Component
public class JwtSecreat {
    PrivateKey privateKey;
    PublicKey publicKey;
    public JwtSecreat() throws NoSuchAlgorithmException {
        KeyPair keyPair = KeyPairGenerator.getInstance(SignatureAlgorithm.RS256.getFamilyName()).generateKeyPair();
        privateKey =  keyPair.getPrivate();
        publicKey = keyPair.getPublic();
    }

    public String makeJwtToken(HashMap<String, String> userMap){
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + 60*24);
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("")
                .setIssuedAt(now)
                .setExpiration(expireDate);
        Iterator userIterator = userMap.keySet().iterator();
        while(userIterator.hasNext()){
            String key = String.valueOf(userIterator.next());
            builder.claim(key, userMap.get(key));
        }

        return builder.signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    public void parseJwtToken(String authHeader){
        String token = extractToken(authHeader);

        Jwt jwt = Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parse(token);
    }

    private String extractToken(String auth){
        return auth.substring("Bearer ".length());
    }

    public byte[] jwtMapParser(String token){
        String[] tokens = token.split("\\.");
        if(tokens.length==3){
            return Base64.getUrlDecoder().decode(tokens[1]);
        }else{
            return null;
        }
    }
}
