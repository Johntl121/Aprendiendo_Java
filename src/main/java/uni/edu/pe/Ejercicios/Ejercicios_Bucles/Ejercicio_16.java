package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_16 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Mostrar tabla de multiplicar del numero: ");
        int N = entrada.nextInt();
        System.out.println("==========TABLA DE MULTIPLICAR DE "+N+"==========");
        for(int i = 1; i <= 12; i++){
            int mult = N*i;
            System.out.println(N+" x "+i+" = "+mult);
        }
    }
}
