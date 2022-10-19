package programacion2.parcial3.model;

public abstract class Cliente {
	
	//Atributos
	private String nombre;
	
	//---------------------CONSTRUCTOR----------------
	
	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}
	//------------------GETTERS AND SETTERS--------------
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
