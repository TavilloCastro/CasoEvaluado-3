import javax.swing.JOptionPane;
import java.util.Random;

public class TiendaAbarrotes {
    public static void main(String[] args) {
        // Solicitar el número de productos
        int n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de productos:"));

        // Arreglos para almacenar los nombres de los productos y las ventas
        String[] productos = new String[n];
        int[][] ventas = new int[7][n]; // 7 días de la semana

        // Ingresar los nombres de los productos
        for (int i = 0; i < n; i++) {
            productos[i] = JOptionPane.showInputDialog("Ingrese el nombre del producto " + (i + 1) + ":");
        }

        // Generar ventas aleatorias
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < n; j++) {
                ventas[i][j] = random.nextInt(10); // Ventas aleatorias entre 0 y 9
            }
        }

        // Calcular el total de ventas por producto
        StringBuilder totalVentas = new StringBuilder("Total de ventas por producto:\n");
        int[] sumaVentasPorProducto = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < 7; i++) {
                sumaVentasPorProducto[j] += ventas[i][j];
            }
            totalVentas.append(productos[j]).append(": ").append(sumaVentasPorProducto[j]).append("\n");
        }
        JOptionPane.showMessageDialog(null, totalVentas.toString());

        // Determinar el día con mayores ventas totales
        int[] sumaVentasPorDia = new int[7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < n; j++) {
                sumaVentasPorDia[i] += ventas[i][j];
            }
        }

        int diaMaximo = 0;
        for (int i = 1; i < 7; i++) {
            if (sumaVentasPorDia[i] > sumaVentasPorDia[diaMaximo]) {
                diaMaximo = i;
            }
        }
        String[] diasNombre = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        JOptionPane.showMessageDialog(null, "El día con mayores ventas totales es: " + diasNombre[diaMaximo] +
                " (con un total de " + sumaVentasPorDia[diaMaximo] + " ventas).");

        // Encontrar el producto más vendido
        int productoMaximo = 0;
        for (int j = 1; j < n; j++) {
            if (sumaVentasPorProducto[j] > sumaVentasPorProducto[productoMaximo]) {
                productoMaximo = j;
            }
        }
        JOptionPane.showMessageDialog(null, "El producto más vendido es: " + productos[productoMaximo] +
                ", con " + sumaVentasPorProducto[productoMaximo] + " unidades.");
    }
}