package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.ok(userServices.addUser(user));
    }
}
