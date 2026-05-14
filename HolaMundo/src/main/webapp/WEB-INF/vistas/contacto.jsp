<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contacto - ${contacto.nombreTienda}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contacto.css">
</head>
<body>
    <div class="tarjeta">
        <h1>Contacto</h1>
        
        <c:if test="${not empty error}">
            <div class="alerta error">
                ${error}
            </div>
        </c:if>
        
        <c:if test="${not empty exito}">
            <div class="alerta exito">
                ${exito}
            </div>
        </c:if>
        
        <h2>Información de la Tienda</h2>
        <div class="contacto-info">
            <div class="info-item">
                <h3>Empresa</h3>
                <p><c:out value="${contacto.nombreTienda}"/></p>
            </div>
            
            <div class="info-item">
                <h3>Teléfono</h3>
                <p><c:out value="${contacto.telefono}"/></p>
            </div>
            
            <div class="info-item">
                <h3>Correo Electrónico</h3>
                <p><c:out value="${contacto.email}"/></p>
            </div>
            
            <div class="info-item">
                <h3>Ubicación</h3>
                <p><c:out value="${contacto.direccion}"/></p>
            </div>
            
            <div class="info-item" style="grid-column: 1 / -1;">
                <h3>Horario de Atención</h3>
                <p><c:out value="${contacto.horario}"/></p>
            </div>
        </div>
        
        <div class="formulario">
            <h2>Envíanos un Mensaje</h2>
            <form method="POST" action="${pageContext.request.contextPath}/tienda/contacto">
                <div class="campo">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" required>
                </div>
                
                <div class="campo">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                
                <div class="campo">
                    <label for="asunto">Asunto:</label>
                    <input type="text" id="asunto" name="asunto" required>
                </div>
                
                <div class="campo">
                    <label for="mensaje">Mensaje:</label>
                    <textarea id="mensaje" name="mensaje" required></textarea>
                </div>
                
                <button type="submit">Enviar Mensaje</button>
            </form>
        </div>
        
        <c:url value="/tienda/catalogo" var="urlCatalogo" />
        <a class="boton volver" href="${urlCatalogo}">Volver al Catálogo</a>
    </div>
</body>
</html>