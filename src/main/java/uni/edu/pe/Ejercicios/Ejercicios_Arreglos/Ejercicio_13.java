//Leer 10 enteros. Guardar en otra tabla los elementos pares de la primera, y a continuación los elementos
//impares.

package uni.edu.pe.Ejercicios.Ejercicios_Arreglos;

import java.util.Scanner;

public class Ejercicio_13 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int[] arreglo = new int[10];
        int conteo_pares = 0,conteo_impares = 0;
        System.out.println("LLENANDO EL ARREGLO");
        for (int i=0; i<10;i++){
            System.out.print((i+1)+". Digite un numero: ");
            arreglo[i]=entrada.nextInt();

            if(arreglo[i] % 2 == 0){
                conteo_pares++;
            }
            else{
                conteo_impares++;
            }
        }
        int[] pares = new int[conteo_pares];
        int[] impares = new int[conteo_impares];
        conteo_pares=0;
        conteo_impares=0;
        for (int i=0; i<10;i++){
            if (arreglo[i] % 2 == 0){
                pares[conteo_pares] = arreglo[i];
                conteo_pares++;
            }
            else {
                impares[conteo_impares] = arreglo[i];
                conteo_impares++;
            }
        }
        System.out.println("El arreglo de pares es: ");
        for (int i=0;i<conteo_pares; i++){
            System.out.print(pares[i] + " ");
        }
        System.out.println();
        System.out.println("El arreglo de impares es: ");
        for (int i=0;i<conteo_impares; i++){
            System.out.print(impares[i] + " ");
        }

    }
}
