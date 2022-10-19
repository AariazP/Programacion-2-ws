package co.edu.uniquindio.model;

import java.util.ArrayList;

public class Empresa {
	private String nombre; 
	private Administrador administrador;
	private ArrayList<Sede> listaSedes; 
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Administrador> listaAdmins;
	private ArrayList<Producto> listaProductos;
	private ArrayList<Empleado> listaEmpleados; 

	//----------------CONSTRUCTORES----------------
	public Empresa(String nombre) {
		this.setNombre(nombre); 
		listaSedes = new ArrayList<>(0);
		listaClientes = new ArrayList<>(0); 
		listaAdmins= new ArrayList<>(0); 
		listaProductos = new ArrayList<>(0);
		listaEmpleados = new ArrayList<>(0); 
		crearAdminQuemado(); 
		crearClienteQuemado(); 
		cargarProductosAleatorios();
		initializeClientesAleatorios(); 
		initializeAdminsAleatorios(); 
		quemarSede(); 
	}

	public Empresa() {
	}

	//-----------METODOS--------------------
	
	/**
	 * METODO QUE PERMITE QUEMAR UNA SEDE
	 */
	private void quemarSede() {
		//CREAMOS LA SEDE
		Sede sede = new Sede(); 
		//CREAMOS LA CIUDAD
		Ciudad ciudad = new Ciudad("Armenia"); 
		sede.setCiudad(ciudad);
		listaSedes.add(sede); 

		Sede sede1 = new Sede(); 
		Ciudad ciudad1 = new Ciudad("Pereira"); 
		sede1.setCiudad(ciudad1);
		listaSedes.add(sede1); 
	}
	/**
	 * METODO QUE PERMITE CARGAR LOS DATOS QUEMADOS EN EL CONTRUCTOR DE EMPRESA
	 */
	public void cargarProductosAleatorios() {
		initializeProductosEmpresariales();
		initializeProductosHogar(); 
		initializeProductoMusica();
		initializeProductoTecnologiaComputacional();
		initializeTecnologiaMovil();

	}
	//METODO QUE INICIALIZA LOS PRODUCTOS EMPRESARIALES SETTEANDO SUS ATRIBUTOS
	public void initializeProductosEmpresariales() {

		//-----------------------TIPO EMPRESARIAL-----------------------------------------
		//CREAMOS EL PRODUCTO Y LE SETTEAMOS SUS ATRIBUTOS
		Producto producto = new Producto(nombre, nombre, 0, 0, null);
		producto.setNombre("Windows 10");
		producto.setPrecio(38.000);
		producto.setTipoProducto(TipoProducto.EMPRESARIAL);
		producto.setCantDisponible(4);
		producto.setDescripcion("Sistema Operativo");
		//LO AGREGAMOS A LA LISTA DE PRODUCTOS
		listaProductos.add(producto);

		Producto producto2 = new Producto(nombre, nombre, 0, 0, null);
		producto2.setNombre("Ecplipse ");
		producto2.setPrecio(48.000);
		producto2.setTipoProducto(TipoProducto.EMPRESARIAL);
		producto2.setCantDisponible(7);
		producto2.setDescripcion("IDE Java");
		listaProductos.add(producto2);

		Producto producto3 = new Producto(nombre, nombre, 0, 0, null);
		producto3.setNombre("windows office 2019 ");
		producto3.setPrecio(65.000);
		producto3.setTipoProducto(TipoProducto.EMPRESARIAL);
		producto3.setCantDisponible(23);
		producto3.setDescripcion("Espacios de trabajo");
		listaProductos.add(producto3);
	}
	//-----------------------------------------------------------------------
	//----------------------------TIPO HOGAR -----------------------------------------------------
	public void initializeProductosHogar() {
		Producto producto = new Producto(nombre, nombre, 0, 0, null);
		producto.setNombre("Jabon para cocina");
		producto.setPrecio(15.000);
		producto.setTipoProducto(TipoProducto.HOGAR);
		producto.setCantDisponible(34);
		producto.setDescripcion("olor frutal");
		listaProductos.add(producto);

		Producto producto2 = new Producto(nombre, nombre, 0, 0, null);
		producto2.setNombre("Trapeador");
		producto2.setPrecio(10.000);
		producto2.setTipoProducto(TipoProducto.HOGAR);
		producto2.setCantDisponible(50);
		producto2.setDescripcion("limpia las esquinas dificiles");
		listaProductos.add(producto2);

		Producto producto3 = new Producto(nombre, nombre, 0, 0, null);
		producto3.setNombre("Jabon Fab");
		producto3.setPrecio(40.000);
		producto3.setTipoProducto(TipoProducto.HOGAR);
		producto3.setCantDisponible(43);
		producto3.setDescripcion("limpa y cuida la ropa");
		listaProductos.add(producto3);
	}

	//------------------------------------------------------------------------------------------
	//-------------------------TIPO MUSICA---------------------------------------------------------

	public void initializeProductoMusica(){
		Producto producto = new Producto(nombre, nombre, 0, 0, null);
		producto.setNombre("Album Michael Jackson");
		producto.setPrecio(150.000);
		producto.setTipoProducto(TipoProducto.MUSICA);
		producto.setCantDisponible(3);
		producto.setDescripcion("just beat it");
		listaProductos.add(producto);

		Producto producto2 = new Producto(nombre, nombre, 0, 0, null);
		producto2.setNombre("Album un verano sin ti");
		producto2.setPrecio(187.000);
		producto2.setTipoProducto(TipoProducto.MUSICA);
		producto2.setCantDisponible(12);
		producto2.setDescripcion("solo quiere party");
		listaProductos.add(producto2);

		Producto producto3 = new Producto(nombre, nombre, 0, 0, null);
		producto3.setNombre("Metallica");
		producto3.setPrecio(134.000);
		producto3.setTipoProducto(TipoProducto.MUSICA);
		producto3.setCantDisponible(6);
		producto3.setDescripcion("beat your fears");
		listaProductos.add(producto3);
	}

	//-------------------------------------------------------------------------------------------
	//---------------------------------TIPO TECNOLOGIA COMPUTACIONAL-----------------------------
	public void initializeProductoTecnologiaComputacional() {
		Producto producto = new Producto(nombre, nombre, 0, 0, null);
		producto.setNombre("RTX 3090");
		producto.setPrecio(3400000);
		producto.setTipoProducto(TipoProducto.TECNOLOGIA_COMPUTACIONAL);
		producto.setCantDisponible(10);
		producto.setDescripcion("graficos realistas");
		listaProductos.add(producto);

		Producto producto2 = new Producto(nombre, nombre, 0, 0, null);
		producto2.setNombre("Ryzen 9");
		producto2.setPrecio(400000);
		producto2.setTipoProducto(TipoProducto.TECNOLOGIA_COMPUTACIONAL);
		producto2.setCantDisponible(15);
		producto2.setDescripcion("16 nucleos - 32 hilos");
		listaProductos.add(producto2);

		Producto producto3 = new Producto(nombre, nombre, 0, 0, null);
		producto3.setNombre("Monitor LG");
		producto3.setPrecio(1200000);
		producto3.setTipoProducto(TipoProducto.TECNOLOGIA_COMPUTACIONAL);
		producto3.setCantDisponible(19);
		producto3.setDescripcion("144HZ");
		listaProductos.add(producto3);
	}

	//--------------------------------------------------------------------------------------------
	//------------------------TIPO TECONOLOGIA MOVIL ---------------------------------------------

	public void initializeTecnologiaMovil() {
		Producto producto = new Producto(nombre, nombre, 0, 0, null);
		producto.setNombre("Iphone 12");
		producto.setPrecio(4600000);
		producto.setTipoProducto(TipoProducto.TECNOLOGIA_MOVIL);
		producto.setCantDisponible(20);
		producto.setDescripcion("ultima gama en moviles");
		listaProductos.add(producto);

		Producto producto2 = new Producto(nombre, nombre, 0, 0, null);
		producto2.setNombre("Asus Rog Phone 5s");
		producto2.setPrecio(2456000);
		producto2.setTipoProducto(TipoProducto.TECNOLOGIA_MOVIL);
		producto2.setCantDisponible(34);
		producto2.setDescripcion("La mejor opcion para jugar");
		listaProductos.add(producto2);

		Producto producto3 = new Producto(nombre, nombre, 0, 0, null);
		producto3.setNombre("Redmi note 9");
		producto3.setPrecio(1200000);
		producto3.setTipoProducto(TipoProducto.TECNOLOGIA_MOVIL);
		producto3.setCantDisponible(34);
		producto3.setDescripcion("Calidad - Precio");
		listaProductos.add(producto3);
	}



	//----------------------------------------------------------------------------

	// metodo que inicializa los clientes en el tableview
	public void initializeClientesAleatorios() {
		Cliente cliente = new Cliente();
		cliente.setCiudad("Armenia");
		cliente.setCorreo("albertito@gmail.com");
		cliente.setDepartamento("Quindio");
		cliente.setDireccion("calle 56 #56-45");
		cliente.setFechaNacimiento("23/06/1995");
		cliente.setNombre("Alberto");
		cliente.setUsuario("a");
		cliente.setContrasenia("a");
		listaClientes.add(cliente);

		Cliente cliente2 = new Cliente();
		cliente2.setCiudad("Cordoba");
		cliente2.setCorreo("alex@gmail.com");
		cliente2.setDepartamento("Quindio");
		cliente2.setDireccion("calle 12 #76-45");
		cliente2.setFechaNacimiento("5/09/1998");
		cliente2.setNombre("Alex");
		cliente2.setUsuario("AlexIng");
		cliente2.setContrasenia("56789");
		listaClientes.add(cliente2);

		Cliente cliente3 = new Cliente();
		cliente3.setCiudad("Calarca");
		cliente3.setCorreo("JuanCR@gmail.com");
		cliente3.setDepartamento("Quindio");
		cliente3.setDireccion("calle 56 #56-45 - calarcá");
		cliente3.setFechaNacimiento("24/09/2000");
		cliente3.setNombre("Juan");
		cliente3.setUsuario("JuanIng");
		cliente3.setContrasenia("123456");
		listaClientes.add(cliente3);
	}

	//----------------------------------------------------------------------------
	//Metodo que inicializa administradores en el tableview
	public void initializeAdminsAleatorios() {
		Administrador admin = new Administrador();
		admin.setNombre("Jesus");
		admin.setDireccion("calle 14 #19-03");
		admin.setFechaNacimiento("14/02/1990");
		admin.setCorreo("jesusFG@gmail.com");
		admin.setSede(null);
		admin.setSueldo(2300000);
		admin.setUsuario("jesusAdmin");
		admin.setContrasenia("aeio");
		listaAdmins.add(admin);

		Administrador admin2 = new Administrador();
		admin2.setNombre("Alejandro");
		admin2.setDireccion("calle 18 #20-03");
		admin2.setFechaNacimiento("18/09/1992");
		admin2.setCorreo("AlejandroJR@gmail.com");
		admin2.setSede(null);
		admin2.setSueldo(4900000);
		admin2.setUsuario("AlejoAdmin");
		admin2.setContrasenia("0987");
		listaAdmins.add(admin2);

		Administrador admin3 = new Administrador();
		admin3.setNombre("Michael");
		admin3.setDireccion("calle 24 #12-09");
		admin3.setFechaNacimiento("26/07/1995");
		admin3.setCorreo("MichaelDF@gmail.com");
		admin3.setSede(null);
		admin3.setSueldo(3500000);
		admin3.setUsuario("MichaelAdmin");
		admin3.setContrasenia("6543");
		listaAdmins.add(admin3);
	}

	//------------------------------------------------------------------------------------------------
	// metodo que iniciliza empleados de muestra en la table view
	public void initializeEmpleados() {
		Empleado empleado = new Empleado();
		empleado.setNombre("Steven");
		empleado.setSueldo(1300000);
		empleado.setIdEmpleado(6778);
		empleado.setSede(null);
		listaEmpleados.add(empleado);

		Empleado empleado2 = new Empleado();
		empleado2.setNombre("Juliana");
		empleado2.setSueldo(1250000);
		empleado2.setIdEmpleado(3456);
		empleado2.setSede(null);
		listaEmpleados.add(empleado2);

		Empleado empleado3 = new Empleado();
		empleado3.setNombre("");
		empleado3.setSueldo(1300000);
		empleado3.setIdEmpleado(6778);
		empleado3.setSede(null);
		listaEmpleados.add(empleado3);
	}

	//CREAMOS UN CLIENTE Y LO ADICIONAMOS A LA LISTA DE LOS CLIENTES
	private void crearClienteQuemado() {
		Cliente cliente = new Cliente("Alejandro", "Cra 9 #8-53","kdls" , "jlaskdj", "user", "fds", "Armenia", "user");
		listaClientes.add(cliente); 
	}
	//CREAMOS UN ADMIN Y SETTEAMOS SUS PARAMETROS PARA AGREGARLO A LA LISTA DE LOS ADMINS
	private void crearAdminQuemado() {
		Administrador admin = new Administrador();
		admin.setNombre("Gerente principal");
		admin.setSueldo(1000000);
		admin.setUsuario("admin");
		admin.setContrasenia("1234");
		listaAdmins.add(admin); 

	}
	
	/**
	 * METODO QUE CREA UN CLIENTE DADOS SUS PARAMETROS
	 * @param nombre
	 * @param direccion
	 * @param correo
	 * @param fechaNacimiento
	 * @param contrasenia
	 * @param ciudad
	 * @param departamento
	 * @param usuario
	 * @return
	 */
	public String crearCliente(String nombre, String direccion, String correo, String fechaNacimiento,String contrasenia, String ciudad,
			String departamento, String usuario) {
		//CREO EL CLIENTE 
		Cliente cliente = new Cliente(nombre,direccion, correo, fechaNacimiento, contrasenia, ciudad, departamento, usuario);
		//VERIFICO SI EL CLIENTE EXISTE, EL CLIENTE EXISTE SI EL USUARIO PASADO POR PARAMETRO ES EL MISMO
		if(!existeCliente(cliente)) {
			listaClientes.add(cliente); 
			return "Cliente creado"; 
		}

		return "No se puede crear el cliente"; 
	}

	/**
	 * Método que busca un cliente y retorna un true si lo encuentra
	 * @param cliente
	 * @return
	 */

	private boolean existeCliente(Cliente cliente) {
		//RECORREMOS LA LISTA DE LOS CLIENTES
		for (int i = 0; i < listaClientes.size(); i++) {

			Cliente aux = listaClientes.get(i);
			if(aux != null && aux.compararUsuario(cliente)) {
				return true; 
			}
		}

		return false;
	}

	/**
	 * METODO QUE RECIBE UN USUARIO Y CONTRASEÑA, SI EXISTE UN USUARIO CON AMBOS
	 * REQUISITOS LO RETORNA
	 * @param usuario
	 * @param contrasenia
	 * @return
	 */
	public Cliente iniciarSesion(String usuario, String contrasenia) {
		//RECORREMOS LA LISTA DE LOS CLIENTES
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente aux = listaClientes.get(i);
			//VERIFICAMOS EL CLIENTE DADOS SU USUARIO Y SU CONTRASEÑA
			if(aux != null && aux.verificarCliente(usuario, contrasenia)) {
				return aux; 
			}
		}

		return null; 
	}

	//----------GETTER AND SETTERS--------------------
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	/**
	 * @return the listaSedes
	 */
	public ArrayList<Sede> getListaSedes() {
		return listaSedes;
	}

	/**
	 * @param listaSedes the listaSedes to set
	 */
	public void setListaSedes(ArrayList<Sede> listaSedes) {
		this.listaSedes = listaSedes;
	}

	/**
	 * METODO QUE PERMITE CREAR UNA SEDE
	 * @param ciudadSede
	 * @return
	 */
	public String crearSede(String ciudadSede) {
		String mensaje = "La sede no pudo ser creada"; 
		//VERIFICAMOS SI EN LA CIUDAD HAY MENOS DE 3 SEDES
		if(hayMenos3Sedes(ciudadSede)<3) {
			Sede sedeAux = new Sede(); 
			//CREAMOS UNA SEDE Y LA AGREGAMOS A LA LISTA DE LAS SEDES
			sedeAux.setCiudad(new Ciudad(ciudadSede));
			listaSedes.add(sedeAux); 
			return "Sede creada con éxito"; 
		}else {
			mensaje = "Ya existe 3 sedes de la empresa en esa ciudad"; 
		}

		return mensaje; 
	}
	/**
	 * METODO QUE PERMITE VERIFICAR SI EN UNA CIUDAD HAY MENOS DE 3 SEDES
	 * @param ciudadSede
	 * @return
	 */
	private int hayMenos3Sedes(String ciudadSede) {
		int contador = 0; 
		//RECORREMOS LA LISTA DE LA SEDES
		for (int i = 0; i < listaSedes.size(); i++) {
			if(listaSedes.get(i).compararCiudad(ciudadSede)) {
				contador++; 
			}
		}
		return contador;
	}

	/**
	 * MÉTODO QUE MUESTRA POR CONSOLA LA CIUDAD Y EL ID DE LAS SEDES CREADAS
	 */
	public void mostrarSedes() {
		//RECORREMOS LA LISTA DE SEDES
		for (int i = 0; i < listaSedes.size(); i++) {
			Sede sede = listaSedes.get(i); 
			//VERIFICAMOS SI LA SEDE ES DIFERENTE DE NULL Y LE ADICIONAMOS LA CIUDAD Y SU ID
			if(sede != null) {
				System.out.print("Ciudad: "+sede.getStrCiudad()+"     "+"Id: "+sede.getIdSede());
				System.out.println();
			}
		}
	}
	/**
	 * MÉTODO QUE PERMITE OBTENER UNA SEDE DADA SU CIUDAD
	 * @param nomSede
	 * @return
	 */
	public Sede obtenerSede(String nomSede) {
		//RECORO LA LISTA DE SEDES
		for (int i = 0; i < listaSedes.size(); i++) {
			if(listaSedes.get(i).compararCiudad(nomSede)) {
				return listaSedes.get(i); 
			}
		}
		return null;
	}
	/**
	 * MÉTODO QUE PERMITE ELIMINAR UNA SEDE DADA SU CIUDAD
	 * @param ciudad
	 * @return
	 */
	public String eliminarSede(String ciudad) {
		for (int i = 0; i < listaSedes.size(); i++) {
			//VERIFICO SI ES LA MISMA CIUDAD
			if(listaSedes.get(i).compararCiudad(ciudad)) {
				listaSedes.remove(i); 
				return "La sede se ha eliminado correctamente"; 
			}
		}
		return "La sede no se ha podido eliminar";
	}
	/**
	 * MÉTODO QUE PERMITE ACTUALIZAR UNA SEDE DADA LA CIUDAD
	 * @param ciudad
	 * @return
	 */
	public String actualizarSede(String ciudad) {
		
		String[] arreglo = ciudad.split(" "); 
		//RECORREMOS LA LISTA DE LAS SEDES
		for (int i = 0; i < listaSedes.size(); i++) {
			if(listaSedes.get(i).compararCiudad(arreglo[0])) {
				listaSedes.get(i).setNombreCiudad(arreglo[1]); 
				return "Se ha actualizado la ciudad correctamente"; 
			}
		}

		return "No se ha podido actualizar la ciudad";
	}
	/**
	 * METODO QUE PERMITE BUSCAR UNA SEDE DADA LA CIUDAD
	 * @param ciudad
	 * @return
	 */
	public Sede buscarSede(String ciudad) {
		//RECORREMOS LA LISTA DE LAS SEDES
		for (int i = 0; i < listaSedes.size(); i++) {
			//VERIFICAMOS SI LA SEDE ESTA EN UNA CIUDAD Y LA RETORNAMOS
			if(listaSedes.get(i).compararCiudad(ciudad)) {
				return listaSedes.get(i); 
			}
		}

		return null;
	}

	/**
	 * METODO QUE PERMITE SUSTITUIR UNA SEDE POR OTRA
	 * @param cadena
	 * @return
	 */
	public String sustituirSede(String cadena) {
		String arreglo[] = cadena.split(" "); 
		//VERIFICAMOS SI HAY MENOS DE 3 SEDES
		if(hayMenos3Sedes(arreglo[1])<3) {
			//RECORREMOS LA LISTA DE LAS SEDES
			for (int i = 0; i < listaSedes.size(); i++) {
				//VERIFICAMOS SI LA SEDE ESTA EN UNA MISMA CIUDAD
				if(listaSedes.get(i).compararCiudad(arreglo[0])) {
					listaSedes.remove(listaSedes.get(i));
					Sede sede = new Sede();
					Ciudad ciudad = new Ciudad(arreglo[1]); 
					sede.setCiudad(ciudad);
					listaSedes.add(sede); 
					return "La sede se ha sustituido correctamente";
				}
			}
		}
		return "No se ha podido sustiur la sede";
	}
	/**
	 * METODO QUE PERMITE VERIFICAR UN ADMIN DADO SU CONTRASEÑA Y SU USUARIO
	 * @param contrasenia
	 * @param usuario
	 * @return
	 */
	public boolean verificarAdmin(String contrasenia, String usuario) {
		//RECORREMOS LA LISTA DE LOS ADMINS
		for (int i = 0; i < listaAdmins.size(); i++) {
			//VERIFICAMOS SI EL ADMIN ES EQUIVALENTE A LA CONTRASEÑA Y USUARIO
			if(listaAdmins.get(i).verificarAdmin(contrasenia,usuario)) {
				return true; 
			}
		}

		return false;
	}
	/**
	 * METODO QUE PERMITE OBTENER UNA LISTA DEL TIPO DE PRODUCTO DADO SU TIPO
	 * @param tipo
	 * @return
	 */
	public ArrayList<Object> obtenerListaTipoProducto(TipoProducto tipo) {
		ArrayList<Object> productos = new ArrayList<>(0); 
		//RECORREMOS LA LISTA DE PRODUCTOS
		for (int i = 0; i < listaProductos.size(); i++) {
			//VERIFICAMOS SI EL PRODUCTO EQUIVALE AL TIPO 
			if(listaProductos.get(i).compararTipoProducto(tipo)) {
				Object producto = (Object) listaProductos.get(i); 
				productos.add(producto); 
			}
		}
		return productos;
	}
	/**
	 * METODO QUE PERMITE OBTENER LOS EMPLEADOS DADO SU LISTA
	 * @return
	 */
	public ArrayList<Object> obtenerEmpleados() {
		ArrayList<Object> lista = new ArrayList<>();
		//RECORREMOS LA LISTA DE LOS EMPLEADOS Y LOS AGREGAMOS
		for (int i = 0; i <listaEmpleados.size(); i++) {
			lista.add(listaEmpleados.get(i)); 
		}
		for (int i = 0; i < listaAdmins.size(); i++) {
			lista.add(listaAdmins.get(i));
		}

		return lista; 
	}
	/**
	 * METODO QUE PERMITE CREAR UN PRODUCTO DADOS SUS PARAMETROS
	 * @param nomProd
	 * @param descripcion
	 * @param precio
	 * @param cantidadDisponible
	 * @param tipoProductoGlobal
	 * @return
	 */
	public String crearProducto(String nomProd, String descripcion, double precio, int cantidadDisponible,
			TipoProducto tipoProductoGlobal) {

		String mensaje = "El producto ya existe"; 
		boolean existeProd = false; 
		//CREAMOS EL PRODUCTO
		Producto prodAux = new Producto(nomProd, descripcion, precio, cantidadDisponible, tipoProductoGlobal); 
		//RECORREMOS LA LISTA DE PRODUCTOS
		for (int i = 0; i < listaProductos.size(); i++) {
			if(listaProductos.get(i).equals(prodAux)) {
				existeProd = true; 
			}
		}

		if(!existeProd) {
			listaProductos.add(prodAux);
			mensaje = "El producto fue creado satisfactoriamente"; 
		}

		return mensaje;
	}

		/**
		 * METODO QUE PERMITE REEMPLAZAR UN PRODUCTO
		 * @param productoReemplazar
		 * @param productoNuevo
		 * @return
		 */
	public String reemplazarProducto(Producto productoReemplazar, Producto productoNuevo) {
		String mensaje ="No se ha podido reemplazar el producto";
		//RECORREMOS LA LISTA
		for (int i = 0; i < listaProductos.size(); i++) {
			//VERIFICAMOS SI EL PRODUCTO EQUIVALE AL PRODUCTO A REEMPLAZAR, LO ELIMINAMOS
			//Y ADICCIONAMOS EL PRODUCTO QUE EL CLIENTE DESEA
			if(listaProductos.get(i).equals(productoReemplazar)) {
				listaProductos.remove(productoReemplazar); 
				listaProductos.add(productoNuevo); 
				mensaje ="El producto se ha sustituido correctamente"; 
			}
		}

		return mensaje;
	}
	
	/**
	 * METODO QUE PERMITE ACTUALIZAR LOS ATRIBUTOS DEL PRODUCTO DADOS SUS PARAMETROS
	 * @param productoActualizar
	 * @param nomProd
	 * @param descripcion
	 * @param precio
	 * @param cantidadDisponible
	 * @return
	 */
	public String actualizarAtributosProducto(Producto productoActualizar, String nomProd, String descripcion,
			double precio, int cantidadDisponible) {

		String mensaje = "El producto no pudo ser actualizado"; 
		
		//RECORREMOS LA LISTA DE PRODUCTOS
		for (int i = 0; i < listaProductos.size(); i++) {
			//VERIFICAMOS SI EL PRODUCTO EQUIVALE AL PRODUCTO QUE SE DEA ACTUALIZAR Y LE
			//SETTEAMOS SUS PARAMETROS
			if(listaProductos.get(i).equals(productoActualizar)) {
				Producto prodAux = listaProductos.get(i);
				prodAux.setNombre(nomProd);
				prodAux.setDescripcion(descripcion);
				prodAux.setPrecio(precio);
				prodAux.setCantDisponible(cantidadDisponible);
				mensaje = "El producto se actualizó correctamente"; 
			}
		}

		return mensaje;
	}
	/**
	 * METODO QUE PERMITE ELIMINAR UN PRODUCTO
	 * @param prodEliminar
	 * @return
	 */
	public String eliminarProducto(Producto prodEliminar) {
		String mensaje ="El producto no se ha podido eliminar";
		//RECORREMOS LA LISTA DE PRODUCTOS
		for (int i = 0; i <listaProductos.size(); i++) {
			Producto prod = listaProductos.get(i);
			//VERIFICAMOS SI EL PRODUCTO EQUIVALE AL PRODUCTO QUE SE DESEA ELIMINAR 
			//Y LO ELIMINAMOS
			if(prod.equals(prodEliminar)) {
				listaProductos.remove(prod);
				mensaje = "El producto se elimino correctamente";
			}
		}

		return mensaje;
	}
	
	/**
	 * METODO QUE PERMITE OBTENER UN STRING DE SEDES
	 * @return
	 */
	public ArrayList<String> obtenerStringSedes() {
		ArrayList<String> sedesString = new ArrayList<String>(0); 
		//RECORREMOS LA LISTA DE LAS SEDES
		for (int i = 0; i < listaSedes.size(); i++) {
			sedesString.add(listaSedes.get(i).getStrCiudad()); 
		}

		return sedesString;
	}
	/**
	 * METODO QUE PERMITE CREAR UN EMPLEADO EN LA SEDE DADOS SUS PARAMETROS
	 * @param nomEmpleado
	 * @param sueldoEmp
	 * @param sede
	 * @return
	 */
	public String crearEmpleado(String nomEmpleado, double sueldoEmp, String sede) {
		String mensaje = "No se ha podido crear el empleado";
		Sede sedeEmpleado = buscarSede(sede);
		//VERIFICAMOS SI EL EMPLEADO ES DIFERENTE DE NULL Y LO CREAMOS
		if(sedeEmpleado != null) {
			Empleado empleAux = new Empleado(nomEmpleado, sueldoEmp); 
			empleAux.setSede(sedeEmpleado);
			listaEmpleados.add(empleAux); 
			mensaje = "El empleado se creó correctamente"; 
		}

		return mensaje;
	}
	
	/**
	 * METODO QUE PERMITE CREAR UN ADMIN DADOS SUS PARAMETROS
	 * @param nombre2
	 * @param direccion
	 * @param email
	 * @param fechaNacimiento
	 * @param sede
	 * @param usuario
	 * @param password
	 * @param sueldo
	 * @return
	 */

	public String crearAdmin(String nombre2, String direccion, String email, String fechaNacimiento, String sede
			,String usuario, String password, double sueldo) {

		String mensaje = "El administrador no pudo ser creado"; 
		Sede sedeAux = buscarSede(sede);
		//CREAMOS UN ADMIN Y LE SETTEAMOS SUS ATRIBUTOS
		Administrador adminAux = new Administrador(nombre2, direccion, mensaje, fechaNacimiento, sedeAux); 
		adminAux.setUsuario(usuario);
		adminAux.setContrasenia(password);
		adminAux.setSueldo(sueldo);

		if(!existeAdmin(adminAux)) {
			listaAdmins.add(adminAux);
			mensaje = "Administrador creado correctamente"; 
		}else {
			mensaje = "Ya existe un administrador con esas caracteristicas"; 
		}
		return mensaje;
	}
	/**
	 * METODO QUE VERIFICA LA EXITENCIA DE UN ADMIN
	 * @param adminAux
	 * @return
	 */
	private boolean existeAdmin(Administrador adminAux) {
		//RECORREMOS LA LISTA DE LOS ADMINS
		for (int i = 0; i < listaAdmins.size(); i++) {
			//VERIFICAMOS SI EL ADMIN EQUIVALE AL ADMIN QUE DESEAMOS ENCONTRAR
			if (listaAdmins.get(i).equals(adminAux)) {
				return true; 
			}
		}
		return false;
	}
	/**
	 * METODO QUE PERMITE ELIMINAR UN EMPLEADO DADO EL OBJETO
	 * @param empleado
	 * @return
	 */
	public String eliminarEmpleado(Object empleado) {
		String mensaje = "El empleado no pudo ser eliminado"; 

		if(empleado instanceof Empleado) {
			mensaje = eliminarEmpleadoModelo(empleado);
		}else if(empleado instanceof Administrador) {
			mensaje = eliminarAdministrador(empleado); 
		}
		return mensaje;
	}
	
	/**
	 * METODO QUE PERMITE ELIMINAR UN ADMIN 
	 * @param empleado
	 * @return
	 */
	private String eliminarAdministrador(Object empleado) {
		Administrador admin = (Administrador) empleado; 
		//RECORREMOS LA LISTA DE LOS ADMINS
		for (int i = 0; i < listaAdmins.size(); i++) {
			//VERIFICAMOS SI EL ADMIN EQUIVALE AL ADMIN QUE DESEAMOS ELIMINAR
			if(listaAdmins.get(i).equals(admin)) {
				listaAdmins.remove(i); 
			}
		}
		return "El administrador se eliminó correctamente";
	}
	/**
	 * METODO QUE PERMITE ELIMINAR UN EMPLEADO
	 * @param empleado
	 * @return
	 */
	private String eliminarEmpleadoModelo(Object empleado) {
		//CREAMOS EL EMPLEADO
		Empleado emplAux = (Empleado) empleado;
		//RECORREMOS LA LISTA DE EMPLEADOS
		for (int i = 0; i < listaEmpleados.size(); i++) {
			//VERIFICAMOS SI EL EMPLEADO EQUIVALE AL EMPLEADO QUE DESEAMOS ELIMINAR
			if(listaEmpleados.get(i).equals(emplAux)) {
				listaEmpleados.remove(i); 
			}
		}
		return "El empleado se eliminó correctamente";
	}
	
	/**
	 * METODO QUE PERMITE ACTUALIZAR UN ADMIN DADO SUS PARAMETROS
	 * @param admin
	 * @param nombre2
	 * @param direccion
	 * @param email
	 * @param fechaNacimiento
	 * @param sede
	 * @param usuario
	 * @param password
	 * @param sueldo
	 * @return
	 */
	public String actualizarAdmin(Administrador admin, String nombre2, String direccion, String email,
			String fechaNacimiento, String sede, String usuario, String password, double sueldo) {
		//SETTEAMOS LOS ATRIBUTOS DEL ADMIN
		admin.setNombre(nombre2);
		admin.setDireccion(direccion);
		admin.setCorreo(email);
		admin.setFechaNacimiento(fechaNacimiento);
		//CREAMOS UN ADMIN EN SEDE Y LE SEDEAMOS SU USUARIO,PASSWORD Y SUELDO
		Sede sedeAux = buscarSede(sede); 
		admin.setSede(sedeAux);
		admin.setUsuario(usuario);
		admin.setContrasenia(password);
		admin.setSueldo(sueldo);

		return "El administrador se actualizó adecuadamente";
	}
	/**
	 * METODO QUE PERMITE ACTUALIZAR UN EMPLEADO DADO SUS PARAMETROS
	 * @param empl
	 * @param nom
	 * @param sueldo
	 * @param sede
	 * @return
	 */
	public String actualizarEmpleado(Empleado empl, String nom, double sueldo, String sede) {
		//SETTEAMOS LOS ATRIBUTOS DEL EMPLEADO
		empl.setSede(buscarSede(sede));
		empl.setNombre(nom);
		empl.setSueldo(sueldo);

		return "Empleado actualizado satisfactoriamente";
	}
	/**
	 * 
	 * @return the listaProductos
	 */
	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}
	
	/**
	 * METODO QUE PERMITE FILTRAR LOS PRODUCTOS DADOS SU PRECIO Y TIPO
	 * @param precio
	 * @param tipo
	 * @return
	 */
	public ArrayList<Producto> filtrarProductos(int precio, String tipo) {
		ArrayList<Producto> listaFiltrada = new ArrayList<Producto>();
		//CREAMOS EL TIPO DE PRODUCTO
		TipoProducto tipoAux = identificarTipoProd(tipo); 
		int precioAux = precio; 

		listaFiltrada = filtrarProdPrecio(precioAux); 
		listaFiltrada = filtrarProdTipo(listaFiltrada, tipoAux);

		return listaFiltrada;
	}
	/**
	 * METODO QUE PERMITE FILTRAR UN PRODUCTO DADOS SUS PARAMETROS
	 * @param listaFiltrada
	 * @param tipoAux
	 * @return
	 */
	private ArrayList<Producto> filtrarProdTipo(ArrayList<Producto> listaFiltrada, TipoProducto tipoAux) {
		//CREAMOS EL PRODUCTO
		Producto[] aux = new Producto[listaFiltrada.size()]; 
		//RECORREMOS EL ARREGLO DEL PRODUCTO CREADO
		for (int i = 0; i < aux.length; i++) {
			aux[i] = listaFiltrada.get(i); 
		}
		listaFiltrada.clear();

		for (int i = 0; i < aux.length; i++) {

			if(!aux[i].compararTipoProducto(tipoAux)) {
				aux[i] = null; 
			}
		}

		for (int i = 0; i < aux.length; i++) {

			if(aux[i] != null) {
				listaFiltrada.add(aux[i]);
			}
		}

		return listaFiltrada;
	}
	
	/**
	 * METODO QUE FILTRA UN PRODUCTO POR SU PRECIO Y LO RETORNA
	 * @param precioAux
	 * @return
	 */

	private ArrayList<Producto> filtrarProdPrecio(int precioAux) {
		ArrayList<Producto> aux = new ArrayList<Producto>(); 
		//RECORREMOS LA LISTA DE PRODUCTOS 
		for (int i = 0; i < listaProductos.size(); i++) {
			//VERIFICAMOS SI LA LISTA DE PRODUCTOS ES EQUIVALENTE AL PRECIO MENOS Y LO RETORNAMOS
			if(listaProductos.get(i).precioMenorA(precioAux)) {
				aux.add(listaProductos.get(i)); 
			}
		}

		return aux;
	}
	
	/**
	 * METODO QUE IDENTIFICA UN PRODUCTO POR SU TIPO Y LO RETORNA
	 * @param tipo
	 * @return
	 */

	private TipoProducto identificarTipoProd(String tipo) {
		if(tipo.equals("Movil")) return TipoProducto.TECNOLOGIA_MOVIL;
		else if(tipo.equals("Computacional")) return TipoProducto.TECNOLOGIA_COMPUTACIONAL; 
		else if(tipo.equals("Musica"))return TipoProducto.MUSICA; 
		else if(tipo.equals("Hogar")) return TipoProducto.HOGAR;
		else return TipoProducto.EMPRESARIAL; 
	}
	
	/**
	 * METODO QUE FILTRA UN PRODUCTO POR SU TIPO
	 * @param tipo
	 * @return
	 */

	public ArrayList<Producto> filtrarProductosTipo(String tipo) {
		ArrayList<Producto> lista = new ArrayList<Producto>(); 
		TipoProducto tipoAux = identificarTipoProd(tipo);
		//RECORREMOS LA LISTA DE PRODUCTOS
		for (int i = 0; i < listaProductos.size(); i++) {
			//VERIFICAMOS SI LA LISTA DE PRODUCTOS ES IGUAL AL PRODUCTO DESEADO Y LO RETORNAMOS
			if(listaProductos.get(i).compararTipoProducto(tipoAux)) {
				lista.add(listaProductos.get(i)); 
			}
		}

		return lista;
	}
	
	/**
	 * METODO QUE FILTRA LOS PRODUCTOS DADO SU PRECIO
	 * @param precio
	 * @return
	 */
	public ArrayList<Producto> filtrarProductosPrecio(int precio) {
		//CREAMOS LA LISTA PRODUCTOS
		ArrayList<Producto> lista = new ArrayList<Producto>(); 
		//RECORREMOS LA LISTA DE PRODUCTOS
		for (int i = 0; i < listaProductos.size(); i++) {
			//VERIFICAMOS SI EL PRODUCTO DE LA LISTA ES MENOR A UN PRECIO
			if(listaProductos.get(i).precioMenorA(precio)) {
				lista.add(listaProductos.get(i)); 
			}
		}
		return lista;
	}
	
	/**
	 * METODO QUE REDUCE LA CANTIDAD DE UN PRODUCTO QUE ESTE EN EL CARRITO DEL CLIENTE
	 * @param prodCarrito
	 * @param cantidad
	 */

	public void reducirCantidadProducto(Producto prodCarrito, int cantidad) {
		//RECORREMOS LA LISTA DE PRODUCTOS
		for (int i = 0; i < listaProductos.size(); i++) {
			//VERIFICAMOS SI LA LISTA DE LOS PRODUCTOS EQUIVALE AL PRODUCTO Y A LA CANTIDAD DESEADA
			//POR EL CLIENTE
			if(listaProductos.get(i).equals(prodCarrito)) {
				listaProductos.get(i).reducirCantidad(cantidad); 
			}
		}
	}
	/**
	 * METODO QUE OBTIENE LA LISTA DE FACTURAS DE UN CLIENTE
	 * @param cliente
	 * @return
	 */
	public ArrayList<Factura> obtenerListaFactura(Cliente cliente) {
		ArrayList<Factura> aux = null; 
		boolean flag = true; 
		//RECORREMOS LA LISTA DE LOS CLIENTES
		for (int i = 0; i < listaClientes.size() && flag; i++) {
			Cliente clienteAux = listaClientes.get(i); 
			//VERIFICAMOS SI EL CLIENTE AUXILIAR EQUIVALE AL CLIENTE Y LO RETORNAMOS CON SUS 
			//RESPECTIVAS FACTURAS
			if(clienteAux.equals(cliente)) {
				flag = false;
				aux = clienteAux.getListaFacturas(); 
			}
		}
		return aux;
	}
	/**
	 * METODO QUE SUMA PRODUCTOS AL CARRITO DEL CLIENTE
	 * @param prodCarrito
	 */
	public void sumarCantidadStock(DetalleFactura prodCarrito) {

		String nomProd = prodCarrito.getNombre();
		//BUSCAMOS EL PRODUCTO POR SU NOMBRE
		Producto prodAux = buscarProducto(nomProd);
		//AGREGAMOS LA CANTIDAD DEL PRODUCTO QUE EL CLIENTE DESEA
		prodAux.sumarCantidad(prodCarrito.getCantidad()); 


	}
	/**
	 * METODO QUE PERMITE BUSCAR UN PRODUCTO DADO SU NOMBRE
	 * @param nomProd
	 * @return
	 */
	private Producto buscarProducto(String nomProd) {
		//RECORREMOS LA LISTA DE PRODUCTOS
		for (int i = 0; i < listaProductos.size(); i++) {
			//VERIFICAMOS SI EL PRODUCTO EQUIVALE AL NOMBRE DESEADO Y LO RETORNAMOS
			if(listaProductos.get(i).compararNombre(nomProd)) {
				return listaProductos.get(i);
			}

		}
		return null;
	}
	
	/**
	 * METODO QUE PERMITE QUE EL CLIENTE REALIZE LA COMPRA DE SUS PRODUCTOS DADOS LOS PARAMETROS
	 * @param clienteActivo
	 * @param detalles
	 * @param fecha
	 * @param tipoPago
	 * @param sede
	 * @return
	 */

	public String realizarCompra(Cliente clienteActivo, ArrayList<DetalleFactura> detalles, String fecha,  String tipoPago, String sede) {
		//INICIALIZAMOS LA SEDE
		Sede sedeAux = buscarSede(sede); 
		String mensaje ="";
		//CREAMOS UN MENSAJE CON LOS PARAMETROS DE LA FACTURA Y SE RETORNA AL CLIENTE
		mensaje = clienteActivo.hacerFactura(detalles, fecha,tipoPago ,sedeAux); 
		return "La factura se ha generado correctamente"+mensaje;
	}
	
	/**
	 * METODO QUE RETORNA LA LISTA DE LOS CLIENTES
	 * @return
	 */

	public ArrayList<Cliente> obtenerListaClientes() {
		return listaClientes;
	}


	//--------------------------MÉTODOS AUXILIARES DE LA TIENDA-----------------

	public String obtenerProdMasVendidos() {
		String mensaje = ""; 
		//creo una matriz que en la primera fila obtendrá los productos 
		//y en la segunda su cantidad de veces en la tienda

		Object[][] prodVeces = new Object[2][3];
		inicializarMatrizProd(prodVeces); 
		//CICLOS QUE BUSCAN LOS TRES PRODUCTOS MAS VENDIDOS
		//BUSCO EL PRIMER PRODUCTO
		for (int i = 0; i < listaProductos.size(); i++) {
			Producto prodAux = listaProductos.get(i); 
			Integer cantAux = obtenerVecesProd(prodAux); 
			cambiarMatrizVecesProd(prodAux, cantAux, prodVeces); 
		}
		//BUSCO EL SEGUNDO PRODUCTO
		for (int i = 0; i < listaProductos.size(); i++) {
			Producto prodAux = listaProductos.get(i); 
			Integer cantAux = obtenerVecesProd(prodAux); 
			cambiarMatrizVecesProd(prodAux, cantAux, prodVeces); 
		}
		//BUSCO EL TERCER PRODUCTO
		for (int i = 0; i < listaProductos.size(); i++) {
			Producto prodAux = listaProductos.get(i); 
			Integer cantAux = obtenerVecesProd(prodAux); 
			cambiarMatrizVecesProd(prodAux, cantAux, prodVeces); 
		}
		//OBTENGO LOS PRODUCTOS DE LA MATRIZ AUXILIAR
		Producto prod1 = (Producto) prodVeces[0][0]; 
		Producto prod2 = (Producto) prodVeces[0][1]; 
		Producto prod3 = (Producto) prodVeces[0][2];
		//OBTENGO LOS NOMBRES DE LOS PRODUCTOS MAS VENDIDOS
		if(prod1 != null) mensaje += "El producto mas vendido "+prod1.getNombre()+"\n";
		if(prod2 != null) mensaje += "El segundo producto mas vendido "+prod2.getNombre()+"\n";
		if(prod3 != null) mensaje += "El tercer producto mas vendido "+prod3.getNombre()+"\n";
		
		return mensaje; 
	}


	/**
	 * METODO QUE CAMBIA LA MATRIZ DE LOS PRODUCTOS DEPENDIENDO DE SU VALOR Y CANTIDAD
	 * @param prodAux
	 * @param cantAux
	 * @param prodVeces
	 */
	private void cambiarMatrizVecesProd(Producto prodAux, Integer cantAux, Object[][] prodVeces) {
		//RECORREMOS LA MATRIZ
		for (int i = 0; i < 3; i++) {
			
			Integer cantMatriz = (Integer) prodVeces[1][i];
			//VERIFICAMOS SI LA MATRIZ EQUIVALE A UN VALOR U A OTRO
			if( !estaMatriz(prodVeces, prodAux) && cantAux.intValue() > cantMatriz.intValue()) {
				prodVeces[0][i] =prodAux; 
				prodVeces[1][i] = cantAux; 
			}
			
		}
	}
	/**
	 * METODO QUE VERIFICA Y RECORRE LA MATRIZ DEL PRODUCTO Y RETORNA UN VALOR BOOLEAN
	 * @param prodVeces
	 * @param prodAux
	 * @return
	 */
	private boolean estaMatriz(Object[][] prodVeces, Producto prodAux) {
		//RECORREMOS LA MATRIZ 
		for (int i = 0; i < 3; i++) {
			Producto prod = (Producto)prodVeces[0][i]; 
			//VERIFICAMOS SI EL PRODUCTO AUXILIAR EQUIVALE AL PRODUCTO DE LA MATRIZ
			if(prodAux.equals(prod)) {
				return true; 
			}
		}
		
		return false;
	}
	
	/**
	 * ESTE METODO VERIFICA SI EL PRODUCTO QUE VERIFICA SI EL PRODUCTO ES  DIFERENTE NULL
	 * SI CUMPLE LA CONDICION ENTRA AL METODO PARA OBTENER LA FECHA MAS VENDIDA 
	 * DE DICHO PRODUCTO
	 * @param producto
	 * @return
	 */
	public String obtenerMasFechaProductoVendidos(Producto producto) {
		//INICIALIZAMOS EL ARRAYLIST DE LAS FECHAS DE FACTURA
		ArrayList<String> fechasFacturas = new ArrayList<String>(); 
		String fechaFinal = ""; 
		int cant = 0, cantAux = 0; 
		//RECORREMOS LA LISTA DE LOS CLIENTES
		for (int i = 0; i < listaClientes.size(); i++) {
			fechasFacturas.addAll(listaClientes.get(i).obtenerFechasFacturas()); 
		}
		//RECORREMOS LA LISTA DE LAS FECHAS FACTURA
		for (int i = 0; i < fechasFacturas.size(); i++) {
			
			String fechaAux = fechasFacturas.get(i); 
			
			for (int j = 0; j < listaClientes.size(); j++) {
				cantAux += listaClientes.get(i).obtenerVecesProd(producto, fechaAux); 
			}
			//VERIFICAMOS SI LA CANTIDAD AUXILIAR ES MAYOR A LA CANTIDAD
			if(cantAux> cant) {
				cant = cantAux; 
				fechaFinal= fechaAux; 
			}

		}
		if(fechaFinal.isEmpty()) return "El producto no se ha vendido aún"; 
		else return "La fecha en que mas se vendió fue: "+fechaFinal;
	}

	/**
	 * Método que recibe un producto como parametro y devuelve cuantas veces se ha comprado
	 * @param prodAux
	 * @return
	 */
	private Integer obtenerVecesProd(Producto prodAux) {
		Integer vecesProd = 0;
		//RECORRO LOS CLIENTES PARA BUSCAR EN SUS FACTURAS CUANTAS VECES 
		//COMPRÓ ESTE PRODUCTO
		for (int i = 0; i < listaClientes.size(); i++) {
			//OBTENGO EL CLIENTE DE LA ITERACIÓN
			Cliente clienteAux = listaClientes.get(i);
			//OBTENGO LAS VECES QUE HA COMPRADO EL PRODUCTO
			vecesProd += clienteAux.getVecesCompradasProd(prodAux); 
		}
		return vecesProd;
	}

	/**
	 * MÉTODO QUE INICIALIZA UNA MATRIZ DE OBJETOS EN LA PRIMERA FILA NULL
	 * Y EN LA SEGUNDA CON ENTEROS
	 * @param prodVeces
	 */

	private void inicializarMatrizProd(Object[][] prodVeces) {
		//RECORRO LA MATRIZ 
		for (int i = 0; i < prodVeces[0].length; i++) {
			prodVeces[0][i] = null; 
		}
		for (int i = 0; i < prodVeces[0].length; i++) {
			prodVeces[1][i] = 0; 
		}
	}


	//se busca la informacion del cliente
	public String buscarInfoCliente(int cedula) {
		Cliente aux=null;
		//RECORRO LA LISTA DE LOS CLIENTES
		for(Cliente c: listaClientes) {
			//DETERMINO SI EL CODIGO DEL CLIENTE EQUIVALE A LA CEDULA
			if(c.getCodigoCliente() == cedula) {
				aux = c;
				break;
			}
		}
		return aux.toString();
	}

	//se busca la factura de un cliente
	public String mostrarFacturaCliente(int cedula) {
		Cliente aux=null;
		//RECORRO LA LISTA DE LOS CLIENTES
		for(Cliente c: listaClientes) {
			if(c.getCodigoCliente() == cedula) {
				aux = c;
				break;
			}
		}
		String mensaje="";
		//RECORRO LA LISTA DE LAS FACTURAS
		for(Factura f: aux.getListaFacturas()) {
			mensaje+=f.toString();
		}
		return mensaje;
	}

}
