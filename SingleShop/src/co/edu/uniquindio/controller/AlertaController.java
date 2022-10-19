package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertaController {

	@FXML
	private Label lblTexto = new Label();

	public void setLabel(String texto) {
		lblTexto.setText(texto);
	}


	public void mostrarFrame(String mensaje) {
		//CARGO EL FXML
		Parent root;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			Stage alerta = new Stage(); 
			fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/view/Alerta.fxml"));
			root = fxmlLoader.load();
			alerta.setScene(new Scene(root));
			AlertaController controllerDialog = fxmlLoader.getController(); 
			controllerDialog.setLabel(mensaje);
			alerta.setTitle("Tienda Quindío");
			alerta.initModality(Modality.APPLICATION_MODAL);
			alerta.setResizable(false);
			InputStream inputStream;
	        inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
	        Image image = new Image(inputStream);
	        alerta.getIcons().add(image);
			alerta.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}