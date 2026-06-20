package uni.edu.pe.Grafos.PropuestosAvanzada.GraphConectiviti;

import java.util.*;

public class GraphConnectivityV2 {
    // Definimos el límite máximo de nodos (Suficiente para el abecedario)
    static final int N = 100;

    // Matriz de Adyacencia: g[u][v] es 'true' si hay una arista entre u y v
    static boolean g[][] = new boolean[N][N];

    // Arreglo para rastrear qué nodos ya pertenecen a un grupo descubierto
    static boolean used[] = new boolean[N];

    // BFS Clásico: Inunda toda la componente conexa a partir del nodo 'r'
    static void bfs(int r, int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(r);
        used[r] = true;

        while(!q.isEmpty()){
            int u = q.poll();

            // Al usar Matriz, debemos revisar TODOS los nodos del 1 al 'n'
            for(int v = 1; v <= n; v++) {
                // Si existe conexión y el nodo 'v' no ha sido visitado
                if(g[u][v]){
                    if(used[v]) continue; // Si ya se visitó, saltamos

                    q.offer(v);
                    used[v] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lee el nodo mayor (ej. 'G') y lo convierte a número (ej. 7)
        int n = sc.next().charAt(0) - 'A' + 1;
        int m = sc.nextInt(); // Número total de aristas

        // Construcción del Grafo (No dirigido)
        for(int i = 0; i < m; i++){
            String s = sc.next(); // Ej: "AB"
            int u = s.charAt(0) - 'A' + 1;
            int v = s.charAt(1) - 'A' + 1;

            g[u][v] = true;
            g[v][u] = true;
        }

        int comp = 0; // Contador de componentes conexas

        // Búsqueda de componentes aisladas
        for(int u = 1; u <= n; u++) {
            if(!used[u]){
                comp++;      // Encontramos una nueva "isla"
                bfs(u, n);   // Inundamos la isla para no volver a contar sus nodos
            }
        }

        System.out.println(comp);
        sc.close();
    }
}