package com.miapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    private BigDecimal precio;
    
    @Column(nullable = false)
    private String categoria;
    
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(nullable = true)
    private String imagen;
}
