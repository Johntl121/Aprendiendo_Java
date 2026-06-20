package uni.edu.pe.Backtracking.PropuestosAvanzada.Passwords;

import java.util.*;

public class PasswordsV2 {
    // Límite máximo de palabras (aunque en este código no se usa directamente)
    static final int MX = 105;

    // Nuestra "pizarra" global donde construiremos las contraseñas
    static StringBuilder s = new StringBuilder();

    // Lista para guardar las palabras del diccionario
    static List<String> words = new ArrayList<>();

    /**
     * @param i    -> Índice del carácter de la regla que estamos leyendo
     * @param rule -> El string con la regla completa (ej. "#0#")
     */
    static void solve(int i, String rule) {

        // 1. CASO BASE: Si ya recorrimos toda la regla
        if (i == rule.length()) {
            // Imprimimos el contenido actual de la pizarra
            System.out.println(s.toString());
            return;
        }

        // 2. EXPLORAR OPCIONES

        // Si el carácter actual de la regla es un '0' (Pide un número)
        if (rule.charAt(i) == '0') {
            for (char c = '0'; c <= '9'; c++) {
                // -> ELEGIR: Escribimos el dígito en la pizarra
                s.append(c);

                // -> EXPLORAR: Avanzamos al siguiente carácter de la regla
                solve(i + 1, rule);

                // -> DESHACER (Backtrack): Borramos el dígito que acabamos de poner
                s.deleteCharAt(s.length() - 1);
            }
        }
        // Si el carácter actual de la regla no es '0' (asumimos que es '#' y pide palabra)
        else {
            for (String t : words) {
                // -> ELEGIR: Escribimos la palabra completa en la pizarra
                s.append(t);

                // -> EXPLORAR: Avanzamos al siguiente carácter de la regla
                solve(i + 1, rule);

                // -> DESHACER (Backtrack):
                // Recortamos la longitud de la pizarra restándole el tamaño de la palabra 't'.
                // Esto elimina exactamente la palabra que acabamos de agregar.
                s.setLength(s.length() - t.length());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leemos mientras haya casos de prueba
        while (sc.hasNext()) {
            int N = sc.nextInt();

            // Limpiamos el diccionario para el nuevo caso de prueba
            words.clear();

            // Condición de parada de seguridad
            if (N == 0) break;

            // Leemos el diccionario
            for (int i = 0; i < N; i++) {
                String t = sc.next();
                words.add(t);
            }

            int m = sc.nextInt(); // Número de reglas

            // Procesamos cada regla
            for (int i = 0; i < m; i++) {
                String rule = sc.next();
                System.out.println("--");

                // Iniciamos la recursión desde el índice 0
                solve(0, rule);
            }
        }
        sc.close();
    }
}