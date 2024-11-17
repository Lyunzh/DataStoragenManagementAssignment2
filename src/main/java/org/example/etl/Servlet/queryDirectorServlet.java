package org.example.etl.Servlet;


import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.etl.Entity.MergeMovie;
import org.example.etl.qAction.MovieQuery;
import org.example.etl.Entity.OriginalMovie;
import jakarta.servlet.annotation.*;

@WebServlet(name = "queryVersionServlet", value = "/queryVersion.jsp/query")
public class queryDirectorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String DirectorName = request.getParameter("DirectorName");
        List<MergeMovie> result = MovieQuery.queryByDirector(DirectorName);
        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Actorresult.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}