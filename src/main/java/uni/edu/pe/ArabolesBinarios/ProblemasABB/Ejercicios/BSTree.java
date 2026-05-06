package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

public class BSTree implements IBSTree {

    protected BSTNode root; // Nodo raíz del árbol

    // =========================
    // TAMAÑO DEL ÁRBOL
    // =========================

    @Override
    public int getSize() {
        return getSize(root); // inicia desde la raíz
    }

    private int getSize(BSTNode node) {
        if (node == null) return 0; // caso base

        // cuenta nodo actual + subárbol izquierdo + subárbol derecho
        return 1 + getSize(node.leftChild) + getSize(node.rightChild);
    }

    // =========================
    // ALTURA DEL ÁRBOL
    // =========================

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BSTNode node) {
        if (node == null) return 0;

        // altura = 1 + la mayor altura entre hijos
        return 1 + Math.max(
                getHeight(node.leftChild),
                getHeight(node.rightChild)
        );
    }

    // =========================
    // RECORRIDO PREORDER
    // =========================

    @Override
    public void showPreOrder() {
        showPreOrder(root);
    }

    private void showPreOrder(BSTNode node) {
        if (node == null) return;

        System.out.println(node.elem);     // 1. raíz
        showPreOrder(node.leftChild);      // 2. izquierda
        showPreOrder(node.rightChild);     // 3. derecha
    }

    // =========================
    // RECORRIDO INORDER
    // =========================

    @Override
    public void showInOrder() {
        showInOrder(root);
    }

    private void showInOrder(BSTNode node) {
        if (node == null) return;

        showInOrder(node.leftChild);       // 1. izquierda
        System.out.println(node.elem);     // 2. raíz
        showInOrder(node.rightChild);      // 3. derecha
    }

    // =========================
    // RECORRIDO POSTORDER
    // =========================

    @Override
    public void showPostOrder() {
        showPostOrder(root);
    }

    private void showPostOrder(BSTNode node) {
        if (node == null) return;

        showPostOrder(node.leftChild);     // 1. izquierda
        showPostOrder(node.rightChild);    // 2. derecha
        System.out.println(node.elem);     // 3. raíz
    }

    @Override
    public void showLevelOrder() {
        // No implementado (normalmente se usa una cola - BFS)
    }

    // ==========================================
    // NUEVAS HERRAMIENTAS SOFISTICADAS
    // ==========================================

    /*
     * Herramienta 1: Saber si el árbol no tiene elementos.
     * Muy útil para evitar errores de NullPointerException al inicio de tus algoritmos.
    */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /*
     * Herramienta 2: Encontrar el MÍNIMO.
     * Lógica: En un BST, el menor valor SIEMPRE está lo más a la izquierda posible.
     * Retorna el NODO completo para que puedas acceder a su parent si lo necesitas.
     */
    @Override
    public BSTNode findMin() {
        if (isEmpty()) return null;

        BSTNode current = root;
        // Mientras haya un camino hacia la izquierda, seguimos bajando
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current;
    }

    /*
     * Herramienta 3: Encontrar el MÁXIMO.
     * Lógica: En un BST, el mayor valor SIEMPRE está lo más a la derecha posible.
     */
    @Override
    public BSTNode findMax() {
        if (isEmpty()) return null;

        BSTNode current = root;
        // Mientras haya un camino hacia la derecha, seguimos bajando
        while (current.rightChild != null) {
            current = current.rightChild;
        }
        return current;
    }

    // ======================================
    // INSERCIÓN (Mantenimiento del Árbol)
    // ======================================

    @Override
    public void insert(int key, String elem) {

        BSTNode newNode = new BSTNode(key, elem);

        if (root == null) {
            // Si el árbol está vacío, el nodo se vuelve raíz
            root = newNode; // Primer nodo del árbol
            root.parent = null;
        } else {
            insert(newNode, root);
        }
    }

    private void insert(BSTNode newNode, BSTNode node) {

        int key = newNode.key;

        if (key == node.key) {
            System.out.println("No se pueden poner duplicados!!!");
            return;
        }

        if (key < node.key) {
            // Insertar en el lado izquierdo
            if (node.leftChild == null) {
                node.leftChild = newNode;
                newNode.parent = node; // ¡CRUCIAL! El nuevo nodo reconoce quién es su padre
            } else {
                insert(newNode, node.leftChild); // Si está ocupado, sigue bajando
            }
        } else {
            // Insertar en el lado derecho
            if (node.rightChild == null) {
                node.rightChild = newNode;
                newNode.parent = node; // Actualiza la referencia del padre
            } else {
                insert(newNode, node.rightChild);
            }
        }
    }

    // ===============================================
    // ELIMINAR (La operación más compleja de un BST)
    // ===============================================

    @Override
    public void remove(int key) {
        root = remove(key, root); // puede cambiar la raíz
    }

    private BSTNode remove(Integer key, BSTNode currentNode) {

        if (currentNode == null) {
            System.out.println("No se encontró el elemento");
            return null;
        }

        // Fase 1: Búsqueda el nodo a eliminar
        if (key < currentNode.key) {
            currentNode.leftChild = remove(key, currentNode.leftChild);
            return currentNode;

        } else if (key > currentNode.key) {
            currentNode.rightChild = remove(key, currentNode.rightChild);
            return currentNode;

        } else {
            // Fase 2: ¡Nodo encontrado! Manejo de los 3 casos de eliminación

            // Caso 1: Es una hoja (sin hijos)
            if (currentNode.leftChild == null && currentNode.rightChild == null) {
                return null; // simplemente, desaparece, el recolector de basura de Java hará el resto
            }

            // Caso 2: Tiene un solo hijo (se "puentea" al nodo actual)
            if (currentNode.leftChild == null) {
                currentNode.rightChild.parent = currentNode.parent; // El hijo ahora apunta al abuelo
                return currentNode.rightChild;
            }

            if (currentNode.rightChild == null) {
                currentNode.leftChild.parent = currentNode.parent;
                return currentNode.leftChild;
            }

            // Caso 3: Tiene dos hijos.
            // Buscar sucesor (mínimo del subárbol derecho)
            BSTNode succesorNode = currentNode.rightChild;

            while (succesorNode.leftChild != null) {
                succesorNode = succesorNode.leftChild; // Baja todo lo posible a la izquierda.
            }

            // Reemplazar datos
            currentNode.key = succesorNode.key;
            currentNode.elem = succesorNode.elem;

            // Eliminar el sucesor
            currentNode.rightChild = remove(succesorNode.key, currentNode.rightChild);

            return currentNode;
        }
    }

    // =========================
    // BÚSQUEDA
    // =========================

    @Override
    public String find(int key) {
        return find(root, key);
    }

    private String find(BSTNode currentNode, int key) {

        if (currentNode == null) {
            System.out.println("No se encontró el elemento");
            return null;
        }

        if (currentNode.key == key) {
            return currentNode.elem;
        }

        if (key < currentNode.key) {
            return find(currentNode.leftChild, key);
        } else {
            return find(currentNode.rightChild, key);
        }
    }
}