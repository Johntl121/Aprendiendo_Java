package uni.edu.pe.Operadores;

import java.util.Scanner;

public class Metodo_Math {
    public static void main (String[] arg){
        double num1, num2, potencia, raiz1, raiz2, random;
        long redondeo1, redondeo2; // Mejor usar long para redondeos

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite un numero: ");
        num1 = entrada.nextDouble();
        System.out.print("Digite otro numero: ");
        num2 = entrada.nextDouble();

        // Operaciones
        potencia = Math.pow(num1, num2);
        raiz1 = Math.sqrt(num1);
        raiz2 = Math.sqrt(num2);
        redondeo1 = Math.round(num1);
        redondeo2 = Math.round(num2);
        random = Math.random() * 100; // Multiplico por 100 para que no sea solo 0.0...

        System.out.println("---------------------------");
        System.out.println("La potencia es: " + potencia);
        System.out.println("La raiz del 1er numero es: " + raiz1);
        System.out.println("La raiz del 2do numero es: " + raiz2);
        System.out.println("El 1er numero redondeado es: " + redondeo1);
        System.out.println("El 2do numero redondeado es: " + redondeo2);
        System.out.println("Un numero Random (0-100): " + random);
    }
}
