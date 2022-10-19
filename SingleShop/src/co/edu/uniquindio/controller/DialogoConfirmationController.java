package co.edu.uniquindio.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DialogoConfirmationController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btnNo = new Button();

	@FXML
	private Button btnSi  = new Button();

	@FXML
	private Label lblTexto = new Label();

	private Stage stage = new Stage();

	private boolean decision;


	@FXML
	void initialize() {
	}

	/**
	 * Método que devuelve la decisión de un usuario con true 
	 * o false según el caso
	 * @param e
	 * @return
	 */
	@FXML
	public void actionPerformed(ActionEvent e) {
		//si el boton salir es presionado se cierra la ventana y se envía una decisión para cerrar
		if(e.getSource() == btnSi) {
			Main.cerrarApplication(); 
		}else if(e.getSource() == btnNo){
			decision = false;
			stage.close();
			stage.hide();
			System.out.println(decision);
		}
	}

	/**
	 * Método que permite cambiar el texto de un label
	 * @param titleLabel
	 */
	public void setLabel(String titleLabel) {
		lblTexto.setText(titleLabel);
	}


	public void mostrarDialogConfirmation(String titleLabel) {
		//CARGO EL FXML
		Parent root;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			Stage confirmationDialog = new Stage(); 
			fxmlLoader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/view/DialogoConfirmation.fxml"));
			root = fxmlLoader.load();
			confirmationDialog.setScene(new Scene(root));
			DialogoConfirmationController controllerDialog = fxmlLoader.getController(); 
			controllerDialog.setLabel(titleLabel);
			confirmationDialog.setTitle("Tienda Quindío");
			confirmationDialog.initModality(Modality.APPLICATION_MODAL);
			confirmationDialog.setResizable(false);
			InputStream inputStream;
	        inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
	        Image image = new Image(inputStream);
	        confirmationDialog.getIcons().add(image);
			confirmationDialog.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * METODO QUE ABRE EL CUADRO DE DIALOGO CON EL TITULO
	 * @param titleLabel
	 * @return
	 */
	public void abrirConfirmation(String titleLabel) {
		mostrarDialogConfirmation(titleLabel);
	}
}
