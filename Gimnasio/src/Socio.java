package Gimnasio.src;

public class Socio {
    String nombre;
    int edad;
    String tipoPlan;
    boolean descuento;

    public Socio(String nombre, int edad, String tipoPlan, boolean descuento)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoPlan = tipoPlan;
        this.descuento = descuento;
    }

    public int validarEdad()
    {
        if (edad < 14)
        {
            return 14;
        }
        else
        {
            return edad;
        }
    }

    public void mostrarInfo()
    {
        System.out.printf("Nombre: %s%n - Edad: %d%n - tipoPlan: %s%n - descuento: %b%n", nombre, edad, plan(), descuento);
    }
    
    public String plan()
    {
        return tipoPlan;
    }
}