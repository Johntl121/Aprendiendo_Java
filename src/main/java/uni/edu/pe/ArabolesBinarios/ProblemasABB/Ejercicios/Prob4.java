package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob4: Dado un nodo, devolver su predecesor de forma iterativa
public class Prob4 {
    public BSTNode getPredecessor(BSTNode node) {
        if (node == null) return null;

        // Caso 1: Tiene subárbol izquierdo
        if (node.leftChild != null) {
            BSTNode current = node.leftChild;
            // Buscamos el máximo de ese subárbol (td a la derecha)
            while (current.rightChild != null) {
                current = current.rightChild;
            }
            return current; // Este es el predecesor
        }

        // Caso 2: No tiene subárbol izquierdo, subimos por los padres
        BSTNode current = node;
        BSTNode padre = node.parent;

        // Mientras haya padre y sigamos siendo el hijo izquierdo de ese padre...
        while (padre != null && current == padre.leftChild) {
            current = padre;
            padre = padre.parent; // Seguimos subiendo
        }

        // Si salimos del bucle, el padre es nuestro predecesor (o null si era el elemento más pequeño)
        return padre;
    }
}
