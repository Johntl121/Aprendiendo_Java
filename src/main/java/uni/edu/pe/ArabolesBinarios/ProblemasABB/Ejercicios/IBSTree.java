package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

public interface IBSTree {
    // Retorna el número total de nodos
    public int getSize();

    // Retorna la altura del árbol (niveles)
    public int getHeight();

    // Recorridos del árbol
    public void showPreOrder();   // raíz → izquierda → derecha
    public void showInOrder();    // izquierda → raíz → derecha (ordenado)
    public void showPostOrder();  // izquierda → derecha → raíz
    public void showLevelOrder(); // por niveles (no implementado en tu BSTree)

    // Operaciones básicas
    public void insert(int key, String elem); // insertar nodo
    public void remove(int key);              // eliminar nodo por clave
    public String find(int key);              // buscar y devolver el valor

    // Nuevas herramientas sofisticadas
    public boolean isEmpty(); // ¿El árbol está vacío?
    public BSTNode findMin(); // Devuelve el nodo más pequeño
    public BSTNode findMax(); // Devuelve el nodo más grande
}
