package uni.edu.pe.Ejercicios.Ejercicios_Operadores;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        int horas_trabajadas, sal_hora, sal_semanal;
        System.out.print("Ingrese las horas trabajadas (a la semana): ");
        horas_trabajadas = entrada.nextInt();
        System.out.print("Ingrese el salario por hora (en S/.): ");
        sal_hora = entrada.nextInt();
        sal_semanal = sal_hora*horas_trabajadas;
        System.out.print("Su salario semanal es: S/. "+sal_semanal);
    }
}
