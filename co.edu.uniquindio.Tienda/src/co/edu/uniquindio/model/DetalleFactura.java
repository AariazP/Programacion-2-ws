package co.edu.uniquindio.model;

public class DetalleFactura {
	private int cantidad; 
	private double subtotal;
	
	public DetalleFactura(int cantidad, double subtotal) {
		this.cantidad=cantidad;
		this.subtotal=subtotal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
