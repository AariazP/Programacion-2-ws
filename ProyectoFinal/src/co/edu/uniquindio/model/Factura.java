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
	
	//------------ CONSTRUCTOR VACIO --------------
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
		listaDetalles = new ArrayList<DetalleFactura>(); 
		setListaDetalles(detalles);
		setCodigoFact(id); 
		id++; 
	}


	
	//-----------------------MÉTODOS----------------------
	/**
	 * ESTE METODO NOS AYUDA A DEFINIR CUANDO EL CLIENTE VA A ELEGIR AL PAGAR,
	 * CUAL ES EL TIPO DE PAGO CON EL QUE LO QUIERE HACER 
	 * @param tipoPago
	 * @return
	 */
	private String definirTipoPago(TipoPago tipoPago) {
		
		if(tipoPago == TipoPago.TARJETA_CREDITO) {
			return "Tarjeta crédito"; 
		}else {
			return "Tarjeta débito"; 
		}
		
	}
	
	/**
	 * ESTE METODO REALIZARA EL CALCULO DE UNA FACTURA, SUMARA TODAS LAS COMPRAS
	 * QUE SE VAN HACER Y POSTERIORMENTE A ESO SE LE AUMENTA EL IVA
	 * @return
	 */
	public String realizarCalculoFactura() {
		String mensaje = "Nombre del cliente que realiza la factura: "+cliente.getNombre()+"\n";
		//RECORREMOS TODOS LOS DETALLES FACTURAS DE ESA FACTURA PARA OBTENER LOS DATOS
		for (int i = 0; i < listaDetalles.size(); i++) {
			
			//BUSCAMOS EL PRECIO DE LOS PRODUCTOS Y LOS VAMOS SUMANDO
			mensaje += "Producto "+i+": "+ listaDetalles.get(i).getPrecio()+"\n";
			//LUEGO DE LOS PRECIOS LOS MULTIPLICAMOS CON LA CANTIDAD QUE CADA PRODUCTO TIENE
			total += (listaDetalles.get(i).getPrecio())*listaDetalles.get(i).getCantidad(); 
		}
		//YA LA SUMA QUE QUEDO EN MENSAJE LE AUMENTAMOS EL IVA DEL TOTAL A PAGAR
		mensaje = "IVA "+(iva*100)+"\n";
		total += total * iva; 
		//DE ACA PARA BAJO PASAMOS A MOSTRAR LA INFORMACION NECESARIO QUE OBTUVIMOS DE DETALLE FACTURA
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
		for (int i = 0; i < listaDetalles.size(); i++) {
			this.listaDetalles.add(listaDetalles.get(i)); 
		}
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

	/**
	 * METODO DE COGER LOS NOMBRES DEL PRODUCTO DE LOS DETALLES 
	 * DE FACTURA EN LA CLASE FACTURA
	 * @return
	 */ 
	public String obtenerTresProductosMasVendidos() {
		String mensaje = "";
		//SON LOS CONTADORES DE LOS TRES PRODUCTOS MAS VENDIDOS EN UNA FACTURA
		double conPrimero = 0, conSegundo = 0, conTercero = 0;
		//DONDE VAN A QUEDAR LOS NOMBRES DE LOS TRES PROCUTOS QUE ESTAN EN DETALLE FACTURAS
		DetalleFactura primero = new DetalleFactura(), segundo = new DetalleFactura(), tercero = new DetalleFactura();
		for (int i = 0; i < listaDetalles.size(); i++) {//RECORREMOS LA LISTA DE DETALLES
			DetalleFactura deAux = listaDetalles.get(i);//PASAMOS POR CADA POSICION
			//COMPARAMOS EL SUBTOTAL DEL PRODUCTO PARA SABER CUAL ES EL PRIMERO QUE MAS COMPRARON
			//LUEGO DE TENER EL PRIMERO SE HACE LO MIMSO CON EL SEGUNDO 
			//Y LUEGO DE TENER EL SEGUNDO SE HACE LO MISMO CON EL TERCERO
			if (deAux.getSubTotal() > deAux.getSubTotal() && deAux.getSubTotal() > conPrimero) {
				primero = deAux;//LUEGO DE TENERLO QUEDARA GUARDADO EN PRIMERO 
				conPrimero = deAux.getSubTotal();//EL CONTADOR AYUDA A CONTAR CUANTAS VECES TOCO HACER LA SUMA DEL PRODUCTO
			} else if (deAux.getSubTotal() > deAux.getSubTotal() && deAux.getSubTotal() > conSegundo) {
				segundo = deAux;//LUEGO DE TENERLO QUEDARA GUARDADO EN SEGUNDO
				conSegundo = deAux.getSubTotal();//EL CONTADOR AYUDA A CONTAR CUANTAS VECES TOCO HACER LA SUMA DEL PRODUCTO
			} else if (deAux.getSubTotal() > deAux.getSubTotal() && deAux.getSubTotal() > conTercero) {
				tercero = deAux;//LUEGO DE TENERLO QUEDARA GUARDADO EN TERCERO
				conTercero = deAux.getSubTotal();//EL CONTADOR AYUDA A CONTAR CUANTAS VECES TOCO HACER LA SUMA DEL PRODUCTO
			}
		}
		//YA ACA SE GUARDARAN LOS TRES NOMBRES DE LOS PRODUCTOS MAS COMPRADOS
		mensaje += primero.getNombre() + segundo.getNombre() + tercero.getNombre();
		return mensaje;
	}

	
	@Override
	public String toString() {
		return "Factura [sede=" + sede + ", codigoFact=" + codigoFact + ", fecha=" + fecha + ", strCiudad=" + strCiudad
				+ ", nomCliente=" + nomCliente + ", strTipoPago=" + strTipoPago + ", total=" + total + ", subTotal="
				+ subTotal + ", iva=" + iva + ", listaDetalles=" + listaDetalles + ", cliente=" + cliente
				+ ", tipoPago=" + tipoPago + "]";
	}

	/**
	 * NOS AYUDA A SABER CUANTAS VECES HAY DE UN PRODUCTO
	 * @param prodAux
	 * @return
	 */
	public Integer getVecesProd(Producto prodAux) {
		Integer vecesComp = 0;//CONTADOR QUE INICIA EN CERO
		for (int i = 0; i < listaDetalles.size(); i++) {//RECORREMOS TODA LA LISTA DETALLES
			DetalleFactura detalleAux = listaDetalles.get(i);//BUSCAMOS POSICION POR POSICION Y VAMOS COMPARANDO
			if(detalleAux.compararProducto(prodAux)) {//QUE SI DETALLEAUX SE COMPARA CON PORDAUX Y ES TRUE
				vecesComp += detalleAux.getCantidad();// GUARDAMOS LA CANTIDAD DEL PRODUCTO MAS VENDIDO 
			}
		}
		return vecesComp;
	}

	/**
	 * ESTE METODO NOS AYUDARA A COMOPRAR FECHAS PARA VER
	 * SI EL IGUAL A LA QUE ESTAMOS BUSCANDO
	 * @param fechaAux
	 * @return
	 */
	public boolean compararFecha(String fechaAux) {
		if(fechaAux.equals(fecha)) return true;//SI FECHA ES IGUAL A LA FECHA DEL PARAMETRO RETORNA TRUE 
		return false;//SI NO SE ENCONTR UNA FECHA IGUAL, ENTONCES RETORNA FALSE
	}

	/**
	 * NOS SIRVE PARA OBTENER LAS VECES QUE ESTAN UN PRODUCTO EN DETALLE FACTURA
	 * @param producto
	 * @return
	 */
	public int obtenerVecesProducto(Producto producto) {
		int acumulador = 0; 
		for (int i = 0; i < listaDetalles.size(); i++) {//RECORREMOS LA LISTA DETALLE
			//MIRAMOS EN TODAS LA POSICIONES Y SI ESTA EN UNA POSICION DE LA LISTA DE ARREGLO
			DetalleFactura detalleAux = listaDetalles.get(i);
			if (detalleAux.compararProducto(producto)) {//COMPARAMOS SI DETALLEAUX ES SIMILAR A PRODUCTO Y SI LO ES
				acumulador+= detalleAux.getCantidad();//GUARDAMOS LA CANTIDAD DEL PRODUCTO
			}
		}
		
		return acumulador;
	}
	
}
