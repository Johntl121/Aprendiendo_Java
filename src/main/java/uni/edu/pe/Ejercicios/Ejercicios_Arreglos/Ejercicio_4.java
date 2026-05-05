package uni.edu.pe.Ejercicios.Ejercicios_Arreglos;

import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[10];

        // 1. Lectura de los 10 números
        System.out.println("--- Ingreso de datos ---");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + ". Digite un número: ");
            numeros[i] = entrada.nextInt();
        }

        // 2. Mostrar en el orden solicitado
        System.out.println("\n--- Resultado (Primero, último, segundo, penúltimo...) ---");

        // Solo necesitamos recorrer hasta la mitad (5 iteraciones)
        // porque en cada vuelta imprimimos DOS números.
        for (int i = 0; i < 5; i++) {
            // Imprimimos el elemento desde el inicio (i)
            System.out.print(numeros[i] + " ");

            // Imprimimos el elemento desde el final (9 - i)
            System.out.print(numeros[9 - i] + " ");
        }
        System.out.println();
    }
}
