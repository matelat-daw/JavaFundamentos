package Gimnasio.src;

public class Socio {
    private String nombre;
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

    public String getName()
    {
        return nombre;
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

    public void socioInfo()
    {

    }

    public String plan()
    {
        return tipoPlan;
    }
}