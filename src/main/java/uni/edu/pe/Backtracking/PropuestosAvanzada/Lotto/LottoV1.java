package uni.edu.pe.Backtracking.PropuestosAvanzada.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoV1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean primerCaso = true;

        // Leemos hasta que no haya más entrada o encontremos un 0
        while (sc.hasNextInt()) {
            int k = sc.nextInt();
            if (k == 0) break; // El programa termina cuando k es 0

            // Controlamos el salto de línea estricto entre casos de prueba
            if (!primerCaso) {
                System.out.println();
            }
            primerCaso = false;

            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = sc.nextInt(); // El conjunto S ya viene en orden ascendente
            }

            List<Integer> rutaActual = new ArrayList<>();
            // Pasamos el arreglo, la ruta y el índice de 'inicio' que arranca en 0
            resolverBacktrack(S, rutaActual, 0);
        }
        sc.close();
    }

    private static void resolverBacktrack(int[] S, List<Integer> rutaActual, int inicio) {
        // 1. CASO BASE: Si tenemos exactamente 6 números, imprimimos la combinación
        if (rutaActual.size() == 6) {
            for (int i = 0; i < 6; i++) {
                // Imprimimos separados por un espacio, sin espacio extra al final [cite: 15]
                System.out.print(rutaActual.get(i) + (i == 5 ? "" : " "));
            }
            System.out.println();
            return;
        }

        // 2. EXPLORAR OPCIONES: Iteramos desde 'inicio' hasta el final del arreglo
        for (int i = inicio; i < S.length; i++) {

            // -> ELEGIR: Tomamos el número actual
            rutaActual.add(S[i]);

            // -> EXPLORAR: Bajamos en el árbol.
            // El truco de las combinaciones está aquí: el nuevo inicio es 'i + 1'.
            // Esto asegura que siempre escojamos números a la derecha, manteniendo
            // el orden ascendente y evitando repeticiones.
            resolverBacktrack(S, rutaActual, i + 1);

            // -> DESHACER (Backtrack): Quitamos el número para intentar con el siguiente en el bucle
            rutaActual.remove(rutaActual.size() - 1);
        }
    }
}