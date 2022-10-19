package co.edu.uniquindio.model;

import java.util.Objects;

public class Empleado {

	private static int id;
	private int idEmpleado; 
	private String nombre;
	private double sueldo;
	private Sede sede; 

	//----------CONSTRUCTORES-----------------------------
	public Empleado(String nombre, double sueldo) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
		setIdEmpleado(id); 
		id++; 
	}

	public Empleado() {
	}

	//---------------------------MÉTODOS-----------------------------
	@Override
	public int hashCode() {
		return Objects.hash(idEmpleado, nombre, sede, sueldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		return idEmpleado == other.idEmpleado && Objects.equals(nombre, other.nombre)
				&& Objects.equals(sede, other.sede)
				&& Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo);
	}

	//---------------GETTERS AND SETTERS---------------

	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Empleado.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	} 
}
