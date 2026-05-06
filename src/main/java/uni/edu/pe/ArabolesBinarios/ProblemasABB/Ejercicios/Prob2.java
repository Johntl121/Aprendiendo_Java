package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

//Prob2: Recorrer el árbol recursivamente e imprimir los elementos cuyo abuelo tenga un valor múltiplo de 10
public class Prob2 {
    private BSTNode root;

    public void printGrandparentMultipleOf10() {
        System.out.println("Nodos con abuelo múltiplo de 10:");
        printGrandparentHelper(root);
    }

    private void printGrandparentHelper(BSTNode node) {
        if (node == null) return; // Caso base

        // Verificamos si tiene padre, y si ese padre tiene padre (abuelo)
        if (node.parent != null && node.parent.parent != null) {
            int valorAbuelo = node.parent.parent.key;

            // Si la clave del abuelo es múltiplo de 10, imprimimos el elemento
            if (valorAbuelo % 10 == 0) {
                System.out.println("Elemento: " + node.elem + " (Abuelo: " + valorAbuelo + ")");
            }
        }

        // Continuamos la recursión por ambas ramas
        printGrandparentHelper(node.leftChild);
        printGrandparentHelper(node.rightChild);
    }
}
