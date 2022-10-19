package co.edu.uniquindio.model;

public abstract class Docente {
	
	//------------------------ATRIBUTOS-----------------------
	private double sueldo;
	private String nombre; 
	


	//M�TODO CALCULAR SUELDO
	public abstract void calcularSueldo(); 
	
	//------------------------M�TODOS---------------------
	
	@Override
	public String toString() {
		return "Docente [sueldo=" + sueldo + ", nombre=" + nombre + "]";
	}

	
	//-------------GETTERS AND SETTERS-----------------
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
