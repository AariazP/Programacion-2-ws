package principal1;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	@Override
    public void start(Stage ventana) {
		/**
		 * el try catchat es necesario para poder mostrar una respuesta 
		 * especifica por si sale alguna excepción
		 */
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/principal1/Ventana2.fxml"));
			Scene scene = new Scene(root);
			
			InputStream inputStream;
	        inputStream =  getClass().getResourceAsStream("/images/iconoApp.png");
	        Image image = new Image(inputStream);
			
			/**
			 * gracias a las ventanas se pondran mostrar todas las ventanas que tiene la interfas
			 * ya sea los titulos, iconosl, estilo de botones y varias cosas mas
			 */
			ventana.initStyle(StageStyle.UNDECORATED);
			ventana.setTitle("Logistica");
			ventana.getIcons().add(image);
			ventana.setScene(scene);
			ventana.centerOnScreen();
			ventana.setResizable(false);
			ventana.show();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
