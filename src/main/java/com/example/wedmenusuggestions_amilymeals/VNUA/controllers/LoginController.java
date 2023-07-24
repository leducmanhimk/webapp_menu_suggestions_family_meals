package com.example.wedmenusuggestions_amilymeals.VNUA.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String viewHomeLogin(){
        return "login";
    }
}
