package asociacionClases;

public class Estudiante {
	private String nombre, id, grupo, facultad; 
	private int numero; 
	private Profesor profesor; 


	public Estudiante(String nombre, String id, String grupo, String facultad, int numero) {
		this.nombre = nombre; 
		this.id = id;
		this.grupo = grupo; 
		this.facultad = facultad;
		this.numero = numero; 
	}
	
	
	public String retornarInfoEstudiante() {
		
		return "El nombre del estudiante es: "+nombre+"\n"
				+"El id del estudiante es: "+id+"\n"
				+"El grupo del estudiante es: "+grupo+"\n"
				+"La facultada del estudiante es: "+facultad+"\n"
				+"El numero del estudiante es: "+numero+"\n"
				+"El nombre del profesor es: "+ profesor.getProfesor();
	}
	
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
}
