package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob8: Calcular el factor de equilibrio por tamaño de un nodo, que es el valor absoluto
// de la diferencia entre el tamaño de su hijo derecho y su hijo izquierdo.
public class Prob8 extends BSTree {
    public int getSizeBalanceFactor(BSTNode node) {
        if (node == null) return 0; // Un nodo inexistente tiene tamaño 0, su factor es 0

        // Llamamos a un metodo privado getSizeNode (asumiendo que modificas un poco
        // tu getSize() para que acepte un nodo específico y no solo la raíz)
        int leftSize = getSizeOfNode(node.leftChild);
        int rightSize = getSizeOfNode(node.rightChild);

        // Valor absoluto de la diferencia
        return Math.abs(rightSize - leftSize);
    }

    // Helper auxiliar (similar al getSize() privado de tu BSTree)
    private int getSizeOfNode(BSTNode node) {
        if (node == null) return 0;
        return 1 + getSizeOfNode(node.leftChild) + getSizeOfNode(node.rightChild);
    }
}
