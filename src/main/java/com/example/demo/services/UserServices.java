package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.exceptions.APIException;

import java.util.List;

public interface UserServices {

    List<User> getUsers();

    User getUserById(String id) throws APIException;

    void deleteUserById(String id);

    User addUser(User user) throws APIException;

}
