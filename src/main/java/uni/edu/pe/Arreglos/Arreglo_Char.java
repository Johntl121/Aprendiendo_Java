package uni.edu.pe.Arreglos;

import java.util.Scanner;

public class Arreglo_Char {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int n;
        System.out.print("Digite el numero de elementos: ");
        n = entrada.nextInt();
        char[] letras = new char[n];
        System.out.println("Digite los elementos del arreglo: ");
        for (int i = 0; i<n; i++){
            System.out.print((i+1)+". Digite un caracter: ");
            letras[i] = entrada.next().charAt(0);
        }
        System.out.print("Los elementos del arreglo son: ");
        for (int i=0;i<n;i++){
            System.out.print(letras[i]+" ");
        }
    }
}
