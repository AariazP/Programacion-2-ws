package clases;

public class Empleado {
	// se declaran las variables de la clase Empleado
	private String nombre, id, codigo = "EEE", anios;
	private int cantFacturas;
	private static int contador  = 1; 
	private double pago=0; 
	

	/**
	 * este metodo constructor se llama automaticamente cada vez que se crea un objeto en esa clase,
	 * tambien se le debe pasar los atributos que estan en esta clase y son de tipo privado
	 * 
	 * tambien se debe inicializar los atributos de la clase, los cuales son:
	 * @param nombre
	 * @param id 
	 * @param anios 
	 */

	public Empleado(String nombre, String id, String anios) {

		//El this sirve para utilizar el nombre de un atributo con el mismo nombre, 
		//sin necesidad de cambiar el nombre
		this.nombre = nombre;
		this.id = id;
		this.codigo += contador;//el contador sirve para aumente 1 el codigo que se genere EJ: zz1,zz2
		this.anios = anios;
		contador ++;
	}

	/**
	 * el getNombre nos retorna u obtiene el nombre del empleado para luego mostrarlo por pantalla
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * con el setNombre se establese el nombre que tiene el empleado 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * el getId nos retorna u obtiene la identifiacion del empleado para luego mostrarlo por pantalla
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * con el setNombre el empleado puede modificar o poner su identificacion 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAnios() {
		return anios;
	}

	public void setAnios(String anios) {
		this.anios = anios;
	}

	public int getCantFacturas() {
		return cantFacturas;
	}

	public void setCantFacturas() {
		this.cantFacturas ++;
	}

	public double getPago() {
		return pago;
	}

	public void setPago(double pago) {
		this.pago += pago;
	}
	
	
	
}
