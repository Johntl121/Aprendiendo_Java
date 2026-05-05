package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_22 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int nota;
        boolean esSuspenso = false;
        for (int i=1; i <= 5; i++){
            do{
                System.out.print("Digite la nota nro "+i+": ");
                nota = entrada.nextInt();
            }while (nota<0 || nota>10);
            if (nota<=4){
                esSuspenso = true;
            }
        }
        if(esSuspenso){
            System.out.print("Hay suspensos...");
        }else{
            System.out.print("No hay suspensos...");
        }
    }
}
