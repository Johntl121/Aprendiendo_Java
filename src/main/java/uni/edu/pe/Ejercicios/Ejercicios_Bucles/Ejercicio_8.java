package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import javax.swing.*;
import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite el numero N: ");
        int N = entrada.nextInt();

        for (int i=1; i<=N; i++) {
            System.out.println(i);
        }
    }
}
