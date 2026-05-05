package uni.edu.pe.Arreglos;

public class Crear_Mostrar_Arreglo {
    public static void main (String[] args){
        int[] arreglo1 = new int[4];
        arreglo1[0]=5;
        arreglo1[1]=12;
        arreglo1[2]=8;
        arreglo1[3]=25;
        for(int i=0; i<4; i++){
            System.out.print(arreglo1[i]+" ");
        }
        System.out.println();
        int[] arreglo2 = {5,6,8,9,2};
        for(int i=0; i<5; i++){
            System.out.print(arreglo2[i]+" ");
        }
    }
}
