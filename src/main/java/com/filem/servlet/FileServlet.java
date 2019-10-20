package com.filem.servlet;


import com.filem.accounts.AccountService;
import com.filem.accounts.UserProfile;
import com.filem.tech.FilesList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = req.getSession().getId();
        UserProfile userProfile = AccountService.getUserBySessionId(sessionId);
        if (sessionId == null || userProfile == null){
            req.getRequestDispatcher("/templates/authorization.jsp").forward(req, resp);
            return;
        }
        String path = req.getParameter("path");
        String login = userProfile.getLogin();

        if (!path.contains(login)){
            resp.sendRedirect("http://localhost:8088/?path=C:\\" + login);
            return;
        }
        if (path == null) {
            getServletContext().getRequestDispatcher("/templates/error.jsp").forward(req, resp);
        } else {

            System.out.println(path);
            path = new String(path.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            FilesList filesList = new FilesList();
            if (filesList.setLists(path)) {
                req.setAttribute("dirs", filesList.getDirs());
                req.setAttribute("files", filesList.getFiles());
                req.setAttribute("parentsPath", filesList.getPath());
                getServletContext().getRequestDispatcher("/templates/index.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/templates/error.jsp").forward(req, resp);
            }
        }

    }
}
