<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resumen - Tienda</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="tarjeta">
        <h1>Error</h1>
        <p>Lo sentimos, ha ocurrido un error al procesar su solicitud. Puede que hayas escrito Texto en lugar de un Número.</p>
        <c:url value="/tienda" var="urlInicio" /> 
        <a href="${urlInicio}">Volver al inicio</a>
    </div>