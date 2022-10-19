package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.application.Main;
import co.edu.uniquindio.model.Administrador;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Empleado;
import co.edu.uniquindio.model.Producto;
import co.edu.uniquindio.model.Sede;
import co.edu.uniquindio.model.Singleton;
import co.edu.uniquindio.model.TipoProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class paneAdminController{


	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> cmbBoxRolEmpleado = new ComboBox<String>(); 

	@FXML
	private ComboBox<String> comBoxSedeEmple = new ComboBox<String>(); 

	@FXML
	private Button btnComputacional= new Button();

	@FXML
	private Button btnEmpresarial= new Button();

	@FXML
	private Button btnHogar= new Button();

	@FXML
	private Button btnEmpleado= new Button();

	@FXML
	private Button btnMovil= new Button();

	@FXML
	private Button btnSedes= new Button();

	@FXML
	private Button btnMusica= new Button();

	@FXML
	private Button btnPerfil= new Button();

	@FXML
	private Button btnClientes= new Button();

	@FXML
	private Button btnCrearEmpleado= new Button();

	@FXML
	private Button btnEliminarEmpleado= new Button();

	@FXML
	private Button btnUpdateEmpleado = new Button();

	@FXML
	private Button btnReplaceEmpleado = new Button();

	@FXML
	private Button btnCrearSede = new Button();

	@FXML
	private Button btnReplaceSede= new Button();

	@FXML
	private Button btnUpdateSede= new Button();

	@FXML
	private Button btnDeleteSede= new Button();

	@FXML
	private Button btnSignOut= new Button();

	@FXML
	private Button btnCrearProd= new Button();

	@FXML
	private Button btnReplaceProd= new Button();

	@FXML
	private Button btnUpdateProd= new Button();

	@FXML
	private Button btnDeleteProd= new Button();

	@FXML
	private Button btnClienteMasCompras= new Button();

	@FXML
	private Button btnReporteFacturasPeriodo= new Button();

	@FXML
	private Button btnVerFacturasCliente= new Button();

	@FXML
	private Button btnBuscarInfoCliente= new Button();

	@FXML
	private Button btnFechaProdMasVendidos= new Button();

	@FXML
	private Button btnProdMasVendidos= new Button();

	@FXML
	private Pane paneComputacional;

	@FXML
	private Pane paneEmpleado;

	@FXML
	private Pane paneSedes = new Pane();

	@FXML
	private TableView<Object> tblGlobalProductos = new TableView<Object>();

	@FXML
	private TableView<Object> tblSedes = new TableView<Object>();

	@FXML
	private TableView<Object> tblEmpleados = new TableView<Object>();

	@FXML
	private TableView<Cliente> tblClientes = new TableView<Cliente>();

	@FXML
	private Pane paneEmpresarial;

	@FXML
	private Pane paneClientes;

	@FXML
	private Pane paneHogar;

	@FXML
	private Pane paneMovil;

	@FXML
	private Pane paneMusica;

	@FXML
	private HBox HboxTextFields = new HBox();

	@FXML
	private HBox HboxButtons = new HBox();

	@FXML
	private TextField txtNombreProducto = new TextField(); 

	@FXML
	private TextField txtDescripcionProd = new TextField();

	@FXML
	private TextField txtNomEmpleado = new TextField(); 

	@FXML
	private TextField txtSueldoEmpleado = new TextField();

	@FXML
	private TextField txtCiudadSede = new TextField(); 

	@FXML
	private TextField txtPrecioProd = new TextField(); 

	@FXML
	private TextField txtCantProdDisponible = new TextField(); 

	@FXML
	private TableColumn<Object, String> columna1 = new TableColumn<Object, String>();

	@FXML
	private TableColumn<Object, Integer> columna2= new TableColumn<Object, Integer>();

	@FXML
	private TableColumn<Cliente, String> colNomCliente = new TableColumn<Cliente, String>();

	@FXML
	private TableColumn<Cliente, Integer> colIDCliente= new TableColumn<Cliente, Integer>();

	@FXML
	private TableColumn<Object, Integer> columna3 = new TableColumn<Object, Integer>();

	@FXML
	private TableColumn<Object, String> columnaCiudadSede = new TableColumn<Object, String>();

	@FXML
	private TableColumn<Object, String> columnaIDSede= new TableColumn<Object, String>();

	@FXML
	private TableColumn<Object, String> ColumnaNomEmpleado = new TableColumn<Object, String>();

	@FXML
	private TableColumn<Object, String> columnaCodEmpleado= new TableColumn<Object, String>();

	private static String nomSede = ""; 

	private Stage stage = new Stage(); 

	private double x, y = 0;

	private Sede sedeSeleccionada; 

	private String[] roles = {"Administrador", "Empleado"}; 

	private TipoProducto tipoProductoGlobal = TipoProducto.TECNOLOGIA_MOVIL; 

	ObservableList<Object> listaObservableProductos = FXCollections.observableArrayList();
	ObservableList<Object> listaObservableEmpleados = FXCollections.observableArrayList();
	ObservableList<Object> listaObservableSedes = FXCollections.observableArrayList();
	ObservableList<String> listaObservableSedesString = FXCollections.observableArrayList();
	ObservableList<Cliente> listaObservableCliente = FXCollections.observableArrayList(); 

	public ObservableList<Object> getListaSedesData() {

		listaObservableProductos.addAll(Singleton.obtenerSedes());
		return listaObservableProductos;
	}

	/**
	 * METODO QUE PERMITE CARGAR LAS TABLAS DE LOS TIPOS DE PRODUCTO EN LA VIEW DEL ADMIN
	 * @param i
	 */
	public void cargarTablas(int i ) {

		if(i==0) {
			actualizarProductosTabla(TipoProducto.TECNOLOGIA_MOVIL);
		}else if(i==1) {
			actualizarProductosTabla(TipoProducto.TECNOLOGIA_COMPUTACIONAL);
		}else if(i==2) {
			actualizarProductosTabla(TipoProducto.MUSICA);
		}else if(i==3) {
			actualizarProductosTabla(TipoProducto.HOGAR);
		}else if(i==4) {
			actualizarProductosTabla(TipoProducto.EMPRESARIAL);
		}else if(i==5) {
			tblEmpleados.getItems().clear();
			listaObservableEmpleados.clear();
			cargarDatosLista(listaObservableEmpleados);
			tblEmpleados.setItems(listaObservableEmpleados);
			tblEmpleados.refresh();
		}else if(i==6) {
			tblSedes.getItems().clear();
			listaObservableSedes.clear();
			cargarDatosLista(listaObservableSedes); 
			cargarDatosSedeString(); 
			tblSedes.setItems(listaObservableSedes);
			tblSedes.refresh();
		}else if(i==7) {
			tblClientes.getItems().clear();
			listaObservableCliente.clear();
			listaObservableCliente.addAll(Singleton.obtenerListaClientes());
			tblClientes.setItems(listaObservableCliente);
			tblClientes.refresh();
		}

	}

	/**
	 * MEOTOD QUE PERMITE CARGAR LOS DATOS QUEMADOS QUE SE ENCUENTRAN
	 * EN LA TIENDA
	 */
	private void cargarDatosSedeString() {
		listaObservableSedesString.clear();///LIMPIAMOS LA LISTAOBSERVABLE
		//SE OBTIENE LOS METODOS SEL SINGELTON Y SE GUARDAN EL LA LISTAOBSERVABLE
		listaObservableSedesString.addAll(Singleton.obtenerStringSedes()); 
	}

	/**
	 * METODO QUE PERMITE ACTUALIZAR LOS PRODUCTOS DE LA TABLA SEGUN 
	 * EL TIPO DE PRODUCTO QUE SEA
	 * @param tipo
	 */
	private void actualizarProductosTabla(TipoProducto tipo) {
		tblGlobalProductos.getItems().clear();//LIMPIAMOS LA TABLA GLOBLA DE PORDUCTOS
		listaObservableProductos.clear();//LIMPIAMOS LA LISTA 
		cargarDatosLista(tipo);//CARGAMOS LOS DATOS A LA LISTA, DEPENDIENDO DEL TIPO ELEGIDO
		tblGlobalProductos.setItems(listaObservableProductos);//CARGAMOS LA LISTA ACTUALIZADA 
		tblGlobalProductos.refresh();//REFRESCAMOS LA LISTA TABLA PARA QUE APAREZCA LOS PRODUCTOS DEPENDEINTO DEL TIPO
	}

	/**
	 * ESTA ACCION DE CRUD NOS PEMITE HACEDER A UN METODO DEPENDIENDO DEL
	 * BOTO QUE ELIJAMOS. LOS CUALES SON PARA CREAR EL PRODUCTO - 
	 * ELIMINAR EL PORDUCTO - ACTUALIZAR EL PRODCUTO - REMPLAZAR EL PORDUCTO
	 * @param e
	 */
	public void actionsProductos(ActionEvent e) {

		if(e.getSource() == btnCrearProd) {
			crearProducto(); 
		}else if(e.getSource() == btnDeleteProd) {
			eliminarProducto(); 
		}else if(e.getSource() == btnUpdateProd) {
			actualizarProducto(); 
		}else if(e.getSource() == btnReplaceProd) {
			reemplazarProducto(); 
		}
	}

	/**
	 * ESTA ACCION DE CRUD NOS PEMITE HACEDER A UN METODO DEPENDIENDO DEL
	 * BOTO QUE ELIJAMOS. LOS CUALES SON PARA CREAR EL SEDE - 
	 * ELIMINAR LA SEDE - ACTUALIZAR LA SEDE - REMPLAZAR SEDE
	 * @param e
	 */
	public void actionsSedes(ActionEvent e) {
		if(e.getSource() == btnCrearSede) {
			crearSede(); 
		}else if(e.getSource() == btnReplaceSede) {
			reemplazarSede(); 
		}else if(e.getSource() == btnUpdateSede) {
			actualizarSede(); 
		}else if(e.getSource() == btnDeleteSede) {
			borrarSede(); 
		}
	}

	/**
	 * ESTA ACCION DE CRUD NOS PEMITE HACEDER A UN METODO DEPENDIENDO DEL
	 * BOTO QUE ELIJAMOS. LOS CUALES SON PARA CREAR EL EMPLEADO- 
	 * ELIMINAR EL EMPLEADO - ACTUALIZAR EL EMPLEADO - REMPLAZAR EMPLEADO
	 * @param e
	 */
	public void actionsEmpleados(ActionEvent e) {
		if(e.getSource() == btnCrearEmpleado) {
			crearEmpleado(); 
		}else if(e.getSource() == btnEliminarEmpleado) {
			eliminarEmpleado(); 
		}else if(e.getSource() == btnUpdateEmpleado) {
			actualizarEmpleado(); 
		}else if(e.getSource() == btnReplaceEmpleado) {
			//replaceEmpleado(); 
		}
	}

	/**
	 * ESTA ACCION NOS PEMITE HACEDER A UN METODO DEPENDIENDO DEL
	 * BOTO QUE ELIJAMOS. LOS CUALES SON PARA VER CLIENTES CON MAS COMPRAS - 
	 * GENERAR EL REPORTE FACTURA - MOSTRAR FACTURA DE UN CLIENTE - 
	 * MOSTRAR INFOMRACION DE UN CLIENTE - OBTENER FECHA DE UN PRODUCTO MAS VENDIDO -
	 * Y OBTENER LOS TRES PODCUTOS MAS COMPRADOS DE UNA FACTURA DE UN CLIENTE
	 * @param e
	 */
	public void actionsCliente(ActionEvent e) {

		if(e.getSource() == btnClienteMasCompras) {
			verClienteMasCompras(); 
		}else if(e.getSource() == btnReporteFacturasPeriodo) {
			generarReporteFacturas(); 
		}else if(e.getSource() == btnVerFacturasCliente) {
			mostrarFacturasCliente(0); 
		}else if(e.getSource() == btnBuscarInfoCliente) {
			buscarInfoCliente(0); 
		}else if(e.getSource() == btnFechaProdMasVendidos) {
			obtenerFechaMasProductosVendidos(); 
		}else if(e.getSource() == btnProdMasVendidos) {
			obtenerProdMasVendidos(); 
		}
	}

	/**
	 * ESTE METODO NOS DA LOS TRES PORDUCTOS MAS VENDIDO, EL CUAL SE
	 * MOSRTRARA POR UNA VENTANA
	 */
	private void obtenerProdMasVendidos() {
		String mensaje = Singleton.obtenerTresProdMasVendidos();//OBTENEMOS LOS TRES PORDUCTOS MAS VENDIDOS POR EL SINGLETON 
		Main.abrirAlerta(mensaje);
	}

	/**
	 * ESTE METODO NOS MOSTRARA EL PRODUCTO MAS VENDIDO EN UNA FECHA
	 */
	private void obtenerFechaMasProductosVendidos() {
		//SELECIONAMOS EL PORDUCTO DE LA TABLA
		Producto producto = (Producto) tblGlobalProductos.getSelectionModel().getSelectedItem();
		if(producto != null) {//SI EL PORDUCTO ES DIFERENTE DE NULL
			//PODEMOS OBTENER LA FECHA EN LA CUAL MAS SE VENDIO ESE PRODUCTO PPOR MEDIO DEL SINGLETON
			String mensaje = Singleton.obtenerMasFechaProductosVendidos(producto);
			Main.abrirAlerta(mensaje);
		}else {//SI NO SE SELECCIONO UN PRODUCTO DE LA TABLA ENTONCES APARECERA UNA ALERTA 
			Main.abrirAlerta("Seleccione un producto de la tabla");//EL CUAL DICE QUE SELLECIONE UN PRODUCTO
		}
	}

	/**
	 * CON EL METODO PODREMOS BUSCAR LA INFORMACION DE UN CLIENTE EN ESPECIFICO
	 * @param cedula
	 */
	private void buscarInfoCliente(int cedula) {
		String mensaje = Singleton.buscarInfoCliente(cedula);//SE OBTENDRA LA INFOTMACION DEL CLIENTE POR MEDIO DEL SINGLETON
		Main.abrirAlerta(mensaje);

		System.out.println("La información del cliente es");
	}

	/**
	 * SE MOSTRARA LA FACTURA DE UN CLIENTE EN ESPECIFICO
	 * @param cedula
	 */
	private void mostrarFacturasCliente(int cedula) {
		String mensaje = Singleton.mostrarFacturaCliente(cedula);
		Main.abrirAlerta(mensaje);
		System.out.println("Las facturas del cliente");
	}

	private void generarReporteFacturas() {

		System.out.println("Los reportes son");
	}

	private void verClienteMasCompras() {
		System.out.println("El cliente con mas compras");
	}

	//private void replaceEmpleado() {
	//}

	/**
	 * CON ESTE METODO PODEMOS ACTUALIZAR LA IMPORMACION DE UN EMPLEADO
	 * ELIGINEDOLO DESDE LA TABLA PAR ACAMBIARLE LO QUE SE NECESITA
	 */
	private void actualizarEmpleado() {
		Object empleado = tblEmpleados.getSelectionModel().getSelectedItem();//LO SELECCIONAMOS DESDE LA TABLA 

		if(empleado != null) {//SI EL EMPLEADO ES DIFERENTE DE NULL PODEMOS ENTRAR AL OTRO IF EL CUAL ES
			if(empleado instanceof Administrador) {//DONDE EL EMPLEADO SERA INSTANCIADO POR EL ADMINISTRADOR

				Administrador admin = (Administrador) empleado;//DONDE ADMIN PUEDE MANEJAR LA INFO DEL EMPLEADO
				Singleton.setAdmin(admin);//SE LLAMA LA INFORMACION DEL EMPLEADO PARAMODIFICAR
				UpdateAdminController updateAdmin = new UpdateAdminController();
				updateAdmin.mostrarFrame();
				// LLAMAMOS A LA TABLA 5 QUE ACTUALIZA EL TIPO EMPRESARIAL DONDE VA ADMIN Y EL ADMIN MANEJA LA INFO DEL CLIENTE
				cargarTablas(5);
				limpiarCamposTexto();
			//SI NO ENTONCES INSTANCIAMOS EMPLEADO DE EMPLEADO PARA MODIFICARLO EL MISMO CON LOS DATOS
			}else if(empleado instanceof Empleado) {
				Empleado empl = (Empleado) empleado;
				double sueldo = 0; 
				String nom = txtNomEmpleado.getText(); 
				try {
					sueldo = Double.parseDouble(txtSueldoEmpleado.getText()); 
				}catch(Exception e) {
					Main.abrirAlerta("Ingrese datos númericos, tonto");
				}
				if(!nom.isEmpty() && sueldo != 0 && comBoxSedeEmple.getValue() != null) {

					String respuesta = Singleton.actualizarEmpleado(empl, nom, sueldo, comBoxSedeEmple.getValue() );
					Main.abrirAlerta(respuesta);
					cargarTablas(5);
					limpiarCamposTexto();
				}else {//SI QUIERE MODIFICAR AL EMPLEADO Y NO LO HACE CORRECTAMENTE 
					//LE APARECERA UNA ADVERTENCIA, LO CUAL DICE
					Main.abrirAlerta("Para actualizar al empleado debe escribir sus atributos en los campos de texto");
				}
			}
		}else {//SI NO SALE LA ALERTA DICIENDO QUE SE DEBE SELECCIONAR UN EMPLEADOS EN LA TABLA, PORQUE NO ESTA SELECCIONADO
			Main.abrirAlerta("Seleccione un empleado de la tabla");
		}
	}

	/**
	 * CON ESTE METODO PODREMOS ELIMINAR EL EMPLEADO QUE SE REQUIERA ELIMINAR
	 */
	private void eliminarEmpleado() {
		
		// SE DEBE SELECIONAR EL EMPLEADO POR MEDIO DE LA TABLA
		Object empleado = tblEmpleados.getSelectionModel().getSelectedItem(); 
		if(empleado != null) {//VERIFICAMOS QUE EMPLEADO NO SEA NULL
			String respuesta = Singleton.eliminarEmpleado(empleado);
			cargarTablas(5);//VAMOS A LA TABLA 5, LA CUAL ES LA EMPRESARIAL
			Main.abrirAlerta(respuesta);//MOSTRAMOS LA RESPUESTA

		}else {//SI NO SELECCIONO AL EMPLEADO DE LA TABLA, LA TIENDA LE PEDIRA....
			Main.abrirAlerta("Seleccione un empleado de la tabla");//QUE POR FAVOR SELECCIONE UN EMPLEADO
		}

	}

	/**
	 * CON ESTE METODO PODEMOS CREAR AL EMPLEADO SI NO EXISTE
	 * Y SE LE PASAN LOS DATOS DEL EMPLEADO QUE VAMOS A METER
	 */
	private void crearEmpleado() {

		if(verificarInfoEmpleado()) {//VERIFICAMOS QUE LA INFO EMPLEADOS ESTE VACIA PARA AGREGAR INFO
			
			//LAS 4 LINEAS SIGUIENTES ES PARA LLENAR LA INFORMACION DEL EMPLEADO
			String nomEmpleado = txtNomEmpleado.getText(); 
			double sueldoEmp = Double.parseDouble(txtSueldoEmpleado.getText()); 
			String rol = cmbBoxRolEmpleado.getValue(); 
			String sede = comBoxSedeEmple.getValue(); 

			if(rol.equals("Administrador")) {//SI TIENE UN ROLL IGUAL A ADMINISTRADOR
				CreateAdminController createAdmin = new CreateAdminController(); //LO CREAMOS COMO UN ADMINISTRADOR
				createAdmin.mostrarFrame();//MOSTRAMOS LOS OTROS CAMPOS QUE DEBE LLENAR PARA SER ADMIN
				limpiarCamposTextoEmpleado(); 
			}else {//SI NO ENTONCES SOLO PEDIMOS AL SINGLETON LOS ATRIBUTOS PARA QUE LLENE COMO EMPLEADO
				String respuesta = Singleton.crearEmpleado(nomEmpleado, sueldoEmp, sede);
				Main.abrirAlerta(respuesta);
				limpiarCamposTextoEmpleado(); 
			}
			cargarTablas(5);//VAMOS A LA TABLA 5, LA CUAL ES DONDE SE MANEJA EL TIPO EMPRESARIAL 
		}else {
			Main.abrirAlerta("Ingrese información correcta");
		}
	}

	/**
	 * EN EL MOMENTO QUE SE NECESITE LIMPIAR LOS ESPACIOS
	 * DE CADA TEXTO SOLO ES LLAR A ESTE METODO, QUE ESTA EN 
	 * VARIOS METOS Y NOS AYUDA A LIMPIAR LOS ESPACIOS
	 */
	private void limpiarCamposTextoEmpleado() {
		txtNomEmpleado.setText("");
		txtSueldoEmpleado.setText("");
		cmbBoxRolEmpleado.setValue(null);
		comBoxSedeEmple.setValue(null);
	}

	/**
	 * ESTE METODO AYUDA A VERIFICAR SI LA INFORMACION QUE SE
	 * LE ESTA INTRODUCCIENDO A EMPLEADO ESTA CORRECTA, QUE SI
	 * INCERTA EN UN CAMPO DE TEXTO ALGO ERRONEO NO LO DEJE SEGUIR
	 * @return
	 */
	private boolean verificarInfoEmpleado() {
		try {
			String nomEmpleado = txtNomEmpleado.getText();//SE INGRESA EL NOMBRE DEL EMPLEADO
			double sueldoEmp = Double.parseDouble(txtSueldoEmpleado.getText());// SE LE INGRESA EL SUELDO Y SE CONVIERTE EN DOUBLE
			String rol = cmbBoxRolEmpleado.getValue();//SE LE PASA EL ROL QUE VA A DESEMPEÑAR
			String sede = comBoxSedeEmple.getValue();//SE LE PASA LA SEDE EN LA CULA VA A TRABAJAR
			if(sede != null && rol != null && sueldoEmp != 0 && !nomEmpleado.isEmpty()) {//VERIFICAMOS QUE SEA DIFERENTE DE NULL
				return true;//SI CUMPLE CONDICION RETORNA UN TRUE
			}
		}catch(Exception e){
			limpiarCamposTextoEmpleado();//PARA LIMPIAR LOS CAMPOS DE TEXTOS
		}

		return false;//SI NO SE CUMLE NADA, SE RETORNA FALSE
	}

	/**
	 * CON ESTE METODO NOS PERMITE BORRAR LAS SEDES QUE
	 * YA ESTAN EN LA TABLA DE SEDES, SI LA SEDE NO ES NECESARIA
	 */
	private void borrarSede() {
		Sede sede = (Sede) tblSedes.getSelectionModel().getSelectedItem();// SE SELECCIONA LA SEDE DESDE LA TABLA 
		if(sede != null) {//SE VERIFICA SI LA SEDE NO ES NULA
			//LLAMAMOS AL METODO ELIMINARSEDES QUE ESTA EN EL SINGLETON, PARA PODER ELIMINAR LA SEDE QUE SE SELECCINO
			String respuesta = Singleton.eliminarSede(sede.getStrCiudad()); 
			txtCiudadSede.setText("");
			cargarTablas(6);//VAMOS AL METODO CARGAR TABLAS AL CONDICIONAL SEIS PARA OBTENER LA INFORMACION DE LAS SEDES
			tblSedes.refresh();//REFRESCAMOS PARA VER LOS CAMBIOS DE LA TABLA
			Main.abrirAlerta(respuesta);

		}else {//SI NO SE CUMPLE CON LA CONDICION DE QUE LA SEDE SEA DIFERENTE DE NULL
			//SACAMOS ESTA ALERTA PARA QUE SELECCIONE UNA SEDE DE LA TABLA
			Main.abrirAlerta("Seleccione un elemento de la tabla");
		}

	}

	/**
	 * CON EL METODO DE ACTUALIZAR SEDES PODEMOS MODIFICAR LA INFORMACION QUE TIENE
	 * UNA SEDE EN ESPECIFICO, LO QUE PERMITE CAMBIAR LA INFORMACION DE LA SEDE
	 * SI ES NECESARIO
	 */
	private void actualizarSede() {
		Sede sede = (Sede) tblSedes.getSelectionModel().getSelectedItem();//OBTENEMOS LA SEDE SELLECIONANDO LA TABLA 

		if(sede != null) {//SE VERIFICA SI LA SEDE NO ES NULA
			String ciudad = txtCiudadSede.getText(); 
			if(!ciudad.isEmpty()) {//VERIFICAMOS LA CONDICION QUE SEA DIFERENTE DE ISEMPTY

				String aux = sede.getStrCiudad()+" "+ciudad;//MUESTRA EL NOBRE DE LA SEDE QUE SE VA A MODIFICAR
				String respuesta = Singleton.actualizarSede(aux);//SE BUSCA DESE EL SINGLETON PARA QUE SE MODIFIQUE
				cargarTablas(6);//VAMOS AL METODO CARGAR TABLAS AL CONDICIONAL SEIS PARA OBTENER LA INFORMACION DE LAS SEDES  
				tblSedes.refresh();//REFRESCAMOS PARA VER LOS CAMBIOS DE LA TABLA
				txtCiudadSede.setText("");
				Main.abrirAlerta(respuesta);
			}else {//SI NO SE CUMPLE CON LA CONDICION DE QUE LA SEDE SEA DIFERENTE DE NULL
				//SACAMOS ESTA ALERTA PARA QUE VERIFIQUE LA INFO INGRESADA
				Main.abrirAlerta("Verifique la información ingresada");
				txtCiudadSede.setText("");
			}

		}else {//SI NO SE CUMPLE CON LA CONDICION DE QUE LA SEDE SEA DIFERENTE DE NULL
			//SACAMOS ESTA ALERTA PARA QUE SELECCIONE UNA SEDE DE LA TABLA
			txtCiudadSede.setText("");
			Main.abrirAlerta("Debe seleccionar una sede en la tabla");
		}
	}

	/**
	 * CON EL METODO DE REMPLAZARSEDE SI NECESITMOS CAMBIAR EL
	 * NOMBRE DE LA SEDE SE PUEDE REMPLAZAR 
	 */
	private void reemplazarSede() {
		Sede sedeAux = (Sede) tblSedes.getSelectionModel().getSelectedItem();//SE SELECCIONA LA SEDE DE LA TABLA
		if(sedeAux != null) {//VERIFICAMOS QUE LA CONDICION DEA DIFERENTE DE NULL
			String ciudad = txtCiudadSede.getText();//LLENAMOS EL ESPACIO DEL NUEVO NOMBRE, TENIENDO LA SEDE SELECCIONADA 
			if(!ciudad.isEmpty()) {//VERIFICAMOS QUE LA CIUDAD QUE VAMOS A INGRESAR SEA DIFERENTE DE ISEMPTY

				String aux = sedeAux.getStrCiudad()+" "+ciudad;//SE GUARDA EL NUEVO NOMBRE DE LA SEDE
				String respuesta = Singleton.sustituirSede(aux);//EL SINGLGETON NOS RETORNARA LA NUEVA SEDE 
				txtCiudadSede.setText("");
				cargarTablas(6);//VAMOS AL METODO CARGAR TABLAS AL CONDICIONAL SEIS PARA OBTENER LA INFORMACION DE LAS SEDES
				Main.abrirAlerta(respuesta);

			}else {//SI LA CONDICION NO SE CUMPLE, MADAMOS UNA ALERTA
				Main.abrirAlerta("Verifique la información");
			}

		}else {// Y SI LA CONDICION ES IGUAL A NULL,LA ALERTA DIRA QUE SELECIONE UNA SEDE DE LA TABLA
			Main.abrirAlerta("Debe seleccionar un elemento de la tabla para reemplazar");
		}

	}

	/**
	 * CON ESTE METODO PODEMOS CREAR LA SEDE NUEVA QUE VA HACER 
	 * PARTE DE UNA EXTENSION DE LA TIENDA PRINCIPAL
	 */
	private void crearSede() {
		//SI LA SELDA DEL TEXTO DONDE SE INGRESA EL NOMBRE DE LA NUEVA CELDA ES DIFERENTE DE ISEMPTY
		if(!txtCiudadSede.getText().isEmpty()) {
			//VAMOS AL SINGLETON PARA PODER OBTENR EL METODO DE CREAR SEDE CON EL NOMBRE DE LA NUEVA SEDE
			String respuesta = Singleton.crearSede(txtCiudadSede.getText());
			cargarTablas(6);//VAMOS AL METODO CARGAR TABLAS AL CONDICIONAL SEIS PARA OBTENER LA INFORMACION DE LAS SEDES
			tblSedes.refresh();//REFRESCAMOS LA TABLA DE SEDES
			txtCiudadSede.setText("");
			Main.abrirAlerta(respuesta);
		}else{//SI EL CAMPO DEL TEXTO ESTA VACIA Y LE DA CREAR SEDE LE VA APARECER LA ALERTA
			Main.abrirAlerta("La ciudad de la sede no puede estar vacía");
		}

	}

	/**
	 * CON EL METODO DE REMPLAZARPRODUCTO, SI SE NECESITA CAMBIAR EL
	 * NOMBRE DEL PRODUCTO SE PUEDE REMPLAZAR
	 */
	private void reemplazarProducto() {
		
		//SE SELECCIONA EL PRODUCTO DE LA TABLA
		Producto productoReemplazar = (Producto)tblGlobalProductos.getSelectionModel().getSelectedItem();

		if(productoReemplazar != null ) {//VERIFICAMOS QUE EL PRODUCTO A REMPLAZAR NO SEA NULL
			if(verificarCamposTexto()) {//VERIFICAMOS QUE SE CUMPLA EL CAMPO DE TEXTO DE PRODUCTO 
				/**
				 * TENER EN CUENTA QUE SI SOLO SE NECESITA MODIFICAR ALGO EN ESPECIFICO DEL PRODUCTO 
				 * SE DEBE PONER ENTONCES LA MISMA INFORMACION Y SOLO SE CAMBIA LA INFORMACION QUE 
				 * DESEA MODIFICAR
				 */
				String nomProd = txtNombreProducto.getText();//SE PONE EL NUEVO NOMBRE DEL PRODUCTO 
				String descripcion = txtDescripcionProd.getText();//SE PONE LA NUEVA DESCRIPCION DEL PRODUCTO
				//SE PONE EL NUEVO PRECIO DEL PRODUCTO Y SE CONVIERTE EN UN DOUBLE
				double precio = Double.parseDouble(txtPrecioProd.getText());
				//SE PONE LA CANTIDAD DISPONIBLE Y SE CONVIERTE EN UN INT
				int cantidadDisponible = Integer.parseInt(txtCantProdDisponible.getText());
				Producto productoNuevo = new Producto(nomProd, descripcion, precio, cantidadDisponible, tipoProductoGlobal);
				//SE VA AL SINGELTON PARA CAMBIAR EL PRODUCTO ANIGUO POR EL PORDUCTO NUEVO
				String resultado = Singleton.reemplazarProductos(productoReemplazar, productoNuevo);
				actualizarProductosTabla(tipoProductoGlobal);//ACTUALIZAMOS LA TABLA CON EL NUEVO PORDUCTO
				limpiarCamposTexto();//LIMPIAMOS LOS CAMPOS DE TEXTOS
				Main.abrirAlerta(resultado);

			}else {//SI LOS CAMPOS NO ESTAN COMPLETOS O METE UNA INFOMACION EN UN CAMPO DONDE NO ES ENTONCES
				//APARECE UNA ALERTA
				Main.abrirAlerta("Los campos de texto están vacíos o existe información incorrecta");
			}


		}else {//SI PRIMER CONDICIONAL ES NULO, ENTONCES NOS SALE UNA ALERTA QUE DICE, DEBE ELEGIR UN ELEMENTO DE LA TABLA
			Main.abrirAlerta("Debe seleccionar un elemento de la tabla para reemplazar");
		}
	}

	/**
	 * VERIFICAMOS QUE LOS CAMPOS DE TEXTOS ESTEN CORRECTAMENTE
	 * @return
	 */
	private boolean verificarCamposTexto() {
		try {
			String nomProd = txtNombreProducto.getText(); 
			String descripcion = txtDescripcionProd.getText();
			double precio = Double.parseDouble(txtPrecioProd.getText()); 
			int cantidadDisponible = Integer.parseInt(txtCantProdDisponible.getText());
			//SI SE CIMPLE LAS CONDICIONES ENTONCES RETORNA UN TRUE
			if(!nomProd.isEmpty() && !descripcion.isEmpty() && precio != 0 && cantidadDisponible != 0 && !txtPrecioProd.getText().isEmpty()
					&& !txtCantProdDisponible.getText().isEmpty()) {
				return true;
			}

		}catch(Exception e) {
		}

		return false;//SI NO CUMPLE CON NADA, RETORNA UN FALSE
		
	}

	/**
	 * CON DICHO METODO PODEMOS ACTUALIZAR UN PRODUCTO EN ESPECIFICO
	 * EL CUAL SE NECESITA ACTUALIZAR 
	 */
	private void actualizarProducto() {
		//SE SELECIONA UN PRODUCTO DE LA TABLA
		Producto productoActualizar = (Producto)tblGlobalProductos.getSelectionModel().getSelectedItem();

		if(productoActualizar != null) {//MIRMAOS QUE NO SEA NULL EL PRODUCTO A ACTUALIZAR
			if(verificarCamposTexto()) {//VERIFICAMOS QUE SE CUMPLA EL CAMPO DE TEXTO DE PRODUCTO
				//DE ACA PARA ABAJO PONEMOS LOS NUEVOS DATOS DEL PRODUCTO QUE
				//VA A PONER EN LA TABLA DE PRODUCTOS
				String nomProd = txtNombreProducto.getText(); 
				String descripcion = txtDescripcionProd.getText();
				double precio = Double.parseDouble(txtPrecioProd.getText()); 
				int cantidadDisponible = Integer.parseInt(txtCantProdDisponible.getText());
				String resultado = Singleton.actualizarAtributosProducto(productoActualizar, nomProd, descripcion, precio, cantidadDisponible );
				actualizarProductosTabla(tipoProductoGlobal);//SE ACTUALIZA LA TABLA Y EL TIPO DEL PRODUCTO
				limpiarCamposTexto();//LIMPIAMOS LOS CAMPOS DE TEXTOS
				Main.abrirAlerta(resultado);
			}else {//SI EL PRODUCTO NUEVO NO TIENE TODOS LOS CAMPOS DE TEXTOS CON SU INFORMACION 
				Main.abrirAlerta("Debe actualizar cada componente");//LA ALERTA DIRA ESTO
			}
		}else {//SI EL PRODUCTO ES NULL, APARECERA ESTE MENSAJE
			Main.abrirAlerta("Seleccione un producto de la tabla");
		}

	}

	/**
	 * CON ESTE METODO DE ELIMINAR, SE PODRA ELIMINAR UN PRODUCTO
	 * QUE YA NO SE NECESITE MAS O QUE ESTE FUERA DE SERVICIO
	 */
	private void eliminarProducto() {
		//ELEGIMOS EL PRODUCTO QUE SE DESEA ELMINAR DE LA TABLA
		Producto prodEliminar = (Producto)tblGlobalProductos.getSelectionModel().getSelectedItem();
		if(prodEliminar != null) {//VERIFICAMOS QUE EL PRODUCTO SEA DIFERENTE DE NULL
			//VAMOS AL SINGLETON OBTENER EL METODO QUE ELIMINA AL PRODUCTO
			String resultado = Singleton.eliminarProducto(prodEliminar);
			actualizarProductosTabla(tipoProductoGlobal);//SE ACTUALIZA LA TABLA DE PRODUCTOS CON LOS NUEVOS DATOS
			Main.abrirAlerta(resultado);
		}else {//SI NO ES DIFERENTE DE NULL
			Main.abrirAlerta("Seleccione un producto de la tabla");//LA ALERTA DIRA ESTO
		}
	}

	/**
	 * EN EL MOMENTO QUE SE NECEITE CREAR EL PRODUCTO, ESTE METODO ES QUE
	 * NOS VA AYUDAR PARA CREAR EL NUEVO PRODUCTO QUE SE VA A IMPLEMENTAR
	 * EN LA TIENDA Y SEDES
	 */
	private void crearProducto() {
		try {
			//LLENAMOS LOS CAMPOS DE TEXTOS PARA CREAR EL PRODUCTO
			String nomProd = txtNombreProducto.getText(); 
			String descripcion = txtDescripcionProd.getText();
			double precio = Double.parseDouble(txtPrecioProd.getText()); 
			int cantidadDisponible = Integer.parseInt(txtCantProdDisponible.getText());

			//SI ESTA CONDICION SE CUMPLE, AUNQUE SEA SOLO UNO ENTONCES APARECERA UNA ADVERTENCIA DE
			if(nomProd.isEmpty() || descripcion.isEmpty() || precio == 0 || cantidadDisponible == 0) {
				Main.abrirAlerta("Hay campos en blanco");//QUE ALGUN CAMPO ESTA VACIO
			}else {//SI LA CONDICION NO SE CUMPLE
				//VAMOS AL SINGLETON PARA QUE EL METODO CREARPRODUCTO, LO CREE CON LA INFORMACION 
				//QUE SE LE ESTA PASANDO POR MEDIO DE LOS CAMPOS DE TEXTOS
				String resultado = Singleton.crearProducto(nomProd, descripcion, precio, cantidadDisponible, tipoProductoGlobal); 
				if(resultado.equals("El producto fue creado satisfactoriamente")) {//SI SE CIMPLE ESTA INFORMACION
					actualizarProductosTabla(tipoProductoGlobal); //ENTONCES SE VA ACTUALIZAR LA TABLA GLOBAL
				}
				limpiarCamposTexto();
				Main.abrirAlerta(resultado);
			}

		}catch(Exception e) {//SI LOS CAMPOS DE TEXTOS NO ESTAN TODOS CON SUS VALORES EN ESPECIFICO
			//ENTONCES LA ALERTA DIRA QUE VERIFIQUEMOS LOS CAMPOS DE TEXTOS
			Main.abrirAlerta("Verifique los datos de los campos de texto");
			limpiarCamposTexto();
		}
	}

	/**
	 * ESTE METODO NOS AYUDA A LIMPIAR LOSC CAMPOS TE TEXTOS
	 * PARA QUE NO TOQUE BORRAR LA INFORMACION MANUALMENTE
	 */
	private void limpiarCamposTexto() {
		txtNombreProducto.setText("");
		txtDescripcionProd.setText("");
		txtPrecioProd.setText("");
		txtCantProdDisponible.setText("");
	}

	/**
	 * ESTE METODO NOS PERMITE CARGAR LOS DATOS,YA SEA LOS DATOS SIN CAMBIOS
	 * Y LOS DATOS CON CAMBIOS,. PODEMOS GUARDAR LA INFORMACION
	 * @param listaObservable
	 */
	private void cargarDatosLista(ObservableList<Object> listaObservable) {

		if( listaObservable == listaObservableSedes) {//VERIFICAMOS LA CONDICION
			listaObservableSedes.addAll(Singleton.obtenerSedes());//SE LLAMA LA INFORMACION DE LAS SEDES DESE EL SINGLETON 
		}else if(listaObservable == listaObservableEmpleados) {
			//SE LLAMA LA INFORMACION DE LOS EMPLEADOS DESE EL SINGLETON
			listaObservableEmpleados.addAll(Singleton.obtenerEmpleados()); 
		}

	}

	private void cargarDatosLista(TipoProducto tipo) {
		listaObservableProductos.addAll(Singleton.obtenerListaTipoProducto(tipo));
	}

	/**
	 * METODO QUE PERMITE CAMBIAR DE PANELES SEGÚN CLICKEÉ EL USUARIO
	 * @param event
	 */
	@FXML
	void switchPanel(ActionEvent event) {
		if(event.getSource() == btnEmpleado) {

			paneEmpleado.toFront();
			paneEmpleado.setVisible(true);
			paneMovil.setVisible(false);
			paneComputacional.setVisible(false);
			paneMusica.setVisible(false);
			paneHogar.setVisible(false);
			paneEmpresarial.setVisible(false);
			paneSedes.setVisible(false);
			HboxTextFields.setVisible(false);
			HboxButtons.setVisible(false);
			tblSedes.setVisible(false);
			tblGlobalProductos.setVisible(false);
			cargarTablas(5);
			tblEmpleados.setVisible(true);
			cargarListaSedeCombo(); 


		}if(event.getSource() == btnMovil) {

			paneMovil.toFront();
			paneMovil.setVisible(true);
			paneEmpleado.setVisible(false);
			paneComputacional.setVisible(false);
			paneMusica.setVisible(false);
			paneHogar.setVisible(false);
			paneEmpresarial.setVisible(false);
			paneSedes.setVisible(false);
			setProductoGlobal(TipoProducto.TECNOLOGIA_MOVIL);
			cargarTablas(0);
			HboxTextFields.setVisible(true);
			HboxButtons.setVisible(true);
			tblSedes.setVisible(false);
			tblGlobalProductos.setVisible(true);

		}if(event.getSource() == btnComputacional) {

			paneComputacional.toFront();
			paneComputacional.setVisible(true);
			paneEmpleado.setVisible(false);
			paneMovil.setVisible(false);
			paneMusica.setVisible(false);
			paneHogar.setVisible(false);
			paneEmpresarial.setVisible(false);
			paneSedes.setVisible(false);
			setProductoGlobal(TipoProducto.TECNOLOGIA_COMPUTACIONAL);
			cargarTablas(1);
			HboxTextFields.setVisible(true);
			HboxButtons.setVisible(true);
			tblSedes.setVisible(false);
			tblGlobalProductos.setVisible(true);

		}if(event.getSource() == btnMusica) {

			paneMusica.toFront();
			paneMusica.setVisible(true);
			paneEmpleado.setVisible(false);
			paneMovil.setVisible(false);
			paneHogar.setVisible(false);
			paneEmpresarial.setVisible(false);
			paneComputacional.setVisible(false);
			paneSedes.setVisible(false);
			setProductoGlobal(TipoProducto.MUSICA);
			cargarTablas(2);
			HboxTextFields.setVisible(true);
			HboxButtons.setVisible(true);
			tblSedes.setVisible(false);
			tblGlobalProductos.setVisible(true);

		}if(event.getSource() == btnHogar) {

			paneHogar.toFront();
			paneHogar.setVisible(true);
			paneMusica.setVisible(false);
			paneEmpleado.setVisible(false);
			paneMovil.setVisible(false);
			paneEmpresarial.setVisible(false);
			paneComputacional.setVisible(false);
			paneSedes.setVisible(false);
			setProductoGlobal(TipoProducto.HOGAR);
			cargarTablas(3);
			HboxTextFields.setVisible(true);
			HboxButtons.setVisible(true);
			tblSedes.setVisible(false);
			tblGlobalProductos.setVisible(true);

		}if(event.getSource() == btnEmpresarial) {
			paneEmpresarial.toFront();
			paneEmpresarial.setVisible(true);
			paneHogar.setVisible(false);
			paneMusica.setVisible(false);
			paneEmpleado.setVisible(false);
			paneMovil.setVisible(false);
			paneComputacional.setVisible(false);
			paneSedes.setVisible(false);
			setProductoGlobal(TipoProducto.EMPRESARIAL);
			cargarTablas(4);
			HboxTextFields.setVisible(true);
			HboxButtons.setVisible(true);
			tblSedes.setVisible(false);
			tblGlobalProductos.setVisible(true);

		}if(event.getSource() == btnSedes) {
			paneSedes.toFront(); 
			paneSedes.setVisible(true); 
			paneHogar.setVisible(false);
			paneMusica.setVisible(false);
			paneEmpleado.setVisible(false);
			paneMovil.setVisible(false);
			paneComputacional.setVisible(false);
			paneEmpresarial.setVisible(false);
			HboxTextFields.setVisible(false);
			HboxButtons.setVisible(false);
			tblGlobalProductos.setVisible(false);
			cargarTablas(6);
			tblSedes.setVisible(true);
		}if(btnClientes == event.getSource()) {
			cargarTablas(7);
			paneClientes.toFront(); 
			paneClientes.setVisible(true); 
			paneHogar.setVisible(false);
			paneMusica.setVisible(false);
			paneEmpleado.setVisible(false);
			paneMovil.setVisible(false);
			paneComputacional.setVisible(false);
			paneEmpresarial.setVisible(false);
			paneSedes.setVisible(false);
			HboxTextFields.setVisible(false);
			HboxButtons.setVisible(false);
			tblGlobalProductos.setVisible(false);
			tblSedes.setVisible(false);
		}
	}

	private void cargarListaSedeCombo() {
		comBoxSedeEmple.getItems().clear();
		cargarDatosSedeString();
		comBoxSedeEmple.setItems(listaObservableSedesString);
	}

	/**
	 * @return the nomSede
	 */
	public static String getNomSede() {
		return nomSede;
	}


	/**
	 * @param nomSede the nomSede to set
	 */
	public static void setNomSede(String nomSede) {
		paneAdminController.nomSede = nomSede;
	}


	@FXML
	public void animation() {
	}



	/**
	 * METODO QUE MUESTRA EL FRAME DEL ADMIN
	 */
	public void mostrarFrame() {
		Parent root; 
		try {
			root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/view/PanelAdmin.fxml"));
			//AÑADO EL FXML A UNA SCENA
			Scene scene = new Scene(root);
			//AÑADO LA SCENA A UNA VENTANA
			stage.setScene(scene);
			stage.setResizable(false);
			//PERMITE PODER DESPLAZAR LA VENTANA DE INICIO A CUALQUIER PARTE DE LA PANTALLA
			root.setOnMousePressed(evt ->{
				x=evt.getSceneX();
				y=evt.getSceneY();
			});
			root.setOnMouseDragged(evt ->{
				stage.setX(evt.getScreenX()-x);
				stage.setY(evt.getScreenY()-y);
			});
			//QUITO LOS BORDES DE LA PANTALLA POR DEFECTO
			stage.initStyle(StageStyle.UNDECORATED);
			stage.setTitle("Tienda Quindío"); 
			InputStream inputStream;
			inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
			Image image = new Image(inputStream);
			stage.getIcons().add(image);
			Main.setFrameAdmin(stage);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public Sede getSedeSeleccionada() {
		return sedeSeleccionada;
	}

	@FXML
	public void initialize() {

		this.columnaCiudadSede.setCellValueFactory(new PropertyValueFactory<>("strCiudad"));
		this.columnaIDSede.setCellValueFactory(new PropertyValueFactory<>("idSede"));
		this.columna1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columna2.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.columna3.setCellValueFactory(new PropertyValueFactory<>("cantDisponible"));
		this.ColumnaNomEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.columnaCodEmpleado.setCellValueFactory(new PropertyValueFactory<>("sueldo"));
		this.colNomCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colIDCliente.setCellValueFactory(new PropertyValueFactory<>("codigoCliente"));


		tblClientes.getItems().clear();
		cargarDatosListaClientes();
		tblClientes.getItems().addAll(listaObservableCliente);
		tblClientes.refresh();

		tblGlobalProductos.getItems().clear();
		tblGlobalProductos.setItems(listaObservableProductos);
		tblSedes.getItems().clear();
		tblEmpleados.getItems().clear();
		cmbBoxRolEmpleado.getItems().addAll(roles); 
	}

	private void cargarDatosListaClientes() {
		listaObservableCliente.clear();
		listaObservableCliente.addAll(Singleton.obtenerListaClientes());
	}

	public void volverLogin(ActionEvent e) {
		Main.cerrarFrameAdmin();
		Main.mostrarLogin();
	}

	public TipoProducto getProductoGlobal() {
		return tipoProductoGlobal;
	}

	public void setProductoGlobal(TipoProducto productoGlobal) {
		this.tipoProductoGlobal = productoGlobal;
	}

}
