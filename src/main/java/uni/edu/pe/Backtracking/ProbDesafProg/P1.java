package uni.edu.pe.Backtracking.ProbDesafProg;
/*
A derangement is a permutation p of {1,...,n} such that no item is in its
proper position, that is, pi ̸ = i for all 1 ≤ i ≤ n. Write an efficient backtracking
program with pruning that constructs all the derangements of n items.
 */

import java.util.ArrayList;
import java.util.List;

public class P1 {

    public static List<List<Integer>> generar(int n) {
        List<List<Integer>> resultados = new ArrayList<>();
        List<Integer> rutaActual = new ArrayList<>();
        // Arreglo para rastrear qué números ya usamos.
        // Usamos tamaño n + 1 para que los índices coincidan con los números del 1 al n.
        boolean[] usados = new boolean[n + 1];

        resolverBacktrack(resultados, rutaActual, usados, n);
        return resultados;
    }

    private static void resolverBacktrack(List<List<Integer>> resultados, List<Integer> rutaActual, boolean[] usados, int n) {
        // 1. CASO BASE: Si la ruta tiene tamaño 'n', encontramos un desordenamiento válido.
        if (rutaActual.size() == n) {
            resultados.add(new ArrayList<>(rutaActual));
            return;
        }

        // Calculamos qué posición estamos a punto de llenar.
        // Si la ruta está vacía (size 0), estamos en la posición 1.
        int posicionActual = rutaActual.size() + 1;

        // 2. EXPLORAR OPCIONES: Probamos los números del 1 al n.
        for (int i = 1; i <= n; i++) {

            // LA PODA (Pruning): Aquí está la eficiencia del algoritmo.
            // Condición A: Si el número 'i' ya fue usado, no es permutación.
            // Condición B: Si el número 'i' es igual a la posición actual, no es desordenamiento.
            if (usados[i] || i == posicionActual) {
                continue; // Descartamos esta opción inmediatamente y pasamos al siguiente número.
            }

            // -> ELEGIR: Tomamos la decisión válida
            rutaActual.add(i);
            usados[i] = true; // Marcamos el número como usado

            // -> EXPLORAR: Bajamos un nivel en el árbol para llenar la siguiente posición
            resolverBacktrack(resultados, rutaActual, usados, n);

            // -> DESHACER (Backtrack): Retrocedemos para probar otra rama
            rutaActual.remove(rutaActual.size() - 1);
            usados[i] = false; // Liberamos el número para que pueda usarse en otras combinaciones
        }
    }

    // Método main para probar el código
    public static void main(String[] args) {
        int n = 3;
        List<List<Integer>> desordenamientos = generar(n);

        System.out.println("Desordenamientos para n = " + n + ":");
        for (List<Integer> desorden : desordenamientos) {
            System.out.println(desorden);
        }
        System.out.println("Total encontrados: " + desordenamientos.size());
    }
}