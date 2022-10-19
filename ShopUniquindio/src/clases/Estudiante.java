package clases;

public class Estudiante {
	 private String id, nombre;
	 private int cantFact; 

	/**
	 * @param id
	 * @param nombre
	 */
	public Estudiante(String nombre, String id) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantFact() {
		return cantFact;
	}

	public void setCantFact() {
		this.cantFact ++;
	}
	 
}
