package uni.edu.pe.Backtracking.PropuestosAvanzada.Sudoku;

import java.util.*;

public class SudokuV2 {
    // n = tamaño del subcuadro (3)
    // N = tamaño total del tablero (9)
    static final int n = 3;
    static final int N = n * n;

    // =========================================================
    // MATRICES DE ESTADO (La optimización O(1))
    // Nos dicen instantáneamente si un número 'x' ya está usado.
    // Usamos N+1 en la última dimensión para que los índices
    // calcen directamente con los números del 1 al 9.
    // =========================================================
    static boolean fila[][] = new boolean[N][N + 1];
    static boolean col[][]  = new boolean[N][N + 1];

    // Matriz 3D para los cuadrantes. Los índices serán [fila/3][col/3][numero]
    static boolean cuad[][][] = new boolean[n][n][N + 1];

    // Nuestro tablero de respuestas
    static int ans[][] = new int[N][N];

    /**
     * @param i -> Fila actual
     * @param j -> Columna actual
     */
    static void solve(int i, int j) {

        // 1. CASO BASE (ÉXITO TOTAL):
        // Si superamos la última columna (j==N) y estamos en la última fila (i==N-1)
        if (j == N && i == N - 1) {
            // Imprimimos el Sudoku completo
            for (int ii = 0; ii < N; ii++) {
                for (int jj = 0; jj < N; jj++) System.out.print(ans[ii][jj] + " ");
                System.out.println();
            }
            System.out.println();
            return;
        }

        // 2. EL SALTO DE LÍNEA (El comportamiento de máquina de escribir)
        // Si llegamos al final de la columna, pasamos a la siguiente fila, columna 0.
        if (j == N) {
            solve(i + 1, 0);
            return; //Si no retornamos, el código explota abajo.
        }

        // 3. EXPLORAR OPCIONES (Probar números del 1 al 9)
        for (int x = 1; x <= N; x++) {

            // LA PODA (Super rápida en O(1))
            // Si el número 'x' ya está en esta fila, columna o cuadrante, lo ignoramos.
            if (fila[i][x] || col[j][x] || cuad[i / n][j / n][x]) {
                continue;
            }

            // -> ELEGIR: Colocamos el número en el tablero y actualizamos los estados
            ans[i][j] = x;
            fila[i][x] = true;
            col[j][x] = true;
            cuad[i / n][j / n][x] = true;

            // -> EXPLORAR: Avanzamos una celda hacia la derecha
            solve(i, j + 1);

            // -> DESHACER (Backtrack): Quitamos el número y liberamos los estados
            ans[i][j] = 0;
            fila[i][x] = false;
            col[j][x] = false;
            cuad[i / n][j / n][x] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Iniciamos la generación desde la esquina superior izquierda
        solve(0, 0);
        sc.close();
    }
}
