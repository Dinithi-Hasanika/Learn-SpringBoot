package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.exceptions.APIException;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user) throws APIException {
        return ResponseEntity.ok(userServices.addUser(user));
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable String user_id) throws APIException {
        return ResponseEntity.ok(userServices.getUserById(user_id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userServices.getUsers());
    }

    @DeleteMapping("/user/{user_id}")
    public HttpStatus deleteUser(@PathVariable String user_id) throws APIException {
        userServices.deleteUserById(user_id);
        return HttpStatus.OK;
    }
}
