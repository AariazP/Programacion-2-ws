package co.edu.uniquindio.model;

public class DocentePlanta extends Docente{
	
	private double sueldo;
	private String nombre; 
	private int cantPuntos; 
	
	public DocentePlanta(String nombre, int cantidadPuntos) {
		this.nombre = nombre;  
		this.sueldo = 0; 
		this.cantPuntos = cantidadPuntos; 
	}
	//---------------------MÉTODOS-----------------
	@Override
	public void calcularSueldo() {
		
		sueldo = cantPuntos*12120;
	}
	
	@Override
	public String toString() {
		return "DocentePlanta [sueldo = " + sueldo + ", nombre = " + nombre + ", cantPuntos = " + cantPuntos + "]";
	}
	
	//---------------GETTERS AND SETTERS-----------
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
	 * @return the cantPuntos
	 */
	public int getCantPuntos() {
		return cantPuntos;
	}
	/**
	 * @param cantPuntos the cantPuntos to set
	 */
	public void setCantPuntos(int cantPuntos) {
		this.cantPuntos = cantPuntos;
	}
	
	
}
