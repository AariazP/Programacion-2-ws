package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

	// ------------ATRIBUTOS------------------------
	private static int id = 0;
	private int codigoCliente;
	private String nombre, direccion, correo, fechaNacimiento, contrasenia, ciudad, departamento, usuario;
	private ArrayList<Factura> listaFacturas;

	// --------------------CONSTRUCTORES-----------------------------------------

	public Cliente() {
		codigoCliente = id;
		id++;
		listaFacturas = new ArrayList<Factura>();
	}

	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
		listaFacturas = new ArrayList<Factura>();
		codigoCliente = id;
		id++;
	}

	public Cliente(String nombre, String direccion, String correo, String fechaNacimiento, String ciudad,
			String departamento) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudad;
		this.departamento = departamento;
		codigoCliente = id;
		id++;
		listaFacturas = new ArrayList<Factura>();
	}

	public Cliente(String nombre, String direccion, String correo, String fechaNacimiento, String contrasenia,
			String ciudad, String departamento, String usuario) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasenia = contrasenia;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.usuario = usuario;
		codigoCliente = id;
		id++;
		listaFacturas = new ArrayList<Factura>();
	}
	
	//----------------------------------------------------------
	// --------------------METODOS------------------------------

	/**
	 * METODO QUE COMPARA DOS CLIENTES POR SU USUARIO
	 * 
	 * @param cliente
	 * @return
	 */
	public boolean compararUsuario(Cliente cliente) {
		//SI EL CLIENTE NO ES NULO Y EL CLIENTE QUE LE PASARON ES EL MISMO QUE
		//EL QUE SE ESTA PASANDO POR PARAMETRO, ENTONCES.....
		if (cliente != null && cliente.getUsuario().equals(usuario))
			return true;//ENTONCES RETORNA UN TRUE
		return false;//DEL RESTO RETONDA UN FALSE
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciudad, contrasenia, correo, departamento, direccion, fechaNacimiento, listaFacturas,
				nombre, usuario);
	}
	
	@Override
	/**
	 * * ESTE METODO NOS PERMITE HACER UN IQUALS DE LO QUE NECESITEMOS 
	 * O TAMBIEN DE TODOS LOS ATRIBUTOS DE ESTA CLASE
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(contrasenia, other.contrasenia)
				&& Objects.equals(correo, other.correo) && Objects.equals(departamento, other.departamento)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(listaFacturas, other.listaFacturas) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(usuario, other.usuario);
	}

	/**
	 * METODO QUE VERIFICA SI EL USUARIO Y CONTRASEÑA PASADO POR PARAMETROS
	 * COINCIDEN CON EL CLIENTE
	 * 
	 * @param usuario2
	 * @param contrasenia2
	 * @return
	 */
	public boolean verificarCliente(String usuario2, String contrasenia2) {
		if (usuario2.equals(usuario) && contrasenia2.equals(contrasenia)) {
			return true;
		}
		return false;
	}

	// --------------------GETTERS AND SETTERS------------------------------
	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Cliente.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}

	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	//-----------------------------------------------------------------
	/**
	 * ESTE METODO NOS RETORNA UN MENSAJE DE TODA LA INFORMACION DE UNA FACTURA
	 * LA CUAL ESA FACTURA ES LA QUE SE ESTA CREANDO EN EL MOMENTO DE QUE EL
	 * CLIENTE LE DE PAGAR, PARA LUEGO MOSTRAR LA INFORMACION
	 * @param detalles
	 * @param fecha
	 * @param tipoPago
	 * @param sedeAux
	 * @return
	 */
	public String hacerFactura(ArrayList<DetalleFactura> detalles, String fecha, String tipoPago, Sede sedeAux) {
		String mensaje = "";//SE DECLARA UN STRING VACIO
		TipoPago tipoPagoAux = obtenerTipoPago(tipoPago);//OBTENEMOS EL TIPO DE PAGO QUE EL CLIENTE SELECIONO
		//VAMOS A FACTURAS Y OBTENEMOS LOS DATOS QUE SE NECESITAN DE LA FACTURA 
		//ESOS DATOS QUEDAN ALMACENADOS EN FACTURAAUX
		Factura facturaAux = new Factura(sedeAux, fecha, 0.16, this, tipoPagoAux, detalles);
		listaFacturas.add(facturaAux);//SE AGREGA TODA LA INFORMACION A LA LISTA DE FACTURAS QUE SE ESTA CREANDO
		//YA LUEGO GUARDAMOS LA INFORMACION Y TAMBIEN EL TOTAL A PAGAR DE LA FACTURA
		mensaje = facturaAux.realizarCalculoFactura();
		return mensaje;//RETORNAMOS MENSAJE
	}

	/**
	 * ACÁ SE OBTIENE EL TIPO DE PAGO 
	 * @param tipoPago
	 * @return
	 */
	private TipoPago obtenerTipoPago(String tipoPago) {
		if (tipoPago.equals("Tarjeta crédito"))//SI EL TIPO DE PAGO ES IGUAL A TARJETA DE CREDITO
			return TipoPago.TARJETA_CREDITO;//RETORNAMOS TARJETA DE CREDITO Y APARECERA EN LA FACTURA
		else
			return TipoPago.TARJETA_DEBITO;//SI NO ENTONCES ES TARJETA DE DEBITO Y SE MOSTRARA EN LA FACTURA
	}

	//-------- GETTER Y SETTER-----------------------------------
	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	//------------------------------------------------------------
	/**
	 * CON ESTE METODO PODEMSO OBTENER UNA FACTURA CON SU FECHA DE COMPRA 
	 * 
	 * @return
	 */
	public ArrayList<String> obtenerFechasFacturas() {
		ArrayList<String> fechas = new ArrayList<String>();//ACA QUEDARA GUARDADA LA FECHA QUE ESTAMOS BUSCANDO 

		for (int i = 0; i < listaFacturas.size(); i++) {//RECORREMOS LAS LISTAS FACTURAS BUSCANDO LA FECHA
			fechas.add(listaFacturas.get(i).getFecha());//LUEGO DE ENCONTRARLA LA GUARDAMOS O AGREGAMOS EN FECHAS
		}

		return fechas;//PARA LUEGO RETORNAR ESA FECHA
	}
	
	/**
	 * NOS PERMITIRA OBTENER LOS TRES PORDUCTOS MAS VENDIDOS DE UNA 
	 * LISTA QUE FUE REGISTRADA
	 * @param prodAux
	 * @return
	 */
	public Integer getVecesCompradasProd(Producto prodAux) {
		Integer vecesCompr = 0; 
		for (int i = 0; i < listaFacturas.size(); i++) {
			//OBTENGO LA FACTURA DE LA ITERACIÓN
			Factura factAux = listaFacturas.get(i);
			//OBTENGO LAS VECES QUE APARECE EL PRODUCTO EN LA FACTURAAUX
			vecesCompr += factAux.getVecesProd(prodAux); 
		}

		return vecesCompr;
	}

	/**
	 * OBTENEMOS LAS VECES QUE SE COPRE UN PRODUCTO
	 * @param producto
	 * @param fechaAux
	 * @return
	 */
	public int obtenerVecesProd(Producto producto, String fechaAux) {
		int acumulador = 0;
		for (int i = 0; i < listaFacturas.size(); i++) {//RECORREMOS LAS LISTAS FACTURAS
			Factura factAux = listaFacturas.get(i);//GUARDAMOS EL PRODUCTO ENCONTRADO EN FACTAUX
			if (factAux.compararFecha(fechaAux)) {//SE COMPARA FACTAUX CON LA FECHA Y SI CUMPLE LA CONDICION
				//EL ACUIMULADOR OBTENDRA LAS VECES QUE ESE PRODUCTO SE COMPRO
				acumulador += factAux.obtenerVecesProducto(producto);
			}
		}

		return acumulador;//RETORNAMOS EL CONTADOR
	}

}
