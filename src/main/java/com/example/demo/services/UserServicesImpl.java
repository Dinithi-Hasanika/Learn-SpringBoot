package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.exceptions.APIException;
import com.example.demo.exceptions.ErrorResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.UserIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices{

    Logger log = LoggerFactory.getLogger(UserServicesImpl.class);

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
    public User addUser(User user) throws APIException {
        User newUser = null;
        try{
            user.setId(new UserIdGenerator().generateId());
           newUser = userRepository.saveAndFlush(user);
        }catch (Exception e){
            log.error("Error occurred while adding user",e);
            throw new APIException(HttpStatus.BAD_REQUEST,new ErrorResponse("Username Exists"));
        }
        return newUser;
    }
}
