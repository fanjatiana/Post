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


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /*  HttpSession session = req.getSession();
        String choice = req.getParameter("supprimer") != null ? "supprimer" : "modifier";
        if (choice.equals("supprimer")) {
            session.setAttribute("choice", choice);
            PostService postService = new PostService();
            List<Post> postList = postService.deletePost(Integer.parseInt(choice));
            System.out.println("id session" + session + " " + choice);
            req.setAttribute("postList", postList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/posts-list.jsp");
            requestDispatcher.forward(req, resp);
        } else if (choice.equals("modifier")) {
            session.setAttribute("choice", choice);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form-posts.jsp");
            requestDispatcher.forward(req, resp);
            resp.sendRedirect(req.getContextPath()+"/userSession/form-posts");
        }*/
        HttpSession session = req.getSession();
        PostService postService = new PostService();
        String btnDelete = req.getParameter("buttonId");
        String btnUpdate = req.getParameter("btnUpdate");
         if(btnDelete != null){
             session.setAttribute("buttonId", btnDelete);

             List<Post> postList = postService.deletePost(Integer.parseInt(btnDelete));
             System.out.println("id session" + session + " " + btnDelete);
             req.setAttribute("postList", postList);
             RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/posts-list.jsp");
             requestDispatcher.forward(req, resp);
         }else if(btnUpdate != null){
             session.setAttribute("btnUpdate", btnUpdate);
             System.out.println(btnUpdate);
             Post thispost = postService.getPostById(Integer.parseInt(btnUpdate));
             Post postUpdate = postService.updatePost(thispost);
             req.setAttribute("post", postUpdate);
             RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form-posts.jsp");
             requestDispatcher.forward(req, resp);
             resp.sendRedirect(req.getContextPath()+"/userSession/form-posts");
         }

       /* String btnUpdate = req.getParameter("btnUpdate");
        HttpSession session = req.getSession();
        session.setAttribute("buttonId", btnId);
        PostService postService = new PostService();
        List<Post> postList = postService.deletePost(Integer.parseInt(btnId));
        System.out.println("id session" + session + " " + btnId);
        req.setAttribute("postList", postList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/posts-list.jsp");
        requestDispatcher.forward(req, resp);*/
    }
}