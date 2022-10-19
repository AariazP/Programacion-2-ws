package co.edu.uniquindio.model;

import java.util.ArrayList;

public final class Singleton {

	//ESTOS SON LOS ATRIBUTOS DEL SINGLETON
	private static Empresa empresa;
	public String nomEmpresa;

	/**
	 * SE HACE EL CONSTRUCTOR PRIVADO PARA IMPEDIR QUE SE HAGAN NUEVAS INSTANCIAS
	 * @param nomEmpresa
	 */
	private Singleton(String nomEmpresa) {
		//SE LE ASIGNA EL NOMBRE A LA EMPRESA
		this.nomEmpresa = nomEmpresa;
	}
	/**
	 * CON ESTE METODO CREAMOS LA INSTANCIA DE LA
	 * CLASE EMPRESA
	 * @param nomEmpresa
	 * @return la empresa principal
	 */
	public static Empresa createInstance(String nomEmpresa) {
		if (empresa == null) {//SI LA EMPRESA ES NULA ENTONCES
			empresa = new Empresa(nomEmpresa);//LE PASAMOS A EMPRESA EL NOMBRE QUE VA A TENER
		}
		return empresa;
	}
	/**
	 * METODO QUE AYUDA A DEVOLVER LA INSTACIA DE LA EMPRESA
	 * @return
	 */
	public static Empresa getInstance() {
		return empresa;
	}

	/**
	 * ACA VERIFICAMOS LA CONTRASESÑA Y EL USUARIO 
	 * DEL ADMIN, PARA SABER SI EXISTE ESE ADMIN
	 * @param contrasenia
	 * @param usuario
	 * @return
	 */
	public static boolean verificarAdmin(String contrasenia, String usuario) {
		if(empresa.verificarAdmin(contrasenia,usuario)) return true;//SI CUMPLE CON LAS CONDICIONES RETORNA UN TRUE 
		return false;//SI NO RETORNA UN FALSE
	}

	/**
	 * MÉTODO QUE PERMITE OBTENER TODAS LAS SEDES QUE TIENE LA EMPRESA EN GENERAL
	 * @return
	 */
	public static ArrayList<Sede> obtenerSedes() {
		return empresa.getListaSedes();//LLAMAMOS A LA LISTA SEDES PARA QUE EMPRESA LAS OBTENGA Y LAS MUESTRE
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
	 * MÉTODO QUE PERMITE MOSTRAR LAS SEDES CREADAS
	 * PARA ELEGIR EN CUAL SEDE ESTA O QUIER COMPRAR
	 */
	public static void mostrarListaSedes() {
		empresa.mostrarSedes(); 
	}
	
	/**
	 * OBTENEMOS LAS SEDES POR EL NOMBRE
	 * @param nomSede
	 * @return
	 */
	public static Sede obtenerSede(String nomSede) {
		return empresa.obtenerSede(nomSede);
	}
	
	/**
	 * PODEMOS ELIMINAR LA SEDE SI YA NO ESTA ENFUNCIONAMIENTO 
	 * O YA NO SE NECESITA EN LA EMPRESA
	 * @param ciudad
	 * @return
	 */
	public static String eliminarSede(String ciudad) {
		return empresa.eliminarSede(ciudad);
	}
	
	/**
	 * SI LA SEDE SE CAMBIO DE LUGAR SE PUDE ACTUALIZAR 
	 * LOS ATRIBUTOS DE LA SEDE
	 * @param ciudad
	 * @return
	 */
	public static String actualizarSede(String ciudad) {
		return empresa.actualizarSede(ciudad);
	}
	
	/**
	 * SI NECESITAMOS BUSCAR UNA SEDE EN ESPECIFICO
	 * LO PODEMOS HACER POR MEDIO DE LA CIUDAD
	 * @param ciudad
	 * @return
	 */
	public static Sede buscarSede(String ciudad) {
		return empresa.buscarSede(ciudad);
	}
	
	/**
	 * SI SE NECESITA SUSTITUR UNA SEDE POR OTRA SE PODRA 
	 * HACER PARA TENER UNA INFORMACION CORRECTA DE LA SEDE
	 * @param ciudad
	 * @return
	 */
	public static String sustituirSede(String ciudad) {
		return empresa.sustituirSede(ciudad);
	}
	
	/**
	 * DEPENDIENDO DEL TIPO DE PRODUCTO PODREMOS OBTENER LA 
	 * LISTA DE SOLO ESE TIPO DE PRODUCTO
	 * @param tipo
	 * @return
	 */
	public static ArrayList<Object> obtenerListaTipoProducto(TipoProducto tipo) {
		return empresa.obtenerListaTipoProducto(tipo);
	}
	
	/**
	 * PODEMOS OBTENER EMPLEADOS, LOS CUALES SON NECESARIOS
	 * PARA EL BUEN FUNCIONAMIETNO DE LA EMPRESA
	 * @return
	 */
	public static ArrayList<Object> obtenerEmpleados() {
		return empresa.obtenerEmpleados();
	}
	
	/**
	 * ESTE METODO NOS PERMITE CREAR EL PRODUCTO SI NO EXISTE
	 * PASANDOLE TODOS LOS PARAMETROS NECESARIOS QUE SE REQUIERE
	 * PRODUCTO
	 * @param nomProd
	 * @param descripcion
	 * @param precio
	 * @param cantidadDisponible
	 * @param tipoProductoGlobal
	 * @return
	 */
	public static String crearProducto(String nomProd, String descripcion, double precio, int cantidadDisponible,
			TipoProducto tipoProductoGlobal) {
		return empresa.crearProducto( nomProd,  descripcion,  precio,  cantidadDisponible, tipoProductoGlobal);
	}
	
	/**
	 * PODEMOS REMPLAZAR UN PRODUCTO QUE NECESITE MODIFICACION POR EL NUEVO
	 * SE DE VA A IMPLEMENTAR
	 * @param productoReemplazar
	 * @param productoNuevo
	 * @return
	 */
	public static String reemplazarProductos(Producto productoReemplazar, Producto productoNuevo) {
		return empresa.reemplazarProducto(productoReemplazar, productoNuevo);
	}
	
	/**
	 * PODEMOS REMPLAZAR TODOS LOS ATRIBUTOS DEL 
	 * PRODUCTO ANTIGUO O SOLO REEMPLAZAR LOS ATRIBUTOS NECESARIOS
	 * @param productoActualizar
	 * @param nomProd
	 * @param descripcion
	 * @param precio
	 * @param cantidadDisponible
	 * @return
	 */
	public static String actualizarAtributosProducto(Producto productoActualizar, String nomProd, String descripcion,
			double precio, int cantidadDisponible) {
		return empresa.actualizarAtributosProducto(productoActualizar, nomProd, descripcion, precio, cantidadDisponible);
	}
	/**
	 * SI YA UN PORDUCTO NO VOLVIO A LLEGAR O NO LO VOLVIERON 
	 * A CREAR, SE PUEDE ELIMINAR, PARA QUE YA NO EXISTA EN LA
	 * TIENDA COMO TAL
	 * @param prodEliminar
	 * @return
	 */
	public static String eliminarProducto(Producto prodEliminar) {
		return empresa.eliminarProducto(prodEliminar);
	}
	
	/**
	 * ESTE METODO NOS RETORNARA TODAS LAS SEDES
	 * QUE HAY Y SE GUARDARAN EN UN ARRAYLIST DE STING
	 * PARA LUEGO RETORNAR LAS SEDES
	 * @return
	 */
	public static ArrayList<String> obtenerStringSedes() {
		return empresa.obtenerStringSedes();
	}
	
	/**
	 * ESTE METODO NOS PERMITE RETORNAR EL EMPLEADO QUE SE CREO,SI NO EXISTE
	 * CLARO ESTA QUE SE DEBE LLENAR TODOS LOS CAMPOS 
	 * PARA QUE EL SISTEMA RECONOZCA QUE SE CREO UN NUEVO EMPLEADO
	 * @param nomEmpleado
	 * @param sueldoEmp
	 * @param sede
	 * @return
	 */
	public static String crearEmpleado(String nomEmpleado, double sueldoEmp, String sede) {
		return empresa.crearEmpleado(nomEmpleado, sueldoEmp, sede); 
	}
	
	/**
	 * ESTE METODO NOS PERMITE RETORNAR EL NUEVO ADMIN QUE SE CREO,
	 * PARA QUE EL SISTEMA RECONOZCA QUE SE CREO UN NUEVO EMPLEADO
	 * @param nombre
	 * @param direccion
	 * @param email
	 * @param fechaNacimiento
	 * @param sede
	 * @param usuario
	 * @param password
	 * @param sueldo
	 * @return
	 */
	public static String crearAdmin(String nombre, String direccion, String email, String fechaNacimiento,
			String sede, String usuario, String password, double sueldo) {
		return empresa.crearAdmin(nombre, direccion, email, fechaNacimiento, sede, usuario, password, sueldo);
	}
	
	/**
	 * ESTE METODO RETORNA EL EMPLEADOQUE SE ELIMINO DE LA EMPRESA
	 * @param empleado
	 * @return
	 */
	public static String eliminarEmpleado(Object empleado) {
		return empresa.eliminarEmpleado(empleado);
	}
	private static Administrador admin; 

	/**
	 * SE OBTIEN EL ADMIN QUE SE VA A UTILIZAR
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
	
	/**
	 * ESTE METODO NOS DEVUELVE UN ADMINISTRADOS ACTUALIZADO,
	 * DONDE LE PUEDE CAMBIAR LA INFOAMCION PARA PONERLE LA CORRECTA
	 * @param nombre
	 * @param direccion
	 * @param email
	 * @param fechaNacimiento
	 * @param sede
	 * @param usuario
	 * @param password
	 * @param sueldo
	 * @return
	 */
	public static String actualizarAdmin(String nombre, String direccion, String email,
			String fechaNacimiento, String sede, String usuario,String password,  double sueldo) {
		return empresa.actualizarAdmin(admin, nombre, direccion, email, fechaNacimiento, sede, usuario, password, sueldo);
	}
	/**
	 * ESTE METODO NOS DEVUELVE EL EMPLEADO ACTUALIZADO,
	 * Y LE PUEDE CAMBIAR LA INFOAMCION PARA PONERLE LA CORRECTA
	 * @param empl
	 * @param nom
	 * @param sueldo
	 * @param sede
	 * @return
	 */
	public static String actualizarEmpleado(Empleado empl, String nom, double sueldo, String sede) {
		return empresa.actualizarEmpleado(empl, nom, sueldo,sede );
	}
	
	/**
	 * SE VA A RECOLECTAR DONA LA LISTA PRODUCTO QUE HAY EN LA EMPRESA
	 * @return
	 */
	public static ArrayList<Producto> obtenerListaProductos() {
		return empresa.getListaProductos();
	}
	
	/**
	 * METODO QUE NOS PERMITE OBTENER LOS PRODUCTO, YA SEA POR EL 
	 * TIPO PRODUCTO, EL PRECION O POR AMBOS
	 * @param precio
	 * @param tipo
	 * @return
	 */
	public static ArrayList<Producto> filtrarProductosCondiciones(int precio, String tipo) {
		return empresa.filtrarProductos(precio, tipo);
	}
	
	/**
	 * METODO QUE NOS PERMITE OBTENER LOS PRODUCTO POR EL TIPO DEL PORDUCTO
	 * @param tipo
	 * @return
	 */
	public static ArrayList<Producto> filtrarProductosTipo(String tipo) {
		return empresa.filtrarProductosTipo( tipo);
	}

	/**
	 * METODO QUE NOS PERMITE OBTENER LOS PRODUCTO POR EL TIPO DEL PORDUCTO
	 * @param precio
	 * @return
	 */
	public static ArrayList<Producto> filtrarProductosPrecio(int precio) {
		return empresa.filtrarProductosPrecio(precio);
	}
	
	/**
	 * METODO QUE PERMITE ESCRIBIR LA CANTIDAD CUANDO LE DEMOS A 
	 * PONER EN CARRITO Y DISMINUYE LAS UNIDADES QUE TIENE
	 * LA TIENDA DE ESE ESPECIFICO PORDUCTO
	 * @param prodCarrito
	 * @param cantidad
	 */
	public static void reducirCantidadProducto(Producto prodCarrito, int cantidad) {
		empresa.reducirCantidadProducto(prodCarrito, cantidad);
	}
	
	/**
	 * PEDIREMOS LAS LISTAS FACATURAS QUE TENGA LA EMPRESA
	 * DEL CLIENTE QUE ESTA COMPRANDO PARA PODER MOSTRARLA
	 * @param cliente
	 * @return
	 */
	public static ArrayList<Factura> obtenerListaFacturas(Cliente cliente) {
		return empresa.obtenerListaFactura(cliente);
	}
	
	/**
	 * CUANDO SE AGREGA UN NUMERO DEL PRODUCTO QUE VAS A LLEVA, LA CANTIDAD
	 * SUMARA LA CANTIDAD QUE SE VA A LLEVAR D UN PRODUCTO
	 * @param prodCarrito
	 */
	public static void sumarCantidadStock(DetalleFactura prodCarrito) {
		empresa.sumarCantidadStock(prodCarrito); 
	}
	
	/**
	 * CON ESTE METODO OBTENDREMOS TODA LA INFORMACION DEL METODO
	 * AL REALIZAR UNA COMPRA MIENTRAS EL CLIENTE ESTE ACTIVO,
	 * LO QUE SE DEBE LLENAR AL MOMENTO DE HACER EL PAGO DE LOS PORDUCTOS
	 * @param clienteActivo
	 * @param detalles
	 * @param fecha
	 * @param sede
	 * @param tipoPago
	 * @return
	 */
	public static String realizarCompra(Cliente clienteActivo, ArrayList<DetalleFactura> detalles, String fecha, String sede, String tipoPago ) {
		return empresa.realizarCompra(clienteActivo, detalles, fecha,tipoPago ,sede);
	}
	
	/**
	 * METODO QUE OBTIENE LA LISTA DE LOS CLIENTES
	 * @return
	 */
	public static ArrayList<Cliente> obtenerListaClientes() {
		return empresa.obtenerListaClientes();
	}
	//METODO QUE COMPARA CUALES SON LOS 3 PRODUCTOS MAS COMPRADOS
	public static String obtenerTresProdMasVendidos() {
		return empresa.obtenerProdMasVendidos();
	}
	
	//METODO QUE LLAMA A LA EMPRESA PARA QUE LE PASE LA FECHA 
	//QUE MAS VENDIO UN PRODUCTO EN ESPECIFICO
	public static String obtenerMasFechaProductosVendidos(Producto producto) {
		return empresa.obtenerMasFechaProductoVendidos(producto);
	}
	//BUSCA CLIENTES	
	public static String buscarInfoCliente(int cedula) {
		
		return empresa.buscarInfoCliente(cedula);
	}
	//BUSCA LA FACTURA DE UN CLIENTE
	public static String mostrarFacturaCliente(int cedula) {
		
		return empresa.mostrarFacturaCliente(cedula);
	}

}