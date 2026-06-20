package uni.edu.pe.Backtracking.PropuestosAvanzada.Passwords;

import java.util.Scanner;

public class PasswordsV1 {
    // Máximo 100 palabras en el diccionario según el problema
    static String[] diccionario = new String[100];

    // Arreglo para guardar los pedazos de la contraseña generada (máximo 256 caracteres en la regla)
    static String[] ans = new String[256];

    static String reglaActual;
    static int numPalabras;

    /**
     * @param indice -> La posición del carácter de la regla que estamos leyendo
     */
    static void solve(int indice) {
        // 1. CASO BASE: Si ya procesamos todos los caracteres de la regla
        if (indice == reglaActual.length()) {
            // Imprimimos los pedazos que juntamos en nuestra "mochila"
            for (int i = 0; i < indice; i++) {
                System.out.print(ans[i]);
            }
            System.out.println();
            return;
        }

        char caracter = reglaActual.charAt(indice);

        // 2. EXPLORAR OPCIONES SEGÚN EL CARÁCTER

        if (caracter == '#') {
            // RAMA A: Es una palabra. Iteramos sobre todas las palabras del diccionario.
            for (int i = 0; i < numPalabras; i++) {
                ans[indice] = diccionario[i]; // -> ELEGIR
                solve(indice + 1);            // -> EXPLORAR
                // No necesitamos "deshacer" limpiando el arreglo porque el bucle
                // sobrescribirá esta posición en la siguiente iteración.
            }
        } else if (caracter == '0') {
            // RAMA B: Es un dígito. Iteramos del 0 al 9.
            for (int i = 0; i <= 9; i++) {
                ans[indice] = String.valueOf(i); // -> ELEGIR
                solve(indice + 1);               // -> EXPLORAR
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leemos hasta que no haya más datos
        while (sc.hasNextInt()) {
            numPalabras = sc.nextInt();

            // Leemos el diccionario
            for (int i = 0; i < numPalabras; i++) {
                diccionario[i] = sc.next();
            }

            int numReglas = sc.nextInt();

            // Imprimimos el formato exacto que pide el juez para cada set
            System.out.println("--");

            // Procesamos cada regla
            for (int i = 0; i < numReglas; i++) {
                reglaActual = sc.next();
                solve(0);
            }
        }
        sc.close();
    }
}