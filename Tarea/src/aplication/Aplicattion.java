package aplication;

import javax.swing.JOptionPane;

public class Aplicattion {
	
	
	public static void main(String[] arg) {
		String nombre = leerNumero(); 
		System.out.println("Tu nombre es: "+nombre);
	}
	
	
	public static String leerNumero() throws Error{
		String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
		if(nombre.length()<3) {
			throw new Error("Nombre no valido. Nombre demasiado corto");
		}
		return nombre; 
	}
}
