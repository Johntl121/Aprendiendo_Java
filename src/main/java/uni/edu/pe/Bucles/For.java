package uni.edu.pe.Bucles;

import java.util.Scanner;

public class For {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int contador;
        System.out.print("Valor del contador: ");
        contador = entrada.nextInt();
        for(int i=1;i<=contador;i++){
            System.out.println(i);
        }
    }
}
