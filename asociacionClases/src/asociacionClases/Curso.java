package asociacionClases;

import java.util.ArrayList;
public class Curso {
	
	private int duracion, numCreditos;
	private String nombre, codigo, jornada;
	private Profesor profesor;
	private static int contador; 
	private ArrayList<Estudiante> estudiantes;

	public Curso(int duracion, int numCreditos, String nombre, String codigo, String jornada) {
		profesor = new Profesor("Aún no hay profesor");
		estudiantes = new ArrayList<Estudiante>();
		contador = 0; 
		this.duracion = duracion; 
		this.numCreditos = numCreditos;
		this.nombre = nombre; 
		this.codigo = codigo;
		this.jornada = jornada; 
	}
	
	
	public String retornarInformacionCurso() {
		String info=""; 
		for (int i = 0; i < estudiantes.size(); i++) {
			info +=estudiantes.get(i).retornarInfoEstudiante();
		}
		
		
		return "La duración del curso es: "+duracion+" semestre\n"+"El curso tiene "+numCreditos+" créditos\n"+"El nombre del curso es: "+nombre+"\n"
				+"El codigo del curso es: "+codigo+"\n"+"La jornada del curso es: "+jornada+"\n" +"El nombre del profesor es:"+profesor.getProfesor()+"\n"+"\n "+info;
	}
	
	public void setProfesor(String nombrePrf) {
		profesor.setProfesor(nombrePrf);
	}
	
	public void aniadirEstudiante(String nombre, String id, String grupo, String facultad) {
		Estudiante estudiante = new Estudiante( nombre,  id,  grupo,  facultad, contador);
		estudiante.setProfesor(profesor);
		profesor.addEstudiantes(estudiante);
		estudiantes.add(estudiante);
		
		contador ++; 
	}
}
