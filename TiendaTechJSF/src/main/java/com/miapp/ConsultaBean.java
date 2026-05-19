package com.miapp;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("consultaBean")
@RequestScoped

public class ConsultaBean implements Serializable {
    
    private String nombreCliente;
    private String email;
    private String producto;
    private int cantidad;
    private boolean urgente;

    public ConsultaBean() {
        // Constructor vacío
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public String enviar() {
        System.out.println("Consulta recibida de: " + nombreCliente);
        System.out.println("Email: " + email);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("¿Es urgente?: " + urgente);
        
        return "confirmacion-consulta?faces-redirect=false"; // Redirige a una página de confirmación
    }
}