package uni.edu.pe.Grafos.PropuestosAvanzada.Erdos;

import java.util.*;

public class ErdosV1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int escenarios = sc.nextInt();

        for (int s = 1; s <= escenarios; s++) {
            int P = sc.nextInt(); // Número de artículos (Papers)
            int N = sc.nextInt(); // Número de nombres a consultar
            sc.nextLine(); // Consumir el salto de línea

            // Nuestro Grafo: Mapa que relaciona un Autor con su Lista de Coautores
            Map<String, List<String>> grafo = new HashMap<>();

            // 1. CONSTRUCCIÓN DEL GRAFO
            for (int i = 0; i < P; i++) {
                String linea = sc.nextLine();

                // Separamos los autores del título (El formato UVa usa ':')
                String[] partes = linea.split(":");
                if (partes.length == 0) continue;

                String zonaAutores = partes[0];

                // Extraemos los autores. Como cada autor tiene una coma en su nombre,
                // separamos por comas y unimos de a dos fragmentos.
                String[] tokens = zonaAutores.split(",");
                List<String> autoresDelPaper = new ArrayList<>();

                for (int j = 0; j < tokens.length; j += 2) {
                    if (j + 1 < tokens.length) {
                        // Limpiamos espacios extra y reconstruimos "Apellido, Iniciales."
                        String nombre = tokens[j].trim() + ", " + tokens[j+1].trim();
                        autoresDelPaper.add(nombre);

                        // Si el autor no existe en el grafo, lo inicializamos
                        grafo.putIfAbsent(nombre, new ArrayList<>());
                    }
                }

                // Conectamos a todos los autores de este paper entre sí (Aristas no dirigidas)
                for (int j = 0; j < autoresDelPaper.size(); j++) {
                    for (int k = j + 1; k < autoresDelPaper.size(); k++) {
                        String u = autoresDelPaper.get(j);
                        String v = autoresDelPaper.get(k);
                        grafo.get(u).add(v);
                        grafo.get(v).add(u);
                    }
                }
            }

            // 2. BÚSQUEDA EN ANCHURA (BFS)
            // Mapa para guardar la distancia (Número de Erdös) de cada autor
            Map<String, Integer> distancias = new HashMap<>();
            Queue<String> cola = new ArrayDeque<>();

            String origen = "Erdos, P.";

            // Solo iniciamos el BFS si Erdös realmente publicó algo en este escenario
            if (grafo.containsKey(origen)) {
                distancias.put(origen, 0);
                cola.offer(origen);
            }

            while (!cola.isEmpty()) {
                String actual = cola.poll();
                int distActual = distancias.get(actual);

                // Recorremos todos los coautores del autor actual
                for (String vecino : grafo.getOrDefault(actual, new ArrayList<>())) {
                    // Si no hemos visitado a este vecino (no tiene distancia asignada)
                    if (!distancias.containsKey(vecino)) {
                        distancias.put(vecino, distActual + 1); // Asignamos su número de Erdös
                        cola.offer(vecino); // Lo encolamos para explorar sus conexiones luego
                    }
                }
            }

            // 3. RESPUESTAS
            System.out.println("Scenario " + s);
            for (int i = 0; i < N; i++) {
                String query = sc.nextLine().trim();
                if (distancias.containsKey(query)) {
                    System.out.println(query + " " + distancias.get(query));
                } else {
                    // Si el BFS nunca llegó a él (o no existe), su número es infinito
                    System.out.println(query + " infinity");
                }
            }
        }
        sc.close();
    }
}