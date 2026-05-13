package Gimnasio.src;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Gimnasio {
    private String nombre;
    private ArrayList<Socio> socios;
    private Map<String, Double> planes;
    private double total;
    private final double descuento = 0.15;

    public Gimnasio(String nombre) // Constructor de la Clase Gimnasio, para Crear un Nuevo Gimnasio.
    {
        this.nombre = nombre;
        socios = new ArrayList<Socio>(); // Inicializa el ArrayList de Socios del Gimnasio.
        planes = new HashMap<String, Double>(); // Inicializa el HashMap de Planes del Gimnasio, con el Nombre del Plan como Clave y el Precio del Plan como Valor.
        crearSocio(); // Crea los Socios del Gimnasio, utilizando el método crearSocio() de la Clase Gimnasio.
        crearPlanes(); // Crea los Planes del Gimnasio, utilizando el método crearPlanes() de la Clase Gimnasio. 
    }

    public String getNombre() // Método para Obtener el Nombre del Gimnasio, Llamado desde ProgramaGimnasio.
    {
        return nombre;
    }

    public void crearSocio() // Método para Crear los Socios del Gimnasio, utilizando ArrayList.
    {
        socios.add(new Socio("Ana", 25, "PREMIUM", true));
        socios.add(new Socio("Pedro", 50, "BÁSICO", false));
        socios.add(new Socio("María", 40, "FAMILIAR", false));
        socios.add(new Socio("José", 40, "FAMILIAR", false));
        socios.add(new Socio("María José", 12, "FAMILIAR", false));
    }

    public void agregarSocio(Socio socio) // Método para Agregar un Socio en el Gimnasio, Llamado desde ProgramaGimnasio.
    {
        socios.add(socio);
    }

    public void crearPlanes() // Método para Crear los Planes del Gimnasio, utilizando HashMap.
    {
        planes.put("BÁSICO", 35.0);
        planes.put("PREMIUM", 20.0);
        planes.put("FAMILIAR", 50.0);
    }

    public void crearPlan(String nombrePlan, double precio) // Método para Crear un Nuevo Plan en el Gimnasio, Llamado desde ProgramaGimnasio.
    {
        planes.put(nombrePlan, precio);
    }

    public void mostrarInfo() // Método para Mostrar la Información de Todos los Socios del Gimnasio, utilizando ArrayList y HashMap.
    {
        boolean familiar = false;
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).edad < 14)
                socios.get(i).edad = socios.get(i).validarEdad();
            System.out.printf("Nombre: %s%n - Edad: %d%n - tipoPlan: %s%n - descuento: %b%n", socios.get(i).nombre, socios.get(i).edad, socios.get(i).obtenerPlan(), socios.get(i).descuento);
            if (socios.get(i).descuento)
                System.out.printf("Precio con descuento: %.2f €%n", planes.get(socios.get(i).obtenerPlan()) * (1 - descuento));
            else {
                if (socios.get(i).obtenerPlan().equals("FAMILIAR")) {
                    if (!familiar) {
                        System.out.printf("Precio sin descuento: %.2f €%n", planes.get(socios.get(i).obtenerPlan()));
                        familiar = true;
                    }
                    else
                        System.out.println("Forma Parte del Plan Familiar de: " + socios.get(2).nombre);
                }
                else
                    System.out.printf("Precio sin descuento: %.2f €%n", planes.get(socios.get(i).obtenerPlan()));
            }
        }
    }

    public double calcularTotal() // Método para Calcular el Total Recaudado por el Gimnasio, utilizando ArrayList y HashMap.
    {
        boolean familiar = false;
        total = 0;
        for (int i = 0; i < socios.size(); i++) {
            double precioPlan = planes.get(socios.get(i).obtenerPlan());
            if (socios.get(i).descuento)
                precioPlan *= (1 - descuento);
            if (!socios.get(i).obtenerPlan().equals("FAMILIAR"))
                total += precioPlan;
            else
            {
                if (!familiar) {
                    total += precioPlan;
                    familiar = true;
                }
            }
        }
        return total;
    }
}