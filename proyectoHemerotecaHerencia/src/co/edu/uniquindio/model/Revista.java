package co.edu.uniquindio.model;

public abstract class Revista {
	
	private String nombre, fechaPublicacion, ISSN;


	public Revista(String nombre, String fechaPublicacion, String iSSN) {
		super();
		this.nombre = nombre;
		this.fechaPublicacion = fechaPublicacion;
		ISSN = iSSN;
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
	 * @return the fechaPublicacion
	 */
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * @param fechaPublicacion the fechaPublicacion to set
	 */
	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * @return the iSSN
	 */
	public String getISSN() {
		return ISSN;
	}

	/**
	 * @param iSSN the iSSN to set
	 */
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}
	
}
