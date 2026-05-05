package uni.edu.pe.Ejercicios.Ejercicios_Operadores;

import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] arg){
        Scanner entrada = new Scanner(System.in);
        int nro_carros;
        float precio, Salario_Mensual;
        System.out.print("Ingrese el numero de carros vendidos: ");
        nro_carros = entrada.nextInt();
        System.out.print("Ingrese el precio de la venta por carro (en S/.): ");
        precio = entrada.nextInt();
        Salario_Mensual = 1000 + 150*nro_carros + 0.05f*precio;
        System.out.print("El salario del vendedor es: "+ Salario_Mensual);
    }
}
