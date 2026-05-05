package uni.edu.pe.Ejercicios_Operadores;

import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        // Usamos double (primitivo)
        double a, b, c, x1, x2, discriminante;

        System.out.println("--- Calculadora de Ecuación Cuadrática ---");
        System.out.print("Ingrese los valores de a, b y c: ");

        a = entrada.nextDouble();
        b = entrada.nextDouble();
        c = entrada.nextDouble();

        discriminante = (b * b) - (4 * a * c);

        if (discriminante >= 0) {
            // ¡OJO a los paréntesis en el (2 * a)!
            x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminante)) / (2 * a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            System.out.println("La ecuación no tiene soluciones reales (Discriminante negativo).");
        }
    }
}
