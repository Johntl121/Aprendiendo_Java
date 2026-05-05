package uni.edu.pe.Ejercicios.Ejercicios_Condicionales;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        int a, b;
        System.out.print("Ingrese dos nuemros: ");
        a = entrada.nextInt();
        b = entrada.nextInt();
        if(a<b){
            System.out.print("El numero "+b+" es mayor.");
        }else{
            if(a>b){
                System.out.print("El numero "+a+" es mayor.");
            }
            else {
                System.out.print("Los numeros son iguales.");
            }
        }
    }
}
