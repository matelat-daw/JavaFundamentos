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

    public Gimnasio(String nombre)
    {
        this.nombre = nombre;
        socios = new ArrayList<Socio>();
        planes = new HashMap<String, Double>();
        crearSocio();
        crearPlanes();
    }

    public void crearSocio()
    {
        socios.add(new Socio("Ana", 25, "PREMIUM", true));
        socios.add(new Socio("Pedro", 50, "BÁSICO", false));
        socios.add(new Socio("María", 40, "FAMILIAR", false));
        socios.add(new Socio("José", 40, "FAMILIAR", false));
        socios.add(new Socio("María José", 12, "FAMILIAR", false));
    }

    public void crearSocio(Socio socio)
    {
        socios.add(socio);
    }

    public void crearPlanes()
    {
        planes.put("BÁSICO", 35.0);
        planes.put("PREMIUM", 20.0);
        planes.put("FAMILIAR", 50.0);
    }

    public void crearPlan(String nombrePlan, double precio)
    {
        planes.put(nombrePlan, precio);
    }

    public void mostrarInfo()
    {
        boolean familiar = false;
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).edad < 14) {
                socios.get(i).edad = socios.get(i).validarEdad();
            }
            System.out.printf("Nombre: %s%n - Edad: %d%n - tipoPlan: %s%n - descuento: %b%n", socios.get(i).nombre, socios.get(i).edad, socios.get(i).tipoPlan, socios.get(i).descuento);
            if (socios.get(i).descuento) {
                System.out.printf("Precio con descuento: %.2f €%n", planes.get(socios.get(i).tipoPlan) * (1 - descuento));
            }
            else {
                if (socios.get(i).tipoPlan.equals("FAMILIAR")) {
                    if (!familiar) {
                        System.out.printf("Precio sin descuento: %.2f €%n", planes.get(socios.get(i).tipoPlan));
                        familiar = true;
                    }
                    else
                    System.out.println("Forma Parte del Plan Familiar de: " + socios.get(2).nombre);
                }
                else
                System.out.printf("Precio sin descuento: %.2f €%n", planes.get(socios.get(i).tipoPlan));
            }
        }
    }

    public double calcularTotal()
    {
        boolean familiar = false;
        total = 0;
        for (int i = 0; i < socios.size(); i++) {
            double precioPlan = planes.get(socios.get(i).tipoPlan);
            if (socios.get(i).descuento) {
                precioPlan *= (1 - descuento);
            }
            if (!socios.get(i).tipoPlan.equals("FAMILIAR")) {
                total += precioPlan;
            }
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