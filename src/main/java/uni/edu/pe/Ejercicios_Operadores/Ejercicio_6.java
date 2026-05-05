package uni.edu.pe.Ejercicios_Operadores;

import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        int a,b,resultado;
        System.out.print("Digite el valor de a: ");
        a = entrada.nextInt();
        System.out.print("Digite el valor de b: ");
        b = entrada.nextInt();
        resultado=a+b;
        resultado*=resultado;
        System.out.print("El cuadrado de la suma es: "+resultado);

    }
}
