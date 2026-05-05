package uni.edu.pe.POO.ClasesObjetos.Parametros_y_Argumentos;

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
        op.sumar(n1,n2);
        op.restar(n1,n2);
        op.multiplicar(n1,n2);
        op.dividir(n1,n2);
        op.mostrarResultado();
    }
}