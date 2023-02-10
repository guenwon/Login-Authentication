package com.example.jwtTest.Utill;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.constructor.Construct;

import java.security.*;
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
        HashMap<String , String> map = new HashMap<>();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key = String.valueOf(iterator.next());
            builder.claim(key, map.get(key));
        }

        return builder.signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }
}
