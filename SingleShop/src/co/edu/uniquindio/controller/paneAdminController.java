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

	private void cargarDatosSedeString() {
		listaObservableSedesString.clear();
		listaObservableSedesString.addAll(Singleton.obtenerStringSedes()); 
	}

	private void actualizarProductosTabla(TipoProducto tipo) {
		tblGlobalProductos.getItems().clear();
		listaObservableProductos.clear();
		cargarDatosLista(tipo); 
		tblGlobalProductos.setItems(listaObservableProductos); 
		tblGlobalProductos.refresh();
	}

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

	public void actionsEmpleados(ActionEvent e) {
		if(e.getSource() == btnCrearEmpleado) {
			crearEmpleado(); 
		}else if(e.getSource() == btnEliminarEmpleado) {
			eliminarEmpleado(); 
		}else if(e.getSource() == btnUpdateEmpleado) {
			actualizarEmpleado(); 
		}else if(e.getSource() == btnReplaceEmpleado) {
			replaceEmpleado(); 
		}
	}

	public void actionsCliente(ActionEvent e) {

		if(e.getSource() == btnClienteMasCompras) {
			verClienteMasCompras(); 
		}else if(e.getSource() == btnReporteFacturasPeriodo) {
			generarReporteFacturas(); 
		}else if(e.getSource() == btnVerFacturasCliente) {
			mostrarFacturasCliente(); 
		}else if(e.getSource() == btnBuscarInfoCliente) {
			buscarInfoCliente(); 
		}else if(e.getSource() == btnFechaProdMasVendidos) {
			obtenerFechaMasProductosVendidos(); 
		}else if(e.getSource() == btnProdMasVendidos) {
			obtenerProdMasVendidos(); 
		}
	}


	private void obtenerProdMasVendidos() {
		String mensaje = Singleton.obtenerTresProdMasVendidos(); 
		Main.abrirAlerta(mensaje);
	}

	private void obtenerFechaMasProductosVendidos() {
		System.out.println("Fecha donde mas se vendieron productos");
	}

	private void buscarInfoCliente() {
		System.out.println("La información del cliente es");
	}

	private void mostrarFacturasCliente() {
		System.out.println("Las facturas del cliente");
	}

	private void generarReporteFacturas() {
		System.out.println("Los reportes son");
	}

	private void verClienteMasCompras() {
		System.out.println("El cliente con mas compras");
	}

	private void replaceEmpleado() {
	}

	private void actualizarEmpleado() {
		Object empleado = tblEmpleados.getSelectionModel().getSelectedItem(); 

		if(empleado != null) {
			if(empleado instanceof Administrador) {

				Administrador admin = (Administrador) empleado;
				Singleton.setAdmin(admin);
				UpdateAdminController updateAdmin = new UpdateAdminController();
				updateAdmin.mostrarFrame();
				cargarTablas(5);
				limpiarCamposTexto();
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
				}else {
					Main.abrirAlerta("Para actualizar al empleado debe escribir sus atributos en los campos de texto");
				}
			}
		}else {
			Main.abrirAlerta("Seleccione un empleado de la tabla");
		}
	}

	private void eliminarEmpleado() {

		Object empleado = tblEmpleados.getSelectionModel().getSelectedItem(); 
		if(empleado != null) {
			String respuesta = Singleton.eliminarEmpleado(empleado);
			cargarTablas(5);
			Main.abrirAlerta(respuesta);

		}else {
			Main.abrirAlerta("Seleccione un empleado de la tabla");
		}

	}

	private void crearEmpleado() {

		if(verificarInfoEmpleado()) {

			String nomEmpleado = txtNomEmpleado.getText(); 
			double sueldoEmp = Double.parseDouble(txtSueldoEmpleado.getText()); 
			String rol = cmbBoxRolEmpleado.getValue(); 
			String sede = comBoxSedeEmple.getValue(); 

			if(rol.equals("Administrador")) {
				CreateAdminController createAdmin = new CreateAdminController(); 
				createAdmin.mostrarFrame();
				limpiarCamposTextoEmpleado(); 
			}else {
				String respuesta = Singleton.crearEmpleado(nomEmpleado, sueldoEmp, sede); 
				Main.abrirAlerta(respuesta);
				limpiarCamposTextoEmpleado(); 
			}
			cargarTablas(5);
		}else {
			Main.abrirAlerta("Ingrese información correcta");
		}
	}

	private void limpiarCamposTextoEmpleado() {
		txtNomEmpleado.setText("");
		txtSueldoEmpleado.setText("");
		cmbBoxRolEmpleado.setValue(null);
		comBoxSedeEmple.setValue(null);
	}

	private boolean verificarInfoEmpleado() {
		try {
			String nomEmpleado = txtNomEmpleado.getText(); 
			double sueldoEmp = Double.parseDouble(txtSueldoEmpleado.getText()); 
			String rol = cmbBoxRolEmpleado.getValue(); 
			String sede = comBoxSedeEmple.getValue(); 
			if(sede != null && rol != null && sueldoEmp != 0 && !nomEmpleado.isEmpty()) {
				return true; 
			}
		}catch(Exception e){
			limpiarCamposTextoEmpleado(); 
		}

		return false; 
	}

	private void borrarSede() {
		Sede sede = (Sede) tblSedes.getSelectionModel().getSelectedItem(); 
		if(sede != null) {
			String respuesta = Singleton.eliminarSede(sede.getStrCiudad()); 
			txtCiudadSede.setText("");
			cargarTablas(6);
			tblSedes.refresh();
			Main.abrirAlerta(respuesta);

		}else {
			Main.abrirAlerta("Seleccione un elemento de la tabla");
		}

	}

	private void actualizarSede() {
		Sede sede = (Sede) tblSedes.getSelectionModel().getSelectedItem(); 

		if(sede != null) {
			String ciudad = txtCiudadSede.getText(); 
			if(!ciudad.isEmpty()) {

				String aux = sede.getStrCiudad()+" "+ciudad; 
				String respuesta = Singleton.actualizarSede(aux);
				cargarTablas(6);
				tblSedes.refresh();
				txtCiudadSede.setText("");
				Main.abrirAlerta(respuesta);
			}else {
				Main.abrirAlerta("Verifique la información ingresada");
				txtCiudadSede.setText("");
			}

		}else {
			txtCiudadSede.setText("");
			Main.abrirAlerta("Debe seleccionar una sede en la tabla");
		}
	}

	private void reemplazarSede() {
		Sede sedeAux = (Sede) tblSedes.getSelectionModel().getSelectedItem(); 
		if(sedeAux != null) {
			String ciudad = txtCiudadSede.getText(); 
			if(!ciudad.isEmpty()) {

				String aux = sedeAux.getStrCiudad()+" "+ciudad; 
				String respuesta = Singleton.sustituirSede(aux);
				txtCiudadSede.setText("");
				cargarTablas(6);
				Main.abrirAlerta(respuesta);

			}else {
				Main.abrirAlerta("Verifique la información");
			}

		}else {
			Main.abrirAlerta("Debe seleccionar un elemento de la tabla para reemplazar");
		}

	}

	private void crearSede() {

		if(!txtCiudadSede.getText().isEmpty()) {
			String respuesta = Singleton.crearSede(txtCiudadSede.getText());
			cargarTablas(6);
			tblSedes.refresh();
			txtCiudadSede.setText("");
			Main.abrirAlerta(respuesta);
		}else{
			Main.abrirAlerta("La ciudad de la sede no puede estar vacía");
		}

	}

	private void reemplazarProducto() {

		Producto productoReemplazar = (Producto)tblGlobalProductos.getSelectionModel().getSelectedItem();

		if(productoReemplazar != null ) {
			if(verificarCamposTexto()) {

				String nomProd = txtNombreProducto.getText(); 
				String descripcion = txtDescripcionProd.getText();
				double precio = Double.parseDouble(txtPrecioProd.getText()); 
				int cantidadDisponible = Integer.parseInt(txtCantProdDisponible.getText());
				Producto productoNuevo = new Producto(nomProd, descripcion, precio, cantidadDisponible, tipoProductoGlobal); 
				String resultado = Singleton.reemplazarProductos(productoReemplazar, productoNuevo);
				actualizarProductosTabla(tipoProductoGlobal);
				limpiarCamposTexto();
				Main.abrirAlerta(resultado);

			}else {
				Main.abrirAlerta("Los campos de texto están vacíos o existe información incorrecta");
			}


		}else {
			Main.abrirAlerta("Debe seleccionar un elemento de la tabla para reemplazar");
		}
	}

	private boolean verificarCamposTexto() {
		try {
			String nomProd = txtNombreProducto.getText(); 
			String descripcion = txtDescripcionProd.getText();
			double precio = Double.parseDouble(txtPrecioProd.getText()); 
			int cantidadDisponible = Integer.parseInt(txtCantProdDisponible.getText());
			if(!nomProd.isEmpty() && !descripcion.isEmpty() && precio != 0 && cantidadDisponible != 0 && !txtPrecioProd.getText().isEmpty()
					&& !txtCantProdDisponible.getText().isEmpty()) {
				return true;
			}

		}catch(Exception e) {
		}

		return false;
	}

	private void actualizarProducto() {
		Producto productoActualizar = (Producto)tblGlobalProductos.getSelectionModel().getSelectedItem();

		if(productoActualizar != null) {
			if(verificarCamposTexto()) {

				String nomProd = txtNombreProducto.getText(); 
				String descripcion = txtDescripcionProd.getText();
				double precio = Double.parseDouble(txtPrecioProd.getText()); 
				int cantidadDisponible = Integer.parseInt(txtCantProdDisponible.getText());
				String resultado = Singleton.actualizarAtributosProducto(productoActualizar, nomProd, descripcion, precio, cantidadDisponible );
				actualizarProductosTabla(tipoProductoGlobal);
				limpiarCamposTexto();
				Main.abrirAlerta(resultado);
			}else {
				Main.abrirAlerta("Debe actualizar cada componente");
			}
		}else {
			Main.abrirAlerta("Seleccione un producto de la tabla");
		}

	}

	private void eliminarProducto() {
		Producto prodEliminar = (Producto)tblGlobalProductos.getSelectionModel().getSelectedItem();
		if(prodEliminar != null) {
			String resultado = Singleton.eliminarProducto(prodEliminar);
			actualizarProductosTabla(tipoProductoGlobal);
			Main.abrirAlerta(resultado);
		}else {
			Main.abrirAlerta("Seleccione un producto de la tabla");
		}
	}

	private void crearProducto() {
		try {
			String nomProd = txtNombreProducto.getText(); 
			String descripcion = txtDescripcionProd.getText();
			double precio = Double.parseDouble(txtPrecioProd.getText()); 
			int cantidadDisponible = Integer.parseInt(txtCantProdDisponible.getText());

			if(nomProd.isEmpty() || descripcion.isEmpty() || precio == 0 || cantidadDisponible == 0) {
				Main.abrirAlerta("Hay campos en blanco");
			}else {
				String resultado = Singleton.crearProducto(nomProd, descripcion, precio, cantidadDisponible, tipoProductoGlobal); 
				if(resultado.equals("El producto fue creado satisfactoriamente")) {
					actualizarProductosTabla(tipoProductoGlobal); 
				}
				limpiarCamposTexto();
				Main.abrirAlerta(resultado);
			}

		}catch(Exception e) {
			Main.abrirAlerta("Verifique los datos de los campos de texto");
			limpiarCamposTexto();
		}
	}

	private void limpiarCamposTexto() {
		txtNombreProducto.setText("");
		txtDescripcionProd.setText("");
		txtPrecioProd.setText("");
		txtCantProdDisponible.setText("");
	}

	private void cargarDatosLista(ObservableList<Object> listaObservable) {

		if( listaObservable == listaObservableSedes) {
			listaObservableSedes.addAll(Singleton.obtenerSedes()); 
		}else if(listaObservable == listaObservableEmpleados) {
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



	@SuppressWarnings("exports")
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



	@SuppressWarnings("exports")
	public TipoProducto getProductoGlobal() {
		return tipoProductoGlobal;
	}



	public void setProductoGlobal(@SuppressWarnings("exports") TipoProducto productoGlobal) {
		this.tipoProductoGlobal = productoGlobal;
	}

}
