package co.edu.uniquindio.model;

public class Tienda {
	
	private String nombre, nit;
	private Cliente cliente1, cliente2, cliente3;
	private Factura factura;

	public Cliente getCliente2() {
		return cliente2;
	}

	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
	}

	public Cliente getCliente3() {
		return cliente3;
	}

	public void setCliente3(Cliente cliente3) {
		this.cliente3 = cliente3;
	}

	public Cliente getCliente1() {
		return cliente1;
	}

	public void setCliente1(Cliente cliente1) {
		this.cliente1 = cliente1;
	}

	public Tienda(String nombre, String nit) {
		this.nombre = nombre;
		this.nit = nit;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
}
