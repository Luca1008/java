import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] denominaciones = {1, 5, 10, 25}; // Denominaciones de las monedas disponibles
        int cantidad = 36; // Cantidad de dinero a obtener
        
        int[] resultado = calcularCambio(denominaciones, cantidad);
        
        System.out.println("Cantidad mínima de monedas necesarias: " + resultado[cantidad]);
        System.out.println("Monedas utilizadas:");
        imprimirMonedasUtilizadas(resultado, denominaciones, cantidad);
    }
    
    private static int[] calcularCambio(int[] denominaciones, int cantidad) {
        int[] cambio = new int[cantidad + 1];
        Arrays.fill(cambio, Integer.MAX_VALUE);
        
        cambio[0] = 0;
        
        for (int i = 1; i <= cantidad; i++) {
            for (int j = 0; j < denominaciones.length; j++) {
                if (denominaciones[j] <= i) {
                    int subproblema = cambio[i - denominaciones[j]];
                    if (subproblema != Integer.MAX_VALUE && subproblema + 1 < cambio[i]) {
                        cambio[i] = subproblema + 1;
                    }
                }
            }
        }
        
        return cambio;
    }
    
    private static void imprimirMonedasUtilizadas(int[] resultado, int[] denominaciones, int cantidad) {
        if (resultado[cantidad] == Integer.MAX_VALUE) {
            System.out.println("No es posible obtener la cantidad exacta con las denominaciones dadas.");
            return;
        }
        
        while (cantidad > 0) {
            for (int i = 0; i < denominaciones.length; i++) {
                if (denominaciones[i] <= cantidad && resultado[cantidad] == resultado[cantidad - denominaciones[i]] + 1) {
                    System.out.println(denominaciones[i]);
                    cantidad -= denominaciones[i];
                    break;
                }
            }
        }
    }
}
