package co.edu.uniquindio.model;

public class Ciudad {
	
	private Empresa empresa; 
	private String nombre;
	
	//-----------CONSTRUCTORES---------
	
	public Ciudad() {
		
	}
	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	}
	//----------GETTERS AND SETTERS
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean compararCiudad(String ciudadSede) {
		if(nombre.equals(ciudadSede)) return true; 
		return false;
	}
	
}
