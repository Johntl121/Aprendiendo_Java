package uni.edu.pe.Ejercicios.Ejercicios_Condicionales;

import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        float a,b;
        System.out.print("Digite dos numeros: ");
        a = entrada.nextFloat();
        b = entrada.nextFloat();

        if((a % 2 == 0) && (b % 2 == 0)){
            System.out.print("Ambos numeros son pares.");
        } else if((a % 2 != 0) && (b % 2 == 0)){
            System.out.print("1er numero impar y 2do numero par");
        } else if ((a % 2 == 0) && (b % 2 != 0)) {
            System.out.print("1er numero par y 2do numero impar");
        } else {
            System.out.print("Ambos numeros son impares.");
        }
    }
}
