package uni.edu.pe.Ejercicios.Ejercicios_Arreglos;

import java.util.Scanner;

public class Ejercicio_14 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int[] a = new int[10];
        int[] b = new int[10];

        System.out.println("LLENADO DEL ARREGLO 1 EN ORDEN ASCENDENTE");
        for (int i = 0; i < 10; i++) {
            do {
                System.out.print((i + 1) + ". Digite un numero: ");
                a[i] = entrada.nextInt();

                if (i > 0 && a[i] <= a[i - 1]) {
                    System.out.println("¡Incorrecto! El número debe ser mayor a " + a[i - 1]);
                }
            } while (i > 0 && a[i] <= a[i - 1]); // Repite si no es ascendente
        }

        System.out.println("LLENADO DEL ARREGLO 2 EN ORDEN ASCENDENTE");
        for (int i = 0; i < 10; i++) {
            do {
                System.out.print((i + 1) + ". Digite un numero: ");
                b[i] = entrada.nextInt();

                if (i > 0 && b[i] <= b[i - 1]) {
                    System.out.println("¡Incorrecto! El número debe ser mayor a " + b[i - 1]);
                }
            } while (i > 0 && b[i] <= b[i - 1]); // Repite si no es ascendente
        }

        int[] c = new int[20];
        for (int i=0; i<20;i++){
            c[i]=a[i];

        }

    }
}
