package com.filem.servlet;

import com.filem.accounts.AccountService;
import com.filem.accounts.UserProfile;
import com.filem.service.AuthorizationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        AuthorizationService auth = new AuthorizationService();
        UserProfile user = auth.login(login, password);

        String href = "http://localhost:8088/?path=H:\\" + login;

        System.out.println("auth post");

        if (user == null) {
            request.getRequestDispatcher("/templates/registration.jsp").forward(request, response);
            return;
        }

        String sessionId = request.getSession().getId();
        AccountService.addSession(sessionId, user);

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