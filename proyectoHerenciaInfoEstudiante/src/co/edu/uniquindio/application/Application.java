package co.edu.uniquindio.application;

import co.edu.uniquindio.model.ProgramaIngesis;

public class Application {

	public static void main(String[] args) {
		//CREO EL PROGRAMA
		ProgramaIngesis progrm = new ProgramaIngesis();
		//AÑADO ESTUDIANTES AL PROGRAMA
		progrm.crearEstudiantePosgrado("Juan", "1297384", "22/10/71");
		progrm.crearEstudiantePregrado("Juan2", "0239", "370");
		//MUESTRO INFO POR PANTALLA
		System.out.println(progrm.leerEstudiantesPosgrado());
		System.out.println(progrm.leerEstudiantesPregrado());
	}
}
