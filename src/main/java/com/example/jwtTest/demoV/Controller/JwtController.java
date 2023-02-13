package com.example.jwtTest.demoV.Controller;

import com.example.jwtTest.demoV.Service.JwtService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class JwtController {
    @Autowired
    JwtService jwtService;
    @ResponseBody
    @PostMapping("/jwtTest")
    public byte[] jwtTest(@RequestBody HashMap<String, String> req){
        return jwtService.jwtCreate(req);
    }
    @ResponseBody
    @GetMapping("/test")
    public String apiTest(){
        System.out.println("hi test");
        return "Hi";
    }


}
