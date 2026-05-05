package uni.edu.pe.POO.ClasesObjetos.Creacion_Metodos;

public class Main {
    public static void main(String[] args){
        Operacion op = new Operacion();
        //Llamar a los metodos
        op.LeerNumeros();
        op.sumar();
        op.restar();
        op.multiplicar();
        op.dividir();
        op.mostrarResultado();

    }
}
