package uni.edu.pe.ArabolesBinarios.EjmArbBinBusq;

public class BSTest {
    public static void main(String[] args) {
        testInsercion1(); // ejecuta prueba
    }

    private static void testInsercion1() {

        // Uso de la interfaz (polimorfismo)
        IBSTree tree = new BSTree();

        // Construcción del árbol
        tree.insert(50, "50");
        tree.insert(30, "30");
        tree.insert(70, "70");
        tree.insert(20, "20");
        tree.insert(40, "40");
        tree.insert(60, "60");
        tree.insert(80, "80");

        // Recorridos
        System.out.println("Pre-order:");
        tree.showPreOrder();

        System.out.println("In-order:");
        tree.showInOrder(); // importante: imprime ordenado

        System.out.println("Post-order:");
        tree.showPostOrder();

        // Métricas
        System.out.println("size: " + tree.getSize());
        System.out.println("height: " + tree.getHeight());
    }

    private static void testInsercion2() {

        IBSTree tree = new BSTree();

        // Otro ejemplo de árbol
        tree.insert(5, "A");
        tree.insert(3, "B");
        tree.insert(7, "C");
        tree.insert(2, "D");
        tree.insert(4, "E");
        tree.insert(6, "F");
        tree.insert(8, "G");

        System.out.println("Pre-order:");
        tree.showPreOrder();

        System.out.println("In-order:");
        tree.showInOrder();

        System.out.println("Post-order:");
        tree.showPostOrder();
    }
}
