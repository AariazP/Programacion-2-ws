package poo.Arias.repositorio.modelo;

public class Producto {
	
	private String nombre; 
	private Double precio; 
	private Integer id;
	private static int idAux;
	
	
	//------------CONSTRUCTORES---------
	public Producto() {
		id = ++idAux; 
	}
	
	public Producto(String nombre, Double precio) {
		this(); 
		this.nombre = nombre;
		this.precio = precio;
	}
	
	//-------GETTER AND SETTERS---------
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
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
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
	 * @return the idAux
	 */
	public static int getIdAux() {
		return idAux;
	}
	/**
	 * @param idAux the idAux to set
	 */
	public static void setIdAux(int idAux) {
		Producto.idAux = idAux;
	} 
	
	
}
