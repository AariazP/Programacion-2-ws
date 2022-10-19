package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import co.edu.uniquindio.application.Main;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Factura;
import co.edu.uniquindio.model.Singleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ControllerHistorialFacturas {

    @FXML
    private TableView<Factura> TblFacturas = new TableView<Factura>();

    @FXML
    private TableColumn<Factura, String> colCliente = new TableColumn<Factura, String>();

    @FXML
    private TableColumn<Factura, String> colFecha = new TableColumn<Factura, String>();

    @FXML
    private TableColumn<Factura, Integer> colIva = new TableColumn<Factura, Integer>();

    @FXML
    private TableColumn<Factura, String> colSede = new TableColumn<Factura, String>();

    @FXML
    private TableColumn<Factura, String> colTipoPago = new TableColumn<Factura, String>();

    @FXML
    private TableColumn<Factura, Double> colTotal = new TableColumn<Factura, Double>();
    
    private Stage stage; 
    
    ObservableList<Factura> listaObservableFacturas = FXCollections.observableArrayList();
    
    /**
     * METODO QUE INICIALIZA EN EL TABLEVIEW LOS ATRIBUTOS DE LA FACTURA LOS CUALES 
     * SON IMPORTATES, YA QUE SON IRRELEVANTES EN EL HISTORIAL DE FACTURA 
     */
    
    @FXML
    public void initialize() {
    	//EN LA FACTURA DEBE IR....
    	this.colCliente.setCellValueFactory(new PropertyValueFactory<>("nomCliente"));//NOMBRE DEL CLIENTE 
		this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));//FECHA DE CAUNDO SE COMPRA
		this.colIva.setCellValueFactory(new PropertyValueFactory<>("iva"));//SE LE SUMA EL IBA AL TOTAL DEL VALOR DE LA COMPRA
		this.colSede.setCellValueFactory(new PropertyValueFactory<>("strCiudad"));//LA CIUDAD DE DONDE FUE LA COMPRA
		this.colTipoPago.setCellValueFactory(new PropertyValueFactory<>("strTipoPago"));//CUAL FUE EL TIPO DE PAGO
		this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));//EL TOTAL A PAGAR CONTANDO EL IVA
		
		TblFacturas.getItems().clear();
		cargarProductosLista(); 
		TblFacturas.setItems(listaObservableFacturas);
    }
    
    /**
     * METODO QUE CARGA LOS PRODUCTOS COMPRADOS QUE SE ENCUENTRAN EN LISTA FACTURA
     */
    private void cargarProductosLista() {
    	Cliente cliente = Main.getClienteActivo();//CLIENTE QUE ESTA COMPRANDO EN ESE MOMENTO
    	//PEDIMOS LOS DATOS AL SINGLETON QUE ESTAN EN LISTAFACTURAS DEL CLIENTE
    	ArrayList<Factura> listaFacturas = Singleton.obtenerListaFacturas(cliente);
    	if(listaFacturas != null) {//VERIFICAMOS SI LISTAFACTURAS ES DIFERENTE DE NULL
    		listaObservableFacturas.addAll(listaFacturas);//AGREGAMOS TODAS LAS LISTAS FACTURAS PARA QUE QUEDEN ALMACENADAS
    	}
	}

    /**
     * METODO QUE MUESTRA EL FRAME DEL HISTORIAL DE FACTURAS
     */
	public void mostrarFrame() {
    	stage = new Stage(); 
    	Parent root; 
		try {
			root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/view/HistorialFacturasCliente.fxml"));
			//AÑADO EL FXML A UNA SCENA
			Scene scene = new Scene(root);
			//AÑADO LA SCENA A UNA VENTANA
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Tienda Quindío"); 
			//QUITO LOS BORDES DE LA PANTALLA POR DEFECTO
			InputStream inputStream;
	        inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
	        Image image = new Image(inputStream);
	        stage.getIcons().add(image);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
