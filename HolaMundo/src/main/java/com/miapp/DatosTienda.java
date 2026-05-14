package com.miapp; 
  
import java.util.ArrayList; 
import java.util.List; 
  
public class DatosTienda { 
  
    public static List<Producto> obtenerCatalogo() { 
        List<Producto> catalogo = new ArrayList<>(); 
  
        catalogo.add(new Producto( 
            1, 
            "Teclado mecánico RGB", 
            89.99, 
            "Periféricos", 
            "Teclado cómodo para escribir y jugar." 
        )); 
  
        catalogo.add(new Producto( 
            2, 
            "Monitor 27 pulgadas 144Hz", 
            349.00, 
            "Pantallas", 
            "Monitor grande y fluido para trabajar y jugar." 
        )); 
  
        catalogo.add(new Producto( 
            3, 
            "Ratón gaming 12000 DPI", 
            45.50, 
            "Periféricos", 
            "Ratón preciso con varios botones configurables." 
        )); 
  
        catalogo.add(new Producto( 
            4, 
            "Auriculares con micrófono", 
            69.99, 
            "Audio", 
            "Auriculares adecuados para videollamadas y juegos." 
        )); 
  
        return catalogo; 
    } 
  
    public static Producto buscarPorId(int id) { 
        for (Producto producto : obtenerCatalogo()) { 
            if (producto.getId() == id) { 
                return producto; 
            } 
        } 
  
        return null; 
    } 
} 