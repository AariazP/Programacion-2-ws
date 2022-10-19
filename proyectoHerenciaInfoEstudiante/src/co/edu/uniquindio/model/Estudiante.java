package co.edu.uniquindio.model;

public abstract class Estudiante {
	private ProgramaIngesis programa; 
	//-----------ATRIBUTOS--------------------
	private String nombre, cedula;
	//------------------CONSTRUCTORES------
	public Estudiante() {
		// TODO Auto-generated constructor stub
	}
	
	public Estudiante(String nombre, String cedula) {
		this.nombre = nombre; 
		this.cedula = cedula; 
	}

	//----------GETTERS AND SETTERS-------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	//-------MÉTODOS---------
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", cedula=" + cedula + "]";
	}

	public ProgramaIngesis getPrograma() {
		return programa;
	}

	public void setPrograma(ProgramaIngesis programa) {
		this.programa = programa;
	} 
}
