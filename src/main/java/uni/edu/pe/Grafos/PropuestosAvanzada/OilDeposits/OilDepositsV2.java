package uni.edu.pe.Grafos.PropuestosAvanzada.OilDeposits;

import java.util.*;

public class OilDepositsV2 {
    // Límite máximo del tablero según el problema (100x100)
    static final int N = 100;

    // Matriz booleana para saber si hay petróleo (true) o no (false)
    static boolean[][] a = new boolean[N][N];

    // Matriz booleana para rastrear qué pozos ya hemos procesado
    static boolean[][] used = new boolean[N][N];

    // Arreglos de dirección: combinando di[k] y dj[k] obtenemos los 8 movimientos posibles
    // (derecha, izquierda, abajo, arriba y las 4 diagonales)
    static int[] di = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dj = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt(); // Filas
            int m = sc.nextInt(); // Columnas

            // Condición de parada
            if (n == 0 || m == 0) break;

            // 1. LECTURA Y CONSTRUCCIÓN DEL TABLERO
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    used[i][j] = false; // Reiniciamos el estado de visitado
                    char c = s.charAt(j);
                    a[i][j] = (c == '@'); // True si es petróleo, False si no lo es
                }
            }

            int comp = 0; // Contador de componentes conectados (depósitos)

            // 2. BÚSQUEDA DEL PETRÓLEO
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    // Si encontramos un pozo Y no lo hemos visitado antes
                    if (a[i][j] && !used[i][j]) {
                        comp++; // Encontramos un nuevo depósito

                        // ==========================================
                        // INICIO DEL BFS (Inundación en anchura)
                        // ==========================================
                        Queue<Integer> q = new ArrayDeque<>();

                        used[i][j] = true; // Marcamos el origen como visitado

                        // TRUCO DE COMPRESIÓN: 2D a 1D
                        q.offer(i * m + j);

                        while (!q.isEmpty()) {
                            // Sacamos el elemento actual de la cola
                            int u = q.poll();

                            // TRUCO DE DESCOMPRESIÓN: 1D a 2D
                            int ui = u / m; // Fila actual
                            int uj = u % m; // Columna actual

                            // Exploramos los 8 vecinos
                            for (int k = 0; k < 8; k++) {
                                int vi = ui + di[k]; // Fila del vecino
                                int vj = uj + dj[k]; // Columna del vecino

                                // Verificamos que el vecino sea válido:
                                // 1. Que no se salga del mapa (vi < 0, vi >= n, etc.)
                                // 2. Que tenga petróleo (!a[vi][vj])
                                // 3. Que NO haya sido visitado antes (used[vi][vj])
                                if (vi < 0 || vi >= n || vj < 0 || vj >= m || !a[vi][vj] || used[vi][vj]) {
                                    continue; // Si no es válido, lo ignoramos
                                }

                                // Si es un vecino válido, lo comprimimos y a la cola
                                q.offer(vi * m + vj);
                                used[vi][vj] = true; // Lo marcamos para no encolarlo dos veces
                            }
                        }
                    }
                }
            }
            // Imprimimos la cantidad total de depósitos encontrados
            System.out.println(comp);
        }
    }
}