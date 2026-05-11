package Gimnasio.src;

public class Socio {
    String nombre;
    int edad;
    private String tipoPlan;
    boolean descuento;

    public Socio(String nombre, int edad, String tipoPlan, boolean descuento) // Constructor de la Clase Socio, para Crear un Nuevo Socio.
    {
        this.nombre = nombre;
        this.edad = edad;
        this.tipoPlan = tipoPlan;
        this.descuento = descuento;
    }

    public int validarEdad() // Método para Validar la Edad del Socio, Si es Menor de 14 Años, se le Asigna una Edad de 14 Años.
    {
        if (edad < 14)
            return 14;
        else
            return edad;
    }

    public void mostrarInfo() // Método para Mostrar la Información del Socio.
    {
        System.out.printf("Nombre: %s%n - Edad: %d%n - tipoPlan: %s%n - descuento: %b%n", nombre, edad, obtenerPlan(), descuento);
    }
    
    public String obtenerPlan() // Método para Obtener el Tipo de Plan del Socio.
    {
        return tipoPlan;
    }
}