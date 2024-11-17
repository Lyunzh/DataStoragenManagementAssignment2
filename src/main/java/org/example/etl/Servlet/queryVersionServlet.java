package org.example.etl.Servlet;


import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.etl.qAction.MovieQuery;
import org.example.etl.Entity.OriginalMovie;
import jakarta.servlet.annotation.*;

@WebServlet(name = "queryVersionServlet", value = "/queryVersion.jsp/query")
public class queryVersionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("queryVersionServlet");
        String movieName = request.getParameter("movieName");
        List<OriginalMovie> result = MovieQuery.queryByName(movieName);
        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Versionresult.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}