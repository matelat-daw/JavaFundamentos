package Gimnasio.src;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ProgramaGimnasio {
    Map<String, Double> planes = new HashMap<>();
    ArrayList<Socio> socios = new ArrayList();
    
    public void main(String[] args)
    {
        socios.add(new Socio("Ana", 25, "PREMIUM", true));
        socios.add(new Socio("Pedro", 50, "BÁSICO", false));
        socios.add(new Socio("María", 40, "FAMILIAR", false));
        socios.add(new Socio("José", 40, "FAMILIAR", false));
        socios.add(new Socio("María José", 12, "FAMILIAR", false));
        planes.put("BÁSICO", 1.20);
        planes.put("PREMIUM", 3.50);
        planes.put("FAMILIAR", 0.95);
        Gimnasio energyFit = new Gimnasio("EnergyFit", socios, planes);
        energyFit.mostrarInfo();
        energyFit.calcularTotal();
    }
}