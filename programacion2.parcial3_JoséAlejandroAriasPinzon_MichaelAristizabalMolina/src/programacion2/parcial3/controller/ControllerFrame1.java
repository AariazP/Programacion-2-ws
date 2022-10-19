package programacion2.parcial3.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import programacion2.parcial3.model.Cliente;
import programacion2.parcial3.model.EmpresaEDEQ;
import programacion2.parcial3.model.Factura;

public class ControllerFrame1 {

	//------ATRIBUTOS--------
	private static EmpresaEDEQ empresa; 

	@FXML
	private Button btnBuscarCliente = new Button();

	@FXML
	private Button btnAddFactura = new Button();

	@FXML
	private TableView<Cliente> tblClientes = new TableView<>();

	@FXML
	private TextField txtFecha = new TextField();

	@FXML
	private TextField txtTotalPagar = new TextField();

	@FXML
	private TextField txtIdCliente = new TextField();
	@FXML
	private TableColumn<Cliente, String> colNombre = new TableColumn<Cliente, String>();
	@FXML
	private TableColumn<Cliente, String> colCedula = new TableColumn<Cliente, String>();
	@FXML
	private TableColumn<Cliente, String> colNit = new TableColumn<Cliente, String>();

	ObservableList<Cliente> listaObservableCliente = FXCollections.observableArrayList();




	//--------MÉTODOS DE LA INTERFAZ--------

	/**
	 * Mètodo que busca un cliente dado su id
	 * @param e
	 */

	public void buscarCliente(ActionEvent e) {

		//VERIFICO QUE NO SEA VACIO LA IDENTIFICACIÓN
		if(!txtIdCliente.getText().isEmpty()) {
			//la empresa me retorna el cliente
			Cliente cliente = empresa.buscarCliente(txtIdCliente.getText());
			//muestro la informacion del cliente
			
			if(cliente != null) {
				mostrarInfo("info cliente"+cliente.toString());
				txtIdCliente.setText("");
			}else {
				mostrarInfo("No se ha encontrado el cliente");
				txtIdCliente.setText("");
			}
			

		}else {
			//si el textField es vacío muestro un mensaje
			mostrarInfo("Ingrese información válida");
			txtIdCliente.setText("");
		}
	}

	/**
	 * Método que permite crear una factura
	 * @param e
	 */
	public void crearFactura(ActionEvent e) {
		//obtengo el cliente seleccionado de la tabla
		Cliente cliente = tblClientes.getSelectionModel().getSelectedItem();
		//verifico si es diferente de nulo para la creacion de la factura
		if(cliente != null) {
			//obtengo los campos de textos
			String fecha = txtFecha.getText(); 
			String totalPagar = txtTotalPagar.getText(); 
			//verifico que los campos de texto no estén vacíos
			if(!fecha.isEmpty() && !totalPagar.isEmpty()) {
				//convierto a double el total
				Double totalPagarDouble = convertirADouble(totalPagar);
				//creo la factura
				Factura facturaAux = new Factura(fecha, totalPagarDouble, cliente);
				//el modelo se encarga de registrarla y generar una respuesta
				String mensaje = empresa.registrarFactura(facturaAux);
				mostrarInfo(mensaje);
			}else {
				//en caso de que se ingresen numeros o no haya texto
				mostrarInfo("Ingrese información válida");
			}
		}else {
			//en caso de que no se seleccione un cliente
			mostrarInfo("Seleccione un cliente de la tabla");
		}
	}

	/**
	 * Método que recibe un string y lo convierte a double
	 * @param totalPagar
	 * @return
	 */
	private Double convertirADouble(String totalPagar) {
		Double totalPagarDouble = 0.0; 
		try {
			totalPagarDouble = Double.parseDouble(totalPagar); 

		}catch (Exception e2) {
			mostrarInfo("Ingrese numeros en el total");
		}
		return totalPagarDouble;
	}
	/**
	 * Método que incializa las tablas con los valores quemados
	 */

	@FXML
	public void initialize() {
		try {
			this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			this.colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
			this.colNit.setCellValueFactory(new PropertyValueFactory<>("nit"));

			tblClientes.getItems().clear();
			cargarListaObservable(); 
			tblClientes.setItems(listaObservableCliente);
			tblClientes.refresh();
		}catch (Exception e) {
		}

	}

	/*
	 * MÉTODO QUE OBTIENE LA LISTA DE LOS CLIENTES EN LA EMPRESA
	 */
	private void cargarListaObservable() {
		listaObservableCliente.clear();
		listaObservableCliente.addAll(empresa.getListaClientes()); 
	}

	//--------Métodos de ayuda-----
	/**
	 * Método que permite mostrar la información usando una ventana emergente
	 * @param mensaje
	 */
	public void mostrarInfo(String mensaje) {
		Alert alert;
		DialogPane dialog;
		alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(mensaje);
		//alert.setGraphic(new ImageView("/src/co/edu/uniquindio/View/iconoAlertas.png"));
		dialog = alert.getDialogPane();
		dialog.getStyleClass().add("dialog");
		alert.showAndWait();
	}

	//---------GETTERS AND SETTERS-----------------
	@SuppressWarnings("exports")
	public static EmpresaEDEQ getEmpresa() {
		return empresa;
	}

	@SuppressWarnings("exports")
	public static void setEmpresa(EmpresaEDEQ empresa) {
		ControllerFrame1.empresa = empresa;
	}

}
