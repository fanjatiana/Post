package com.example.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/","/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        HttpSession session= req.getSession();

        if(email != null && email.equals("monEmail@email.com") && password != null && password.equals("petitChat44")){
            session.setAttribute("userEmail", email);
            session.setAttribute("userPassword",password);
            resp.sendRedirect(req.getContextPath()+"/userSession/posts-list");
        } else{
            req.setAttribute("isError", true);
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
        }
    }
}
