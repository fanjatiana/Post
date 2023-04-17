package com.example.post;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/userSession")
public class AuthentificationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = request;
        HttpServletResponse httpServletResponse = response;
        HttpSession httpSession=httpServletRequest.getSession();

        if(httpSession.getAttribute("email") != null && httpSession.getAttribute("password") != null){
            chain.doFilter(request,response);
        }else{
            httpServletResponse.sendRedirect(request.getContextPath() + "/login");
        }
    }
}
