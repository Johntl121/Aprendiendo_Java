package uni.edu.pe.Arreglos;

import java.util.Scanner;

public class For_each {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        String[] nombres = {"Juan","Melissa","Andres","John","Janeth","Jose","Daniel","Harold","David","Abi"};
        //nombre_arregloString.length
        for (int i = 0; i< nombres.length;i++){
            System.out.println(nombres[i]);
        }

        System.out.println();
        for (String i:nombres){ //For each
            System.out.println(i);
        }
    }
}
