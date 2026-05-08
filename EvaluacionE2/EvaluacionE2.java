package EvaluacionE2;

public class EvaluacionE2 {
    static void main(String[] args) {
        System.out.println("Hola Mundo");
        System.out.println("Bienvenidas a la Tienda de Femete");

        Producto producto1 = new Producto("Camisa", -10, 10);
        Producto producto2 = new Producto("Pantalón", 45.50, -10);

        producto1.mostrarInfo();
        double total1 = producto1.calcularTotal(2);
        System.out.printf("Total a pagar por %d unidades: %.2f%n", 2, total1);

        producto2.mostrarInfo();
        double total2 = producto2.calcularTotal(6); // Intento de comprar más unidades de las disponibles
        System.out.printf("Total a pagar por %d unidades: %.2f%n", 6, total2);
    }
}