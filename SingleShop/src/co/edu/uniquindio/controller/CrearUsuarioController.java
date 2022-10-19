package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;

import co.edu.uniquindio.application.Main;
import co.edu.uniquindio.model.Singleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CrearUsuarioController {

	@FXML
	private Button btnCrearCuenta;

	@FXML
	private DatePicker dateFecha;

	@FXML
	private TextField txtCiudad;

	@FXML
	private PasswordField txtContrasenia;

	@FXML
	private TextField txtCorreo;

	@FXML
	private TextField txtDepartamento;

	@FXML
	private TextField txtDireccion;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtUsuario;

	Stage stageCreateUser; 

	public void crearUsuario(ActionEvent e) {
		if(e.getSource() == btnCrearCuenta) {
			crearUsuario();
		}
	}

	/**
	 * METODO QUE CREA UN USUARIO Y VERIFICA QUE LOS CAMPOS NO SEAN NULOS
	 */
	private void crearUsuario() {
		//VERIFICO QUE LOS CAMPOS NO SEAN NULOS
		if(!txtCiudad.getText().equals("") && !txtContrasenia.getText().equals("") && !txtCorreo.getText().equals("") && !txtDepartamento.getText().equals("")
				&& !txtDireccion.getText().equals("") && !txtNombre.getText().equals("") && !txtUsuario.getText().equals("") && !dateFecha.getValue().toString().equals("")) {
			//SE INTENTA CREAR EL CLIENTE, SI EXISTE OTRO CLIENTE CON EL MISMO USUARIO NO DEJA CREARLO 
			String resultado = crearUsuarioTienda(); 
			//MUESTRO POR PANTALLA EL RESULTADO
			Main.abrirAlerta(resultado);
			limpiarCamposTexto(); 
		}else {
			Main.abrirAlerta("Verifique los datos ingresados");
			limpiarCamposTexto(); 
		}
	}
	
	private void limpiarCamposTexto() {
		txtCiudad.setText("");
		txtContrasenia.setText("");
		txtCorreo.setText("");
		txtDepartamento.setText("");
		txtDireccion.setText("");
		txtNombre.setText("");
		txtUsuario.setText("");
	}

	/**
	 * METODO QUE CREA UN CLIENTE EN LA TIENDA
	 * @return
	 */
	public String crearUsuarioTienda() {
		//LE ENVIO LOS PARAMTEROS A LA INSTANCIA
		return  Singleton.getInstance().crearCliente(txtNombre.getText(), txtDireccion.getText(), txtCorreo.getText(), dateFecha.getValue().toString(),
				txtContrasenia.getText(),txtCiudad.getText(),
				txtDepartamento.getText(), txtUsuario.getText()); 
	}
	/**
	 * METODO QUE PERMITE MOSTRAR LA VENTA DE CREAR USUARIO
	 */
	public void mostrarFrame() {
		//CARGO EL FXML
		Parent root;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			stageCreateUser = new Stage(); 
			fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/view/CrearUsuario.fxml"));
			root = fxmlLoader.load();
			stageCreateUser.setScene(new Scene(root));
			stageCreateUser.setTitle("Tienda Quindío");
			stageCreateUser.initModality(Modality.APPLICATION_MODAL);
			stageCreateUser.setResizable(false);
			InputStream inputStream;
	        inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
	        Image image = new Image(inputStream);
	        stageCreateUser.getIcons().add(image);
			stageCreateUser.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
