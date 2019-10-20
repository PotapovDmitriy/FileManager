package com.filem.servlet;




import com.filem.tech.FilesList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class  FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getParameter("path");
        System.out.println(path);
        path = new String(path.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        if (path == null ) {
            getServletContext().getRequestDispatcher("/templates/error.jsp").forward(req, resp);
        }
        FilesList filesList = new FilesList();
        if ( path != null && filesList.setLists(path)) {
            req.setAttribute("dirs", filesList.getDirs());
            req.setAttribute("files", filesList.getFiles());
            req.setAttribute("parentsPath", filesList.getPath());
            getServletContext().getRequestDispatcher("/templates/index.jsp").forward(req, resp);
        } else {
            getServletContext().getRequestDispatcher("/templates/error.jsp").forward(req, resp);
        }

    }
}
