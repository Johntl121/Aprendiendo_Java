package uni.edu.pe.Ejercicios.Ejercicios_Arreglos;

import java.util.Scanner;

public class Ejercicio_10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] tabla = new int[10];

        // 1. Llenar la tabla
        System.out.println("--- Ingreso de datos ---");
        for (int i = 0; i < 10; i++) {
            System.out.print("Posición [" + i + "] - Digite un número: ");
            tabla[i] = entrada.nextInt();
        }

        // 2. Pedir N posiciones a desplazar
        System.out.print("\n¿Cuántas posiciones desea desplazar?: ");
        int n = entrada.nextInt();

        // Truco de Ingeniería: Si te piden desplazar 12 posiciones en un arreglo de 10,
        // es exactamente lo mismo que desplazar 2 posiciones. Usamos el módulo (%).
        int desplazamientosReales = n % 10;

        // 3. Bucle externo: Repetimos el proceso 'N' veces
        for (int vuelta = 0; vuelta < desplazamientosReales; vuelta++) {

            // a) Guardamos el último elemento en el bolsillo
            int ultimoEnBolsillo = tabla[9];

            // b) Desplazamos todos los demás 1 posición hacia la derecha (de atrás hacia adelante)
            for (int i = 8; i >= 0; i--) {
                tabla[i + 1] = tabla[i];
            }

            // c) Ponemos el elemento del bolsillo en la primera posición vacía
            tabla[0] = ultimoEnBolsillo;
        }

        // 4. Imprimir el arreglo final rotado
        System.out.println("\n--- Arreglo Rotado ---");
        for (int i = 0; i < 10; i++) {
            System.out.print(tabla[i] + " ");
        }
        System.out.println();
    }
}
