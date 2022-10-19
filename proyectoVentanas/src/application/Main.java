package application;

import java.io.IOException;
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {

	private Double x,y; 

	
	@Override
	public void start(Stage primaryStage) {
		//CARGO EL FXML
		Parent root;
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(Main.class.getResource("/application/Frame1.fxml"));
			root = loader.load();
			ControllerFrame1 controllerAux = loader.getController(); 
			controllerAux.setMain(this);
			//AÑADO EL FXML A UNA SCENA
			Scene frameLogin = new Scene(root);
			//AÑADO LA SCENA A UNA VENTANA
			primaryStage.setScene(frameLogin);
			primaryStage.setResizable(false);
			//PERMITE PODER DESPLAZAR LA VENTANA DE INICIO A CUALQUIER PARTE DE LA PANTALLA
			root.setOnMousePressed(evt ->{
				x=evt.getSceneX();
				y=evt.getSceneY();
			});
			root.setOnMouseDragged(evt ->{
				primaryStage.setX(evt.getScreenX()-x);
				primaryStage.setY(evt.getScreenY()-y);
			});
			//QUITO LOS BORDES DE LA PANTALLA POR DEFECTO
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}





	public static void main(String[] args) {
		launch(args);
	}

	public void abrirFrame(String ruta) {
		Stage stage = new Stage(); 
		//CARGO EL FXML
		Parent root;
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation(Main.class.getResource("/application/Frame2.fxml"));
			root = loader.load();
			ControllerFrame2 controllerAux2 = loader.getController(); 
			controllerAux2.setMain(this); 
			//AÑADO EL FXML A UNA SCENA
			Scene frameLogin = new Scene(root);
			//AÑADO LA SCENA A UNA VENTANA
			stage.setScene(frameLogin);
			stage.setResizable(false);
			//PERMITE PODER DESPLAZAR LA VENTANA DE INICIO A CUALQUIER PARTE DE LA PANTALLA
			root.setOnMousePressed(evt ->{
				x=evt.getSceneX();
				y=evt.getSceneY();
			});
			root.setOnMouseDragged(evt ->{
				stage.setX(evt.getScreenX()-x);
				stage.setY(evt.getScreenY()-y);
			});
			//QUITO LOS BORDES DE LA PANTALLA POR DEFECTO
			stage.initStyle(StageStyle.UNDECORATED);
			Random r = new Random(); 
			
			stage.setX(r.nextInt(1000)); 
			stage.setY(r.nextInt(1000)); 
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




}
