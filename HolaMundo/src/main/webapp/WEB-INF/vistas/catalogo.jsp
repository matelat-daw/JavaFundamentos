<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html> 
<html lang="es"> 
<head> 
    <meta charset="UTF-8"> 
    <title>${titulo}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head> 
<body> 
    <h1><c:out value="${titulo}"/></h1> 
    <p>Total disponible: ${totalProductos} productos</p> 
  
    <table> 
        <tr> 
            <th>ID</th> 
            <th>Nombre</th> 
            <th>Categoría</th> 
            <th>Precio</th> 
            <th>Acción</th> 
        </tr> 
  
        <c:forEach var="p" items="${catalogo}"> 
            <tr> 
                <td>${p.id}</td> 
                <td><c:out value="${p.nombre}"/></td> 
                <td><c:out value="${p.categoria}"/></td> 
                <td>${p.precio} €</td> 
                <td> 
                    <c:url value="/tienda/producto" var="urlProducto"> 
                        <c:param name="id" value="${p.id}" /> 
                    </c:url> 
                    <a href="${urlProducto}">Ver detalle</a> 
                </td> 
            </tr> 
        </c:forEach> 
    </table> 
  
    <p> 
        <c:url value="/tienda" var="urlInicio" /> 
        <a href="${urlInicio}">Volver al inicio</a> 
    </p> 
</body> 
</html>