package co.edu.uniquindio.model;

public class DocenteContrato extends Docente{
	
	private double sueldo;
	private String nombre; 
	private String rol;
	
	//----------------CONSTRUCTOR--------------
	public DocenteContrato(String nombre, String rol) {
		this.nombre = nombre; 
		this.rol = rol; 
		this.sueldo = 0; 
	}
	
	//-------------MÉTODOS----------------------
	
	@Override
	public void calcularSueldo() {
		if(rol.equals("Auxiliar")) {
			sueldo = 2418460; 
		}else if(rol.equals("Asistente")) {
			sueldo = 2671350; 
		}else if(rol.equals("Asociado")) {
			sueldo = 2989580; 
		}else if(rol.equals("Titular")) {
			sueldo = 3434420; 
		}
	}

	@Override
	public String toString() {
		return "DocenteContrato [sueldo=" + sueldo + ", nombre=" + nombre + ", rol=" + rol + "]";
	}

	//-------------------GETTERS AND SETTERS---------------------
	/**
	 * @return the sueldo
	 */
	public double getSueldo() {
		return sueldo;
	}

	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

}
