package co.edu.uniquindio.model;

import java.util.ArrayList;

public class ProgramaIngesis {
	//---------ATRIBUTOS------------

	private ArrayList<Estudiante> listaEstudiantesIngesis;
	
	//------------------CONSTRUCTOR
	public ProgramaIngesis() {
		listaEstudiantesIngesis = new ArrayList<Estudiante>(); 
	}
	
	//---------MÉTODOS--------------
	/**
	 * MÉTODO QUE PERMITE CREAR UN ESTUDIANTE DE POSGRADO
	 * @param nombre
	 * @param cedula
	 * @param fechaGraduación
	 * @return
	 */
	public String crearEstudiantePosgrado( String nombre, String cedula, String fechaGraduación) {
		//INSTANCIO EL NUEVO ESTUDIANTE
		EstudiantePosgrado estudiante = new EstudiantePosgrado( nombre, cedula,fechaGraduación); 
		listaEstudiantesIngesis.add(estudiante); 
		return "Estudiante de posgrado creado"; 
	}
	
	/**
	 * MÉTODO QUE PERMITE CREAR UN ESTUDIANTE DE PREGRADO
	 * @param nombre
	 * @param cedula
	 * @param fechaGraduación
	 * @return
	 */
	public String crearEstudiantePregrado( String nombre, String cedula, String puntajeIngreso) {
		//INSTANCIO EL NUEVO ESTUDIANTE
		EstudiantePregrado estudiante = new EstudiantePregrado( nombre,  cedula, puntajeIngreso); 
		listaEstudiantesIngesis.add(estudiante); 
		return "Estudiante pregrado creado"; 
	}
	
	/**
	 * MÉTODO QUE DEVUELVE EL TO STRING DE TODOS LOS ESTUDIANTES DE POSGRADO
	 * @return
	 */
	public String leerEstudiantesPosgrado() {
		String mensaje = ""; 
		//RECORRO LA LISTA ESTUDIANTES
		for (int i = 0; i < listaEstudiantesIngesis.size(); i++) {
			//VERIFICO SI ES UNA INSTANCIA DE ESTUDIANTE POSGRADO
			if(listaEstudiantesIngesis.get(i) instanceof EstudiantePosgrado) {
				mensaje += listaEstudiantesIngesis.get(i).toString(); 
			}
		}
		return mensaje; 
	}
	/**
	 * MÉTODO QUE DEVUELVE EL TO STRING DE TODOS LOS ESTUDIANTES DE PREGRADO
	 * @return
	 */
	public String leerEstudiantesPregrado() {
		String mensaje = ""; 
		//RECORRO LA LISTA ESTUDIANTES
		for (int i = 0; i < listaEstudiantesIngesis.size(); i++) {
			//VERIFICO QUE SEA ESTUDIANTE DE PREGRADO
			if(listaEstudiantesIngesis.get(i) instanceof EstudiantePregrado) {
				mensaje += listaEstudiantesIngesis.get(i).toString(); 
			}
		}
		return mensaje; 
	}
}
