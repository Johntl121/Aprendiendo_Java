package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob7: Desarrollar un metodo que busque y devuelva el elemento con la clave de mayor valor.
public class Prob7 extends BSTree{

    public BSTNode getLargestNode() {
        if (root == null) return null; // Si el árbol está vacío

        BSTNode current = root;
        // Mientras haya un camino hacia la derecha, seguimos bajando
        while (current.rightChild != null) {
            current = current.rightChild;
        }

        return current; // Cuando el rightChild sea null, hemos llegado al máximo
    }
}
