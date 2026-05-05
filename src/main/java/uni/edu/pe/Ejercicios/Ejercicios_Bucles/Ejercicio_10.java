package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_10 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int num, suma=0;
        for(int i =1 ; i <= 10; i++){
            System.out.print("Digite el nro "+i+": ");
            num = entrada.nextInt();
            suma += num;
        }
        System.out.print("La suma de los 10 numeros es: "+suma);
    }
}
