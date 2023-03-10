package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {

        return null;
    }

    @Override
    public User getUserById(int id) {

        return null;
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public User addUser(User user) {

        return userRepository.saveAndFlush(user);
    }
}
