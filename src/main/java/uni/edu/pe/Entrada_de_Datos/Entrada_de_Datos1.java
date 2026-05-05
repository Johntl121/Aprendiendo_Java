
package uni.edu.pe.Entrada_de_Datos;

import java.util.Scanner;

// Define la clase llamada 'Main'. En Java, el nombre del archivo
// debe coincidir con el nombre de la clase pública.
public class Entrada_de_Datos1 {

    // Este es el "punto de entrada". Es el primer bloque de código
    // que la computadora busca para empezar a ejecutar tu programa.
    public static void main(String[] args) {

        float numero;

        // Aquí creas una "instancia" (un objeto) de la clase Scanner.
        // Le ponemos de nombre 'entrada'. 'System.in' le dice que lea del teclado.
        Scanner entrada = new Scanner(System.in);

        // Imprime un mensaje en la consola.
        System.out.print("Digite un numero: ");

        // Línea 10: El programa se detiene aquí y espera a que el usuario escriba algo.
        // .nextFloat() toma lo que escribiste, lo convierte a decimal y lo guarda en 'numero'.
        numero = entrada.nextFloat();

        System.out.print("El numero es " + numero);

    } // Cierre del método main
} // Cierre de la clase Main
