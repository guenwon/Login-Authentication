package com.example.jwtTest.demoV.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @GetMapping("/")
    public String main(){
        return "index.html";
    }
}
