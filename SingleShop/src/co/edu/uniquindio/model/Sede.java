package co.edu.uniquindio.model;

import java.util.ArrayList;

public class Sede {
	
	private static int id = 0; 
	private String idSede; 
	private Administrador administrador;
	private String strCiudad; 
	private Ciudad ciudad;
	private ArrayList<Empleado> listaEmpleados; 
	private ArrayList<Cliente> listaClientes; 
	private ArrayList<Factura> listaFacturas; 
	
	//--------------------------CONSTRUCTORES----------------------------------------
	public Sede(Ciudad ciudad) {
		this.setCiudad(ciudad);
		setListaEmpleados(new ArrayList<>(0));
		listaClientes = new ArrayList<>(0);
		listaFacturas = new ArrayList<>(0);
		setStrCiudad(ciudad.getNombre());
		setIdSede(id+""); 
		id++; 
	}
	
	public Sede() {
		setListaEmpleados(new ArrayList<>(0)); 
		listaClientes = new ArrayList<>(0);
		listaFacturas = new ArrayList<>(0);
		setIdSede(id+""); 
		id++; 
	}

	//-------------------------GETTERS AND SETTERS-------------------------
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Sede.id = id;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
		setStrCiudad(ciudad.getNombre()); 
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public boolean compararCiudad(String ciudadSede) {
		
		if(ciudad.compararCiudad(ciudadSede)) return true; 
		return false;
	}

	public String getStrCiudad() {
		return strCiudad;
	}

	public void setStrCiudad(String strCiudad) {
		this.strCiudad = strCiudad;
	}

	public String getIdSede() {
		return idSede;
	}

	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}

	public void setNombreCiudad(String ciudad) {
		this.ciudad.setNombre(ciudad);
	}
	

}
