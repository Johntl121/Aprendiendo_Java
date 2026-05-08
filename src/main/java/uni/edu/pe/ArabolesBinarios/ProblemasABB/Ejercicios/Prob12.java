package uni.edu.pe.ArabolesBinarios.ProblemasABB.Ejercicios;

// Prob12: Crear una clase Test con un metodo main, instanciar el árbol e
// insertar una secuencia específica de elementos
public class Prob12 extends BSTree {
    public static void main(String[] args) {
        System.out.println("====== INICIANDO CONSTRUCCIÓN DEL ÁRBOL (EJERCICIO 12) ======\n");

        // 1. Instanciamos nuestra base (o cualquiera de tus ProbX si quieres probar sus métodos)
        BSTree tree = new BSTree();

        // 2. Definimos la secuencia exacta pedida en el PDF
        // (70), (20), (15), (10), (2), (59), (29), (69), (98), (77), (75), (91), (78), (86)
        int[] secuencia = {70, 20, 15, 10, 2, 59, 29, 69, 98, 77, 75, 91, 78, 86};

        // 3. Insertamos los elementos iterando el arreglo
        System.out.println("Insertando elementos...");
        for (int valor : secuencia) {
            // El ejercicio dice elementos (k, e) donde llave y valor son iguales.
            // Pasamos String.valueOf(valor) porque tu BSTNode espera un String como 'elem'
            tree.insert(valor, String.valueOf(valor));
        }
        System.out.println("¡Árbol construido con éxito!\n");

        // 4. Comprobación rápida:
        // Si imprimimos In-Order, DEBEN salir ordenados de menor a mayor.
        System.out.println("Comprobación (Recorrido In-Order):");
        tree.showInOrder();

        // 5. Comprobación de métricas de tu árbol base
        System.out.println("\nTamaño total del árbol: " + tree.getSize());
        System.out.println("Altura total del árbol: " + tree.getHeight());
    }
}
