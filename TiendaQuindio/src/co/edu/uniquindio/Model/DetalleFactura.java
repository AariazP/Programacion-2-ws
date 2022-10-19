package co.edu.uniquindio.Model;

public class DetalleFactura {
	double subtotal;
	int cantidad;
	
	
	public DetalleFactura(double subtotal, int cantidad) {
		super();
		this.subtotal = subtotal;
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
