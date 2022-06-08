package com.example.app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ApplicationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("+++++++ Start servlet after doGet +++++++");
        String message = "Hello!";
        request.setAttribute("message", message);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        ParsingURL.parsingURL();

        try {
            writer.println("<p>Name: " + name + "</p>");

        } finally {
            writer.close();
        }

    }

}
