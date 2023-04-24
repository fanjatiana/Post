package com.example.post;

import com.example.post.ressource.PostResource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.post.model.Post;
import com.example.post.service.PostService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/userSession/posts-list")
public class PostsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* recupération depuis classe post
        PostService postService = new PostService();
        List<Post> postList = postService.fetchAllPosts();*/

        /* récupération depuis bdd
        List<Post> postList = postService.fetchAllPostsFromBdd();*/

        // récupération depuis json
        PostResource postResource = new PostResource();
        List<Post> postList = postResource.getPosts();

        request.setAttribute("postList", postList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/posts-list.jsp");
        requestDispatcher.forward(request, response);
    }
}