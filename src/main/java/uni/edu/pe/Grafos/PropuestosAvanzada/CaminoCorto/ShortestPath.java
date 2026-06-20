package uni.edu.pe.Grafos.PropuestosAvanzada.CaminoCorto;
/*
El Tablero: Una matriz bidimensional donde . es un pasillo libre, # es una pared u obstáculo,
S es el inicio (Start) y E es la salida (Exit). Las Reglas de Movimiento: Solo puedes moverte
arriba, abajo, izquierda y derecha (4 direcciones). Cada movimiento cuesta exactamente 1 paso.
 */
import java.util.*;

public class ShortestPath {

    // Arreglos direccionales para moverse en las 4 direcciones (Arriba, Abajo, Izquierda, Derecha)
    static final int[] di = {-1, 1, 0, 0};
    static final int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) {
        // Un laberinto de ejemplo (5x5)
        char[][] grid = {
                {'S', '.', '.', '#', '.'},
                {'#', '#', '.', '#', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '#', '#', '#', '#'},
                {'.', '.', '.', '.', 'E'}
        };

        int filas = grid.length;
        int columnas = grid[0].length;

        int startI = 0, startJ = 0;

        // Ejecutamos el algoritmo
        int pasosMinimos = resolverBFS(grid, startI, startJ, filas, columnas);

        if (pasosMinimos != -1) {
            System.out.println("Salida encontrada en " + pasosMinimos + " pasos.");
        } else {
            System.out.println("Imposible llegar a la salida (Atrapado).");
        }
    }

    /**
     * @return El número mínimo de pasos para llegar a 'E', o -1 si no hay ruta.
     */
    static int resolverBFS(char[][] grid, int startI, int startJ, int n, int m) {
        // Matriz de distancias: Reemplaza a nuestro clásico arreglo 'used'
        int[][] dist = new int[n][m];

        // Inicializamos todas las distancias en -1 (no visitado)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<Integer> cola = new ArrayDeque<>();

        // 1. CONFIGURACIÓN INICIAL
        // Comprimimos la coordenada de inicio y la metemos a la cola
        cola.offer(startI * m + startJ);
        dist[startI][startJ] = 0; // La distancia al punto de inicio es 0

        // 2. EL BUCLE DE INUNDACIÓN (BFS)
        while (!cola.isEmpty()) {
            int actual = cola.poll();

            // Descomprimimos la coordenada 1D para obtener fila y columna
            int ui = actual / m;
            int uj = actual % m;

            // CASO BASE DE ÉXITO: Si pisamos la salida, retornamos la distancia acumulada.
            // Gracias a BFS, sabemos con certeza que esta ES la distancia más corta.
            if (grid[ui][uj] == 'E') {
                return dist[ui][uj];
            }

            // Exploramos los 4 vecinos posibles
            for (int k = 0; k < 4; k++) {
                int vi = ui + di[k];
                int vj = uj + dj[k];

                // CONDICIONES DE VALIDEZ (La Poda):
                // 1. No salirnos de los límites de la matriz
                // 2. No chocar con una pared '#'
                // 3. Que la celda NO haya sido visitada antes (dist == -1)
                if (vi >= 0 && vi < n && vj >= 0 && vj < m && grid[vi][vj] != '#' && dist[vi][vj] == -1) {

                    // La magia del BFS: El vecino está a un paso más lejos que mi celda actual
                    dist[vi][vj] = dist[ui][uj] + 1;

                    // Encolamos al vecino comprimiendo su coordenada
                    cola.offer(vi * m + vj);
                }
            }
        }

        // Si la cola se vacía y nunca retornamos, significa que el destino es inalcanzable
        return -1;
    }
}