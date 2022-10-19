package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.application.Main;
import co.edu.uniquindio.model.Singleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerLoginAdmin {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnCrearCuenta;

	@FXML
	private Button btnIniciarSesion;

	@FXML
	private PasswordField txtContrasenia;

	@FXML
	private TextField txtUsuario;

	private Stage stageCreateAdmin;


	private void iniciarSesionAdmin() {
		paneAdminController paneController = new paneAdminController(); 
		paneController.mostrarFrame();
		Main.cerrarLogin();
	}
	
	public void crearCuenta(ActionEvent e) {
		CreateAdminController createAdmin = new CreateAdminController(); 
		createAdmin.mostrarFrame();
	}
	
	public void iniciarSesion(ActionEvent e) {

		if(!txtContrasenia.getText().isEmpty() && !txtUsuario.getText().isEmpty() && Singleton.verificarAdmin(txtContrasenia.getText(), txtUsuario.getText())) {
			iniciarSesionAdmin(); 
			Main.cerrarFrameLoginAdmin();
		}else {
			Main.abrirAlerta("No se encuentra ningún admin con ese usuario y contraseña");
		}

	}

	@FXML
	void initialize() {
		assert btnCrearCuenta != null : "fx:id=\"btnCrearCuenta\" was not injected: check your FXML file 'LoginAdmin.fxml'.";
		assert btnIniciarSesion != null : "fx:id=\"btnIniciarSesion\" was not injected: check your FXML file 'LoginAdmin.fxml'.";
		assert txtContrasenia != null : "fx:id=\"txtContrasenia\" was not injected: check your FXML file 'LoginAdmin.fxml'.";
		assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'LoginAdmin.fxml'.";

	}

	public void mostrarFrame() {
		//CARGO EL FXML
		Parent root;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			stageCreateAdmin = new Stage(); 
			fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/view/LoginAdmin.fxml"));
			root = fxmlLoader.load();
			stageCreateAdmin.setScene(new Scene(root));
			stageCreateAdmin.setTitle("Tienda Quindío");
			stageCreateAdmin.initModality(Modality.APPLICATION_MODAL);
			stageCreateAdmin.setResizable(false);
			InputStream inputStream;
			inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
			Image image = new Image(inputStream);
			Main.setFrameLoginAdmin(stageCreateAdmin);
			stageCreateAdmin.getIcons().add(image);
			stageCreateAdmin.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
