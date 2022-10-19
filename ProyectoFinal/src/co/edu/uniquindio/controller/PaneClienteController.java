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
    
    /**
     * CUANDO EL CLIENTE LE DE EN SING OUT ESTA ACCION LO VA A
     * DEVOLVER A LA PAGINA PRINCIPAL DE LA TIENADA
     * @param event
     */
    @FXML
    void volverLogin(ActionEvent event) {
    	Main.cerrarFrameCliente();//AYUDA A CERRA LA VENTAN DEL CLIENTE Y SE DEVULEVE A LA PAGINA PRINCIPAL
    	Main.mostrarLogin();//CUANDO CIERRA EL PANEL DEL CLIENTE, ESTA LINEA SIRVE PARA MOSTRAR LA PAGINA PRINCIPAL LOGIN
    }
    
    /**
     *METODO QUE PERMITE MOSTRAR EL FRAME DE CLIENTE
     */
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
    
    /**
     * METODO QUE INICIALIZA LAS TBL DE LOS PRODUCTOS Y QUE EL CLIENTE LOS PUEDA
     * VER PARA LUEGO DE LA MISMA TABLA LOS PUEDRA AGREGAR AL CARRITO
     */
    @FXML
    public void initialize() {
    	this.nomProdTienda.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.precioProdTienda.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.canDispoProdTienda.setCellValueFactory(new PropertyValueFactory<>("cantDisponible"));
		this.colNomDetalle.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		this.colPrecioDetalle.setCellValueFactory(new PropertyValueFactory<>("precio"));
		this.colCantDetalle.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
		this.colSubTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
		
		//CUANDO HAYA UN CAMBIO EN LA TABLA, YA SEA DE QUE YA NO HAY LA MISMA CANTIDAD LOS PRODUCTOS, 
		//DE QUE SE AGREGARON MAS O DE QUE QUITARON PRODUCTOS; PARA ELLO SE DEBE  HACER LO SIGUIENTE
		tblViewProdTienda.getItems().clear();//SE DEBE LIMPIAR LA TABLA A MODIFICAR
		cargarProductosLista();//SE LLAMA AL METODO DE CARGAR PRODUCTOS (PRODUCTOS ACTUALIZADOS)
		tblViewProdTienda.setItems(listaObservableProductos);//SE LE PASA LOS PRODUCTOS CON SUS ACTUALIZACIONES A LA TABLA
    	cmbFilterTipo.getItems().addAll(tipoProductos);
    	cmbFilterPrecio.getItems().addAll(preciosSugeridos);
    	btnPerfil.setText(Main.getClienteActivo().getNombre());
    }

    /**
     * ESTE METODO AYUDA A CARGAR LOS DATOS MAS ACTUALIZADOS DE PRODUCTOS
     */
	private void cargarProductosLista() {
		listaObservableProductos.addAll(Singleton.obtenerListaProductos());//SE OBTIENE LOS PRODUCTOS DEL SINGLETON 
	}
    
	
	/**
	 * CON ESTA ACCION PODEMOS FILTRAR LOS PRODUCTOS YA SEAN POR
	 * TIPO DEL PRODUCTO Y/O DEL PRECIO QUE NECESITE
	 * @param e
	 */
	public void filtrarProductos(ActionEvent e) {
		//SI EL TIPO Y EL PRECIO A FILTRAR ES IGUAL A NULL, ENTONCES... 
		if(cmbFilterTipo == null && cmbFilterPrecio.getValue() == null) {
			//NOS APARECERA UNA ALERTA DICIENDO QUE COMO LO QUIERE FILTRAR LOS PRODUCTOS
			Main.abrirAlerta("Indique por qué desea filtrar los productos");
		//ACA SE FILTRAR POR LAS DOS MANERAS, YA QUIE TIPO Y PRECIO DEBEN SER DIFERENTES DE NULL
		}else if(cmbFilterTipo.getValue() != null && cmbFilterPrecio.getValue() != null) {
			filtrarProductosTipoYPrecio();//SI CUMPLE LA CONDICION, ENTONCES FILTRAMOS LOS PRODUCTOS
		}else if(cmbFilterPrecio.getValue() != null) {// SI SOLO QUEREMOS FILTRAR POR EL PRECIO, DEBE SER DIFERENTE DE NULL
			filtrarProductosPrecio();//SI CUMPLE VERIFICAMOS LA CONDICION Y FILTRAMOS SOLO POR PRECIOS 
		}else if(cmbFilterTipo.getValue() != null) {// SI SOLO QUEREMOS FILTRAR POR EL TIPO, DEBE SER DIFERENTE DE NULL
			filtrarProductosTipo();//SI CUMPLE VERIFICAMOS LA CONDICION Y FILTRAMOS SOLO POR EL TIPO DEL PORDUCTO
		}
	}

	/**
	 * METODO QUE FILTRA LOS PRODUCTOS MEDIANTE LA SELECCION DEL TIPO DE PRODUCTO QUE EL CLIENTE DESEE
	 * ADQUIRIR
	 */
	private void filtrarProductosTipo() {
		
		String tipo = cmbFilterTipo.getValue();
		tblViewProdTienda.getItems().clear();
		listaObservableProductos.clear();
		listaObservableProductos.addAll(Singleton.filtrarProductosTipo(tipo));
		tblViewProdTienda.setItems(listaObservableProductos);
		tblViewProdTienda.refresh();
		
	}

	/**
	 * METODO QUE FILTRA LOS PRODUCTOS MEDIANTE EL PRECIO QUE EL CLIENTE DESEE
	 * O TENGA PARA ADQUIRIRLO
	 */
	private void filtrarProductosPrecio() {
		try {
			int precio = Integer.parseInt(cmbFilterPrecio.getValue()); 
			tblViewProdTienda.getItems().clear();
			listaObservableProductos.clear();
			listaObservableProductos.addAll(Singleton.filtrarProductosPrecio(precio));
			tblViewProdTienda.setItems(listaObservableProductos);
			tblViewProdTienda.refresh();
		}catch (Exception e) {
			//SI FILTRAN MAL O NO FILTRAR APARECERA UNA ALERTA PARA DECIR QUE INGRESE INFORMACION VALIDA
			Main.abrirAlerta("Ingrese info válida");
		}
	}

	/**
	 * METODO QUE FILTRA UN PRODUCTO POR SU PRECIO Y SU TIPO, DEPENDIENDO DE LA SELECCION
	 * DEL CLIENTE
	 */
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
			//SI FILTRAN MAL O NO FILTRAR APARECERA UNA ALERTA PARA DECIR QUE INGRESE INFORMACION PARA CALIDAR
			Main.abrirAlerta("Ingres información válida para filtrar");
		}
	}
    
	/**
	 * ACCION QUE AÑADE PRODUCTOS AL CARRITO DEL CLIENTE, CUANDO UNDE EL BOTON
	 * Y DE UNA VES SE PREGUNTA CUNATOS PRODUCTOS DEL MISMO TIPO DESEA LLEVAR
	 * @param e
	 */
	public void aniadirProdCarrito(ActionEvent e) {
		//SELECCIONAMOS LOS PORDUCTOS DESDE LA TABLA PARA LUEGO AÑADIRLOS AL CARRITO
		Producto prodCarrito = (Producto)tblViewProdTienda.getSelectionModel().getSelectedItem();
		
		if(prodCarrito != null) {//EL PRODUCTO DEL CARRO DEBE SER DIFERENTE DE NULL, DEBE EXISITIR PRODUCTO SELECCIONADO
			CantProdCompradoController cant = new CantProdCompradoController(); 
			cant.mostrarFrame();
			boolean flag = true;//SI EXISTE PARA GREGAR AL CARRITO, ENTONCES ES TRUE
			
			if(prodCarrito.getCantDisponible() != 0) {//MIENSTRAS CANTIDAD A LLEVAR SEA MAYOR A CERO
				do {
					//PODEMOS LLEVAR EL MISMO TIPO DEL PRODUCTO MENOS O IGUAL A LA CANTODAD EXISITENTE EN LA TIENDA
					if(cantidad<=prodCarrito.getCantDisponible()) {
						//DEVUELVE FALSE PORQUE TODAVIA LA CONDICION NO SE CUMPLE Y EXISTE TODAVIA CANTIDAD DEL PRODUCTO
						flag= false;
					}else {//SI YA NO HAY MAS CANTIDAD DE ESE PRODUCTO ENTONCES MOSTRARA UNA ALERTA
						Main.abrirAlerta("No hay tanto de ese producto");//LA ALERTA ADVIERTE QUE NO HAY MAS DE ESE PRODUCTO
						cant.mostrarFrame();
					}
					
				}while(flag); 
				Singleton.reducirCantidadProducto(prodCarrito, cantidad);//LLAMAMOS LA CANTIDAD DEL PRODUCTO DEL SINGLETON 
				//MIRMAOS EN DETALLE FACTURA EL NOMBRE DE LOS PORDUCTOS Y LA CANTIDAD DE CADA PRODUCTO SON SU PRECIO
				DetalleFactura aux = new DetalleFactura(prodCarrito.getNombre(), cantidad, prodCarrito.getPrecio()); 
				tblViewProdTienda.getItems().clear();//SE LIMPIA DETALLEFACTURA CADA VES QUE SE ACTUALICE LA INFO
				cargarProductosLista(); //MUESTRA LA INFOMRACION MAS NUEVA QUE HAY EN LISTA DE PRODUCTOS EN LA TABLA
				tblViewProdTienda.setItems(listaObservableProductos);
				tblViewProdTienda.refresh();//SE REFRESCA LA INFORMACION DE LA TABLA PARA MOSRTARLA
				
				carrito.add(aux);//AGREGAMOS LOS DETALLER DEL PRODUCTO AL CARRITO 
				tblViewProdCarrito.getItems().clear();
				cargarListaCarritoCompras(); 
				tblViewProdCarrito.setItems(carritoCompras);
				tblViewProdCarrito.refresh();
			}else {//SI QUIERE LLEVAR MAS DEL PRODUCTO Y NO HAY MAS ENTONCES VA A SALIR UNA ALERTA 
				Main.abrirAlerta("Ya no queda de ese producto");//QUE DICE QUE YA NO QUEDA MAS DE ESE PRODUCTO
			}
			
		}else {//SI NO HA SELECIONADO NADA DE LA TABLA Y QUIERE AGREGAR UN PRODCUTO AL CARRITO 
			Main.abrirAlerta("Seleccione un producto de la tabla");//ESTA ALERTA LE APARECERA
		}
	}
	/**
	 *ESTA ACCION DEL CRUD NOS PERMITE ELIMINAR EL PRODUCTO DEL CARRITO QUE ELGIMOS LLEVAR
	 * @param e
	 */
	public void eliminarProdCarrito(ActionEvent e) {
		//SELECIONAMOS UN PRODUCTO DE LA TABLA DE CARRITO CON SUS DETALLES PARA LUEGO ELIMINAR ESE PRODUCTO
		DetalleFactura prodCarrito = (DetalleFactura) tblViewProdCarrito.getSelectionModel().getSelectedItem();
		
		if(prodCarrito != null) {//ANTES DE ELIMNAR EL PRODUCTO MIRAMOS SI NO ES NULL EL PRODUCTO DEL CARRITO
			
			//LUEGO DE SELECIONAR EL PRODUCTO EL METODO DE ELIMINAR PRODUCTO, ELIMINARA EL PRODUCTO SELECCIONADO
			eliminarProductoCarrito(prodCarrito);
			tblViewProdTienda.getItems().clear();//LIMPIAMOS LA TABLA
			cargarProductosLista();//CARGAMOS LOS DATOS MAS NUEVOS DE LA TABLA
			//LE PASAMOS LOS DATOS QUE ESTAN GUARDADOS EN ESE MOMENTO A LA TABLEVIEW
			tblViewProdTienda.setItems(listaObservableProductos);
			Main.abrirAlerta("Producto eliminado");//APARECERA UN MENSAJE DICIENDO QUE EL MENSAJE SE ELIMINO
			
		}else {//SI NO A SELECIONADO NINGUNPRODUCTO, SALDRA UNA ALERTA
			//LA CUAL DICE QUE SELECIONE UN PRODUCTO PARA ELIMARLO
			Main.abrirAlerta("Para eliminar un producto seleccione uno de la tabla");
		}
		
	}

	/**
	 * ESTE METODO NOS PERMITE ELIMINAR UN PRODUCTO DEL CARRITO
	 * QUE EL USUARIO YA NO REQUIERA
	 * @param prodCarrito
	 */
	private void eliminarProductoCarrito(DetalleFactura prodCarrito) {
		boolean aux = true; 
		for (int i = 0; i < carrito.size() && aux; i++) {//ACA SE RECORRE TODO EL CARRITO
			
			if(carrito.get(i).equals(prodCarrito)) {//SI EL CARRITO ES IGUAL AL PRODUCTO CARRITO ENTOCNES
				carrito.remove(i);//SE REMOVERA ESE PRODUCTO DE ESA POSICION Y DE LA TABLA
				aux = false; 
			}
		}
		Singleton.sumarCantidadStock(prodCarrito);//LUEGO SE VOLVERA HACER LA SUMA DEL TOTAL A PAGAR SIN CONTAR EL IVA
		cargarListaCarritoCompras();//SE CARGARA LA LISTA NUEVA A LAS COMPRAS DEL CARRITO
	}

	/**
	 *METODO QUE PERMITE CARGAR LA LISTA DEL CARRITO DE COMPRAS
	 */
	private void cargarListaCarritoCompras() {
		
		carritoCompras.clear();
		for (int i = 0; i < carrito.size(); i++) {//RECORREMOS EL CARRITO
			carritoCompras.add(carrito.get(i));//SI EN EL CARRI COMPRAS NO HAY DE ESE PRODUCTO LO PONE EN UN NUEVO CAMPO
		}
	}

	//---------------------------GETTER AND SETTER--------------------------------------------
	public static int getCantidad() {
		return cantidad;
	}

	public static void setCantidad(int cantidad) {
		PaneClienteController.cantidad = cantidad;
	}
	
	//-----------------------------------------------------------------------------------	
	/**
	 * ESTA ACCION NOS PERMITE OBSERVAR LA INFOMRACION DEL HISTORIAL DE COMPRAR DEL ESE CLIENTE CLIENTE
	 * @param e
	 */
	public void verComprasCliente(ActionEvent e) {
		ControllerHistorialFacturas controller = new ControllerHistorialFacturas(); 
		controller.mostrarFrame(); 
	}
	
	/**
	 * ACCION QUE LE PERMITE A UN CLIENTE COMPRAR PRODUCTOS Y AGREGARLOS A SU CARRITO DE COMPRAS
	 * @param e
	 */
	public void comprarProductos(ActionEvent e) {
		Main.setDetallesClienteActivo(carrito);
		ComprarProductosController paneComprarProd = new ComprarProductosController();// SE OBTIENE EL METODO PARA CPMRAR PRODUCTO 
		paneComprarProd.mostrarFrame();
		tblViewProdCarrito.getItems().clear();
		carrito.clear();
	}

}
