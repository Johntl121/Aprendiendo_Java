package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_5 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int num, aleatorio, cont=0;
        aleatorio = (int)(Math.random()*100);

        System.out.print("Digite un numero (1-100): ");
        num = entrada.nextInt();

        do{
            if(num<aleatorio){
                System.out.print("Digite un numero mayor: ");
                num = entrada.nextInt();
            }
            else {
                System.out.print("Digite un numero menor: ");
                num = entrada.nextInt();
            }
            cont++;
        }while (num != aleatorio);
        System.out.print("¡¡¡Genial, encontraste el numero!!!");
    }
}
