package uni.edu.pe.Entrada_de_Datos;

import javax.swing.JOptionPane;

public class JOptionPane_0 {
    public static void main(String[] arg){
        String cadena;
        int numero;
        char letra;
        double decimal;

        cadena = JOptionPane.showInputDialog("Digite una cadena: ");
        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
        letra = JOptionPane.showInputDialog("Digite un numero: ").charAt(0);
        decimal = Double.parseDouble(JOptionPane.showInputDialog("Digite un numero decimal: "));

        JOptionPane.showMessageDialog(null,"La cadena es: "+cadena);
        JOptionPane.showMessageDialog(null,"El numero es: " + numero);
        JOptionPane.showMessageDialog(null,"La letra es: "+letra);
        JOptionPane.showMessageDialog(null,"El decimal es: "+decimal);
    }
}
