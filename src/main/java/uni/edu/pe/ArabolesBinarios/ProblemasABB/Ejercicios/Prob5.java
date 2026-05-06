package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob5: Dado un nodo, devolver su sucesor de forma iterativa
public class Prob5 extends BSTree {
    public BSTNode getSuccessor(BSTNode node) {
        if (node == null) return null;

        // Caso 1: Tiene subárbol derecho
        if (node.rightChild != null) {
            BSTNode current = node.rightChild;
            // Buscamos el mínimo de ese subárbol (td a la izquierda)
            while (current.leftChild != null) {
                current = current.leftChild;
            }
            return current; // Este es el sucesor
        }

        // Caso 2: No tiene subárbol derecho, subimos por los padres
        BSTNode current = node;
        BSTNode padre = node.parent;

        // Mientras haya padre y sigamos siendo el hijo derecho de ese padre...
        while (padre != null && current == padre.rightChild) {
            current = padre;
            padre = padre.parent; // Seguimos subiendo
        }

        // Si salimos del bucle, el padre es nuestro sucesor
        return padre;
    }
}
