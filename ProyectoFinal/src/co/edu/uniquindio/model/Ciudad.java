package co.edu.uniquindio.model;

public class Ciudad {
	//----------- ATRIVUTOS -------------
	private Empresa empresa; 
	private String nombre;
	
	//----------- CONSTRUCTOR VACIO -----------
	public Ciudad() {
		
	}
	
	//-----------CONSTRUCTOR --------------
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
	
	/**
	 * COMPARAMOS SI EL NOMBRE DE LA SEDE DE LA CIUDAD QUE ELEGUIO 
	 * ESTA EN LA MISA CIUDAD CON EL MISMO NOMBRE
	 * @param ciudadSede
	 * @return
	 */
	public boolean compararCiudad(String ciudadSede) {
		if(nombre.equals(ciudadSede)) return true;//SI CUMPLE CONLA CONDICION RETORNA UN TRUE 
		return false;//SI NO, RETORNA UN FALSE
	}
	
}
