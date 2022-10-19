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

	/**
	 * GUARDA LOS DATOS DEL ADMIN INGRESADOS POR EL USUARIO EN EL TEXTFIELD
	 * @param event
	 */
	@FXML
	void guardarDatosAdmin(ActionEvent event) {

		if(verificarCamposTexto()) {//SE VERIFICA EL METODO DE LOS CAMPOS SI ESTAN VACIOS
			String nombre = txtNomAdmin.getText(); 
			String direccion = txtAdressAdmin.getText(); 
			String email = txtEmailAdmin.getText(); 
			String fechaNacimiento = dateAdmin.getValue().toString();
			String usuario = txtUserAdmin.getText(); 
			String password = txtPasswordAdmin.getText(); 
			String sede = comBoxSedeAdmin.getValue(); 
			double sueldo = Double.parseDouble(txtSueldoAdmin.getText()); 
			
			//SI ESTAN VACION OBTENEMOS LOS NUEMOS DATOS DESDE EL SINGLETON
			Main.abrirAlerta(Singleton.actualizarAdmin(nombre,direccion, email, 
					fechaNacimiento, sede, usuario, password, sueldo ));
			Main.cerrarUpdateAdmin();
		}else {//SI LA INFOMACION QUE SE PIDE NO ES CORRECTA SALDRA UNA ALERTA 
			Main.abrirAlerta("Ingrese información válida");
		}
	}
	
	/**
	 * METODO BOOLEAN QUE VERIFICA SI LOS CAMPOS DE TEXTOS
	 * CUMPLE CON LA CONDICION DE INGRESAR LA INFORMACION Y ESTEN UTILIZADOS PARA CREAR AL ADMIN
	 * @return
	 */
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

	/**
	 * METODO QUE MUESTRA EL FRAME DEL UPDATE ADMIN
	 */
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
	
	/**
	 * METODO QUE INICIALIZA LOS COMBOBOX CON LA INFORMACION SUMINISTRADA DEL SINGLETON
	 */
	@FXML
	public void initialize() {
		comBoxSedeAdmin.getItems().clear();
		comBoxSedeAdmin.getItems().addAll(Singleton.obtenerStringSedes()); 
	}
}
