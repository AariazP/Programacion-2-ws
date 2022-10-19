package application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene2Controller {
	
	@FXML
    private Label lblTitulo;
	
	public void changeLlbl(String string) {
		lblTitulo.setText("Hello "+string);
	}
}
