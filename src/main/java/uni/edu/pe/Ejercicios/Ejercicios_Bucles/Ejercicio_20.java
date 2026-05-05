package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_20 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite la cantidad de Sueldos a ingresar: ");
        int N = entrada.nextInt();
        float max = 0, sueldo;
        for (int i = 1; i <= N; i++) {
            System.out.print("Digite el sueldo nro " + i + ": ");
            sueldo = entrada.nextFloat();
            if (sueldo > max) {
                max = sueldo;
            }
        }
        System.out.printf("El sueldo maximo es: $ "+max); //printf para mostrar dos decimales
    }
}
