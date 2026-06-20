package uni.edu.pe.Backtracking.PropuestosAvanzada.Lotto;

import java.util.*;

public class LottoV2 {
    // a: Guarda los números originales que ingresa el usuario (máximo 14, según el problema)
    static int[] a = new int[14];

    // ans: Es nuestra "mochila". Aquí guardamos la combinación de 6 números que estamos armando
    static int[] ans = new int[6];

    /**
     * Método recursivo que construye las combinaciones.
     * @param i    -> El índice del número que estamos evaluando en el arreglo original 'a'.
     * @param cont -> Cuántos números hemos metido en nuestra "mochila" 'ans' hasta ahora.
     * @param n    -> La cantidad total de números que el usuario ingresó.
     */
    static void solve(int i, int cont, int n) {

        // 1. PRIMER CASO BASE (¡Éxito!)
        // Si ya metimos 6 números en la mochila, tenemos una combinación válida.
        if (cont == 6) {
            // Imprimimos el contenido de la mochila
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
            return; // Cortamos esta rama, ya no necesitamos seguir buscando por aquí.
        }

        // 2. SEGUNDO CASO BASE (¡Límite alcanzado!)
        // Si ya revisamos todos los números disponibles (i >= n) pero NO logramos
        // juntar los 6 números que queríamos, simplemente nos rendimos en esta rama.
        if (i >= n) return;

        // =========================================================
        // RAMA A: LA DECISIÓN DE "TOMAR" EL NÚMERO
        // =========================================================

        // Metemos el número actual (a[i]) en nuestra mochila, en la posición que toca (cont)
        ans[cont] = a[i];

        // Avanzamos al siguiente número en el pasillo (i + 1)
        // y le decimos a la mochila que ahora tiene un elemento más (cont + 1)
        solve(i + 1, cont + 1, n);


        // =========================================================
        // EL BACKTRACKING (Deshacer la decisión)
        // =========================================================

        // Sacamos el número de la mochila. Técnicamente le ponemos un 0 para limpiar,
        // indicando que vamos a probar qué pasa si NO hubiéramos elegido este número.
        ans[cont] = 0;

        // =========================================================
        // RAMA B: LA DECISIÓN DE "NO TOMAR" (IGNORAR) EL NÚMERO
        // =========================================================

        // Avanzamos al siguiente número en el pasillo (i + 1),
        // pero nuestra mochila sigue teniendo la misma cantidad de elementos (cont)
        // porque decidimos no agarrar el número actual.
        solve(i + 1, cont, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();

            // Condición de parada del programa
            if (n == 0) break;

            // Llenamos nuestro arreglo con los números disponibles
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Arrancamos la magia:
            // - Empezamos evaluando el elemento en el índice 0.
            // - Nuestra mochila tiene 0 elementos.
            // - Hay un total de 'n' elementos para evaluar.
            solve(0, 0, n);
        }
        sc.close();
    }
}