package uni.edu.pe.Ejercicios.Ejercicios_Condicionales;

import java.util.Scanner;

public class Ejercicio_14 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("========CONVERTIDOR DE MASAS (KG)========\n"
        + "1. Libra\n"
        + "2. Onza\n"
        + "3. Salir\n");
        System.out.print("Digite una operacion: ");
        int opcion = entrada.nextInt();
        System.out.print("Digite la masa en Kg: ");
        float masa = entrada.nextFloat();
        float libra=0f, onza=0f;
        switch (opcion){
            case 1:
                libra = masa*2.2046226218f;
                System.out.print(masa + "Kg es equivalente a "+libra+" Lb.");
                break;
            case 2:
                onza = masa*35.274f;
                System.out.print(masa + "Kg es equivalente a "+onza+" Lb.");
                break;
            case 3: break;
            default: System.out.print("Eligió una opción incorrecta..."); break;
        }
    }
}
