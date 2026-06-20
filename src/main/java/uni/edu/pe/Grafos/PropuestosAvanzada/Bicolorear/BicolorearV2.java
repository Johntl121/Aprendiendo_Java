package uni.edu.pe.Grafos.PropuestosAvanzada.Bicolorear;

import java.util.*;

public class BicolorearV2 {
    // Grafo representado como Lista de Adyacencia
    static List<Integer>[] adj;
    // Arreglo para marcar si un nodo ya fue visitado
    static boolean[] used;
    // Arreglo para asignar el color (true = Color A, false = Color B)
    static boolean[] tipo;

    // ==========================================================
    // MÉTODO 1: DFS (Búsqueda en Profundidad)
    // Va pintando y metiéndose por una rama hasta el fondo.
    // ==========================================================
    static boolean dfs(int u, boolean t){
        tipo[u] = t;       // Asignamos el color actual
        used[u] = true;    // Marcamos como visitado

        for(int v : adj[u]){
            // Si el vecino ya está visitado y tiene el MISMO color, ¡Choque!
            if(used[v] && tipo[v] == t) {
                return false;
            }
            // Si el vecino no está visitado, lo mandamos a pintar del color CONTRARIO (!t)
            // Si en esa profundidad se detecta un error, propagamos el 'false' hacia arriba
            else if(!used[v] && !dfs(v, !t)) {
                return false;
            }
        }
        return true; // Si terminamos de revisar todos los vecinos sin choques, todo bien.
    }

    // ==========================================================
    // MÉTODO 2: BFS (Búsqueda en Anchura)
    // Pinta por capas: primero los vecinos directos, luego los vecinos de los vecinos.
    // ==========================================================
    static boolean bfs(int root){
        Queue<Integer> q = new ArrayDeque<>();

        q.add(root);
        used[root] = true;
        tipo[root] = true; // El nodo raíz empieza con el Color A (true)

        while(!q.isEmpty()){
            int u = q.poll(); // Sacamos el nodo actual

            for(int v : adj[u]){
                // Si el vecino ya está visitado y tiene el MISMO color que el actual, ¡Choque!
                if(used[v] && tipo[v] == tipo[u]) {
                    return false;
                }
                // Si el vecino no está visitado
                else if(!used[v]){
                    q.add(v);          // Lo metemos a la cola para evaluar sus vecinos después
                    used[v] = true;    // Lo marcamos como visitado
                    tipo[v] = !tipo[u];// Lo pintamos del color CONTRARIO al actual
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n != 0){
            int m = sc.nextInt();

            // Instanciamos el arreglo de listas
            adj = new List[n];
            for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

            // Construimos el grafo no dirigido
            while(m-- > 0){
                int u = sc.nextInt(), v = sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }

            used = new boolean[n];
            tipo = new boolean[n];
            boolean ok = true;

            // Mecanismo de seguridad para grafos desconexos (múltiples islas)
            for(int i = 0; i < n; i++) {
                if(!used[i] && !bfs(i)) { // Puedes cambiar bfs(i) por dfs(i, true) para probar
                    ok = false;
                    break; // Optimización de salida temprana
                }
            }

            System.out.println(ok ? "BICOLORABLE." : "NOT BICOLORABLE.");
            n = sc.nextInt();
        }
        sc.close();
    }
}