package uni.edu.pe.Bucles;

import java.util.Scanner;

public class Do_while {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite la cantidad de repeticiones: ");
        int i=1, contador = entrada.nextInt();
        do{
            System.out.println(i);
            i++;
        }while(i<=contador);
    }
}
