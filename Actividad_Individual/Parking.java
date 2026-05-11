package Actividad_Individual;

public class Parking {
    private String matricula;
    private final double precioHora = 2.5;
    private double total;
    private double parcial;
    private boolean abonado;
    private final double descuento = .2;
    public int horas;

    public Parking(String matricula, int horas, boolean abonado)
    {
        this.matricula = matricula;
        this.horas = horas;
        this.abonado = abonado;
    }

    public double calcularImporte()
    {
        if (abonado)
        {
            parcial = precioHora * horas;
            total = parcial - parcial * descuento;
        }
        else
        {
            total = precioHora * horas;
        }
        return total;
    }

    public int validarHoras()
    {
        if (horas <= 0) {
            return 1;
        }
        return horas;
    }

    public void mostrarResumen()
    {
        System.out.printf("Vehículo: %s%n", matricula);
        if (abonado)
        {
            System.out.printf("Es un Usuario abonado. %n");
        } else {
            System.out.printf("Usuario NO abonado. %n");
        }
    }
}