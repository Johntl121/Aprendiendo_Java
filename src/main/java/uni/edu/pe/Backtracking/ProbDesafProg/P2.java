package uni.edu.pe.Backtracking.ProbDesafProg;
/*
Multisets are allowed to have repeated elements. A multiset of n items may thus have fewer
than n! distinct permutations. For example, {1,1,2,2} has only six distinct permutations:
[1,1,2,2], [1,2,1,2], [1,2,2,1], [2,1,1,2], [2,1,2,1], and [2,2,1,1].
Design and implement an efficient algorithm for constructing all permutations of a multiset.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2 {

    public static List<List<Integer>> ordenarYPermutar(int[] nums) {
        List<List<Integer>> resultados = new ArrayList<>();
        List<Integer> rutaActual = new ArrayList<>();
        boolean[] usados = new boolean[nums.length];

        // 1. PASO CRUCIAL: Ordenar el arreglo para que los duplicados estén juntos
        Arrays.sort(nums);

        resolverBacktrack(resultados, rutaActual, usados, nums);
        return resultados;
    }

    private static void resolverBacktrack(List<List<Integer>> resultados, List<Integer> rutaActual, boolean[] usados, int[] nums) {
        // 1. CASO BASE: Si la ruta tiene el mismo tamaño que el arreglo, encontramos una permutación única completa
        if (rutaActual.size() == nums.length) {
            resultados.add(new ArrayList<>(rutaActual));
            return;
        }

        // 2. EXPLORAR OPCIONES: Iteramos sobre los elementos del multiconjunto
        for (int i = 0; i < nums.length; i++) {

            // PODA A: Si el elemento en el índice 'i' ya está en la ruta actual, lo saltamos
            if (usados[i]) {
                continue;
            }

            // PODA B (Anti-duplicados): Si este elemento es igual al anterior...
            // y el anterior NO está siendo usado (!usados[i-1]), significa que ya exploramos
            // por completo esa alternativa en este mismo nivel de la recursión.
            if (i > 0 && nums[i] == nums[i - 1] && !usados[i - 1]) {
                continue; // Podamos esta rama para evitar permutaciones repetidas
            }

            // -> ELEGIR: Tomamos la decisión
            rutaActual.add(nums[i]);
            usados[i] = true;

            // -> EXPLORAR: Pasamos al siguiente nivel recursivo
            resolverBacktrack(resultados, rutaActual, usados, nums);

            // -> DESHACER (Backtrack): Limpiamos el estado para evaluar la siguiente opción del bucle
            usados[i] = false;
            rutaActual.remove(rutaActual.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] multiconjunto = {1, 1, 2, 2};
        List<List<Integer>> permutaciones = ordenarYPermutar(multiconjunto);

        System.out.println("Permutaciones únicas para " + Arrays.toString(multiconjunto) + ":");
        for (List<Integer> p : permutaciones) {
            System.out.println(p);
        }
        System.out.println("Total de permutaciones distintas: " + permutaciones.size());
    }
}