package uni.edu.pe.Ejercicios.Ejercicios_Arreglos;

import java.util.Scanner;

public class Ejercicio_5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] a,b,c;
        a = new int[10];
        b = new int[10];
        c = new int[20];

        System.out.println("--- Ingreso de datos ---");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + ". Digite un número: ");
            a[i] = entrada.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + ". Digite un número: ");
            b[i] = entrada.nextInt();
        }

        int j=0;
        for(int i = 0; i < 10 ; i++){
            c[j] = a[i];
            j++;
            c[j] = b[i];
            j++;
        }
        System.out.println("El tercer arreglo es: ");
        for (int i=0; i<20; i++){
            System.out.print(c[i]+" ");
        }
        System.out.println();
    }
}
