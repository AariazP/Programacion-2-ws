package co.edu.uniquindio.model;

import java.util.Objects;

public class Producto {

	private static int id; 
	private String nombre, descripcion; 
	private double precio;
	private int cantDisponible; 
	private TipoProducto tipoProducto;
	
	//----------------CONSTRUCTORES--------------------------------
	public Producto(String nombre, String descripcion, double precio, int cantDisponible, TipoProducto tipoProducto) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantDisponible = cantDisponible;
		this.tipoProducto = tipoProducto;
	}
	
	//-------------MÉTODOS----------------------------
	public boolean compararTipoProducto(TipoProducto tipo) {
		if(tipo.getTipoProucto() == tipoProducto.getTipoProucto()) {
			return true; 
		}
			
		return false;
	} 
	
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", cantDisponible=" + cantDisponible + ", tipoProducto=" + tipoProducto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantDisponible, descripcion, nombre, precio, tipoProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Producto))
			return false;
		Producto other = (Producto) obj;
		return cantDisponible == other.cantDisponible && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& tipoProducto == other.tipoProducto;
	}
	public boolean precioMenorA(int precioAux) {
		if(precio<=precioAux) return true; 
		return false;
	}
	

	public void reducirCantidad(int cantidad) {
		this.cantDisponible -= cantidad;
	}

	public boolean compararNombre(String nomProd) {
		if(nombre.equals(nomProd)) return true; 
		return false;
	}
	
	public void sumarCantidad(int cantidad) {
		cantDisponible += cantidad; 
	}

	//-------------GETTERS AND SETTERS----------------------------
	public static int getId() {
		return id;
	}
	
	public static void setId(int id) {
		Producto.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantDisponible() {
		return cantDisponible;
	}
	public void setCantDisponible(int cantDisponible) {
		this.cantDisponible = cantDisponible;
	}
	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
