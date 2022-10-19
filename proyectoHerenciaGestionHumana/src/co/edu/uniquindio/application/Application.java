package co.edu.uniquindio.application;

import co.edu.uniquindio.model.GestionHumana;

public class Application {

	public static void main(String[] args) {
		GestionHumana gestionHumana = new GestionHumana(); 
		gestionHumana.crearDocenteContrato("Alejandro", "Titular");
		gestionHumana.calcularSueldosDocentesContrato(); 
		System.out.println(gestionHumana.mostrarSueldoDocentesContrato());
	}
}
