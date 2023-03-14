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
    public User getUserById(String id) throws APIException {

        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            if (log.isDebugEnabled()) {
                log.debug("User with id: "+id+" not found");
            }
            throw new APIException(HttpStatus.NOT_FOUND,new ErrorResponse("User Not Found"));
        }
        return user;
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public User addUser(User user) throws APIException {
        User newUser;
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
