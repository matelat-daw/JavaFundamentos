package EvaluacionE2;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = (precio < 0) ? 0 : precio;
        this.stock = (stock < 0) ? 0 : stock;
    }

    public double calcularTotal(int cantidad) {
        if (cantidad > stock) {
            System.out.println("No hay suficiente stock para completar la compra.");
            return 0; // Indica que no se pudo calcular el total debido a falta de stock
        }
        return precio * cantidad;
    }

    public void mostrarInfo() {
        System.out.printf("Producto: %s%n", nombre);
        System.out.printf("Precio: %.2f%n", precio);
        System.out.printf("Stock: %d%n", stock);
    }
}