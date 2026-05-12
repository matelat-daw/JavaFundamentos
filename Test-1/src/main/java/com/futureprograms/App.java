package com.futureprograms;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet que sirve la aplicación en Tomcat
 */
public class App extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>JavaFundamentos App</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
        out.println("h1 { color: #333; }");
        out.println(".info { background-color: #f0f0f0; padding: 15px; border-radius: 5px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>¡Bienvenido a JavaFundamentos!</h1>");
        out.println("<div class='info'>");
        out.println("<p><strong>Servidor:</strong> Apache Tomcat</p>");
        out.println("<p><strong>Puerto:</strong> 8080</p>");
        out.println("<p><strong>Hora del servidor:</strong> " + new java.util.Date() + "</p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}