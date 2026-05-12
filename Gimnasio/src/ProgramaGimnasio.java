package Gimnasio.src;

public class ProgramaGimnasio {
    private double total;
    
    public void main(String[] args)
    {
        Gimnasio energyFit = new Gimnasio("EnergyFit"); // Crea el Gimnasio Nombre "EnergyFit", en la Clase Gimnasio
        Socio socio = new Socio("César", 58, "PREMIUM", true); // Crea un Socio en la Clase Socio.
        energyFit.agregarSocio(socio); // Agrega el Socio creado al ArrayList de Socios del Gimnasio.
        socio.mostrarInfo(); // Muestra la información del Socio creado, utilizando el método mostrarInfo() de la Clase Socio.
        String plan = socio.obtenerPlan(); // Obtiene el tipo de plan del Socio utilizando el método plan() de la Clase Socio.
        System.out.printf("Plan de %s: %s%n%n", socio.nombre, plan); // Muestra el tipo de plan del Socio.
        energyFit.crearPlan("VIP", 15.0); // Crea un Nuevo Plan en la Clase Gimnasio.
        energyFit.mostrarInfo(); // Muestra la información de todos los Socios del Gimnasio, utilizando el método mostrarInfo() de la Clase Gimnasio.
        total = energyFit.calcularTotal(); // Obtiene el Total Recaudado por el Gimnasio Utilizando el Método calcularTotal() de la Clase Gimnasio.
        System.out.printf("Total Recaudado: %.2f €%n", total); // Muestra el Total Recaudado por el Gimnasio.
    }
}