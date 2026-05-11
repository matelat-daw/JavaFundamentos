package Gimnasio.src;

public class ProgramaGimnasio {
    private double total;
    
    public void main(String[] args)
    {
        Gimnasio energyFit = new Gimnasio("EnergyFit");
        Socio socio = new Socio("César", 58, "PREMIUM", true);
        energyFit.crearSocio(socio);
        socio.mostrarInfo();
        String plan = socio.plan();
        System.out.printf("Plan de %s: %s%n%n", socio.nombre, plan);
        energyFit.crearPlan("VIP", 15.0);
        energyFit.mostrarInfo();
        total = energyFit.calcularTotal();
        System.out.printf("Total Recaudado: %.2f €%n", total);
    }
}