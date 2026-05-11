package Actividad_Individual;

import java.util.ArrayList;

public class ProgramaParking {
    ArrayList<Parking> vehiculos = new ArrayList<>();
    double totalRecaudado;
    public void main(String[] args)
    {
        System.out.println("Bienvenidas al Parking de Femete");

        Parking coche1 = new Parking("1234BCD", 4, true);
        Parking coche2 = new Parking("5678XYZ", 3, false);
        Parking coche3 = new Parking("1982LMN", 8, false);

        vehiculos.add(coche1);
        vehiculos.add(coche2);
        vehiculos.add(coche3);

        for (Parking vehiculo : vehiculos) {
            totalRecaudado += vehiculo.calcularImporte();
            vehiculo.mostrarResumen();
            vehiculo.validarHoras();
            System.out.printf("Total a Pagar: %.2f%n", vehiculo.calcularImporte());
            
        } 

        System.out.printf("El Total Recaudado Es: %.2f%n", totalRecaudado);
    }
}