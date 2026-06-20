package uni.edu.pe.Backtracking.PropuestosAvanzada.Sudoku;

public class SudokuV1 {

    public static void main(String[] args) {
        // 0 representa las celdas vacías
        int[][] tablero = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (resolverSudoku(tablero)) {
            System.out.println("¡Sudoku Resuelto!");
            imprimirTablero(tablero);
        } else {
            System.out.println("Este Sudoku no tiene solución.");
        }
    }

    /**
     * Método principal de Backtracking
     * Retorna true si encuentra la solución, false si necesita retroceder.
     */
    static boolean resolverSudoku(int[][] tablero) {
        int n = tablero.length;

        // 1. Buscar la primera celda vacía
        for (int fila = 0; fila < n; fila++) {
            for (int col = 0; col < n; col++) {

                // Encontramos una celda vacía
                if (tablero[fila][col] == 0) {

                    // 2. EXPLORAR OPCIONES (Números del 1 al 9)
                    for (int numero = 1; numero <= 9; numero++) {

                        // LA PODA: Verificamos si es legal poner este número aquí
                        if (esValido(tablero, fila, col, numero)) {

                            // -> ELEGIR
                            tablero[fila][col] = numero;

                            // -> EXPLORAR: Llamada recursiva para llenar el resto del tablero
                            // Si la llamada devuelve true, significa que esta elección nos llevó al éxito
                            if (resolverSudoku(tablero)) {
                                return true;
                            }

                            // -> DESHACER (Backtrack): La elección nos llevó a un callejón sin salida
                            tablero[fila][col] = 0;
                        }
                    }

                    // Si probamos del 1 al 9 y ninguno funcionó, esta rama es un fracaso.
                    // Retornamos false para obligar al nivel anterior a cambiar su decisión.
                    return false;
                }
            }
        }
        // 3. CASO BASE: Si los bucles terminan y nunca encontramos un 0, el tablero está lleno.
        return true;
    }

    /**
     * Método auxiliar para la Poda: Verifica si un número puede colocarse en una posición.
     */
    static boolean esValido(int[][] tablero, int fila, int col, int numero) {
        // Verificar Fila
        for (int i = 0; i < 9; i++) {
            if (tablero[fila][i] == numero) return false;
        }

        // Verificar Columna
        for (int i = 0; i < 9; i++) {
            if (tablero[i][col] == numero) return false;
        }

        // Verificar Subcuadro 3x3
        // Truco matemático para encontrar la esquina superior izquierda del subcuadro
        int inicioFila = fila - fila % 3;
        int inicioCol = col - col % 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[inicioFila + i][inicioCol + j] == numero) return false;
            }
        }

        return true; // Si pasa las 3 pruebas, es un movimiento válido
    }

    static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}