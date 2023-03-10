package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.UserIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public User addUser(User user) {
        User newUser = null;
        try{
            user.setId(new UserIdGenerator().generateId());
           newUser = userRepository.saveAndFlush(user);
        }catch (Exception e){
            newUser = null;
        }
        return newUser;
    }
}
