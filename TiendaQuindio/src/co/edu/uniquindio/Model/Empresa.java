package co.edu.uniquindio.Model;

import java.util.ArrayList;
import java.util.Objects;

public class Empresa {
	
	private String nombre;
	private ArrayList<Administrador> listaAdministradores;
	private ArrayList<Ciudad> listaCiudades;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Factura> listafacturas;
	private ArrayList<Sede> listaSedes;
	private ArrayList<Producto> listaProductos; 
	
	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
		listaAdministradores = new ArrayList<>();
		listaCiudades = new ArrayList<>();
		listaClientes = new ArrayList<>();
		listafacturas = new ArrayList<>();
		listaSedes = new ArrayList<>();
		listaProductos = new ArrayList<>();
	}
	
	public Empresa() {
		
	}
	
	//-------------------------CRUD SEDE-----------------------------------------------------------------------------------------------
	
	/**
	 * Método que permite crear una sede
	 * @param nomCiudad
	 * @return
	 */
	public String crearSede(String nomCiudad) {
		//Contador de cuantas sedes hay en la ciudad
		int numSedes = 0; 
		//Creo una ciudad con ese nombre
		Ciudad ciudad = new Ciudad(nomCiudad); 
		//busco en el arraylist si existe una sede en esa ciudad y cuento cuantas hay
		for (Ciudad i : listaCiudades) {
			if(i.equals(ciudad)) {
				numSedes ++; 
			}
		}
		//verifico que la sede se pueda crear
		if(numSedes<3){
			//añado la sede 
			Sede sede = new Sede(ciudad);
			listaSedes.add(sede);
			listaCiudades.add(sede.getCiudad());
			return "Sede creada con éxito"; 
		}else {
			return "Ya existen las sedes necesarias en esa ciudad"; 
		}
	}
	
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", listaAdministradores=" + listaAdministradores + ", listaCiudades="
				+ listaCiudades + ", listaClientes=" + listaClientes + ", listafacturas=" + listafacturas
				+ ", listaSedes=" + listaSedes + ", listaProductos=" + listaProductos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaAdministradores, listaCiudades, listaClientes, listaProductos, listaSedes,
				listafacturas, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empresa))
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(listaAdministradores, other.listaAdministradores)
				&& Objects.equals(listaCiudades, other.listaCiudades)
				&& Objects.equals(listaClientes, other.listaClientes)
				&& Objects.equals(listaProductos, other.listaProductos) && Objects.equals(listaSedes, other.listaSedes)
				&& Objects.equals(listafacturas, other.listafacturas) && Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Factura> getListafacturas() {
		return listafacturas;
	}

	public void setListafacturas(ArrayList<Factura> listafacturas) {
		this.listafacturas = listafacturas;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<Sede> getListaSedes() {
		return listaSedes;
	}

	public void setListaSedes(ArrayList<Sede> listaSedes) {
		this.listaSedes = listaSedes;
	}

	public ArrayList<Ciudad> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(ArrayList<Ciudad> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}
	
	
	
	
}