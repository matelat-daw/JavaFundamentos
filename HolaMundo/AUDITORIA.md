# Auditoría básica de seguridad
| Archivo revisado     | Problema encontrado       | Riesgo         | Corrección aplicada    |
|ProductoDetalleServlet|Está en un bloque try catch|Está contemplado| No es Necesaria        |
|detalle-producto.jsp  |Ninguno                    |No hay          | No es Necesaria        |
|detalle-producto.jsp  |Intento nombre sin c:out   |No se ve la Info| Es imprescindible c:out|
|detalle-producto.jsp  |Con <h1>${producto.nombre} |El riesgo principal de mostrar un dato crudo en JSP sin usar <c:out> es una vulnerabilidad de Cross-Site Scripting (XSS). Al imprimir datos directamente con expresiones como ${variable} o <%= variable %>, el servidor no sanea el contenido.    | Es Obligatorio usar c:out value="${producto.nombre}".|
|listado-incidencias.jsp|Si no uso c:out para la descripción| se ejecuta un script de Javascript, la prueba la hice con el alert del enunciado| Siempre hay que usar c:out\

☐ ¿Hay request.getParameter() sin validar?
    No, el código tiene validaciones de todos los datos
☐ ¿Hay parámetros numéricos como id sin try-catch?
    La única ID que se usa es la de la vista de detalles de los Artículos y está bien rodeada por try catch, si no existe el artículo se devuelve null y el jsp detalle-producto con esta línea verifica si llego un artículo: <c:when test="${not empty producto}">, si llega null, usa: <c:otherwise> 
            <h1>Producto no encontrado</h1> 
            <p>No existe ningún producto con ese identificador.</p> 
        </c:otherwise> 
☐ ¿Hay datos del usuario mostrados en JSP sin c:out?
    No ya que sin c:out no se muestra nada por pantalla.
☐ ¿Hay JSP fuera de WEB-INF/vistas?
    No las vistas deben estar sí o sí en la carpeta WEB-INF, ya que están protejidas y el servidor las muestra desde ahí, el usuario no tiene acceso directo a esos archivos.
☐ ¿Hay catch que muestran e.getMessage() al usuario?
    No, el catch solo asigna null al producto no encontrado, y la jsp muestra que no se ha encontrado el producto.
☐ ¿Hay valores sensibles escritos directamente en el código?
    No, es una App que muestra articulos de una tienda no maneja datos privados de usuario.
☐ ¿Hay rutas que se pueden abrir sin pasar por Servlet?
    No, todas las rutas se muestran a travez del Servlet de la Clase.

Valide la ID de un prducto con el código:
        String idTexto = request.getParameter("id");
        int id;
        try {
        id = Integer.parseInt(idTexto);
        producto = DatosTienda.buscarPorId(id);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Identificador no válido");
            request.getRequestDispatcher("/WEB-INF/vistas/error.jsp")
            .forward(request, response);
            return;
        }
    Fue necesario crear el archivo de vista error.jsp, para mostrar al usuario que hubo un error al pasar la ID de producto dos en luagr de 2, texto en lugar de número.

Hice un poco de trampa al crear la clase IncidenciaSeguridad.java, ya que estoy implementando Lombok en el proyecto, en la clase comenté las líneas que agregan getters y setters, contructor vacio y con todos los argumentos.

Cree todas las clases y las vistas y todo compila.

Visité la URL: http://localhost:8088/HolaMundo-1.0-SNAPSHOT/seguridad/nueva y me meustra el formulario para agregar una nueva incidencia.

Intenté dejar en blanco el campo Título y me mostró una advertencia el navegador que hay que rellenar el campo, no tiene validación personalizada, usa la interna del navegador.

Registré una incidencia sin inconvenientes.

Al registrar la incidencia con el <script>, se muestra como texto en descripción en la tabla.

Al intentar visitar una jsp directamente muestra:
Estado HTTP 404 – No encontrado
Tipo Informe de estado

Descripción El recurso requerido no está disponible.

Apache Tomcat/11.0.22

