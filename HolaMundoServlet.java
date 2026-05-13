package com.miapp;

// Importamos las clases necesarias de Jakarta EE
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// @WebServlet indica a Tomcat que esta clase responde a la URL /hola
@WebServlet("/")
public class HolaMundoServlet extends HttpServlet {
    private static int contadorVisitas = 0;
    // Este método se ejecuta cuando llega una petición GET a /hola
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Indicamos al navegador que la respuesta será texto HTML en UTF-8
        response.setContentType("text/html; charset=UTF-8");
        // Obtenemos el flujo de salida para escribir la respuesta
        PrintWriter out = response.getWriter();
        // Generamos el HTML que verá el usuario
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println(" <head><title>Mi primera app Java Web</title></head>");
        out.println("<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
        out.println(" <body>");
        out.println(" <h1 class=\"text-danger\">¡Hola desde Java!</h1>");
        out.println(" <p>Este texto lo generó un Servlet en el servidor.</p>");
        contadorVisitas++;
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String metodo = request.getMethod();
        out.println("<hr>");
        out.println("<h2 class=\"text-primary\">Bienvenido, César</h2>");
        out.println("<p>Fecha y hora en el servidor: " + fechaHora + "</p>");
        out.println("<p>Visitas desde que arrancó Tomcat: " + contadorVisitas + "</p>");
        out.println("<p>Método HTTP de esta petición: " + metodo + "</p>");
        out.println(" </body>");
        out.println("</html>");
    }
}
