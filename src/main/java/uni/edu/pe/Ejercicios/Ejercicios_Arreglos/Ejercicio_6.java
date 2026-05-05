package uni.edu.pe.Ejercicios.Ejercicios_Arreglos;

import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] a = new int[12];
        int[] b = new int[12];
        int[] c = new int[24];

        System.out.println("--- Ingreso de datos para A ---");
        for (int i = 0; i < 12; i++) {
            System.out.print((i + 1) + ". Digite un número: ");
            a[i] = entrada.nextInt();
        }

        System.out.println("--- Ingreso de datos para B ---");
        for (int i = 0; i < 12; i++) {
            System.out.print((i + 1) + ". Digite un número: ");
            b[i] = entrada.nextInt();
        }

        // --- LA MAGIA CORREGIDA ---
        int j = 0; // Índice independiente para el arreglo 'c'

        // Hacemos que 'i' salte de 3 en 3 (0, 3, 6, 9)
        for (int i = 0; i < 12; i += 3) {

            // Copiamos 3 elementos seguidos de 'a'
            c[j] = a[i];
            j++;
            c[j] = a[i + 1];
            j++;
            c[j] = a[i + 2];
            j++;

            // Copiamos 3 elementos seguidos de 'b'
            c[j] = b[i];
            j++;
            c[j] = b[i + 1];
            j++;
            c[j] = b[i + 2];
            j++;
        }

        System.out.println("\nEl tercer arreglo es: ");
        for (int i = 0; i < 24; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
    }
}
