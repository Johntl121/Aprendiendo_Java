package uni.edu.pe.Backtracking.PropuestosAvanzada.CD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CDV1 {
    // Variables globales para recordar la mejor solución encontrada en todo el árbol
    static int mejorSuma;
    static List<Integer> mejorRuta;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leemos hasta que no haya más entrada
        while (sc.hasNextInt()) {
            int capacidadMax = sc.nextInt(); // N: Capacidad máxima del CD
            int numPistas = sc.nextInt();    // Cantidad de pistas disponibles

            int[] pistas = new int[numPistas];
            for (int i = 0; i < numPistas; i++) {
                pistas[i] = sc.nextInt();
            }

            // Reiniciamos las variables de control para cada caso de prueba
            mejorSuma = 0;
            mejorRuta = new ArrayList<>();
            List<Integer> rutaActual = new ArrayList<>();

            // Arrancamos el Backtracking
            resolverBacktrack(pistas, capacidadMax, 0, 0, rutaActual);

            // Imprimimos la mejor combinación encontrada
            for (int pista : mejorRuta) {
                System.out.print(pista + " ");
            }
            System.out.println("sum:" + mejorSuma);
        }
        sc.close();
    }

    /**
     * @param pistas       Arreglo con las duraciones de las pistas
     * @param capacidadMax Límite N del CD
     * @param indice       Pista actual que estamos evaluando
     * @param sumaActual   Total de minutos acumulados en la ruta actual
     * @param rutaActual   Nuestra mochila temporal
     */
    static void resolverBacktrack(int[] pistas, int capacidadMax, int indice, int sumaActual, List<Integer> rutaActual) {

        // 1. EVALUAR EL ESTADO (Actualizar nuestro récord)
        // Cada vez que llegamos a un estado válido, verificamos si es mejor que el anterior.
        // Si hay un empate (misma suma), el problema original suele preferir la primera
        // combinación encontrada (que es la más larga debido al orden de evaluación).
        if (sumaActual > mejorSuma) {
            mejorSuma = sumaActual;
            // Guardamos una COPIA de la lista actual, no la referencia original
            mejorRuta = new ArrayList<>(rutaActual);
        }

        // 2. CASO BASE
        // Si ya revisamos todas las pistas del arreglo, no hay más decisiones que tomar.
        if (indice == pistas.length) {
            return;
        }

        // =========================================================
        // RAMA A: "TOMAR" LA PISTA (Solo si no nos pasamos del límite)
        // =========================================================
        if (sumaActual + pistas[indice] <= capacidadMax) {
            rutaActual.add(pistas[indice]); // Metemos la pista

            // Exploramos avanzando de índice y sumando el tiempo de la pista
            resolverBacktrack(pistas, capacidadMax, indice + 1, sumaActual + pistas[indice], rutaActual);

            // Backtracking: Sacamos la pista para poder explorar el camino de no tomarla
            rutaActual.remove(rutaActual.size() - 1);
        }

        // =========================================================
        // RAMA B: "NO TOMAR" LA PISTA
        // =========================================================
        // Avanzamos al siguiente índice, pero nuestra suma y nuestra mochila quedan intactas
        resolverBacktrack(pistas, capacidadMax, indice + 1, sumaActual, rutaActual);
    }
}