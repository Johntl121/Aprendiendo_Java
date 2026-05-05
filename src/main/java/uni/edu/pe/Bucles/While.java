package uni.edu.pe.Bucles;

import java.util.Scanner;

public class While {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int i=1, contador;

        System.out.print("Digite cuantos numeros quieres en pantalla: ");
        contador = entrada.nextInt();
        while (i<=contador){
            System.out.println(i);
            i++;
        }
    }
}
