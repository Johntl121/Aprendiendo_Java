package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob6: Desarrollar un metodo que busque y devuelva el elemento con la clave más pequeña del árbol
public class Prob6 extends BSTree{

    public BSTNode getSmallestNode() {
        if (root == null) return null; // Si el árbol está vacío

        BSTNode current = root;
        // Mientras haya un camino hacia la izquierda, seguimos bajando
        while (current.leftChild != null) {
            current = current.leftChild;
        }

        return current; // Cuando el leftChild sea null, hemos llegado al mínimo
    }
}
