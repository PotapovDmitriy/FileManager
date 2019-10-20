package com.filem.servlet;

import com.filem.accounts.AccountService;
import com.filem.accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.getRequestDispatcher("/templates/registration.jsp").forward(request, response);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        System.out.println("reg get");
        UserProfile user = new UserProfile(login, password, email);
        AccountService.addNewUser(user);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        System.out.println("reg Post");
        UserProfile user = new UserProfile(login, password, email);
        AccountService.addNewUser(user);
        request.getRequestDispatcher("/templates/authorization.jsp").forward(request, response);

    }
}