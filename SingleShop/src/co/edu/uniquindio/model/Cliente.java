package co.edu.uniquindio.model;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

	//------------ATRIBUTOS------------------------
	private static int id = 0; 
	private int codigoCliente; 
	private String nombre, direccion, correo, fechaNacimiento,contrasenia,  
	ciudad, departamento, usuario;
	private ArrayList<Factura> listaFacturas; 

	//--------------------CONSTRUCTORES-----------------------------------------

	public Cliente() {
		codigoCliente = id; 
		id++; 
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
	//--------------------METODOS------------------------------

	/**
	 * METODO QUE COMPARA DOS CLIENTES POR SU USUARIO
	 * @param cliente
	 * @return
	 */
	public boolean compararUsuario(Cliente cliente) {
		if(cliente != null && cliente.getUsuario().equals(usuario)) return true; 
		return false;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ciudad, contrasenia, correo, departamento, direccion, fechaNacimiento, listaFacturas,
				nombre, usuario);
	}
	@Override
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
	 * METODO QUE VERIFICA SI EL USUARIO Y CONTRASEÑA PASADO POR PARAMETROS COINCIDEN CON EL CLIENTE
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

	//--------------------GETTERS AND SETTERS------------------------------
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
	public String hacerFactura(ArrayList<DetalleFactura> detalles, String fecha, String tipoPago, Sede sedeAux) {
		String mensaje = ""; 
		TipoPago tipoPagoAux = obtenerTipoPago(tipoPago); 
		Factura facturaAux = new Factura(sedeAux, fecha, 0.16, this, tipoPagoAux , detalles); 
		listaFacturas.add(facturaAux); 
		mensaje = facturaAux.realizarCalculoFactura(); 
		return mensaje; 
	}
	private TipoPago obtenerTipoPago(String tipoPago) {
		if(tipoPago.equals("Tarjeta crédito")) return TipoPago.TARJETA_CREDITO; 
		else return TipoPago.TARJETA_DEBITO; 
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
}
