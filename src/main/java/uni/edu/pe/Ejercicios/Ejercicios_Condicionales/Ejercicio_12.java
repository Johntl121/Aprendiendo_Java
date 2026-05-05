package uni.edu.pe.Ejercicios.Ejercicios_Condicionales;

import java.util.Scanner;

public class Ejercicio_12 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite la nota (0-10): ");
        int nota = entrada.nextInt();
        switch (nota){
            case 0:
            case 1:
            case 2: System.out.print("!Insuficiente!");
                    break;
            case 3:
            case 4: System.out.print("¡Suficiente!");
                    break;
            case 5:
            case 6: System.out.print("¡Bien!");
                    break;
            case 7:
            case 8: System.out.print("¡Notable!");
                    break;
            case 9:
            case 10:System.out.print("¡Sobresaliente!");
                    break;
            default: System.out.print("La nota no es válida..."); break;
        }
    }
}
