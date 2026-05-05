package uni.edu.pe.Ejercicios.Ejercicios_Arreglos;

import java.util.Scanner;

public class Ejercicio_12 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int posicion;
        int[] arreglo = new int[10];
        for (int i=0; i<10; i++){
            System.out.print("Posicion [ "+i+" ] Digite un numero: ");
            arreglo[i]=entrada.nextInt();
        }
        do{
            System.out.print("Ingrese una posicion (0-9): ");
            posicion=entrada.nextInt();
        }while(posicion < 0 || posicion > 9);

        for (int i = posicion; i<9;i++){
            arreglo[i] = arreglo[i+1];
        }

        System.out.println("El arreglo queda: ");
        for (int i=0; i<9; i++){
            System.out.print(arreglo[i]+" ");
        }
    }
}
