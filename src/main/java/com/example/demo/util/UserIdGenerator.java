package com.example.demo.util;

import java.util.UUID;

public class UserIdGenerator {

    public String generateId(){
        return UUID.randomUUID().toString();
    }

}
