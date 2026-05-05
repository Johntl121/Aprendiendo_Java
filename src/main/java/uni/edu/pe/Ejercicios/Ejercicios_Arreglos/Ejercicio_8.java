package uni.edu.pe.Ejercicios.Ejercicios_Arreglos;

import java.util.Scanner;

public class Ejercicio_8 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // 1. Declaramos la tabla de 10 elementos (índices del 0 al 9)
        int[] tabla = new int[10];

        // 2. Leemos los 8 primeros números
        System.out.println("--- Ingreso de los 8 números iniciales ---");
        for (int i = 0; i < 8; i++) {
            // Imprimimos el índice para que el usuario sepa en qué posición está guardando
            System.out.print("Posición [" + i + "] - Digite un número: ");
            tabla[i] = entrada.nextInt();
        }

        // 3. Pedimos el nuevo número y la posición
        System.out.println("\n--- Inserción de un nuevo elemento ---");
        System.out.print("Digite el nuevo número a insertar: ");
        int numero = entrada.nextInt();

        System.out.print("Digite la posición donde desea insertarlo (0 al 8): ");
        int posicion = entrada.nextInt();

        // Verificamos que la posición tenga sentido
        if (posicion >= 0 && posicion <= 8) {

            // 4. EL DESPLAZAMIENTO (La parte clave)
            // Empezamos en el índice 7 (el último elemento lleno actualmente)
            // y vamos retrocediendo hasta llegar a la posición deseada.
            for (int i = 7; i >= posicion; i--) {
                tabla[i + 1] = tabla[i]; // Movemos el elemento una silla a la derecha
            }

            // 5. Insertamos el nuevo número en el espacio que acabamos de liberar
            tabla[posicion] = numero;

            // 6. Mostramos el resultado (ahora tenemos 9 elementos llenos)
            System.out.println("\n--- Arreglo Final ---");
            for (int i = 0; i < 9; i++) {
                System.out.print(tabla[i] + " ");
            }
            System.out.println(); // Salto de línea estético

        } else {
            System.out.println("❌ Error: La posición debe estar entre 0 y 8.");
        }
    }
}
