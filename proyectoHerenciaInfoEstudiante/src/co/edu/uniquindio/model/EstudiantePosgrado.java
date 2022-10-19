package co.edu.uniquindio.model;

public class EstudiantePosgrado extends Estudiante{

	//---------------------------------ATRIBUTOS-------------------------
	private String fechaGraduacion; 

	//-------------------------------Constructor------------------------
	public EstudiantePosgrado() {

	}
	public EstudiantePosgrado(String nombre, String cedula, String fechaGraduacion) {
		super(nombre, cedula); 
		this.fechaGraduacion = fechaGraduacion; 
	}


	//-------------------------GETTERS AND SETTERS------------------------
	public String getFechaGraduacion() {
		return fechaGraduacion;
	}

	public void setFechaGraduacion(String fechaGraduacion) {
		this.fechaGraduacion = fechaGraduacion;
	}

	//-------------------------- MÉTODOS-------------------------------------

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		return super.toString()+"EstudiantePosgrado [fechaGraduacion=" + fechaGraduacion + "]";
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
