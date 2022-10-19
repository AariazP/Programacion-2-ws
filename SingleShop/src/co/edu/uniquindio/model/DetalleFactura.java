package co.edu.uniquindio.model;

import java.util.Objects;

public class DetalleFactura {

	//-----------ATRIBUTOS
	private int cantidad;
	private double precio;
	private String nombre; 
	private Double subTotal; 
	
	//-------CONSTRUCTORES---------------
	
	public DetalleFactura() {
		this.cantidad = 0; 
		this.precio = 0; 
	}
	
	public DetalleFactura( String nombre, int cantidad, double precio) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.nombre = nombre;
		this.subTotal= cantidad*precio;  
	}
	
	//--------GETTERS AND SETTERS------------
	
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, nombre, precio, subTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DetalleFactura))
			return false;
		DetalleFactura other = (DetalleFactura) obj;
		return cantidad == other.cantidad && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(subTotal, other.subTotal);
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setSubTotal(double subTotal) {
		this.precio = subTotal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	} 
	
	public Double getSubTotal() {
		return this.subTotal; 
	}
}
