package uni.edu.pe.Ejercicios.Ejercicios_Bucles;

import java.util.Scanner;

public class Ejercicio_18 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int codigo, litros,facturasmasDe600=0;
        float importeFactura, facturacionTotal = 0, precioLitro=0, litrosArticulo1=0;
        for(int i=1; i<=5; i++){
            System.out.print("Factura nro "+ i +": "
                    +"\nDigite el codigo del producto: ");
            codigo =entrada.nextInt();
            System.out.print("Digite la cantidad de litros vendidos: ");
            litros =entrada.nextInt();
            switch (codigo){
                case 1: precioLitro = 0.6f;
                break;
                case 2: precioLitro = 3.0f;
                break;
                case 3: precioLitro = 1.25f;
                break;
                default: System.out.print("Ingreso un codigo no valido...");
            }
            importeFactura = litros*precioLitro;
            facturacionTotal = facturacionTotal + importeFactura;
            if (codigo == 1) {
                litrosArticulo1 += litros;
            }

            if (importeFactura > 600) {
                facturasmasDe600++;
            }
        }
        System.out.println("Facturación total: $" + facturacionTotal);
        System.out.println("Litros vendidos del artículo 1: " + litrosArticulo1);
        System.out.println("Facturas emitidas de más de $600: " + facturasmasDe600);
    }
}
