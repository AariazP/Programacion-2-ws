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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CantProdCompradoController {
	
	private Stage stage;
    @FXML
    private Button btnGuardar = new Button();

    @FXML
    private TextField txtCantidad = new TextField();

    
    public void mostrarFrame() {
    	stage = new Stage(); 
    	Parent root; 
		try {
			root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/view/CantidadProdComprado.fxml"));
			//AÑADO EL FXML A UNA SCENA
			Scene scene = new Scene(root);
			//AÑADO LA SCENA A UNA VENTANA
			stage.setScene(scene);
			stage.setResizable(false);
			//QUITO LOS BORDES DE LA PANTALLA POR DEFECTO
			InputStream inputStream;
	        inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/view/tiendaLogo.png");
	        Image image = new Image(inputStream);
	        stage.getIcons().add(image);
			Main.setFrameCantProd(stage); 
			stage.showAndWait();
		} catch (IOException e) {
		}
    }
    
    public void guardarInfo(ActionEvent e) {
    	try {
			int cantidad = Integer.parseInt(txtCantidad.getText()); 
    		PaneClienteController.setCantidad(cantidad);
    		Main.cerrarFrameCantProd();
		} catch (Exception e2) {
			Main.abrirAlerta("Ingrese info válida");
			txtCantidad.setText("");
		}
    }

}
