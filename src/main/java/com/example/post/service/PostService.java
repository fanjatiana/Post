package com.example.post.service;

import com.example.post.dao.PostJdbcDao;
import com.example.post.model.Post;
import com.example.post.ressource.PostDto;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    public List<Post> fetchAllPostsFromBdd() {
        List<Post> bddPosts = new PostJdbcDao().findAll();
        return bddPosts;
    }

    int id = 0;
    public Boolean createNewPost(String title, String author, String content) {
        Post newPost = new Post(++id, title, author, content);
        boolean newPostAdded = new PostJdbcDao().create(newPost);
        return newPostAdded;
    }


    public List<Post> deletePost(String id) {
        List<Post> bddPosts = new PostJdbcDao().findAll();
        int thisId = new PostJdbcDao().delete(Integer.valueOf(id));
        bddPosts.removeIf(post -> post.equals(thisId));
        return bddPosts;
    }

    public Post updatePost(Post post) {
        new PostJdbcDao().update(post);
        return post;
    }

    public Post getPostById(String id) {
        return new PostJdbcDao().findById(Integer.valueOf(id));
    }

    public int getId() {
        return id;
    }
}
