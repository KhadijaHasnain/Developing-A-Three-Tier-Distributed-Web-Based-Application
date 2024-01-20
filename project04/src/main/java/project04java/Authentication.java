package project04java;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authentication extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuser = request.getParameter("username");

        if ("root".equals(uuser)) {
            RequestDispatcher rd = request.getRequestDispatcher("rootHome.jsp");
            rd.forward(request, response);
        } else if ("dataentry".equals(uuser)) {
            RequestDispatcher rd = request.getRequestDispatcher("dataentryHome.jsp");
            rd.forward(request, response);
        } else if ("accountant".equals(uuser)) {
            RequestDispatcher rd = request.getRequestDispatcher("accountantHome.jsp");
            rd.forward(request, response);
        }else if ("client".equals(uuser)) {
            RequestDispatcher rd = request.getRequestDispatcher("clientHome.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("errorpage.html");
            rd.forward(request, response);
        }
    }
}


