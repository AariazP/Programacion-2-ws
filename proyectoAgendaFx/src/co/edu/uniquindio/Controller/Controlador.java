package co.edu.uniquindio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Controlador {
	@FXML
	Button BtnClearContactos;
	@FXML
	Button btnAddContactos;
	@FXML
	Button btnRefrseh;
	@FXML
	Button btnExisteContacto;
	@FXML
	Button btnCleanGroups;
	@FXML
	Button btnRefreshGroups;
	@FXML
	Button btnaddGroups;
	@FXML
	Button btnCleanAppoinment;
	@FXML
	Button btnRefreshappo;
	@FXML
	Button btnaddAppo;
	@FXML
	Button btnBuscarContactos;
	@FXML
	Button btnElimiContacto;
	@FXML
	Button btnEspacioDisponible;
	@FXML
	Button btnOtrosAtajos;
	@FXML
	Button btnListarContactos;
	
	/**
	 * Método que permite mostrar la información usando una ventana emergente
	 * @param mensaje
	 */
	public void mostrarInfo(String mensaje) {
		Alert alert;
		DialogPane dialog;
		alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(mensaje);
		//alert.setGraphic(new ImageView("/src/co/edu/uniquindio/View/iconoAlertas.png"));
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(this.getClass().getResource("/co/edu/uniquindio/View/iconoAlertas.png").toString()));
		dialog = alert.getDialogPane();
		dialog.getStylesheets().add(getClass().getResource("/co/edu/uniquindio/View/style.css").toString());
		dialog.getStyleClass().add("dialog");
		alert.showAndWait();
	}
	
	public void mostrarOtrosAtajos(ActionEvent e) {
		String mensaje = " Atajos de teclado para ver mas información sobre los contactos:\n\r"+"\n"+
				"Shift + Q:  Imprimir los contactos de las posiciones impares\r\n"
				+ "Shift + W: Obtener cual es la edad que más se repite\r\n"
				+ "Shift + E: Obtener el promedio de edades de los contactos\r\n"
				+ "Shift + R: Obtener los contactos con una edad menor a 18\r\n"
				+ "Shift + T: Calcular la desviación estándar de las edades\r\n"
				+ "Shift + Y: Imprimir el nombre de los contactos de atrás hacia adelante\r\n"
				+ "Shift + U: Inicializar de forma aleatoria la información de los contactos. (TestData)[20 nombres de prueba]\r\n"
				+ "Shift + I: Inicializar de forma aleatoria la información de los grupos.(TestData)\r\n"
				+ "Shift + O: Inicializar los datos de la edad del contacto de forma aleatoria entre un rango de 15 a 60.\r\n"
				+ "Shift + P: Pedir al usuario por teclado una frase y pasar sus caracteres a un arreglo de caracteres.\r\n"
				+ "Shift + A: Asociar un contacto a un grupo dado el nombre del grupo";
		mostrarInfo(mensaje);
	}

}
