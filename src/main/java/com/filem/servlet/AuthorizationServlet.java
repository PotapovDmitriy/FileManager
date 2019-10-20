package com.filem.servlet;

import com.filem.accounts.AccountService;
import com.filem.accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String href = "http://localhost:8088/?path=D:\\" + login;

        System.out.println("auth post");

        UserProfile userProfile = AccountService.getUserByLogin(login);

        if (userProfile == null || !userProfile.getPass().equals(password)){
            request.getRequestDispatcher("/templates/registration.jsp").forward(request, response);
            return;
        }

        String sessionId = request.getSession().getId();
        AccountService.addSession(sessionId, userProfile);

        response.sendRedirect(href);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.getRequestDispatcher("/templates/authorization.jsp").forward(request, response);
        System.out.println("auth get");


    }


    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String sessionId = request.getSession().getId();
        AccountService.deleteSession(sessionId);
    }
}