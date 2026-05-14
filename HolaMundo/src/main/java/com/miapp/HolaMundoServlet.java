package com.miapp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger; // Para hilos seguros

@WebServlet("/hola") // Cambiado para evitar conflictos con archivos estáticos
public class HolaMundoServlet extends HttpServlet {
    
    // AtomicInteger garantiza que el conteo sea correcto con múltiples usuarios
    private final AtomicInteger contadorVisitas = new AtomicInteger(0);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Obtener el nombre del parámetro
        String nombre = request.getParameter("nombre");
        
        // Incrementa el contador de forma segura
        int visitasActuales = contadorVisitas.incrementAndGet();
        
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String metodo = request.getMethod();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <title>Mi primera app Java Web</title>");
        out.println("    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css'>");
        out.println("</head>");
        out.println("<body class='container mt-5'>"); // Añadido contenedor Bootstrap
        out.println("    <h1 class='text-danger'>¡Hola desde Java!</h1>");
        out.println("    <p>Este texto lo generó un Servlet en el servidor.</p>");
        out.println("    <hr>");
        
        // Si no hay nombre, mostrar formulario
        if (nombre == null || nombre.trim().isEmpty()) {
            out.println("    <div class='card p-4'>");
            out.println("        <h2 class='text-primary mb-4'>Por favor, introduce tu nombre</h2>");
            out.println("        <form method='GET' action='" + request.getRequestURI() + "'>");
            out.println("            <div class='mb-3'>");
            out.println("                <label for='nombre' class='form-label'>Nombre:</label>");
            out.println("                <input type='text' class='form-control' id='nombre' name='nombre' required autofocus>");
            out.println("            </div>");
            out.println("            <button type='submit' class='btn btn-primary'>Enviar</button>");
            out.println("        </form>");
            out.println("    </div>");
        } else {
            // Si hay nombre, mostrar bienvenida
            out.println("    <h2 class='text-success'>¡Bienvenido, " + nombre + "!</h2>");
            out.println("    <p>Fecha y hora en el servidor: " + fechaHora + "</p>");
            out.println("    <p>Visitas desde que arrancó Tomcat: " + visitasActuales + "</p>");
            out.println("    <p>Método HTTP de esta petición: " + metodo + "</p>");
            out.println("    <a href='" + request.getRequestURI() + "' class='btn btn-warning mt-3'>Cambiar nombre</a>");
        }
        
        out.println("    <a href='" + request.getContextPath() + "/tienda' class='btn btn-success mt-3'>Ir a la Tienda</a>");
        out.println("</body>");
        out.println("</html>");
    }
}