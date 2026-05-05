package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_12 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escriba el numero del factorial: ");
        int N = entrada.nextInt();
        long factorial=1;
        if(N==0){
            System.out.print("El factorial de 0 es 1.");
        }
        for (int i=1;i<=N;i++){
            factorial *= i;
        }
        System.out.print("El factorial de "+N+" es: "+factorial);
    }
}
