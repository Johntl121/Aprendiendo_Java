package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int num;
        System.out.print("Digite un numero: ");
        num = entrada.nextInt();
        while(num != 0){
            if(num<0){
                System.out.println("El numero es negativo.");
            }
            else {
                System.out.println("El numero es positivo.");
            }
            System.out.print("Digite otro numero: ");
            num = entrada.nextInt();
        }
        System.out.print("Saliendo del sistema...");
    }
}
