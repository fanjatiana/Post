package com.example.post.service;

import com.example.post.model.Post;
import com.example.post.model.User;

import java.util.ArrayList;
import java.util.List;

public class RegisterService {
    private List<User> newUser = new ArrayList<>();
    // create new user
    public User createAUser(String firstname, String lastname, String password, String email) {
        Long id = 0L;
        User newUser = new User(++id, firstname, lastname, password, email);
        return newUser;
    }

}

