package com.miapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/seguridad/listado")
public class ListadoIncidenciasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        // TODO 1: recupera de la sesión el atributo "incidencias".
        // Pista: tendrás que convertirlo a List<IncidenciaSeguridad>.
        @SuppressWarnings("unchecked")
        List<IncidenciaSeguridad> incidencias = (List<IncidenciaSeguridad>) session.getAttribute("incidencias");
        // TODO 2: si la lista es null, crea un ArrayList vacío.
        if (incidencias == null) {
            incidencias = new ArrayList<>();
        }
        // TODO 3: guarda la lista en request con el nombre "incidencias".
        request.setAttribute("incidencias", incidencias);
        // TODO 4: guarda el total en request con el nombre "totalIncidencias".
        request.setAttribute("totalIncidencias", incidencias.size());
        request.getRequestDispatcher("/WEB-INF/vistas/listado-incidencias.jsp")
                .forward(request, response);
    }
}