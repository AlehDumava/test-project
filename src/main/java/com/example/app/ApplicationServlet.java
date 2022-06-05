package com.example.app;



import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ApplicationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("+++++++ Start servlet after doGet +++++++");
        String message = "Hello!";
        request.setAttribute("message", message);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        System.out.println("+++++++ Start servlet after doPost +++++++");

    }

}
