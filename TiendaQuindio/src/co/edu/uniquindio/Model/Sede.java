package co.edu.uniquindio.Model;

import java.util.ArrayList;

public class Sede {
	
	private Empresa empresa;
	private Ciudad ciudad;
	private Administrador administrador;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Producto> listaProductos;
	
	
	//Constructor
	public Sede() {
		
	}
	
	public Sede(Ciudad ciudad) {
		this.ciudad = ciudad; 
	}
	
	
	/**
	 * @return the ciudad
	 */
	public Ciudad getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the administrador
	 */
	public Administrador getAdministrador() {
		return administrador;
	}
	/**
	 * @param administrador the administrador to set
	 */
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	/**
	 * @return the listaClientes
	 */
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}
	/**
	 * @param listaClientes the listaClientes to set
	 */
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	} 
	
}
