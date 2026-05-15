package com.miapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Servlet para guardar un nuevo producto en la BD
 */
@WebServlet("/tienda/guardar")
@MultipartConfig(maxFileSize = 5242880) // 5 MB
public class ProductoGuardarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("=== INICIANDO PROCESAMIENTO DE NUEVO PRODUCTO ===");

        try {
            // Obtener parámetros del formulario
            String nombre = request.getParameter("nombre");
            String precioStr = request.getParameter("precio");
            String categoria = request.getParameter("categoria");
            String descripcion = request.getParameter("descripcion");
            
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio: " + precioStr);
            System.out.println("Categoria: " + categoria);
            System.out.println("Descripcion: " + descripcion);

            double precio = Double.parseDouble(precioStr);

            // Procesar la imagen subida
            Part filePart = request.getPart("imagen");
            String nombreImagen = null;

            if (filePart != null && filePart.getSize() > 0) {
                // Obtener el nombre del archivo original
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                
                System.out.println("Archivo subido: " + fileName + " (Tamaño: " + filePart.getSize() + " bytes)");
                
                // Validar extensión
                if (!isValidImageExtension(fileName)) {
                    System.out.println("Extensión no válida: " + fileName);
                    request.setAttribute("mensaje", "Formato de imagen no permitido. Use: .webp, .jpg, .jpeg, .png");
                    request.setAttribute("tipo", "error");
                    response.sendRedirect(request.getContextPath() + "/tienda/nuevo");
                    return;
                }

                // Generar nombre único para la imagen
                nombreImagen = System.currentTimeMillis() + "_" + fileName;
                System.out.println("Nombre único generado: " + nombreImagen);

                // Obtener la ruta del directorio de imágenes
                String rutaDirectorio = request.getServletContext().getRealPath("/recursos/imgs");
                System.out.println("Ruta del directorio: " + rutaDirectorio);
                
                // Crear el directorio si no existe
                Files.createDirectories(Paths.get(rutaDirectorio));

                // Guardar el archivo
                String rutaCompleta = rutaDirectorio + "/" + nombreImagen;
                filePart.write(rutaCompleta);
                System.out.println("Imagen guardada en: " + rutaCompleta);

            } else {
                System.out.println("ERROR: No se recibió archivo o está vacío");
                request.setAttribute("mensaje", "Error: Debe subir una imagen");
                request.setAttribute("tipo", "error");
                response.sendRedirect(request.getContextPath() + "/tienda/nuevo");
                return;
            }

            // Crear objeto Producto (sin ID, la BD lo asignará)
            Producto producto = new Producto(0, nombre, precio, categoria, descripcion, nombreImagen);
            System.out.println("Objeto Producto creado: " + producto);

            // Insertar en la BD
            System.out.println("Intentando insertar en BD...");
            boolean insertado = ProductoDAO.insertarProducto(producto);
            System.out.println("Resultado de inserción: " + insertado);

            if (insertado) {
                System.out.println("Producto insertado exitosamente");
                request.setAttribute("mensaje", "Producto Agregado Correctamente");
                request.setAttribute("tipo", "exito");
                request.setAttribute("producto", producto);
                request.setAttribute("nombreProducto", nombre);
                request.setAttribute("precioProducto", precio);
            } else {
                System.out.println("ERROR: No se pudo insertar el producto");
                request.setAttribute("mensaje", "Error al Agregar el Producto");
                request.setAttribute("tipo", "error");
            }

        } catch (NumberFormatException e) {
            System.out.println("ERROR: Conversión de número - " + e.getMessage());
            request.setAttribute("mensaje", "Error: Datos Inválidos (Precio debe ser numérico)");
            request.setAttribute("tipo", "error");
        } catch (Exception e) {
            System.err.println("ERROR General: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("mensaje", "Error al procesar la imagen: " + e.getMessage());
            request.setAttribute("tipo", "error");
        }

        // Obtener el catálogo para mostrar junto con el modal
        java.util.List<Producto> catalogo = ProductoDAO.obtenerCatalogo();
        int totalProductos = catalogo.size();
        
        System.out.println("Total de productos en catálogo: " + totalProductos);
        
        request.setAttribute("catalogo", catalogo);
        request.setAttribute("totalProductos", totalProductos);
        request.setAttribute("titulo", "Catálogo de Productos");

        // Usar forward para mantener los atributos
        System.out.println("Haciendo forward a catalogo.jsp");
        request.getRequestDispatcher("/WEB-INF/vistas/catalogo.jsp")
               .forward(request, response);
    }

    /**
     * Valida que la extensión de la imagen sea permitida
     */
    private boolean isValidImageExtension(String fileName) {
        String fileName_lower = fileName.toLowerCase();
        return fileName_lower.endsWith(".webp") || 
               fileName_lower.endsWith(".jpg") || 
               fileName_lower.endsWith(".jpeg") || 
               fileName_lower.endsWith(".png");
    }
}
