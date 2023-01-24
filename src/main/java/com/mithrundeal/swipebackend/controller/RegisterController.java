package com.mithrundeal.swipebackend.controller;

import com.mithrundeal.swipebackend.Logger;
import com.mithrundeal.swipebackend.dto.SwipeUser;
import com.mithrundeal.swipebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public boolean register(@RequestBody SwipeUser user) {
        //TODO: error handling, add contains method against repetitive users
        try {
            if (user.getUserName() != null && user.getEmail() != null && user.getPassword() != null) {
                userRepository.save(new SwipeUser(user.getUserName(), user.getEmail(), user.getPassword()));
                return true;
            }
        } catch (Exception e) {
            Logger.log(e.getMessage());
            return false;
        }
        return false;
    }
}
