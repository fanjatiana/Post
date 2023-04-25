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
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/userSession/posts-list")
public class PostsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostService postService = new PostService();
        List<Post> postList = postService.fetchAllPostsFromBdd();
        request.setAttribute("postList", postList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/posts-list.jsp");
        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PostService postService = new PostService();
        String btnDelete = req.getParameter("btnDelete");
        String btnUpdate = req.getParameter("btnUpdate");
        if (btnDelete != null) {
            session.setAttribute("btnDelete", btnDelete);
            List<Post> postList = postService.deletePost(btnDelete);
            req.setAttribute("postList", postList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/posts-list.jsp");
            requestDispatcher.forward(req, resp);
        } else if (btnUpdate != null) {
            /* Post thispost = postService.getPostById(btnUpdate);
             Post postUpdate = postService.updatePost(thispost);
             req.setAttribute("post", postUpdate);*/
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form-posts.jsp");
            requestDispatcher.forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/userSession/form-posts");
        }


    }
}