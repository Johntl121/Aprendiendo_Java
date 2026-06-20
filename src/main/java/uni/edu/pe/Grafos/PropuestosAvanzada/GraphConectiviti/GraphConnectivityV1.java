package uni.edu.pe.Grafos.PropuestosAvanzada.GraphConectiviti;

import java.util.*;

public class GraphConnectivityV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int casos = sc.nextInt();
        sc.nextLine(); // Consumimos el salto de línea residual del número
        sc.nextLine(); // Consumimos la primera línea en blanco que separa el número de los datos

        for (int c = 0; c < casos; c++) {
            // El juez exige una línea en blanco entre las salidas de casos consecutivos
            if (c > 0) {
                System.out.println();
            }

            // Leemos el nodo mayor (ej. 'E')
            String maxNodoStr = sc.nextLine();
            if (maxNodoStr.isEmpty()) {
                maxNodoStr = sc.nextLine(); // Control de seguridad por si hay líneas en blanco dobles
            }

            // Calculamos el total de nodos (0 indexado)
            int n = maxNodoStr.charAt(0) - 'A' + 1;

            // Inicializamos la Lista de Adyacencia
            List<Integer>[] adyacencia = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adyacencia[i] = new ArrayList<>();
            }

            // Leemos las aristas hasta encontrar una línea en blanco o el fin del archivo
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (linea.isEmpty()) {
                    break; // Fin del bloque de datos de este caso de prueba
                }

                // Convertimos el par de letras (ej. "AB") a coordenadas numéricas (0 y 1)
                int u = linea.charAt(0) - 'A';
                int v = linea.charAt(1) - 'A';

                // Grafo no dirigido
                adyacencia[u].add(v);
                adyacencia[v].add(u);
            }

            // Arreglo para rastrear nodos descubiertos
            boolean[] usado = new boolean[n];
            int subgrafosMaximales = 0;

            // Bucle principal: Buscar componentes conexas
            for (int i = 0; i < n; i++) {
                // Si encontramos un nodo intacto, es una nueva isla
                if (!usado[i]) {
                    subgrafosMaximales++;

                    // ==========================================
                    // INICIO DEL BFS (Para inundar toda la isla)
                    // ==========================================
                    Queue<Integer> cola = new ArrayDeque<>();
                    cola.offer(i);
                    usado[i] = true;

                    while (!cola.isEmpty()) {
                        int u = cola.poll();

                        // Revisamos las conexiones del nodo actual
                        for (int vecino : adyacencia[u]) {
                            if (!usado[vecino]) {
                                usado[vecino] = true; // Lo marcamos inmediatamente para evitar ciclos
                                cola.offer(vecino);
                            }
                        }
                    }
                }
            }

            // Imprimimos el total de componentes conexas de este caso
            System.out.println(subgrafosMaximales);
        }
        sc.close();
    }
}