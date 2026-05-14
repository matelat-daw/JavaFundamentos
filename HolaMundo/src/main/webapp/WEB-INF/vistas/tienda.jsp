<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html> 
<html lang="es"> 
<head> 
    <meta charset="UTF-8"> 
    <title>${nombreTienda}</title> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head> 
<body> 
    <div class="tarjeta"> 
        <h1><c:out value="${nombreTienda}"/></h1> 
        <p><c:out value="${mensaje}"/></p> 
        <p>Esta página no está escrita con out.println().</p> 
        <p>El Servlet prepara los datos y el JSP los muestra.</p> 
  
        <c:url value="/tienda/catalogo" var="urlCatalogo" /> 
        <c:url value="/tienda/resumen" var="urlResumen" /> 
        <c:url value="/tienda/contacto" var="urlContacto" /> 
        
        <a class="boton" href="${urlCatalogo}">Ver catálogo</a> 
        <a class="boton1" href="${urlResumen}">Ver Resumen</a> 
        <a class="boton2" href="${urlContacto}">Contacto</a> 
    </div> 
</body> 
</html> 