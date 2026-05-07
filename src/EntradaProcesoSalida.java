void main() {
    Scanner teclado = new Scanner(System.in);
    IO.print("Introduce un precio, Para los decimales puedes usar el punto (.) o la coma (,): ");
    String precio = teclado.nextLine();
    precio = precio.replace(",", ".");
    calc(precio);
    teclado.close();
}

private void calc(String precio) {
    double conImpuesto = Double.parseDouble(precio) * 1.07;
    IO.print("El precio con el impuesto es: " + Math.round(conImpuesto * 100D) / 100D);
}