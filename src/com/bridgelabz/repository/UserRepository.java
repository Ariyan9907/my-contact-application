package com.bridgelabz.repository;

import com.bridgelabz.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private final List<User> users=new ArrayList<>();

    //Adding user
    public void save(User u){
        users.add(u);
    }

    //finding by email
    public boolean existsByEmail(String email){
        return users.stream()
                .anyMatch(u->u.getEmail().equals(email));
    }

    //returning by email
    public User findUserByEmail(String email){

        return users.stream()
                .filter(u->u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    //returning all email
    public List<User> findALl(){
        return users;
    }



}
