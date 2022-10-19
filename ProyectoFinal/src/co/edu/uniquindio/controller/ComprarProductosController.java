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
    private String[] tipoPago = {"Tarjeta cr�dito", "Tarjeta D�bito"}; 
    ObservableList<DetalleFactura> listaObservable = FXCollections.observableArrayList();

    
    public void mostrarFrame() {
    	stage = new Stage(); 
    	Parent root; 
		try {
			root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/view/ComprarProductos.fxml"));
			//A�ADO EL FXML A UNA SCENA
			Scene scene = new Scene(root);
			//A�ADO LA SCENA A UNA VENTANA
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Tienda Quind�o"); 
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
    
    /**
     * METODO QUE INICIALIZA LAS TABLEVIEW DE PRODUCTOS 
     * CON SUS RESPECTIVOS VALORES POR CADA COLUMNA
     */
    @FXML
    public void initialize() {
    	//EN ESTA COLUMNA NOMBRES APARECERAN LOS NOMBRES DE PRODUCTOS
    	this.colNomProd.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	//EN ESTA COLUMNA SUBTOTAL APARECERA EL VALOR DEL PRODUCTO (SIN EL IVA), A PAGAR
		this.colSubTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
    	cmbBoxTipoPago.getItems().addAll(tipoPago); //SE PODRA ELEGIR LA OPCION DE PAGO
    	tblProd.getItems().clear();//LIMPIA LA TABLA PRODUCTO
		cargarProductosLista(); 
		tblProd.setItems(listaObservable);//CUANDO SE LIMP�E LA TABLA SE LE CARGA LA NUEVA INFORMACION A LA TABLA
		cmbBoxSedes.getItems().addAll(Singleton.obtenerStringSedes());//LLAMMOS LAS SEDES DESDE EL SINGLETON
    }
    
    /**
     * METODO QUE CARGA EN LA LISTA DE PRODUCTOS LOS DETALLES DE LOS PRODUCTOS COMPRADOS
     */
    private void cargarProductosLista() {
		listaObservable.clear();
		listaObservable.addAll(detalles); 
	}

    /**
     * METODO QUE PERMITE REALIZAR TRANSACCIONES DADO UN TIPO DE PAGO
     * @param e
     */
	public void realizarTransaccion(ActionEvent e) {
		
		if(!detalles.isEmpty()) {
			if(cmbBoxTipoPago.getValue() != null) {//EVALUAMOS QUE EL TIPO DE PAGO QUE ELIGIO NO SEA NULL
				
				if(cmbBoxSedes.getValue() != null) {//MIRAMOS QUE LAS SEDES TAMBIEN SEA DIFERENTE DE NULL
					
					if(!txtFechaFactura.getText().isEmpty()) {//SI ES DIFERENTE DEL CONDICIONAL, ENTONCES ENTRA
						//OBTIENE TODOS LOS DETALLES DE LA COMPRA REALIZADA, QUE SE LLAMA DESDE EL SINGELTON
						String respuesta = Singleton.realizarCompra(Main.getClienteActivo(), detalles, txtFechaFactura.getText(), 
								cmbBoxSedes.getValue(), cmbBoxTipoPago.getValue());
		    			Main.abrirAlerta(respuesta);
					}else {//SI LAS CONDICIONES DE ARRIBA NO SE CUMPLES, CON LOS ELSE
						//SI LAS CONDICIONES DE ARRIBA NO SE CUMPLES, CON LOS ELSE
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
