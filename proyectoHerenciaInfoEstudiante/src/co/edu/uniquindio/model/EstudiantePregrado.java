package co.edu.uniquindio.model;

public class EstudiantePregrado extends Estudiante{

	//--------------------ATRIBUTOS------------------------
	private String puntajeIngreso; 



	//----------------------CONTRUCTORES-----------------------------------
	public EstudiantePregrado() {

	}
	public EstudiantePregrado(String nombre, String cedula, String puntajeIngreso) {
		super(nombre, cedula); 
		this.puntajeIngreso = puntajeIngreso; 
	}

	//-------------------MÉTODOS--------------------------------

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "[Puntaje ingreso] "+puntajeIngreso;
	}

	//-------------------GETTERS AND SETTERS------------------
	public String getPuntajeIngreso() {
		return puntajeIngreso;
	}
	public void setPuntajeIngreso(String puntajeIngreso) {
		this.puntajeIngreso = puntajeIngreso;
	}
}

