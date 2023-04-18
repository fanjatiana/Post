package com.example.post.dao;

import java.util.List;

public interface GenericDao<User,ID> {
    boolean create(User entity);

    List<User> findAll();

    User findById(ID id);

    void update(User entity);

    void delete(User entity);
}
