package uni.edu.pe.Backtracking.PropuestosAvanzada.CD;

import java.util.*;

public class CDV2 {
    // a: Guarda las duraciones de las pistas (máximo 20)
    static int a[] = new int[20];

    // v: Nuestra "mochila" actual mientras exploramos el árbol
    static List<Integer> v = new ArrayList<>();

    // ans: La mejor mochila que hemos encontrado hasta ahora
    static List<Integer> ans = new ArrayList<>();

    // mx_sum: El récord de la mejor suma alcanzada
    static int mx_sum = -1;

    /**
     * @param i   -> Índice de la pista actual a evaluar
     * @param sum -> Suma de los minutos que llevamos en la mochila 'v'
     * @param n   -> Total de pistas disponibles en el CD
     * @param lim -> Capacidad máxima del CD
     */
    static void solve(int i, int sum, int n, int lim) {

        // PODA: Si ya nos pasamos de la capacidad del CD, cortamos esta rama de inmediato.
        if (sum > lim) return;

        // CASO BASE: Ya evaluamos todas las pistas (ya decidimos tomar o dejar cada una)
        if (i == n) {
            // Si la suma de esta ruta supera nuestro récord actual, actualizamos
            if (sum > mx_sum) {
                // Tomamos una "foto" (copia profunda) de la ruta actual
                ans = new ArrayList<>(v);
                mx_sum = sum;
            }
            return;
        }

        // =========================================================
        // RAMA A: TOMAR LA PISTA
        // =========================================================
        v.add(a[i]); // Metemos la pista a la mochila temporal

        // Exploramos el siguiente nivel (i+1) sumando el tiempo de esta pista
        solve(i + 1, sum + a[i], n, lim);

        // =========================================================
        // BACKTRACKING: DESHACER LA DECISIÓN
        // =========================================================
        v.removeLast(); // (O v.remove(v.size() - 1) en Java < 21). Sacamos la pista.

        // =========================================================
        // RAMA B: NO TOMAR LA PISTA
        // =========================================================
        // Exploramos el siguiente nivel (i+1) pero manteniendo la suma sin cambios
        solve(i + 1, sum, n, lim);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leemos mientras haya datos de entrada
        while (sc.hasNext()) {
            // Reiniciamos las variables globales para el nuevo caso de prueba
            mx_sum = -1;
            ans.clear();

            int lim = sc.nextInt();
            if (lim == 0) break; // Condición de salida si ingresan 0

            int n = sc.nextInt();

            // Llenamos el arreglo con las duraciones
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Iniciamos la recursión: pista 0, suma inicial 0
            solve(0, 0, n, lim);

            // Imprimimos los resultados
            if (mx_sum == -1) {
                System.out.println("No solution");
            } else {
                for (int x : ans) {
                    System.out.print(x + " ");
                }
                System.out.println("sum: " + mx_sum + " ");
            }
        }
        sc.close();
    }
}