package com.example.jwtTest.demoV.Service;

import com.example.jwtTest.demoV.Utill.JwtSecreat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class JwtService {
    @Autowired
    JwtSecreat jwtSecreat;
    public byte[] jwtCreate(HashMap<String, String> req) {
        String token = jwtSecreat.makeJwtToken(req);
        String BearerToken = "Bearer " + token;
        jwtSecreat.parseJwtToken(BearerToken);
        return jwtSecreat.jwtMapParser(token);
    }


}
