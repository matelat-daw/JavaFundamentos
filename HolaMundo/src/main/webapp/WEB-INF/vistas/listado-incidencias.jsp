<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de incidencias</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
    <div class="tarjeta">
        <h1>📋 Listado de incidencias de seguridad</h1>
        <div class="estadisticas">
            <span class="contador">Total registradas: <strong>${totalIncidencias}</strong></span>
        </div>
        <div class="acciones">
            <a href="${pageContext.request.contextPath}/seguridad/nueva" class="boton boton-agregar">
                ➕ Registrar nueva incidencia
            </a>
        </div>
        <c:if test="${empty incidencias}">
            <div class="mensaje-vacio">
                <p>📭 No hay incidencias registradas todavía.</p>
            </div>
        </c:if>
        <c:if test="${not empty incidencias}">
            <div class="tabla-contenedor">
                <table class="tabla-incidencias">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Título</th>
                            <th>Tipo</th>
                            <th>Gravedad</th>
                            <th>Descripción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="contador" value="0" />
                        <c:forEach var="i" items="${incidencias}">
                            <c:set var="contador" value="${contador + 1}" />
                            <tr class="fila-${i.gravedad.toLowerCase()}">
                                <td class="numero">${contador}</td>
                                <td class="titulo"><c:out value="${i.titulo}" /></td>
                                <td>
                                    <span class="badge badge-${i.tipo}">
                                        <c:out value="${i.tipo}" />
                                    </span>
                                </td>
                                <td>
                                    <span class="badge-gravedad badge-${i.gravedad}">
                                        <c:out value="${i.gravedad}" />
                                    </span>
                                </td>
                                <td class="descripcion"><c:out value="${i.descripcion}" /></td>
                                <!-- <td class="descripcion">${i.descripcion}</td>                            </tr> -->
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </div>
</body>
</html>