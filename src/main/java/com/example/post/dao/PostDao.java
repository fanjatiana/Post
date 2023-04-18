package com.example.post.dao;

import com.example.post.model.Post;
import com.example.post.model.UserLogin;

public interface PostDao extends PostGenericDao<Post, Long> {
    Post findAllPosts(String title, String author, String content);

    Post createAPost(String title, String author, String content);
}
