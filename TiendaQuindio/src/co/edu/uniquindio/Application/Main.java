package co.edu.uniquindio.Application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;


public class Main extends Application {
	
	double x, y = 0; 
	
	@Override
	public void start(Stage stage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/View/Login.fxml"));
			Scene scene = new Scene(root); 
			stage.initStyle(StageStyle.UNDECORATED);
			scene.getStylesheets().add(getClass().getResource("/co/edu/uniquindio/View/application.css").toExternalForm());
			root.setOnMousePressed(evt ->{
				x=evt.getSceneX();
				y=evt.getSceneY();
			});
			root.setOnMouseDragged(evt ->{
				stage.setX(evt.getScreenX()-x);
				stage.setY(evt.getScreenY()-y);
			});
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
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
		dialog.getStylesheets().add(getClass().getResource("/co/edu/uniquindio/View/style.css").toString());
		dialog.getStyleClass().add("dialog");
		alert.showAndWait();
	}
}
