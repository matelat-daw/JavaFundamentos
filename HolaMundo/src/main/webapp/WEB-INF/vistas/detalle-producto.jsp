<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html> 
<html lang="es"> 
<head> 
    <meta charset="UTF-8"> 
    <title>Detalle del producto</title> 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/detalle.css">
</head> 
<body> 
    <c:choose> 
        <c:when test="${not empty producto}"> 
            <div class="producto"> 
                <h1><c:out value="${producto.nombre}"/></h1> 
                <p><strong>Categoría:</strong> 
                   <c:out value="${producto.categoria}"/></p> 
                <p class="precio">${producto.precio} €</p> 
                <p><c:out value="${producto.descripcion}"/></p> 
            </div> 
        </c:when> 
  
        <c:otherwise> 
            <h1>Producto no encontrado</h1> 
            <p>No existe ningún producto con ese identificador.</p> 
        </c:otherwise> 
    </c:choose> 
  
    <p> 
        <c:url value="/tienda/catalogo" var="urlCatalogo" /> 
        <a href="${urlCatalogo}">Volver al catálogo</a> 
    </p> 
</body> 
</html> 