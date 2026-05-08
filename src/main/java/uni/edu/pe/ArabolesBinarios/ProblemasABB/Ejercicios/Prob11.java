package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob11: Añadir un metodo que compruebe si el árbol está equilibrado en altura, es decir,
// que todos sus nodos tienen un factor de equilibrio en altura menor o igual que 1.
// (Esta es exactamente la condición de un Árbol AVL)
public class Prob11 extends BSTree {

    // =======================================================
    // DEPENDENCIAS DEL EJERCICIO 9 (Factor por altura)
    // =======================================================
    public int getHeightBalanceFactor(BSTNode node) {
        if (node == null) return 0;
        int leftHeight = getHeightOfNode(node.leftChild);
        int rightHeight = getHeightOfNode(node.rightChild);
        return Math.abs(rightHeight - leftHeight);
    }

    private int getHeightOfNode(BSTNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeightOfNode(node.leftChild), getHeightOfNode(node.rightChild));
    }

    // =======================================================
    // EJERCICIO 11: Comprobar equilibrio perfecto por altura
    // =======================================================
    public boolean isPerfectlyBalancedByHeight() {
        return isPerfectlyBalancedByHeightHelper(root);
    }

    private boolean isPerfectlyBalancedByHeightHelper(BSTNode node) {
        // Caso base: un nodo vacío se considera equilibrado
        if (node == null) return true;

        // Calculamos el factor de este nodo específico
        int currentFactor = getHeightBalanceFactor(node);

        // Si la diferencia de alturas de sus ramas es mayor a 1, el árbol NO está equilibrado
        if (currentFactor > 1) {
            return false;
        }

        // Si este nodo está bien, preguntamos recursivamente a sus hijos
        return isPerfectlyBalancedByHeightHelper(node.leftChild) &&
                isPerfectlyBalancedByHeightHelper(node.rightChild);
    }
}