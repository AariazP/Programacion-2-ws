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
	 * METODO QUE REALIZA LAS ACCIONES DE UN BOTÓN
	 * @param e
	 */
	@FXML
	public void actions(ActionEvent e) {
		//FUNCIONA EL BOTÓN DE SALIR
		if(e.getSource() == btnExit) {
			cerrarPrograma();
		}else if(e.getSource() == btnIniciarSesion) {
			iniciarSesion(); 
			//FUNCIONA EL BOTÓN DE CREAR USUARIO
		}else if(e.getSource() == btnCrearUsuario) {
			crearUsuario(); 
		}else if(e.getSource() == btnIniciarSesionAdmin) {
			abrirLoginAdmin();
		}
		
	}
	private void abrirLoginAdmin() {
		ControllerLoginAdmin loginAdmin = new ControllerLoginAdmin(); 
		loginAdmin.mostrarFrame(); 
	}

	

	private void crearUsuario() {
		CrearUsuarioController crearUsuario = new CrearUsuarioController(); 
		crearUsuario.mostrarFrame();
	}

	/**
	 * MÉTODO QUE PERMITE A UN USUARIO INGRESAR SESIÓN
	 */
	private void iniciarSesion() {
		Cliente cliente = Singleton.getInstance().iniciarSesion(txtUsuario.getText(), txtContraseña.getText()); 
		if(cliente != null) {
			txtContraseña.setText("");
			txtUsuario.setText("");
			mostrarPanelCliente(cliente); 
		}else {
			txtContraseña.setText("");
			txtUsuario.setText("");
			Main.abrirAlerta("No existe este usuario");
		}
	}

	private void mostrarPanelCliente(Cliente cliente) {
		Main.setClienteActivo(cliente);
		PaneClienteController panelCliente = new PaneClienteController();
		panelCliente.mostrarFrame(); 
	}

	/**
	 * Método que permite cerrar el programa y detenerlo
	 */
	private void cerrarPrograma() {
		DialogoConfirmationController cuadroConfirmation = new DialogoConfirmationController();
		cuadroConfirmation.abrirConfirmation("¿Seguro que desea salir?"); 
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
