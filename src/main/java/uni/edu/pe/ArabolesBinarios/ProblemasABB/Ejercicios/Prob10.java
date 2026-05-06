package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob10: Añadir un metodo que compruebe si todos los nodos del árbol tienen
// un factor de equilibrio por tamaño menor o igual a 1.
public class Prob10 extends BSTree{

    // =======================================================
    // EJERCICIO 8: Factor de equilibrio por tamaño
    // =======================================================
    public int getSizeBalanceFactor(BSTNode node) {
        if (node == null) return 0;
        int leftSize = getSizeOfNode(node.leftChild);
        int rightSize = getSizeOfNode(node.rightChild);
        return Math.abs(rightSize - leftSize);
    }

    // Helper privado para el Ejercicio 8
    private int getSizeOfNode(BSTNode node) {
        if (node == null) return 0;
        return 1 + getSizeOfNode(node.leftChild) + getSizeOfNode(node.rightChild);
    }

    public boolean isPerfectlyBalancedBySize() {
        return isPerfectlyBalancedBySizeHelper(root);
    }

    private boolean isPerfectlyBalancedBySizeHelper(BSTNode node) {
        // Caso base: Las ramas vacías (null) se consideran perfectamente balanceadas
        if (node == null) return true;

        // 1. Revisamos el factor del nodo actual (usando el metodo del ejercicio 8)
        int currentFactor = getSizeBalanceFactor(node);

        // Si este nodo rompe la regla, td el árbol es falso, cortamos aquí
        if (currentFactor > 1) {
            return false;
        }

        // 2 y 3. Si el actual está bien, verificamos recursivamente ambos hijos
        return isPerfectlyBalancedBySizeHelper(node.leftChild) &&
                isPerfectlyBalancedBySizeHelper(node.rightChild);
    }
}
