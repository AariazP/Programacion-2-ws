package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.application.Main;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.Singleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerLogin {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnExit;

	@FXML
	private Button btnIniciarSesion;

	@FXML
	private Button btnCrearUsuario;
	
	@FXML
	private Button btnIniciarSesionAdmin;

	@FXML
	private TextField txtContraseña;

	@FXML
	private TextField txtUsuario;
	
	private double x;
	private double y;

	@FXML
	void initialize() {
		assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'Login.fxml'.";
		assert btnIniciarSesion != null : "fx:id=\"btnIniciarSesion\" was not injected: check your FXML file 'Login.fxml'.";
		assert btnIniciarSesionAdmin != null : "fx:id=\"btnIniciarSesionAdmin\" was not injected: check your FXML file 'Login.fxml'.";
		assert txtContraseña != null : "fx:id=\"txtContraseña\" was not injected: check your FXML file 'Login.fxml'.";
		assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'Login.fxml'.";

	}

	/**
	 * METODO QUE REALIZA ACCIONES, DONDE DENTRO DEL METODO SE ENCONTRARN VARIOS 
	 * BOTONES QUE PERMITEL EL FUNCIONAMIENDO DE DIVERSAS ACCIONES LAS CUALES SON 
	 * CERRAR EL PROGRAMA - INICIAR SESION - CREAR USUARIO - REGISTRAR ADMINISTRADOR
	 * @param e
	 */
	@FXML
	public void actions(ActionEvent e) {
		//FUNCIONA EL BOTÓN DE SALIR
		if(e.getSource() == btnExit) {//SI SE CUMPLE LA CONDICION CON ESTE BOTÓN, SE CIERRA EL PROGRAMA
			cerrarPrograma();
		}else if(e.getSource() == btnIniciarSesion) {//SI SE CUMPLE LA CONDICION CON ESTE BOTÓN, INICIAMOS SESION
			iniciarSesion(); 
			//FUNCIONA EL BOTÓN DE CREAR USUARIO
		}else if(e.getSource() == btnCrearUsuario) {//SI SE CUMPLE LA CONDICION CON ESTE BOTÓN, CREAMOS UN USUARIO DE LA TIENDA
			crearUsuario(); 
		}else if(e.getSource() == btnIniciarSesionAdmin) {//SI SE CUMPLE LA CONDICION CON ESTE BOTÓN, INGRESAMOS CON UNA CUENTA ADMIN
			abrirLoginAdmin();
		}
		
	}
	
	/**
	 * ESTE METODO CONTROLA LA VENTANA DONDE SE REGISTRA
	 * EL INICIAR SESION DEL ADMIN
	 */
	private void abrirLoginAdmin() {
		ControllerLoginAdmin loginAdmin = new ControllerLoginAdmin(); 
		loginAdmin.mostrarFrame(); 
	}

	/**
	 * ACÁ PODEMOS CONTROLAR LA VENTANA DONDE SE CREA
	 * EL USUARIO PARA LA TIENA
	 */
	private void crearUsuario() {
		CrearUsuarioController crearUsuario = new CrearUsuarioController(); 
		crearUsuario.mostrarFrame();
	}

	/**
	 * MÉTODO QUE PERMITE A UN USUARIO INGRESAR SESIÓN LUEGO DE REGISTRARSE
	 */
	private void iniciarSesion() {
		//SE OBTIENE LA INFORMACION DEL USUARIO Y LA CONTRASEÑA DESDE EL SINGLETON
		Cliente cliente = Singleton.getInstance().iniciarSesion(txtUsuario.getText(), txtContraseña.getText()); 
		if(cliente != null) {//MIENTRAS EL CLIENTE NO SEA NULL
			txtContraseña.setText("");//MIENTRAS EL CLIENTE NO SEA NULL
			txtUsuario.setText("");//PODEMOS ESCRIBIR EL USUARIO PARA INGRESAR
			mostrarPanelCliente(cliente);//MOSTRARA LA VENTANA DE ESE CLIENTE DONDE PUEDE COMPRAR
		}else {//SI EL ELIENTE ES NULL
			txtContraseña.setText("");
			txtUsuario.setText("");
			//AUNQUE INGRESEMOS INFORMACION EN LOS CAMPOS NOS VA APARECER ESTE MENSAJE
			Main.abrirAlerta("No existe este usuario");
		}
	}

	/**
	 * SE ENCARGA DE PODER MOSTRAR EL PANEL DEL CLIENTE
	 * DONDE PUEDE COMPRAR
	 * @param cliente
	 */
	private void mostrarPanelCliente(Cliente cliente) {
		Main.setClienteActivo(cliente);//EL CLIENTE QUE INGRESO DEBE ESTAR ACTIVO EN EL MOMENTO DE COMPRAR
		PaneClienteController panelCliente = new PaneClienteController();
		panelCliente.mostrarFrame();//MOSTRAMOS LA INFOMACION EN LA PARTE DEL CLIENTE 
	}

	/**
	 * METODO QUE PERMITE CERRAR EL PROGRAMA Y MUESTRA UN MENDAJE CUANDO LE OPRIME EN LA X PARA CERRAR
	 */
	private void cerrarPrograma() {
		DialogoConfirmationController cuadroConfirmation = new DialogoConfirmationController();
		cuadroConfirmation.abrirConfirmation("¿Seguro que desea salir?");//MENSAJE PARA SABER SI QUIERE SALIR O NO 
	}
	/**
	 * METODO QUE MUESTRA UN FRAME
	 * @param primaryStage
	 */
	public  void mostrarLogin(Stage primaryStage) {
		//CARGO EL FXML
		Parent root;
		//FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/view/Login.fxml"));
			//AÑADO EL FXML A UNA SCENA
			Scene frameLogin = new Scene(root);
			//AÑADO LA SCENA A UNA VENTANA
			primaryStage.setScene(frameLogin);
			primaryStage.setResizable(false);
			InputStream inputStream;
	        inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
	        Image image = new Image(inputStream);
	        primaryStage.getIcons().add(image);
			//PERMITE PODER DESPLAZAR LA VENTANA DE INICIO A CUALQUIER PARTE DE LA PANTALLA
			root.setOnMousePressed(evt ->{
				x=evt.getSceneX();
				y=evt.getSceneY();
			});
			root.setOnMouseDragged(evt ->{
				primaryStage.setX(evt.getScreenX()-x);
				primaryStage.setY(evt.getScreenY()-y);
			});
			//QUITO LOS BORDES DE LA PANTALLA POR DEFECTO
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
