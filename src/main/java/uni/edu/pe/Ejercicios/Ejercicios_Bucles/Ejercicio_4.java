package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite un numero: ");
        int cont=1, num = entrada.nextInt();
        while (num >= 0){
            System.out.print("Digite otro numero: ");
            num = entrada.nextInt();
            cont++;
        }
        System.out.print("Se ha pedido "+cont+" veces un numero.");
    }
}
