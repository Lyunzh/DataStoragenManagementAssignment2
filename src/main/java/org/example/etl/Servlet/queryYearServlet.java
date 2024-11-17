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

@WebServlet(name = "queryVersionServlet", value = "/queryYear.jsp")
public class queryYearServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String year = request.getParameter("year");
        List<MergeMovie> result = MovieQuery.queryByTime(year);
        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Actorresult.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}