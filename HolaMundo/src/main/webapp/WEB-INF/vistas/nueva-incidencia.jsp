<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nueva incidencia de seguridad</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
    <div class="tarjeta">
        <h1>📋 Nueva incidencia de seguridad</h1>
        <c:if test="${not empty error}">
            <div class="alerta-error">
                <c:out value="${error}" />
            </div>
        </c:if>
        <form method="post" action="${pageContext.request.contextPath}/seguridad/guardar" class="formulario-incidencia">
            <input type="hidden" name="csrfToken" value="${csrfToken}">
            
            <div class="campo">
                <label for="titulo">Título:</label>
                <input type="text" id="titulo" name="titulo" maxlength="80" required placeholder="Ingresa el título de la incidencia">
            </div>
            
            <div class="campo">
                <label for="tipo">Tipo de incidencia:</label>
                <select id="tipo" name="tipo" required>
                    <option value="">-- Selecciona un tipo --</option>
                    <option value="XSS">XSS</option>
                    <option value="VALIDACION">VALIDACIÓN</option>
                    <option value="SESION">SESIÓN</option>
                    <option value="ERROR">ERROR</option>
                </select>
            </div>
            
            <div class="campo">
                <label for="gravedad">Gravedad:</label>
                <select id="gravedad" name="gravedad" required>
                    <option value="">-- Selecciona la gravedad --</option>
                    <option value="Baja">🟢 Baja</option>
                    <option value="Media">🟡 Media</option>
                    <option value="Alta">🔴 Alta</option>
                </select>
            </div>
            
            <div class="campo">
                <label for="descripcion">Descripción:</label>
                <textarea id="descripcion" name="descripcion" required placeholder="Describe la incidencia en detalle"></textarea>
            </div>
            
            <button type="submit" class="boton-guardar">✓ Guardar incidencia</button>
        </form>
        
        <div class="enlace-volver">
            <a href="${pageContext.request.contextPath}/seguridad/listado" class="boton">
                ← Ver listado de incidencias
            </a>
        </div>
    </div>
</body>
</html>