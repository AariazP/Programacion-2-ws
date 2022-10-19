package co.edu.uniquindio.model;

import java.util.ArrayList;

public class Factura {
	
	//----------ATRIBUTOS-------------------------
	private Sede sede;
	private static int id;
	private int codigoFact; 
	private String fecha, strCiudad, nomCliente, strTipoPago;
	private double total, subTotal, iva;
	private ArrayList<DetalleFactura> listaDetalles; 
	private Cliente cliente;
	private TipoPago tipoPago; 
	
	//---------------CONSTRUCTORES---------------
	public Factura() {
		
	}
	
	

	public Factura(Sede sede, String fecha, double iva, Cliente cliente, TipoPago tipoPago, ArrayList<DetalleFactura> detalles) {
		super();
		this.sede = sede;
		this.fecha = fecha;
		this.iva = iva;
		this.cliente = cliente;
		this.tipoPago = tipoPago;
		this.strCiudad = sede.getStrCiudad(); 
		this.nomCliente = cliente.getNombre(); 
		this.strTipoPago = definirTipoPago(tipoPago);
		listaDetalles = detalles;
		setCodigoFact(id); 
		id++; 
	}


	
	//-----------------------MÉTODOS----------------------
	private String definirTipoPago(TipoPago tipoPago) {
		
		if(tipoPago == TipoPago.TARJETA_CREDITO) {
			return "Tarjeta crédito"; 
		}else {
			return "Tarjeta débito"; 
		}
		
	}
	
	
	public String realizarCalculoFactura() {
		String mensaje = "Nombre del cliente que realiza la factura: "+cliente.getNombre()+"\n"; 
		for (int i = 0; i < listaDetalles.size(); i++) {
			
			mensaje += "Producto "+i+": "+ listaDetalles.get(i).getPrecio()+"\n"; 
			total += (listaDetalles.get(i).getPrecio())*listaDetalles.get(i).getCantidad(); 
		}
		mensaje = "IVA "+(iva*100)+"\n"; 
		total += total * iva; 
		mensaje += "Total: "+total+"\n"; 
		mensaje += "El tipo de pago realizado es con: "+definirTipoPago(tipoPago)+"\n";
		mensaje += "La sede donde se ha hecho la compra: "+strCiudad+"\n"; 
		mensaje += "El código de la factura es: "+codigoFact; 
		return mensaje; 
	}
	//----------GETTERS AND SETTERS-------------------------
	
	
	



	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public static int getCodigo() {
		return id;
	}

	public static void setCodigo(int codigo) {
		Factura.id = codigo;
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

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public ArrayList<DetalleFactura> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(ArrayList<DetalleFactura> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoPago getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(TipoPago tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getStrCiudad() {
		return strCiudad;
	}

	public void setStrCiudad(String strCiudad) {
		this.strCiudad = strCiudad; 
	}

	public String getNomCliente() {
		return nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}



	public String getStrTipoPago() {
		return strTipoPago;
	}



	public void setStrTipoPago(String strTipoPago) {
		this.strTipoPago = strTipoPago;
	}



	public int getCodigoFact() {
		return codigoFact;
	}



	public void setCodigoFact(int codigoFact) {
		this.codigoFact = codigoFact;
	}
	
}
