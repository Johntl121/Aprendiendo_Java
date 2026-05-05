package uni.edu.pe.POO.ClasesObjetos.Retorno_de_Valores;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite un numero: ");
        int n1 = entrada.nextInt();
        System.out.print("Digite un numero: ");
        int n2 = entrada.nextInt();

        //Creacion del objeto "op"
        Operacion op = new Operacion();

        //Llamar a los metodos
        System.out.println("La suma es: "+op.sumar(n1,n2));
        System.out.println("La resta es: "+op.restar(n1,n2));
        System.out.println("La multiplicacion es: "+op.multiplicar(n1,n2));
        System.out.print("La division es: "+op.dividir(n1,n2));
    }
}
