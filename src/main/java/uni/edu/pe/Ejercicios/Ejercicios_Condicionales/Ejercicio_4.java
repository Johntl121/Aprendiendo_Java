package uni.edu.pe.Ejercicios.Ejercicios_Condicionales;

import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] arg){

        Scanner entrada = new Scanner(System.in);
        float valor_compra;

        System.out.print("Precio a pagar (originalmente): $ ");
        valor_compra = entrada.nextFloat();

        if(valor_compra > 300){
            valor_compra = 0.8f*valor_compra;
            System.out.print("La persona pagará: $ "+valor_compra);
        }
        else {
            System.out.print("La persona pagará: $ "+valor_compra);
        }
    }
}
