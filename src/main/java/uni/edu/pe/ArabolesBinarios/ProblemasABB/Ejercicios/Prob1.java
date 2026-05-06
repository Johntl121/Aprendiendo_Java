package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;
import java.util.LinkedList;
import java.util.Queue;

// Prob1: Implementar un metodo que reciba un nodo y devuelva su recorrido por niveles.
public class Prob1 {
    public void showLevelOrder(BSTNode startNode) {
        if (startNode == null) return;

        // Creamos la cola para manejar el orden de visita
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(startNode); // Empezamos por el nodo recibido

        System.out.print("Recorrido por niveles: ");
        while (!queue.isEmpty()) {
            BSTNode current = queue.poll(); // Sacamos al primero de la fila
            System.out.print(current.elem + " ");

            // Encolamos a los hijos (si existen) de izquierda a derecha
            if (current.leftChild != null) queue.add(current.leftChild);
            if (current.rightChild != null) queue.add(current.rightChild);
        }
        System.out.println();
    }
}
