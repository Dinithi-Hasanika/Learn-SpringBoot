package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.exceptions.APIException;

import java.util.List;

public interface UserServices {

    List<User> getUsers();

    User getUserById(int id);

    void deleteUserById(int id);

    User addUser(User user) throws APIException;

}
