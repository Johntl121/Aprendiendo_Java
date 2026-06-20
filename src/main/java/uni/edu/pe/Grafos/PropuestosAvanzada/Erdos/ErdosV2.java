package uni.edu.pe.Grafos.PropuestosAvanzada.Erdos;

import java.util.*;

public class ErdosV2 {
    // ¡CUIDADO!: 500 es muy pequeño para grafos reales. Considerar aumentar a 10000.
    static final int MX = 500;

    // Nuestro grafo: Un arreglo donde cada índice es el ID numérico de un autor,
    // y contiene la lista de los IDs de sus coautores.
    static List<Integer>[] adj = new List[MX];

    // Arreglo de distancias (Número de Erdös) para cada ID de autor
    static int[] d = new int[MX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // Inicializamos las listas del arreglo una sola vez para todo el programa
        for(int i = 0; i < MX; i++) adj[i] = new ArrayList<>();

        for(int tst = 1; tst <= T; tst++){

            // 1. LIMPIEZA PARA EL NUEVO ESCENARIO
            for(int i = 0; i < MX; i++){
                adj[i].clear();
                d[i] = -1; // -1 significa "infinito" o "no visitado"
            }

            int n = sc.nextInt(), Q = sc.nextInt();
            sc.nextLine(); // Consumimos el salto de línea residual

            // 2. MAPEO DE IDENTIDADES
            Map<String,Integer> mp = new HashMap<>();
            mp.put("Erdos, P.", 1); // Erdös SIEMPRE es el ID 1
            int cur = 2; // El próximo autor descubierto será el ID 2

            // 3. PARSEO MANUAL Y CONSTRUCCIÓN DEL GRAFO
            for(int i = 0; i < n; i++){
                String s = sc.nextLine();
                int sz = s.length();
                List<Integer> a = new ArrayList<>(); // Guarda los IDs de los autores de ESTE paper

                for(int j = 0; j < sz; j++) {
                    // Ignoramos espacios iniciales
                    if(s.charAt(j) != ' '){
                        int cont = 0;
                        StringBuilder t = new StringBuilder();

                        // Extraemos caracteres hasta tener 2 comas (fin de un autor) o ver los dos puntos ':'
                        while(j < sz && cont < 2 && s.charAt(j) != ':'){
                            if(s.charAt(j) == ',') cont++;
                            if(cont == 2) break; // Si vimos 2 comas, ya tenemos "Apellido, Iniciales"

                            t.append(s.charAt(j));
                            j++;
                        }

                        // Si es un autor nuevo, le asignamos su ID numérico ('cur') y aumentamos 'cur'
                        if(mp.get(t.toString()) == null) {
                            mp.put(t.toString(), cur++);
                        }

                        // Añadimos el ID del autor a la lista del paper actual
                        a.add(mp.get(t.toString()));

                        // Si llegamos a los dos puntos, terminaron los autores y empieza el título del paper
                        if(j < sz && s.charAt(j) == ':') break;
                    }
                }

                // Conectamos a todos los autores de este paper usando sus IDs numéricos
                sz = a.size();
                for(int j = 0; j < sz; j++) {
                    for(int k = j + 1; k < sz; k++){
                        int u = a.get(j), v = a.get(k);
                        adj[u].add(v); // u se conecta con v
                        adj[v].add(u); // v se conecta con u
                    }
                }
            }

            // 4. EL BFS (Búsqueda de la ruta más corta)
            d[1] = 0; // La distancia de Erdös a sí mismo es 0
            Queue<Integer> q = new ArrayDeque<>();
            q.add(1); // Encolamos a Erdös

            while(!q.isEmpty()){
                int u = q.poll(); // Sacamos el ID actual

                // Recorremos los IDs de sus coautores
                for(int v : adj[u]) {
                    // Si el coautor no tiene distancia asignada (-1)
                    if(d[v] == -1){
                        d[v] = d[u] + 1; // Su número de Erdös es el del actual + 1
                        q.add(v);        // Lo encolamos para procesar sus contactos después
                    }
                }
            }

            // 5. RESPUESTAS
            System.out.println("Scenario " + tst);
            for(int i = 0; i < Q; i++){
                String t = sc.nextLine();
                Integer u = mp.get(t); // Buscamos el ID del autor consultado

                System.out.print(t + " ");

                // Si nunca lo vimos en los papers (u == null) o el BFS no lo alcanzó (d[u] == -1)
                if(u == null || d[u] == -1) {
                    System.out.println("infinity");
                } else {
                    System.out.println(d[u]);
                }
            }
        }
    }
}