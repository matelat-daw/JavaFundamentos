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

@WebServlet("/seguridad/guardar")
public class GuardarIncidenciaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO 1: recupera el token del formulario y el token de sesión
        // Si no coinciden, responde con error 403 y termina el método.
        // Validar token CSRF
        String tokenFormulario = request.getParameter("csrfToken");
        String tokenSesion = (String) request.getSession().getAttribute("csrfToken");
        if (tokenFormulario == null || !tokenFormulario.equals(tokenSesion)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Petición no válida");
            return;
        }
        // TODO 2: lee los parámetros titulo, tipo, gravedad y descripcion.
        String titulo = request.getParameter("titulo");
        String tipo = request.getParameter("tipo");
        String gravedad = request.getParameter("gravedad");
        String descripcion = request.getParameter("descripcion");
        // TODO 3: valida los datos.
        // Reglas mínimas:
        // - titulo obligatorio
        // - titulo máximo 80 caracteres
        // - tipo debe ser XSS, VALIDACION, SESION o ERROR
        // - gravedad debe ser Baja, Media o Alta
        // - descripcion máximo 300 caracteres
        if (titulo == null || titulo.isBlank()) {
            volverAlFormulario(request, response, "El título es obligatorio", tokenFormulario);
            return;
        }
        if (titulo.length() > 80) {
            volverAlFormulario(request, response, "El título no puede tener más de 80 caracteres", tokenFormulario);
            return;
        }
        if (!tipoValido(tipo)) {
            volverAlFormulario(request, response, "El tipo de incidencia no es válido", tokenFormulario);
            return;
        }
        if (!gravedadValida(gravedad)) {
            volverAlFormulario(request, response, "La gravedad no es válida", tokenFormulario);
            return;
        }
        if (descripcion != null && descripcion.length() > 300) {
            volverAlFormulario(request, response, "La descripción no puede tener más de 300 caracteres", tokenFormulario);
            return;
        }
        // TODO 4: crea un objeto IncidenciaSeguridad.
        IncidenciaSeguridad incidencia = new IncidenciaSeguridad(titulo, tipo, gravedad, descripcion);
        // TODO 5: recupera la lista de incidencias de la sesión.
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<IncidenciaSeguridad> incidencias = (List<IncidenciaSeguridad>) session.getAttribute("incidencias");
        // Si no existe, crea un ArrayList nuevo.
        if (incidencias == null) {
            incidencias = new ArrayList<>();
            session.setAttribute("incidencias", incidencias);
        }
        // TODO 6: añade la incidencia a la lista.
        incidencias.add(incidencia);
        // TODO 7: redirige a /seguridad/listado.
        response.sendRedirect(request.getContextPath() + "/seguridad/listado");
    }
    // TODO 8: crea un método privado tipoValido(String tipo).
    private boolean tipoValido(String tipo) {
        return "XSS".equals(tipo) || "VALIDACION".equals(tipo) || "SESION".equals(tipo) || "ERROR".equals(tipo);
    }
    // TODO 9: crea un método privado gravedadValida(String gravedad).
    private boolean gravedadValida(String gravedad) {
        return "Baja".equals(gravedad) || "Media".equals(gravedad) || "Alta".equals(gravedad);
    }
    // TODO 10: crea un método privado volverAlFormulario(...).
    private void volverAlFormulario(HttpServletRequest request, HttpServletResponse response, String error, String csrfToken)
            throws ServletException, IOException {
        request.setAttribute("error", error);
        request.setAttribute("csrfToken", csrfToken);
        request.getRequestDispatcher("/WEB-INF/vistas/nueva-incidencia.jsp").forward(request, response);
    }
}