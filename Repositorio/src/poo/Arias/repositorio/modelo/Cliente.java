package poo.Arias.repositorio.modelo;

public class Cliente{
	
	
	private Integer id; 
	private String nombre, apellido;
	private static int idAux; 
	
	
	
	
	public Cliente(String nombre, String apellido) {
		this(); 
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public Cliente() {
		id = ++idAux; 
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean compararId(Integer id2) {
		return id == id2 ? true:false; 
	}

	public void setAtributos(Cliente cliente) {
		setNombre(cliente.getNombre());
		setApellido(cliente.getApellido()); 
	}


}
