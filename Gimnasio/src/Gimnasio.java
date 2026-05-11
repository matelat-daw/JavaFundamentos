package Gimnasio.src;

import java.util.ArrayList;
import java.util.Map;

public class Gimnasio {
    private String nombre;
    public ArrayList<Socio> socios;
    public Map<String, Double> planes;
    public double total;

    public Gimnasio(String nombre, ArrayList<Socio> socios, Map<String, Double> planes)
    {
        this.nombre = nombre;
        this.socios = socios;
        this.planes = planes;
    }

    public void mostrarInfo()
    {
        // socios.get(3);
        for (Socio socio : socios) {
            System.out.println(socio.getName() + " - " + socio.edad);
        }

        for (int i = 0; i < socios.size(); i++) {
            System.out.println("Nombre: " + socios.get(i).getName() + " Edad: " + socios.get(i).edad);
        }
    }

    public double calcularTotal()
    {
        return total;
    }
}