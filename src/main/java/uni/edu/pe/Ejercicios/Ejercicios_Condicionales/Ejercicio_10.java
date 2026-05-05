package uni.edu.pe.Ejercicios.Ejercicios_Condicionales;

import java.util.Scanner;

public class Ejercicio_10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // 1. Pedir los datos
        System.out.print("Digite el día: ");
        int dia = entrada.nextInt();

        System.out.print("Digite el mes: ");
        int mes = entrada.nextInt();

        System.out.print("Digite el año: ");
        int anio = entrada.nextInt();

        // Variable bandera (flag) para guardar si la fecha es correcta
        boolean fechaValida = false;

        // 2. Lógica de validación
        // Primero verificamos que el año sea válido y el mes esté entre 1 y 12
        if (anio > 0 && mes >= 1 && mes <= 12) {

            // Si el mes es Febrero (Mes 2) - Sin años bisiestos
            if (mes == 2) {
                if (dia >= 1 && dia <= 28) {
                    fechaValida = true;
                }
            }
            // Si es un mes de 30 días (Abril, Junio, Septiembre, Noviembre)
            else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                if (dia >= 1 && dia <= 30) {
                    fechaValida = true;
                }
            }
            // El resto de los meses tienen 31 días (Enero, Marzo, Mayo, Julio, Agosto, Octubre, Diciembre)
            else {
                if (dia >= 1 && dia <= 31) {
                    fechaValida = true;
                }
            }
        }

        // 3. Mostrar el resultado final
        if (fechaValida) {
            // Imprimimos la fecha con formato dd/mm/yyyy
            System.out.println("\n✅ La fecha ingresada (" + dia + "/" + mes + "/" + anio + ") es CORRECTA.");
        } else {
            System.out.println("\n❌ La fecha ingresada es INCORRECTA.");
        }
    }
}