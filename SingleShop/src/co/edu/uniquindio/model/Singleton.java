package co.edu.uniquindio.model;

import java.util.ArrayList;

public final class Singleton {

	//Atributos del singleton
	private static Empresa empresa;
	public String nomEmpresa;

	/**
	 * Se hace el constructor privado para impedir que se hagan nuevas instancias
	 * @param nomEmpresa
	 */
	private Singleton(String nomEmpresa) {
		//Asigno el nombre a la empresa
		this.nomEmpresa = nomEmpresa;
	}
	/**
	 * Método que crea la instancia de la clase empresa
	 * @param nomEmpresa
	 * @return la empresa principal
	 */
	public static Empresa createInstance(String nomEmpresa) {
		if (empresa == null) {
			empresa = new Empresa(nomEmpresa);
		}
		return empresa;
	}
	/**
	 * Método que devuelve la instancia de la empresa
	 * @return
	 */
	public static Empresa getInstance() {
		return empresa;
	}

	public static boolean verificarAdmin(String contrasenia, String usuario) {
		if(empresa.verificarAdmin(contrasenia,usuario)) return true; 
		return false;
	}

	/**
	 * MÉTODO QUE PERMITE OBTENER TODAS LAS SEDES DE UNA EMPRESA
	 * @return
	 */
	public static ArrayList<Sede> obtenerSedes() {
		return empresa.getListaSedes();
	}
	/**
	 * MÉTODO QUE PERMITE CREAR SEDES EN LA INSTANCIA EMPRESA
	 * @param nomSede
	 * @return
	 */
	public static String crearSede(String nomSede) {
		return empresa.crearSede(nomSede); 
	}
	/**
	 * MÉTODO QUE PERMITE MOSTRAR POR CONSOLA LAS SEDES CREADAS
	 */
	public static void mostrarListaSedes() {
		empresa.mostrarSedes(); 
	}
	public static Sede obtenerSede(String nomSede) {
		return empresa.obtenerSede(nomSede);
	}
	public static String eliminarSede(String ciudad) {
		return empresa.eliminarSede(ciudad);
	}
	public static String actualizarSede(String ciudad) {
		return empresa.actualizarSede(ciudad);
	}
	public static Sede buscarSede(String ciudad) {
		return empresa.buscarSede(ciudad);
	}
	public static String sustituirSede(String ciudad) {
		return empresa.sustituirSede(ciudad);
	}
	public static ArrayList<Object> obtenerListaTipoProducto(TipoProducto tipo) {
		return empresa.obtenerListaTipoProducto(tipo);
	}
	public static ArrayList<Object> obtenerEmpleados() {
		return empresa.obtenerEmpleados();
	}
	public static String crearProducto(String nomProd, String descripcion, double precio, int cantidadDisponible,
			TipoProducto tipoProductoGlobal) {
		return empresa.crearProducto( nomProd,  descripcion,  precio,  cantidadDisponible, tipoProductoGlobal);
	}
	public static String reemplazarProductos(Producto productoReemplazar, Producto productoNuevo) {
		return empresa.reemplazarProducto(productoReemplazar, productoNuevo);
	}
	public static String actualizarAtributosProducto(Producto productoActualizar, String nomProd, String descripcion,
			double precio, int cantidadDisponible) {
		return empresa.actualizarAtributosProducto(productoActualizar, nomProd, descripcion, precio, cantidadDisponible);
	}
	public static String eliminarProducto(Producto prodEliminar) {
		return empresa.eliminarProducto(prodEliminar);
	}
	public static ArrayList<String> obtenerStringSedes() {
		return empresa.obtenerStringSedes();
	}
	public static String crearEmpleado(String nomEmpleado, double sueldoEmp, String sede) {
		return empresa.crearEmpleado(nomEmpleado, sueldoEmp, sede); 
	}
	public static String crearAdmin(String nombre, String direccion, String email, String fechaNacimiento,
			String sede, String usuario, String password, double sueldo) {
		return empresa.crearAdmin(nombre, direccion, email, fechaNacimiento, sede, usuario, password, sueldo);
	}
	public static String eliminarEmpleado(Object empleado) {
		return empresa.eliminarEmpleado(empleado);
	}
	private static Administrador admin; 

	/**
	 * @return the admin
	 */
	public static Administrador getAdmin() {
		return admin;
	}
	/**
	 * @param admin the admin to set
	 */
	public static void setAdmin(Administrador admin) {
		Singleton.admin = admin;
	}
	public static String actualizarAdmin(String nombre, String direccion, String email,
			String fechaNacimiento, String sede, String usuario,String password,  double sueldo) {
		return empresa.actualizarAdmin(admin, nombre, direccion, email, fechaNacimiento, sede, usuario, password, sueldo);
	}
	public static String actualizarEmpleado(Empleado empl, String nom, double sueldo, String sede) {
		return empresa.actualizarEmpleado(empl, nom, sueldo,sede );
	}
	public static ArrayList<Producto> obtenerListaProductos() {
		return empresa.getListaProductos();
	}
	public static ArrayList<Producto> filtrarProductosCondiciones(int precio, String tipo) {
		return empresa.filtrarProductos(precio, tipo);
	}
	public static ArrayList<Producto> filtrarProductosTipo(String tipo) {
		return empresa.filtrarProductosTipo( tipo);
	}
	public static ArrayList<Producto> filtrarProductosPrecio(int precio) {
		return empresa.filtrarProductosPrecio(precio);
	}
	public static void reducirCantidadProducto(Producto prodCarrito, int cantidad) {
		empresa.reducirCantidadProducto(prodCarrito, cantidad);
	}
	public static ArrayList<Factura> obtenerListaFacturas(Cliente cliente) {
		return empresa.obtenerListaFactura(cliente);
	}
	public static void sumarCantidadStock(DetalleFactura prodCarrito) {
		empresa.sumarCantidadStock(prodCarrito); 
	}
	public static String realizarCompra(Cliente clienteActivo, ArrayList<DetalleFactura> detalles, String fecha, String sede, String tipoPago ) {
		return empresa.realizarCompra(clienteActivo, detalles, fecha,tipoPago ,sede);
	}
	public static ArrayList<Cliente> obtenerListaClientes() {
		return empresa.obtenerListaClientes();
	}
	public static String obtenerTresProdMasVendidos() {
		return null;
	}

}