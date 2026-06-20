package uni.edu.pe.Grafos.PropuestosAvanzada.OilDeposits;

import java.util.Scanner;

public class OilDepositsV1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            // Si m = 0, se señala el final de la entrada
            if (m == 0) break;

            char[][] grid = new char[m][n];

            // Leemos la matriz completa
            for (int i = 0; i < m; i++) {
                grid[i] = sc.next().toCharArray();
            }

            int totalDepositos = 0;

            // Recorremos cada parcela de la cuadrícula
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // Si encontramos un pozo de petróleo intacto
                    if (grid[i][j] == '@') {
                        totalDepositos++; // Sumamos 1 al contador de depósitos

                        // Iniciamos la búsqueda para encontrar toda la mancha conectada
                        dfs(grid, i, j, m, n);
                    }
                }
            }

            // Imprimimos el resultado de este tablero
            System.out.println(totalDepositos);
        }
        sc.close();
    }

    /**
     * Algoritmo DFS (Flood Fill) para recorrer todo el depósito conectado.
     */
    static void dfs(char[][] grid, int r, int c, int m, int n) {
        // 1. CASOS BASE (Cuándo detener la búsqueda)
        // - Si nos salimos de los límites de la matriz (arriba, abajo, izquierda, derecha)
        // - O si la celda actual NO es un pozo de petróleo ('@')
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != '@') {
            return;
        }

        // 2. MARCAR COMO VISITADO
        // Para no volver a procesar esta celda y evitar un bucle infinito,
        // la convertimos en tierra sin petróleo ('*').
        // ¡Nota que no hay paso de deshacer como en Backtracking!
        grid[r][c] = '*';

        // 3. EXPLORAR LAS 8 DIRECCIONES (Adyacencia horizontal, vertical y diagonal)
        // Usamos dos bucles cortos que van de -1 a 1 para simular los movimientos.
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                // Evitamos llamar a la posición (0,0) porque es donde ya estamos parados
                if (dr != 0 || dc != 0) {
                    dfs(grid, r + dr, c + dc, m, n);
                }
            }
        }
    }
}