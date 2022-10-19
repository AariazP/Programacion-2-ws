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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UpdateAdminController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnAdmin;

	@FXML
	private ComboBox<String> comBoxSedeAdmin;

	@FXML
	private DatePicker dateAdmin;

	@FXML
	private TextField txtAdressAdmin;

	@FXML
	private TextField txtEmailAdmin;

	@FXML
	private TextField txtNomAdmin;

	@FXML
	private PasswordField txtPasswordAdmin;

	@FXML
	private TextField txtSueldoAdmin;

	@FXML
	private TextField txtUserAdmin;


	@FXML
	void guardarDatosAdmin(ActionEvent event) {

		if(verificarCamposTexto()) {
			String nombre = txtNomAdmin.getText(); 
			String direccion = txtAdressAdmin.getText(); 
			String email = txtEmailAdmin.getText(); 
			String fechaNacimiento = dateAdmin.getValue().toString();
			String usuario = txtUserAdmin.getText(); 
			String password = txtPasswordAdmin.getText(); 
			String sede = comBoxSedeAdmin.getValue(); 
			double sueldo = Double.parseDouble(txtSueldoAdmin.getText()); 

			Main.abrirAlerta(Singleton.actualizarAdmin(nombre,direccion, email, 
					fechaNacimiento, sede, usuario, password, sueldo ));
			Main.cerrarUpdateAdmin();
		}else {
			Main.abrirAlerta("Ingrese información válida");
		}
	}

	private boolean verificarCamposTexto() {
		try {
			String nombre = txtNomAdmin.getText(); 
			String direccion = txtAdressAdmin.getText(); 
			String email = txtEmailAdmin.getText(); 
			String fechaNacimiento = dateAdmin.getValue().toString();
			String usuario = txtUserAdmin.getText(); 
			String password = txtPasswordAdmin.getText(); 
			String sede = comBoxSedeAdmin.getValue(); 
			double sueldo = Double.parseDouble(txtSueldoAdmin.getText()); 

			if(!nombre.isEmpty() && !direccion.isEmpty() && !email.isEmpty() && !fechaNacimiento.isEmpty() && ! usuario.isEmpty() && 
					!password.isEmpty() && !sede.isEmpty() && sueldo != 0) {
				return true; 
			}
		}catch(Exception e) {
		}
		return false;
	}




	public void mostrarFrame() {
		
		//CARGO EL FXML
		Parent root;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			Stage frameCreateAdmin = new Stage(); 
			fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/view/UpdateAdmin.fxml"));
			root = fxmlLoader.load();
			frameCreateAdmin.setScene(new Scene(root));
			frameCreateAdmin.setTitle("Tienda Quindío");
			frameCreateAdmin.initModality(Modality.APPLICATION_MODAL);
			frameCreateAdmin.setResizable(false);
			InputStream inputStream;
			inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
			Image image = new Image(inputStream);
			frameCreateAdmin.getIcons().add(image);
			Main.setFrameUpdateAdmin(frameCreateAdmin); 
			frameCreateAdmin.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void initialize() {
		comBoxSedeAdmin.getItems().clear();
		comBoxSedeAdmin.getItems().addAll(Singleton.obtenerStringSedes()); 
	}
}
