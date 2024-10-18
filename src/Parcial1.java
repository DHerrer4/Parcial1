import java.util.InputMismatchException;
import java.util.Scanner;
public class Parcial1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        String[] nombres = new String[100];
        double[] cantidades = new double[100];
        double[] precios = new double[100];
        int[] cantidadesVendidas = new int[100];
        int contador = 0;

        System.out.println("\n=== Inventarios de Sportline ===");

        while (continuar) {
            System.out.println("\nSelecciona una opción: ");
            System.out.println("1. Agregar un producto");
            System.out.println("2. Mostrar inventarios");
            System.out.println("3. Vender un producto");
            System.out.println("4. Salir");
            System.out.print("\nOpción: ");
            int opcion = 0;
            try {
                opcion = entrada.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("ERR:Opcion inválida. Intente de nuevo.");
                entrada.next();
                continue;
            }
            switch (opcion) {
                case 1:
                    System.out.println("Escriba el nombre del producto:");
                    String nombreProducto = entrada.next();
                    boolean encontrado = false;

                     for (int i = 0; i < contador; i++) {
                        if (nombres[i].equals(nombreProducto)) {
                            encontrado = true;
                            System.out.println("Digite la cantidad a agregar:");
                            int cantidadAgregar = entrada.nextInt();
                            cantidades[i] += cantidadAgregar;
                            System.out.println("Cantidad actualizada. Nueva cantidad: " + cantidades[i]);
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Digite la cantidad inicial:");
                        int cantidadInicial = entrada.nextInt();
                        System.out.println("Digite el precio por unidad:");
                        double precio = entrada.nextDouble();
                        nombres[contador] = nombreProducto;
                        cantidades[contador] = cantidadInicial;
                        precios[contador] = precio;
                        contador++;
                    }
                    break;
                case 2:
                    System.out.println("Inventario disponible:");
                    for (int i = 0; i < contador; i++) {
                        System.out.println("Nombre: " + nombres[i] + ", Cantidad: " + cantidades[i] +
                                ", Precio: B/." + precios[i]  + ", Cantidad vendida: " + cantidadesVendidas[i]);
                    }
                    break;
                case 3:
                    System.out.println("Digite el nombre del producto a vender:");
                    String nombreVenta = entrada.next();
                    boolean encontradoVenta = false;

                    for (int i = 0; i < contador; i++) {
                        if (nombres[i].equals(nombreVenta)) {
                            encontradoVenta = true;
                            System.out.println("Digite la cantidad a vender:");
                            int cantidadVender =entrada.nextInt();

                            if (cantidadVender > cantidades[i]) {
                                System.out.println("No hay suficiente stock disponible para este producto!!!");
                            } else {
                                cantidades[i] -= cantidadVender;
                                cantidadesVendidas[i] += cantidadVender;
                                System.out.println("Venta realizada con éxito!!! Cantidad vendida: " + cantidadVender);

                                if (cantidades[i] == 0) {
                                    System.out.println("¡Inventario agotado!");
                                }
                            }
                            break;
                        }
                    }
                    if (!encontradoVenta) {
                        System.out.println("Producto no encontrado!");
                    }
                    break;

                case 4:
                    System.out.print("Desea salir? (S/N): ");
                    char respuesta = entrada.next().toUpperCase().charAt(0);
                    continuar = (respuesta == 'S') ? false : true;
                    break;
                default:
                    System.out.println("ERR:Opcion inválida. Intente de nuevo.");
            }
        }

        System.out.println("¡Hasta luego!");
        entrada.close();
    }
}
