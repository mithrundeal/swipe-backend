package com.mithrundeal.swipebackend.controller;

import com.mithrundeal.swipebackend.dto.LoginRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login")
    public String login() {

        return "here you register";
    }
}
