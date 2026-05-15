package com.miapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Crea automáticamente getters, setters, toString, equals y hashCode.
@NoArgsConstructor // Crea un constructor sin argumentos
@AllArgsConstructor // Crea un constructor con argumentos para todos los atributos

public class IncidenciaSeguridad {
 // TODO 1: crea cuatro atributos privados de tipo String:
 // titulo, tipo, gravedad y descripcion
 private String titulo;
 private String tipo;
 private String gravedad;
 private String descripcion;
}
