package com.miapp;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("tiendaBean")
@SessionScoped
public class TiendaBean implements Serializable {

    private String nombre;
    private double precio;
    private String categoria;
    private boolean disponible;

    private List<Producto> productos = new ArrayList<>();

    public String guardarProducto() {

        // TODO 5: crea un objeto Producto usando los datos del formulario
        // Pista:
        // Producto nuevo = new Producto(nombre, precio, categoria, disponible);
        Producto nuevo = new Producto(nombre, precio, categoria, disponible);

        // TODO 6: añade el producto a la lista
        // Pista:
        // productos.add(nuevo);
        productos.add(nuevo);

        limpiarFormulario();

        return "listado-productos?faces-redirect=true";
    }

    public String volverAlFormulario() {
        return "alta-producto?faces-redirect=true";
    }

    private void limpiarFormulario() {
        nombre = "";
        precio = 0;
        categoria = "";
        disponible = false;
    }
    // TODO 7: crea getters y setters de todos los atributos
    // Debe haber get/set para: nombre, precio, categoria, disponible y productos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}