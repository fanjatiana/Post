package com.example.post.dao;

import com.example.post.model.User;
import com.example.post.model.UserLogin;

public interface UserDao extends GenericDao<User,Long> {
    UserLogin findByUserEmailAndPassword (String userEmail, String userPassword);
}
