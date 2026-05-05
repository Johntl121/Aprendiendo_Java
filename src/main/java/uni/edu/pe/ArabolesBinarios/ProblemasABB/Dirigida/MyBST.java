package uni.edu.pe.ArabolesBinarios.ProblemasABB.Dirigida;

public class MyBST extends BSTree {

    // =======================================================
    // PROBLEMA 1: NODOS PRIMOS
    // =======================================================

    /*
     * Helper 1: Busca y devuelve el NODO completo según su llave.
     * Tu BSTree tiene un find(), pero devuelve un String. Aquí necesitamos el objeto BSTNode.
     */
    private BSTNode findNode(BSTNode currentNode, int key) {
        if (currentNode == null) return null;
        if (currentNode.key == key) return currentNode;

        // Aprovechamos la regla del BST para buscar rápido
        if (key < currentNode.key) {
            return findNode(currentNode.leftChild, key);
        } else {
            return findNode(currentNode.rightChild, key);
        }
    }

    /*
     * Helper 2: Calcula la profundidad de un nodo subiendo por sus padres.
     * ¡Magia del atributo 'parent'! En vez de buscar desde la raíz hacia abajo,
     * escalamos desde el nodo hacia la raíz contando los pasos.
     */
    private int getDepth(BSTNode node) {
        int depth = 0;
        BSTNode current = node;
        while (current != null) {
            depth++;
            current = current.parent; // Subimos un nivel
        }
        return depth;
    }

    /*
     * Metodo principal del Problema 1.
     * Dos nodos son primos si:
     * 1) Tienen la misma profundidad.
     * 2) Tienen padres distintos.
     * 3) Comparten el mismo abuelo.
     */
    public boolean check_cousins(int a, int b) {
        // 1. Buscamos los nodos físicos en memoria
        BSTNode nodeA = findNode(root, a);
        BSTNode nodeB = findNode(root, b);

        // Si alguno no existe, o son el mismo nodo, o alguno es la raíz (no tiene padre), descartamos.
        if (nodeA == null || nodeB == null || nodeA == nodeB || nodeA.parent == null || nodeB.parent == null) {
            return false;
        }

        // 2. Verificamos que estén en el mismo nivel (profundidad)
        if (getDepth(nodeA) != getDepth(nodeB)) {
            return false;
        }

        // 3. Verificamos la genealogía:
        boolean padresDistintos = (nodeA.parent != nodeB.parent);

        // Cuidado: hay que asegurar que el abuelo exista para evitar un NullPointerException
        boolean compartenAbuelo = (nodeA.parent.parent != null) &&
                (nodeA.parent.parent == nodeB.parent.parent);

        return padresDistintos && compartenAbuelo;
    }

    // =======================================================
    // PROBLEMA 2: MISMA FORMA
    // =======================================================

    /*
     * Helper recursivo: Compara la topología de dos subárboles simultáneamente.
     */
    private boolean isSameShapeHelper(BSTNode n1, BSTNode n2) {
        // Si ambos están vacíos al mismo tiempo, la forma coincide aquí.
        if (n1 == null && n2 == null) return true;

        // Si uno existe y el otro no, la forma se rompió.
        if (n1 == null || n2 == null) return false;

        // La magia de la recursión: preguntamos a los hijos izquierdos Y a los hijos derechos.
        return isSameShapeHelper(n1.leftChild, n2.leftChild) &&
                isSameShapeHelper(n1.rightChild, n2.rightChild);
    }

    /*
     * Metodo principal del Problema 2.
     * Recibe otro árbol (que también debe ser un MyBST) para compararlo.
     */
    public boolean is_same_shape(MyBST otherTree) {
        // Comparamos la raíz de ESTE árbol (this.root) con la raíz del OTRO (otherTree.root)
        return isSameShapeHelper(this.root, otherTree.root);
    }
}
