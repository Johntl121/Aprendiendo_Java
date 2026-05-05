package uni.edu.pe.ArabolesBinarios.ProblemasABB.Dirigida;

public class BSTest {
    public static void main(String[] args) {
        System.out.println("====== INICIANDO PRUEBAS ======\n");
        testProblema1();
        System.out.println("\n-------------------------------\n");
        testProblema2();
    }

    private static void testProblema1() {
        System.out.println("--- Test Problema 1: Nodos Primos ---");

        // Instanciamos nuestra nueva clase MyBST
        MyBST tree = new MyBST();

        // Insertamos los valores manteniendo la topología de la imagen del PDF
        int[] valores = {25, 20, 36, 10, 22, 30, 40, 5, 12, 28, 38, 48};
        for (int v : valores) {
            tree.insert(v, "Dato" + v); // El string es de relleno, lo que importa es la llave (key)
        }

        System.out.println("Verificando primos esperados:");
        System.out.println("¿10 y 30 son primos? (Debería ser true): " + tree.check_cousins(10, 30));
        System.out.println("¿28 y 48 son primos? (Debería ser true): " + tree.check_cousins(28, 48));

        System.out.println("\nVerificando casos trampa:");
        System.out.println("¿10 y 22 son primos? (Falso, son hermanos): " + tree.check_cousins(10, 22));
        System.out.println("¿5 y 48 son primos? (Falso, distinto abuelo): " + tree.check_cousins(5, 48));
    }

    private static void testProblema2() {
        System.out.println("--- Test Problema 2: Misma Forma ---");

        // Construimos el "invoking tree"
        MyBST invokingTree = new MyBST();
        int[] valsInvoking = {10, 7, 15, 4, 9, 20};
        for (int v : valsInvoking) {
            invokingTree.insert(v, "A");
        }

        // Construimos el "invoked tree"
        MyBST invokedTree = new MyBST();
        int[] valsInvoked = {80, 70, 85, 40, 75, 90};
        for (int v : valsInvoked) {
            invokedTree.insert(v, "B");
        }

        // Comprobamos la estructura
        boolean resultado = invokingTree.is_same_shape(invokedTree);
        System.out.println("¿Tienen la misma forma? (Debería ser true): " + resultado);
    }
}
