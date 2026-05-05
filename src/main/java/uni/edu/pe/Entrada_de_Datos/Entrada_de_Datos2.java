package uni.edu.pe.Entrada_de_Datos;

import java.util.Scanner;

public class Entrada_de_Datos2 {
    public static void main(String[] arg){
        String cadena;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escribe su cadena: ");
        cadena = entrada.nextLine();
        // next() para leer la primera palabra
        // nextLine() para leerlo completo
        System.out.print("Su cadena es: "+cadena);
    }
}
