package com.miapp;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("productoBean")
@RequestScoped
public class ProductoBean {
    private String nombre;
    private double precio;
    private String categoria;
    private boolean disponible;

    public ProductoBean() {
    }

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

    public String guardar() {
        // Este mensaje aparece en la consola de Tomcat.
        System.out.println("Producto registrado: " + nombre);
        // Navega a confirmacion.xhtml.
        // No uses faces-redirect=true en esta primera práctica.
        return "confirmacion";
    }
}