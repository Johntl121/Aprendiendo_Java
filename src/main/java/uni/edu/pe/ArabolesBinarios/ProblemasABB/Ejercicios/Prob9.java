package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob9: Calcular el factor de equilibrio por altura, que es el valor absoluto
// de la diferencia entre la altura de su hijo derecho y su hijo izquierdo.
public class Prob9 extends BSTree {
    public int getHeightBalanceFactor(BSTNode node) {
        if (node == null) return 0;

        // Calculamos las alturas de los hijos
        int leftHeight = getHeightOfNode(node.leftChild);
        int rightHeight = getHeightOfNode(node.rightChild);

        // Valor absoluto de la diferencia
        return Math.abs(rightHeight - leftHeight);
    }

    // Helper auxiliar (similar al getHeight() privado de tu BSTree)
    private int getHeightOfNode(BSTNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeightOfNode(node.leftChild), getHeightOfNode(node.rightChild));
    }
}
