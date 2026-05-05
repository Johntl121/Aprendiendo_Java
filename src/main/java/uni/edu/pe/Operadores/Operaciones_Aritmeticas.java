package uni.edu.pe.Operadores;

import java.util.Scanner;

public class Operaciones_Aritmeticas {
    public static void main(String[] arg){
        double num1, num2, suma, mult, division, mod;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite un numero: ");
        num1 = entrada.nextInt();
        System.out.print("Digite otro numero: ");
        num2 = entrada.nextInt();

        suma = num1+num2;
        mult = num1*num2;
        division=num1/num2;
        mod=num1%num2;
        System.out.println("La suma es: "+suma);
        System.out.println("La multiplicacion es: "+mult);
        System.out.println("La division es: "+division);
        System.out.println("EL resto es: "+mod);
    }

}
