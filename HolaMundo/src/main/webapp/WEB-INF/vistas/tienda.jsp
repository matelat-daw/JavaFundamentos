<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %> 
<!DOCTYPE html> 
<html lang="es"> 
<head> 
    <meta charset="UTF-8"> 
    <title>${nombreTienda}</title> 
    <style> 
        body { 
            font-family: Arial, sans-serif; 
            margin: 40px; 
            background-color: #f5f7fb; 
        } 
        .tarjeta { 
            max-width: 700px; 
            background-color: white; 
            padding: 25px; 
            border-radius: 12px; 
            box-shadow: 0 2px 8px rgba(0,0,0,0.15); 
        } 
        a.boton {
            display: inline-block; 
            margin-top: 20px; 
            padding: 10px 16px; 
            background-color: #2E5FA3; 
            color: white; 
            text-decoration: none; 
            border-radius: 8px; 
        } 
    </style> 
</head> 
<body> 
    <div class="tarjeta"> 
        <h1><c:out value="${nombreTienda}"/></h1> 
        <p><c:out value="${mensaje}"/></p> 
        <p>Esta página no está escrita con out.println().</p> 
        <p>El Servlet prepara los datos y el JSP los muestra.</p> 
  
        <c:url value="/tienda/catalogo" var="urlCatalogo" /> 
        <a class="boton" href="${urlCatalogo}">Ver catálogo</a> 
    </div> 
</body> 
</html> 