package com.example.post;

import dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import model.UserLogin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/", "/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    // Login avec database
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        req.setAttribute("isError", "");
        try {
            UserLogin user = new UserDao().findUser(email, password);
            if (user != null) {
                session.setAttribute("userEmail", email);
                //session.setAttribute("userPassword",password);
                System.out.println(session.getAttribute("userEmail"));
                req.setAttribute("isError", "");
                resp.sendRedirect(req.getContextPath() + "/userSession/posts-list");
            } else {
                req.setAttribute("isError", "Oops utilisateur ou mot de passe inconnu");
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
                session.invalidate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* login sans database

        if(email != null && email.equals("monEmail@email.com") && password != null && password.equals("petitChat44")){
            session.setAttribute("userEmail", email);
            //session.setAttribute("userPassword",password);
            System.out.println(session.getAttribute("userEmail"));
            resp.sendRedirect(req.getContextPath()+"/userSession/posts-list");
        } else if (!email.equals("monEmail@email.com")  || !password.equals("petitChat44")  ){
            req.setAttribute("isError", "Oops utilisateur ou mot de passe inconnu");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
            session.invalidate();
        } else {
            req.setAttribute("isError", "Une erreur obscure est apparue soudainement");
        }*/
    }
}

