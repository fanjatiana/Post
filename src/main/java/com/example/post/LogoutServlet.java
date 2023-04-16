package com.example.post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/userSession/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* si on souhaite supprimer la session et les données lors de la déconnexion :
        HttpSession httpSession=req.getSession();
        httpSession.invalidate();
        */

        // ici on veut garder les données lorsque l'on se déconnecte
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}