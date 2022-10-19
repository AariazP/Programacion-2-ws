package asociacionClases;

import java.util.ArrayList;

public class Profesor {
	
	private String nombre;
	private ArrayList<Estudiante> estudiantes;
	
	public Profesor(String nombre) {
		estudiantes = new ArrayList<Estudiante>();
		this.nombre = nombre; 
	}
	
	
	public void setProfesor(String nomProfesor) {
		nombre = nomProfesor; 
	}
	
	public String getProfesor() {
		return nombre; 
	}
	
	public void addEstudiantes(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}
}
