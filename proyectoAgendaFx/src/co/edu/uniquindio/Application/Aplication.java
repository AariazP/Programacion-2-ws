package co.edu.uniquindio.Application;

import java.io.InputStream;

import co.edu.uniquindio.Model.Agenda;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Aplication extends Application implements EventHandler<KeyEvent>{
	
	private KeyCombination combinaciones[] = new KeyCombination[11];
	
	
	private Agenda agenda;
	@Override
	public void start(Stage primaryStage) {
		try {
			agenda = new Agenda(10, 10, 10, "Agenda"); 
			asignarCombinación();
			Parent root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/Controller/Frame1.fxml"));
            Scene scene = new Scene(root);
            scene.setOnKeyPressed(this);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Agenda");
			
			InputStream inputStream;
	        inputStream =  getClass().getResourceAsStream("/co/edu/uniquindio/View/IconoAgenda.png");
	        Image image = new Image(inputStream);
	        primaryStage.getIcons().add(image);
	        primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void asignarCombinación() {
		combinaciones[0] = new KeyCodeCombination(KeyCode.Q, KeyCodeCombination.SHIFT_ANY);
		combinaciones[1] = new KeyCodeCombination(KeyCode.W, KeyCodeCombination.SHIFT_ANY);
		combinaciones[2] = new KeyCodeCombination(KeyCode.E, KeyCodeCombination.SHIFT_ANY);
		combinaciones[3] = new KeyCodeCombination(KeyCode.R, KeyCodeCombination.SHIFT_ANY);
		combinaciones[4] = new KeyCodeCombination(KeyCode.T, KeyCodeCombination.SHIFT_ANY);
		combinaciones[5] = new KeyCodeCombination(KeyCode.Y, KeyCodeCombination.SHIFT_ANY);
		combinaciones[6] = new KeyCodeCombination(KeyCode.U, KeyCodeCombination.SHIFT_ANY);
		combinaciones[7] = new KeyCodeCombination(KeyCode.I, KeyCodeCombination.SHIFT_ANY);
		combinaciones[8] = new KeyCodeCombination(KeyCode.O, KeyCodeCombination.SHIFT_ANY);
		combinaciones[9] = new KeyCodeCombination(KeyCode.P, KeyCodeCombination.SHIFT_ANY);
		combinaciones[10] = new KeyCodeCombination(KeyCode.A, KeyCodeCombination.SHIFT_ANY);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(KeyEvent event) {
		boolean flag = true;
		for (int i = 0; i < combinaciones.length && flag; i++) {
			if(combinaciones[0].match(event)) {
				imprimirPosicionesImpares();
				flag = false;
			}else if(combinaciones[1].match(event)) {
				flag = false;
				obtenerEdadMasRepetida();
			}else if(combinaciones[2].match(event)) {
				flag = false;
				obtenerPromedioEdadContactos();
			}else if(combinaciones[3].match(event)) {
				obtenerContactosMenoresEdad();
				flag = false;
			}else if(combinaciones[4].match(event)) {
				flag = false;
				calcularDesviacionEstandarEdades();
			}else if(combinaciones[5].match(event)) {
				flag = false;
				imprimirContactosAtrasHaciaAdelante();
			}else if(combinaciones[6].match(event)) {
				flag = false;
				inicializarContactosAleatoriamente();
			}else if(combinaciones[7].match(event)) {
				flag = false;
				inicializarGruposAleatoriamente();
			}else if(combinaciones[8].match(event)) {
				flag = false;
				inicializarEdadAleatoriamente();
			}else if(combinaciones[9].match(event)) {
				flag = false;
				creaArregloLetrasFrase();
			}else if(combinaciones[10].match(event)) {
				flag = false;
				AsociarContactoGrupo();
			}
		}
	}

	private void AsociarContactoGrupo() {
		
	}

	private void creaArregloLetrasFrase() {
		// TODO Auto-generated method stub
		
	}

	private void inicializarEdadAleatoriamente() {
		// TODO Auto-generated method stub
		
	}

	private void inicializarGruposAleatoriamente() {
		// TODO Auto-generated method stub
		
	}

	private void inicializarContactosAleatoriamente() {
		// TODO Auto-generated method stub
		
	}

	private void imprimirContactosAtrasHaciaAdelante() {
		// TODO Auto-generated method stub
		
	}

	private void calcularDesviacionEstandarEdades() {
		// TODO Auto-generated method stub
		
	}

	private void obtenerContactosMenoresEdad() {
		// TODO Auto-generated method stub
		
	}

	private void obtenerPromedioEdadContactos() {
		// TODO Auto-generated method stub
		
	}

	private void obtenerEdadMasRepetida() {
		mostrarInfo(agenda.creaArregloLetrasFrase()); 
	}

	/**
	 * Método que imprime posiciones impares de los contactos
	 */
	private void imprimirPosicionesImpares() {
		
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	public void mostrarInfo(String mensaje) {
		Alert alert;
		DialogPane dialog;
		 alert = new Alert(Alert.AlertType.INFORMATION);
		 alert.setHeaderText(mensaje);
		 alert.setTitle("Agenda");
		 Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		 stage.getIcons().add(new Image(this.getClass().getResource("/co/edu/uniquindio/View/iconoAlertas.png").toString()));
		 dialog = alert.getDialogPane();
		 //----
		 dialog.getStylesheets().add(getClass().getResource("/co/edu/uniquindio/View/style.css").toString());
		 dialog.getStyleClass().add("dialog");
		 alert.showAndWait();
	}

}
