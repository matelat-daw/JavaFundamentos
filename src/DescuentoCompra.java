import java.util.Scanner;
public class DescuentoCompra {
    static double total;
    static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.print("Total de compra " + i + ": ");
            total += teclado.nextDouble();
        }

        if (total > 50) {
            double descuento = total * 0.10;
            double finalConDescuento = total - descuento;
            System.out.println("Descuento aplicado: " + descuento);
            System.out.println("Total final: " + finalConDescuento);
        } else {
            System.out.println("No se aplica descuento.");
            System.out.println("Total final: " + total);
        }
        teclado.close();
    }
}