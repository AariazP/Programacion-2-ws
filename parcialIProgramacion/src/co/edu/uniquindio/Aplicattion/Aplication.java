package co.edu.uniquindio.Aplicattion;

import javax.swing.JOptionPane;

import co.edu.uniquindio.model.Parqueadero;

public class Aplication {
	
	public static void main(String[] args) {
		
		Parqueadero parqueadero = new Parqueadero("Parqueader UQ");
		JOptionPane.showMessageDialog(null, "El parqueadero se ha creado");; 
		int filas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas del parqueadero: "));
		int columnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Columnas del parqueadero: "));  
		parqueadero.inicializarPuestos(filas, columnas);
		JOptionPane.showMessageDialog(null, "Los puestos se han creado");
				
	}
	
}
