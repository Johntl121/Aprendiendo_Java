package uni.edu.pe.ArabolesBinarios.EjmArbBinBusq;

// Clase que representa un nodo del árbol binario de búsqueda
public class BSTNode {
    public int key;              // Clave para ordenar en el árbol (criterio BST)
    public String elem;          // Valor asociado a la clave

    public BSTNode parent;       // Referencia al nodo padre
    public BSTNode leftChild;    // Hijo izquierdo (claves menores)
    public BSTNode rightChild;   // Hijo derecho (claves mayores)

    // Constructor: inicializa el nodo con su clave y valor
    public BSTNode(int key, String elem) {
        this.key = key;
        this.elem = elem;
        // Los demás (parent, leftChild, rightChild) quedan en null por defecto
    }
}