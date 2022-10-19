package co.edu.uniquindio.Model;

import java.util.Objects;

public class Ciudad {

	@Override 
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		Ciudad ciudad = (Ciudad) obj; 
		if(ciudad.getNombre().equals(this.nombre)) {
			return true; 
		}else {
			return false; 
		}
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + "]";
	}
	private String nombre; 
	
	//Constructors
	public Ciudad() {
	}
	
	public Ciudad(String nombre) {
		this.setNombre(nombre); 
	}
	
	//Getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
