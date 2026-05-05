package uni.edu.pe.ArabolesBinarios.ProblemasABB.Dirigida;

public class BSTree implements IBSTree {

    // Necesario para que MyBST pueda acceder a la raíz y recorrer el árbol
    protected BSTNode root;

    public BSTree() {
        this.root = null;
    }

    // =======================================================
    // INSERTAR (Lo único que necesitamos para el main)
    // =======================================================

    @Override
    public void insert(int key, String elem) {
        BSTNode newNode = new BSTNode(key, elem);
        if (root == null) {
            root = newNode;
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
            if (node.leftChild == null) {
                node.leftChild = newNode;
                newNode.parent = node;
            } else {
                insert(newNode, node.leftChild);
            }
        } else {
            if (node.rightChild == null) {
                node.rightChild = newNode;
                newNode.parent = node;
            } else {
                insert(newNode, node.rightChild);
            }
        }
    }
}
