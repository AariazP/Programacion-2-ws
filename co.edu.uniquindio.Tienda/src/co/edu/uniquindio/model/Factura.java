package co.edu.uniquindio.model;

public class Factura {
	private int numeroFactura;
	private String fecha;
	private double total, iva, subtotal;
	private Cliente cliente;
	private DetalleFactura theDetalleFactura1, theDetalleFactura2;
	public Factura(int numeroFactura, String fecha, double total, double iva, double subtotal) {
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		this.total = total;
		this.iva = iva;
		this.subtotal = subtotal;
	}
	public int getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
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
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public DetalleFactura getTheDetalleFactura1() {
		return theDetalleFactura1;
	}
	public void setTheDetalleFactura1(DetalleFactura theDetalleFactura1) {
		this.theDetalleFactura1 = theDetalleFactura1;
	}

	public DetalleFactura getTheDetalleFactura2() {
		return theDetalleFactura2;
	}
	public void setTheDetalleFactura2(DetalleFactura theDetalleFactura2) {
		this.theDetalleFactura2 = theDetalleFactura2;
	}
}
