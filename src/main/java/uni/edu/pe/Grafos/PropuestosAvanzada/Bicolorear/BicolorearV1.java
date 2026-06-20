package uni.edu.pe.Grafos.PropuestosAvanzada.Bicolorear;

import java.util.*;

public class BicolorearV1 {
    // Definimos un límite seguro según el problema (n < 200)
    static final int MAX_NODOS = 205;
    static List<Integer>[] adyacencia = new ArrayList[MAX_NODOS];
    static int[] color = new int[MAX_NODOS];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializamos las listas una sola vez
        for (int i = 0; i < MAX_NODOS; i++) {
            adyacencia[i] = new ArrayList<>();
        }

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            // Condición de finalización del programa
            if (n == 0) break;

            int l = sc.nextInt(); // Número de arcos

            // 1. LIMPIEZA PARA EL NUEVO CASO DE PRUEBA
            for (int i = 0; i < n; i++) {
                adyacencia[i].clear();
                color[i] = -1; // -1 significa "sin pintar"
            }

            // 2. CONSTRUCCIÓN DEL GRAFO
            for (int i = 0; i < l; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adyacencia[u].add(v); // u se conecta con v [cite: 245]
                adyacencia[v].add(u); // v se conecta con u
            }

            // 3. BÚSQUEDA EN ANCHURA (BFS)
            boolean esBicoloreable = true;
            Queue<Integer> cola = new ArrayDeque<>();

            // Empezamos por el nodo 0 (el problema dice que es fuertemente conexo)
            cola.offer(0);
            color[0] = 0; // Le asignamos el primer color (0)

            // Mientras la cola tenga elementos y no hayamos detectado un conflicto
            while (!cola.isEmpty() && esBicoloreable) {
                int actual = cola.poll();

                // Recorremos todos los vecinos del nodo actual
                for (int vecino : adyacencia[actual]) {

                    // Si el vecino aún no tiene color
                    if (color[vecino] == -1) {
                        // Lo pintamos del color contrario.
                        // El truco aritmético (1 - color[actual]) alterna entre 0 y 1 de forma perfecta.
                        color[vecino] = 1 - color[actual];
                        cola.offer(vecino); // Lo encolamos para el siguiente nivel de búsqueda
                    }
                    // Si el vecino ya tiene color, revisamos si hay choque
                    else if (color[vecino] == color[actual]) {
                        esBicoloreable = false; // ¡Choque de colores detectado!
                        break; // Rompemos el ciclo for
                    }
                }
            }

            // 4. IMPRESIÓN DEL RESULTADO
            if (esBicoloreable) {
                System.out.println("BICOLORABLE.");
            } else {
                System.out.println("NOT BICOLORABLE.");
            }
        }
        sc.close();
    }
}