package com.mithrundeal.swipebackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @PostMapping("/register")
    public String register() {

        return "here you register";
    }
}
