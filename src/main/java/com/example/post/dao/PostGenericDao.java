package com.example.post.dao;

import java.util.List;

public interface PostGenericDao<Post, ID> {
    boolean create(Post element);

    List<Post> findAll();

    Post findById(ID id);

    void update(Post element);

    int delete(ID id);
}
