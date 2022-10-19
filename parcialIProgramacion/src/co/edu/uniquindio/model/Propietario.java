package co.edu.uniquindio.model;

public class Propietario {
	
	private String nombre, identificacion, telefono;
	private Parqueadero parqueadero; 
	
	//Constructor
	public Propietario(String nombre, String identificacion, String telefono) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.telefono = telefono;
	}

	//Getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}
}
