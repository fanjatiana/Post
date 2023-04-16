package com.example.post;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Post;
import service.PostService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/userSession/posts-list")
public class PostsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostService postService = new PostService();
        List<Post> postList = postService.fetchAllPosts();
        request.setAttribute("postList", postList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/posts-list.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> newList = new PostService().fetchAllPosts();
        String boutonId = req.getParameter("buttonId").toString();
        for (Post post : newList) {
            /*if(post.getId().toString().equals(boutonId)){
                new PostService().deletePost(Long.valueOf(boutonId));
            }*/

            new PostService().deletePost(Long.valueOf(boutonId));
        }

        resp.sendRedirect(req.getContextPath() + "/userSession/posts-list");
    }
}