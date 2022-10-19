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

public class CreateAdminController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private DatePicker dateAdmin = new DatePicker();

	@FXML
	private ComboBox<String> comBoxSedeAdmin = new ComboBox<String>(); 

	@FXML
	private TextField txtSueldoAdmin = new TextField(); 

	@FXML
	private TextField txtAdressAdmin = new TextField();

	@FXML
	private TextField txtEmailAdmin= new TextField();

	@FXML
	private TextField txtNomAdmin= new TextField();

	@FXML
	private PasswordField txtPasswordAdmin= new PasswordField();

	@FXML
	private TextField txtUserAdmin= new TextField();

	@FXML
	private Button btnAdmin = new Button(); 


	/**
	 * METODO QUE PERMITE MOSTRAR EL FRAME DE CREAR ADMINISTRADOR
	 */
	public void mostrarFrame() {
		//CARGO EL FXML
		Parent root;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			Stage frameCreateAdmin = new Stage(); 
			fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/view/CrearAdmin.fxml"));
			root = fxmlLoader.load();
			frameCreateAdmin.setScene(new Scene(root));
			frameCreateAdmin.setTitle("Tienda Quindío");
			frameCreateAdmin.initModality(Modality.APPLICATION_MODAL);
			frameCreateAdmin.setResizable(false);
			InputStream inputStream;
			inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
			Image image = new Image(inputStream);
			frameCreateAdmin.getIcons().add(image);
			Main.setFrameCreateAdmin(frameCreateAdmin); 
			frameCreateAdmin.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * CON LA ACCION DE ESTE METODO NOS PERMITE DALER A UN BOTOM Y CUANDO LA INFORMACION
	 * DEL ADMIN ESTE COMPLETA LA GUARDE Y PERMITA TENER PRIVILEGIOS COMO ADMIN
	 * @param e
	 */
	public void guardarDatosAdmin(ActionEvent e) {

		if(verificarCamposTexto()) {//VERIFICAMOS SI LOS CAMPOS DE TEXTOS EXISTEN
			String nombre = txtNomAdmin.getText(); 
			String direccion = txtAdressAdmin.getText(); 
			String email = txtEmailAdmin.getText(); 
			String fechaNacimiento = dateAdmin.getValue().toString();
			String usuario = txtUserAdmin.getText(); 
			String password = txtPasswordAdmin.getText(); 
			String sede = comBoxSedeAdmin.getValue(); 
			double sueldo = Double.parseDouble(txtSueldoAdmin.getText()); 

			String respuesta = Singleton.crearAdmin(nombre, direccion, email, 
					fechaNacimiento, sede, usuario, password, sueldo);//LLAMAMOS LA INFORMACION QUE HAY DEL ADMIN DESDE EL SINGLETON
			Main.abrirAlerta(respuesta); //NOS APARECERA UNA VENTANA DICENDO QUE LA INDORMACION QUEDO BIEN GUARDADA
			Main.cerrarFrameCreateAdmin();//LUEGO LE DAMOS AL BOTON CERRAR O DEVOLVERNOS, LUEGO DE LLENAR LA INFORMACION Y GUARDARLA
		}else if(verificarCamposTextoSinSede()) {//PERO SI SE CREA  EL ADMIN SIN UNA SEDE, SE HACE DE LA SIGUEINTE FORMA
			
			Main.abrirAlerta("Se creará un administrador sin sede");//LE MOSTRAR UNA ADVERTENCIA DE QUE EL ADMIN CREADO NO TENDRA SEDE
			//SE VA A GUARDAR LA INFORMACION PERO SIN LA SEDE
			String nombre = txtNomAdmin.getText(); 
			String direccion = txtAdressAdmin.getText(); 
			String email = txtEmailAdmin.getText(); 
			String fechaNacimiento = dateAdmin.getValue().toString();
			String usuario = txtUserAdmin.getText(); 
			String password = txtPasswordAdmin.getText(); 
			double sueldo = Double.parseDouble(txtSueldoAdmin.getText());
			
			//SE OBTENDRAN LOS DATOS DEL SINGLETON DEL NUEVO ADMINISTRADOR PERO SIN LA SEDE
			String respuesta = Singleton.crearAdmin(nombre, direccion, email, fechaNacimiento, null, usuario, password, sueldo);
			Main.abrirAlerta(respuesta);//NOS APARECERA UNA VENTANA DICENDO QUE LA INDORMACION QUEDO BIEN GUARDADA
			Main.cerrarFrameCreateAdmin();//LUEGO LE DAMOS AL BOTON CERRAR O DEVOLVERNOS, LUEGO DE LLENAR LA INFORMACION Y GUARDARLA
		}
		else {//SI LA INFORMACION ESTA MALA LES APARECERA UNA ALERTA DICIENDO QUE DEBEN MIRAR BIEN LA INFORMACION DE LOS CAMPOS DE TEXTOS
			Main.abrirAlerta("Verifique los campos de textos");
		}
	}
	
	/**
	 * EN ESTA PARTE SE VERIFICARA LA INFORMACION DEL ADMINISTRADOR QUE SE ESTA CREANDO 
	 * PERO SIN TENER UNA SEDE EN ESPECIFICO ESE ADMINISTRADOR
	 * @return
	 */
	private boolean verificarCamposTextoSinSede() {
		try {
			String nombre = txtNomAdmin.getText(); 
			String direccion = txtAdressAdmin.getText(); 
			String email = txtEmailAdmin.getText(); 
			String fechaNacimiento = dateAdmin.getValue().toString();
			String usuario = txtUserAdmin.getText(); 
			String password = txtPasswordAdmin.getText(); 
			double sueldo = Double.parseDouble(txtSueldoAdmin.getText()); 

			if(!nombre.isEmpty() && !direccion.isEmpty() && !email.isEmpty() && !fechaNacimiento.isEmpty() && ! usuario.isEmpty() && 
					!password.isEmpty()  && sueldo != 0) {//SI SE CUMNPLE CON LAS CONDICIONES DEL IF EL RESULTADO SERA...
				return true;//SU RESULTADO ES VERDADERO
			}
		}catch(Exception e) {
		}
		return false;//SI NO CUMPLE CON TODAS LAS CONDICINOES ENTONCES DEVUELVE UN FALSE
	}
	
	/**
	 * VERIFICAMOS LOS CAMPOS DE TEXTOS QUE AL PRINCIPIO ESTEN VACIOS
	 * PARA LUEGO INGRESAR LOS DATOS EN LOS TEXTFILEDS
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
			
			//SI LOS CAMPOS SON DIFERENTES DE ISEMPTY O DE VERDADERO, NOS PERMITIRA PONER INFOMRACION
			if(!nombre.isEmpty() && !direccion.isEmpty() && !email.isEmpty() && !fechaNacimiento.isEmpty() && ! usuario.isEmpty() && 
					!password.isEmpty() && !sede.isEmpty() && sueldo != 0) {
				return true;//RETORNARA TURE
			}
		}catch(Exception e) {
		}
		return false;//DE LO CONTRARIO RETORNARA FALSE
	}

	/**
	 * SE INICIALIZA LOS COMBOBOX TENIENDO EN CEUNTA LA INFOMRACION SUMINISTRADA POR EL SINGLETON
	 */
	@FXML
	public void initialize() {
		comBoxSedeAdmin.getItems().clear();
		comBoxSedeAdmin.getItems().addAll(Singleton.obtenerStringSedes());//SE LLAMA AL OBTENERSTRINGSEDES DEL SINGELTON PARA AGRGAR TODAS LAS SEDES QUE HAY
	}

}
