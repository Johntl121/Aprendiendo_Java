package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob3: Metodo recursivo que devuelva la suma total de todos los elementos del árbol
public class Prob3 extends BSTree {

    public int sumAllElements() {
        return sumHelper(root);
    }

    private int sumHelper(BSTNode node) {
        // Caso base: un espacio vacío aporta 0 a la suma
        if (node == null) return 0;

        // Retornamos: valor actual + (suma izquierda) + (suma derecha)
        return node.key + sumHelper(node.leftChild) + sumHelper(node.rightChild);
    }
}
