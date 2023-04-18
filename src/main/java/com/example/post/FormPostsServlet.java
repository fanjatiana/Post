package com.example.post;

import com.example.post.dao.PostJdbcDao;
import com.example.post.dao.UserJdbcDao;
import com.example.post.model.Post;
import com.example.post.model.User;
import com.example.post.model.UserLogin;
import com.example.post.service.RegisterService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.post.service.PostService;

import java.io.IOException;


@WebServlet(urlPatterns = "/userSession/form-posts")
public class FormPostsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/form-posts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // recupérer les données du formulaire form-posts (req.getParameter) et les afficher dans posts-list
        String title = request.getParameter("title");// recupère la valeur du name des inputs, textarea
        System.out.println(title);
        //String postImage=request.getParameter("postImage");
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        Post newPost = new PostService().createNewPost(title, author, content);
        System.out.println(newPost);
        boolean newPostAdded = new PostJdbcDao().create(newPost);
        if (newPostAdded) {
            response.sendRedirect(request.getContextPath() + "/userSession/posts-list");
        } else {
            System.out.println("error!");

        }
    }
}
