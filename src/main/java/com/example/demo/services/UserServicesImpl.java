package com.example.demo.services;

import com.example.demo.constants.UserServiceConstants;
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
            throw new APIException(HttpStatus.NOT_FOUND,new ErrorResponse(UserServiceConstants.USER_NOT_FOUND));
        }
        return user;
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
        if (log.isDebugEnabled()) {
            log.debug("User ID "+id+" Deleted.");
        }
    }

    @Override
    public User addUser(User user) throws APIException {
        User newUser;
        try{
            user.setId(new UserIdGenerator().generateId());
           newUser = userRepository.saveAndFlush(user);
        }catch (Exception e){
            log.error("Error occurred while adding user",e);
            throw new APIException(HttpStatus.BAD_REQUEST,new ErrorResponse(UserServiceConstants.USERNAME_EXISTS));
        }
        return newUser;
    }
}
