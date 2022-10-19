package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import co.edu.uniquindio.application.Main;
import co.edu.uniquindio.model.DetalleFactura;
import co.edu.uniquindio.model.Producto;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PaneClienteController {

    @FXML
    private Button btnAddProdCarrito;

    @FXML
    private Button btnComprarProd;

    @FXML
    private Button btnDeleteCarrito;

    @FXML
    private Button btnFiltrar;

    @FXML
    private Button btnHistorialCompras;

    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnSalirLogin;

    @FXML
    private ComboBox<String> cmbFilterPrecio;

    @FXML
    private ComboBox<String> cmbFilterTipo;
    
    @FXML
   	private TableColumn<Object, Double> colSubTotal = new TableColumn<Object, Double>();
    
    @FXML
	private TableColumn<Object, Double> precioProdTienda = new TableColumn<Object, Double>();
    
    @FXML
	private TableColumn<Object, String> colNomDetalle = new TableColumn<Object, String>();
    
    @FXML
  	private TableColumn<Object, Double> colPrecioDetalle = new TableColumn<Object, Double>();
    
    @FXML
  	private TableColumn<Object, Integer> colCantDetalle = new TableColumn<Object, Integer>();
	
	@FXML
	private TableColumn<Object, String> nomProdTienda = new TableColumn<Object, String>();

	@FXML
	private TableColumn<Object, Integer> canDispoProdTienda = new TableColumn<Object, Integer>();

    @FXML
    private TableView<DetalleFactura> tblViewProdCarrito = new TableView<DetalleFactura>();

    @FXML
    private TableView<Producto> tblViewProdTienda = new TableView<Producto>();
    
    private Stage stage; 
    
    private String[] tipoProductos = {"Movil", "Computacional","Musica", "Hogar", "Empresarial"};   
    private	String[] preciosSugeridos = {"10", "1000", "100000", "1000000"};
    ObservableList<Producto> listaObservableProductos = FXCollections.observableArrayList();
    ObservableList<DetalleFactura> carritoCompras = FXCollections.observableArrayList();
    private ArrayList<DetalleFactura> carrito = new ArrayList<DetalleFactura>(); 
    private static int cantidad = 0; 
    
    
    @FXML
    void volverLogin(ActionEvent event) {
    	Main.cerrarFrameCliente(); 
    	Main.mostrarLogin();
    }
    
    public void mostrarFrame() {
    	stage = new Stage(); 
    	Parent root; 
		try {
			root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/view/PanelClientes.fxml"));
			//AÑADO EL FXML A UNA SCENA
			Scene scene = new Scene(root);
			//AÑADO LA SCENA A UNA VENTANA
			stage.setScene(scene);
			stage.setResizable(false);
			//QUITO LOS BORDES DE LA PANTALLA POR DEFECTO
			stage.initStyle(StageStyle.UNDECORATED);
			InputStream inputStream;
	        inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
	        Image image = new Image(inputStream);
	        stage.getIcons().add(image);
			Main.setFrameCliente(stage); 
			Main.cerrarLogin(); 
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    @FXML
    public void initialize() {
    	this.nomProdTienda.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.precioProdTienda.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.canDispoProdTienda.setCellValueFactory(new PropertyValueFactory<>("cantDisponible"));
		this.colNomDetalle.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colPrecioDetalle.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.colCantDetalle.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
		this.colSubTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
		
		
		tblViewProdTienda.getItems().clear();
		cargarProductosLista(); 
		tblViewProdTienda.setItems(listaObservableProductos);
    	cmbFilterTipo.getItems().addAll(tipoProductos);
    	cmbFilterPrecio.getItems().addAll(preciosSugeridos);
    	btnPerfil.setText(Main.getClienteActivo().getNombre());
    }

	private void cargarProductosLista() {
		listaObservableProductos.addAll(Singleton.obtenerListaProductos()); 
	}
    
	
	public void filtrarProductos(ActionEvent e) {
		if(cmbFilterTipo == null && cmbFilterPrecio.getValue() == null) {
			Main.abrirAlerta("Indique por qué desea filtrar los productos");
		}else if(cmbFilterTipo.getValue() != null && cmbFilterPrecio.getValue() != null) {
			filtrarProductosTipoYPrecio(); 
		}else if(cmbFilterPrecio.getValue() != null) {
			filtrarProductosPrecio(); 
		}else if(cmbFilterTipo.getValue() != null) {
			filtrarProductosTipo(); 
		}
	}

	private void filtrarProductosTipo() {
		
		String tipo = cmbFilterTipo.getValue();
		tblViewProdTienda.getItems().clear();
		listaObservableProductos.clear();
		listaObservableProductos.addAll(Singleton.filtrarProductosTipo(tipo));
		tblViewProdTienda.setItems(listaObservableProductos);
		tblViewProdTienda.refresh();
		
	}

	private void filtrarProductosPrecio() {
		try {
			int precio = Integer.parseInt(cmbFilterPrecio.getValue()); 
			tblViewProdTienda.getItems().clear();
			listaObservableProductos.clear();
			listaObservableProductos.addAll(Singleton.filtrarProductosPrecio(precio));
			tblViewProdTienda.setItems(listaObservableProductos);
			tblViewProdTienda.refresh();
		}catch (Exception e) {
			Main.abrirAlerta("Ingrese info válida");
		}
	}

	private void filtrarProductosTipoYPrecio() {
		try {
			int precio = Integer.parseInt(cmbFilterPrecio.getValue());
			String tipo = cmbFilterTipo.getValue();
			
			tblViewProdTienda.getItems().clear();
			listaObservableProductos.clear();
			listaObservableProductos.addAll(Singleton.filtrarProductosCondiciones(precio, tipo));
			tblViewProdTienda.setItems(listaObservableProductos);
			tblViewProdTienda.refresh();
			
		}catch (Exception e) {
			Main.abrirAlerta("Ingres información válida para filtrar");
		}
	}
    
	public void aniadirProdCarrito(ActionEvent e) {
		Producto prodCarrito = (Producto)tblViewProdTienda.getSelectionModel().getSelectedItem();
		
		if(prodCarrito != null) {
			CantProdCompradoController cant = new CantProdCompradoController(); 
			cant.mostrarFrame();
			boolean flag = true; 
			
			if(prodCarrito.getCantDisponible() != 0) {
				do {
					if(cantidad<=prodCarrito.getCantDisponible()) {
						flag= false; 
					}else {
						Main.abrirAlerta("No hay tanto de ese producto");
						cant.mostrarFrame();
					}
					
				}while(flag); 
				Singleton.reducirCantidadProducto(prodCarrito, cantidad); 
				
				DetalleFactura aux = new DetalleFactura(prodCarrito.getNombre(), cantidad, prodCarrito.getPrecio()); 
				tblViewProdTienda.getItems().clear();
				cargarProductosLista(); 
				tblViewProdTienda.setItems(listaObservableProductos);
				tblViewProdTienda.refresh();
				
				carrito.add(aux); 
				tblViewProdCarrito.getItems().clear();
				cargarListaCarritoCompras(); 
				tblViewProdCarrito.setItems(carritoCompras);
				tblViewProdCarrito.refresh();
			}else {
				Main.abrirAlerta("Ya no queda de ese producto");
			}
			
		}else {
			Main.abrirAlerta("Seleccione un producto de la tabla");
		}
	}
	
	public void eliminarProdCarrito(ActionEvent e) {
		DetalleFactura prodCarrito = (DetalleFactura) tblViewProdCarrito.getSelectionModel().getSelectedItem();
		
		if(prodCarrito != null) {
			
			eliminarProductoCarrito(prodCarrito); 
			tblViewProdTienda.getItems().clear();
			cargarProductosLista(); 
			tblViewProdTienda.setItems(listaObservableProductos);
			Main.abrirAlerta("Producto eliminado");
			
		}else {
			Main.abrirAlerta("Para eliminar un producto seleccione uno de la tabla");
		}
		
	}

	private void eliminarProductoCarrito(DetalleFactura prodCarrito) {
		boolean aux = true; 
		for (int i = 0; i < carrito.size() && aux; i++) {
			
			if(carrito.get(i).equals(prodCarrito)) {
				carrito.remove(i); 
				aux = false; 
			}
		}
		Singleton.sumarCantidadStock(prodCarrito); 
		cargarListaCarritoCompras();
	}

	private void cargarListaCarritoCompras() {
		
		carritoCompras.clear();
		for (int i = 0; i < carrito.size(); i++) {
			carritoCompras.add(carrito.get(i)); 
		}
	}

	public static int getCantidad() {
		return cantidad;
	}

	public static void setCantidad(int cantidad) {
		PaneClienteController.cantidad = cantidad;
	}
	
	public void verComprasCliente(ActionEvent e) {
		ControllerHistorialFacturas controller = new ControllerHistorialFacturas(); 
		controller.mostrarFrame(); 
	}
	
	
	public void comprarProductos(ActionEvent e) {
		Main.setDetallesClienteActivo(carrito);
		ComprarProductosController paneComprarProd = new ComprarProductosController(); 
		paneComprarProd.mostrarFrame();
		tblViewProdCarrito.getItems().clear();
		carrito.clear();
	}

}
