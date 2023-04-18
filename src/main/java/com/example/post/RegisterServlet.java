package com.example.post;

import com.example.post.dao.UserJdbcDao;
import com.example.post.model.User;
import com.example.post.service.RegisterService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User newUser = new RegisterService().createAUser(firstname,lastname,email,password);
        boolean newUserAdded = new UserJdbcDao().create(newUser);
        HttpSession session = req.getSession();
        if (newUserAdded) {
            session.setAttribute("userEmail", email);
            resp.sendRedirect(req.getContextPath() + "/userSession/posts-list");
        } else {
            req.setAttribute("isError", "Oops une erreur obscure est survenue");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            session.invalidate();
        }



    }
}
