<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resumen - Tienda</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/resumen.css">
</head>
<body>
    <div class="tarjeta">
        <h1>Resumen de la Tienda</h1>
        
        <div class="resumen-contenedor">
            <div class="resumen-item">
                <h3>Total de Productos</h3>
                <p class="numero"><c:out value="${resumen.totalProductos}"/></p>
            </div>
            
            <div class="resumen-item">
                <h3>Categorías Disponibles</h3>
                <p class="numero"><c:out value="${resumen.totalCategorias}"/></p>
            </div>
            
            <div class="resumen-item caro">
                <h3>Producto Más Caro</h3>
                <p class="texto"><c:out value="${resumen.productoMasCaro}"/></p>
            </div>
        </div>
        
        <c:url value="/tienda/catalogo" var="urlCatalogo" />
        <a class="boton" href="${urlCatalogo}">Ver Catálogo Completo</a>
    </div>
</body>
</html>
