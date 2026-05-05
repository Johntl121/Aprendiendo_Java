package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int num, suma=0;
        do{
            System.out.print("Digite un numero: ");
            num = entrada.nextInt();
            suma += num;
        }while (num != 0);
        System.out.print("La suma de los numero introducidos es: "+suma);
    }
}
