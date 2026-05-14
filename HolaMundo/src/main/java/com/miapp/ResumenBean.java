package com.miapp;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResumenBean implements Serializable {
    private int totalProductos;
    private int totalCategorias;
    private String productoMasCaro;
}