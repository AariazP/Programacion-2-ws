package co.edu.uniquindio.Model;

public class Factura {
	String codigo;
	String fecha;
	double total;
	double subtotal;
	double iva;
	DetalleFactura detalle;
	Cliente listaclientes;
	public Factura(String codigo, String fecha, double total, double subtotal, double iva, DetalleFactura detalle,
			Cliente listaclientes) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.total = total;
		this.subtotal = subtotal;
		this.iva = iva;
		this.detalle = detalle;
		this.listaclientes = listaclientes;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public DetalleFactura getDetalle() {
		return detalle;
	}
	public void setDetalle(DetalleFactura detalle) {
		this.detalle = detalle;
	}
	public Cliente getListaclientes() {
		return listaclientes;
	}
	public void setListaclientes(Cliente listaclientes) {
		this.listaclientes = listaclientes;
	}
	
	
	
}
