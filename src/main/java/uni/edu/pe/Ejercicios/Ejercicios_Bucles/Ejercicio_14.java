package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_14 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        int sueldo, suma = 0,cont = 0;
        for(int i = 1; i<=10; i++){
            System.out.print("Digite el sueldo "+i+": ");
            sueldo = entrada.nextInt();
            suma += sueldo;
            if(sueldo>1000){
                cont++;
            }
        }
        System.out.println("La suma de los 10 sueldos es: "+suma);
        System.out.print("Hay "+cont+" sueldos mayores a $ 1000");
    }
}
