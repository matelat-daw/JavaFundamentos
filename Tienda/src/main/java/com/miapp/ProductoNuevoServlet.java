package com.miapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet para mostrar el formulario de creación de un nuevo producto
 */
@WebServlet("/tienda/nuevo")
public class ProductoNuevoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("titulo", "Nuevo Producto");

        request.getRequestDispatcher("/WEB-INF/vistas/nuevo-producto.jsp")
               .forward(request, response);
    }
}
