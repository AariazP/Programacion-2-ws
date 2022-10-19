package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;
import co.edu.uniquindio.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InputController {

	@FXML
	private Button btnGuardar = new Button();

	@FXML
	private Label lblMensaje = new Label();

	@FXML
	private TextField txtRespuesta = new TextField();
	
	private Stage stage;
	
	private double x;

	private double y; 

	@FXML
	public void guardarInfo(ActionEvent event) {
		
		String resultado = txtRespuesta.getText();
		Main.cerrarInputDialog();
		paneAdminController.setNomSede(resultado);
	}


	public void mostrarFrame(String mensaje) {
		//CARGO EL FXML
		Parent root;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			stage = new Stage(); 
			fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/view/inputMessage.fxml"));
			root = fxmlLoader.load();
			stage.setScene(new Scene(root));
			InputController dialog = fxmlLoader.getController(); 
			dialog.setLabelText(mensaje);
			stage.setTitle("Tienda Quindío");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setResizable(false);
			InputStream inputStream;
			inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
			Image image = new Image(inputStream);
			stage.getIcons().add(image);
			Main.setInputDialog(stage); 
			stage.showAndWait();
			//PERMITE PODER DESPLAZAR LA VENTANA DE INICIO A CUALQUIER PARTE DE LA PANTALLA
			root.setOnMousePressed(evt ->{
				x=evt.getSceneX();
				y=evt.getSceneY();
			});
			root.setOnMouseDragged(evt ->{
				stage.setX(evt.getScreenX()-x);
				stage.setY(evt.getScreenY()-y);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setLabelText(String mensaje) {
		lblMensaje.setText(mensaje);
	}
}
