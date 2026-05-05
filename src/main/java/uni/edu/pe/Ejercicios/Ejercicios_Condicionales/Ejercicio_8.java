package uni.edu.pe.Ejercicios.Ejercicios_Condicionales;

import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        int num;
        System.out.print("Digite un numero entre 0 y 99999: ");
        num = entrada.nextInt();
        if(num == 0){
            System.out.print("Tiene una cifra.");
        }
        if((num < 0) || (num>99999)) {
            System.out.print("Ingrese un numero valido...");
        } else if (num >= 10000){
            System.out.print("Tiene 5 cifras.");
        } else if (num >= 1000){
            System.out.print("Tiene 4 cifras.");
        } else if (num >= 100){
            System.out.print("Tiene 3 cifras.");
        } else if (num >= 10){
            System.out.print("Tiene 2 cifras.");
        } else if (num > 1){
            System.out.print("Tiene 1 cifra.");
        }
    }
}

/*package uni.edu.pe.Ejercicios.Ejercicios_Condicionales;

import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite un numero entre 0 y 99999: ");
        int num = entrada.nextInt();

        if (num < 0 || num > 99999) {
            System.out.println("Ingrese un numero valido...");
        } else {
            // 1. Convertimos el número a String (ej: 1520 -> "1520")
            String numeroEnTexto = String.valueOf(num);

            // 2. Usamos .length() para contar cuántos caracteres tiene
            System.out.println("Tiene " + numeroEnTexto.length() + " cifras.");
        }
    }
}
*/