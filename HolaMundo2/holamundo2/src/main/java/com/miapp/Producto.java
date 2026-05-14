package com.miapp;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private String categoria;
    private String descripcion;

    public Producto(int id, String nombre, double precio,
            String categoria, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public int getId() { 
        return id; 
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }
}