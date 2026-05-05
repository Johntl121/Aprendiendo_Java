package uni.edu.pe.Ejercicios.Ejercicios_Arreglos;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        float[] numeros = new float[5];
        System.out.println("Digite los elementos del arreglo: ");
        for (int i = 0; i<5; i++){
            System.out.print((i+1)+". Digite un numero: ");
            numeros[i] = entrada.nextFloat();
        }
        for (int i = 4; i>=0; i--) {
            System.out.print(numeros[i]+" ");
        }
    }
}
