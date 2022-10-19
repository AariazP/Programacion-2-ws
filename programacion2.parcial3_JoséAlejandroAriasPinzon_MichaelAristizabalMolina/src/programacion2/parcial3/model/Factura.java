package programacion2.parcial3.model;

public class Factura {

	private static int idAux = 0; 
	private int codigo; 
	private String fechaFactura;
	private double totalPagar; 
	private Cliente cliente;

	//----------CONSTRUCTOR------------

	public Factura(String fechaFactura, double totalPagar, Cliente cliente) {
		super();
		this.codigo = idAux;
		idAux ++; 
		this.fechaFactura = fechaFactura;
		this.totalPagar = totalPagar;
		this.cliente = cliente;
	}


	//--------Métodos ---------
	/*
	 * METODO QUE RETORNA TRUE SI LOS DOS VALORES SON IGUALES
	 * Y RETURN FALSE SI LOS VALORES NO SON IGUALES
	 * @param nombre2
	 * @param fecha2
	 * @
	 */
	public boolean compararFechaCliente(String fecha, Cliente cliente2) {
		//verifico si es la misma fecha y el mismo cliente
		if(fechaFactura.equals(fecha) && cliente.equals(cliente2)) return true; 
		return false;
	} 



	//-----------GETTERS AND SETTERS-------

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}



	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	/**
	 * @return the fechaFactura
	 */
	public String getFechaFactura() {
		return fechaFactura;
	}



	/**
	 * @param fechaFactura the fechaFactura to set
	 */
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}



	/**
	 * @return the totalPagar
	 */
	public double getTotalPagar() {
		return totalPagar;
	}



	/**
	 * @param totalPagar the totalPagar to set
	 */
	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}



	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}



	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
