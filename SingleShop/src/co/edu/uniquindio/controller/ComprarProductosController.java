package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import co.edu.uniquindio.application.Main;
import co.edu.uniquindio.model.DetalleFactura;
import co.edu.uniquindio.model.Singleton;
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
import javafx.stage.Stage;

public class ComprarProductosController {

    @FXML
    private Button btnPagar = new Button();

    @FXML
    private ComboBox<String> cmbBoxTipoPago = new ComboBox<String>();
    
    @FXML
    private ComboBox<String> cmbBoxSedes = new ComboBox<String>();
    
    @FXML
    private TextField txtFechaFactura = new TextField(); 

    @FXML
    private TableView<DetalleFactura> tblProd = new TableView<DetalleFactura>();
    
    @FXML
    private TableColumn<DetalleFactura, String> colNomProd = new TableColumn<DetalleFactura, String>();
    
    @FXML
    private TableColumn<DetalleFactura, Double> colSubTotal = new TableColumn<DetalleFactura, Double>();
    
    private Stage stage; 
    private ArrayList<DetalleFactura> detalles = Main.getDetallesClienteActivo(); 
    private String[] tipoPago = {"Tarjeta crédito", "Tarjeta Débito"}; 
    ObservableList<DetalleFactura> listaObservable = FXCollections.observableArrayList();

    
    public void mostrarFrame() {
    	stage = new Stage(); 
    	Parent root; 
		try {
			root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/view/ComprarProductos.fxml"));
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
			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    public void initialize() {
    	this.colNomProd.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colSubTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
    	cmbBoxTipoPago.getItems().addAll(tipoPago); 
    	tblProd.getItems().clear();
		cargarProductosLista(); 
		tblProd.setItems(listaObservable);
		cmbBoxSedes.getItems().addAll(Singleton.obtenerStringSedes()); 
    }
    
    private void cargarProductosLista() {
		listaObservable.clear();
		listaObservable.addAll(detalles); 
	}

	public void realizarTransaccion(ActionEvent e) {
		
		if(!detalles.isEmpty()) {
			if(cmbBoxTipoPago.getValue() != null) {
				
				if(cmbBoxSedes.getValue() != null) {
					
					if(!txtFechaFactura.getText().isEmpty()) {
						String respuesta = Singleton.realizarCompra(Main.getClienteActivo(), detalles, txtFechaFactura.getText(), 
								cmbBoxSedes.getValue(), cmbBoxTipoPago.getValue());
		    			Main.abrirAlerta(respuesta);
					}else {
						Main.abrirAlerta("Ingrese una fecha");
					}
					
				}else {
					Main.abrirAlerta("Seleccione una sede");
				}
				
				
			}else {
				Main.abrirAlerta("Por favor seleccione el tipo de pago");
			}
			
		}else {
			Main.abrirAlerta("No se ha podido realizar la compra porque no hay productos");
		}
    }
}
