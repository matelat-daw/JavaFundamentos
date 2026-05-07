import java.util.Scanner;

public class EvaluacionE1 {
    private static String nombreArticulo;
    private static double precioArticulo;
    private static int cantidadArticulo;
    private static double totalParcial;
    private static double descuento;
    private static double totalPagar;
    private static boolean continuar = true; // Condición para controlar el ciclo de compras, se pueden realizar varias compras hasta que el usuario decida finalizar.
    static void main(String[] args) {
        // Scanner entrada = new Scanner(System.in);
        System.out.println("Hola Mundo");
        System.out.println("Bienvenidas a la Tienda de Femete");

        Scanner entrada = new Scanner(System.in);
        while (continuar) {
            System.out.print("Ingresa el nombre del artículo: ");
            nombreArticulo = entrada.nextLine();

            System.out.print("Ingresa la cantidad del artículo: ");
            cantidadArticulo = entrada.nextInt();

            System.out.print("Ingresa el precio del artículo: ");
            precioArticulo = entrada.nextDouble();
            entrada.nextLine(); // consumir el salto de línea restante
            totalParcial = precioArticulo * cantidadArticulo;
            if (totalParcial >= 50) {
                descuento = totalParcial * .1; // Si el total parcial es mayor o igual a 50, se aplica un descuento del 10%.
                totalPagar = totalParcial - descuento;
            } else {
                totalPagar = totalParcial;
                descuento = 0; // Como la App permite hacer más de una compra, es necesario reiniciar el valor del descuento para cada compra nueva.
            }

            System.out.println("Artículo: " + nombreArticulo);
            System.out.println("Unidades: " + cantidadArticulo);
            System.out.println("Precio unitario: " + precioArticulo);
            System.out.println("Total sin descuento: " + totalParcial);
            System.out.println("Descuento aplicado: " + descuento);
            System.out.println("Total a pagar: " + totalPagar);

            System.out.println("¿Deseas realizar otra compra? (s/n)");
            String respuesta = entrada.nextLine().trim();

            /* Este bloque de código permite al usuario decidir si desea realizar otra compra */
            if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("sí")) {
                continuar = true;
            } else if (respuesta.equalsIgnoreCase("n") || respuesta.equalsIgnoreCase("no")) {
                continuar = false;
            } else {
                System.out.println("Opción no válida, se finalizará la compra.");
                continuar = false;
            }
        }
        entrada.close();
    }
}