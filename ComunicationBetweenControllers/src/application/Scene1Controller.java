package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {

    @FXML
    private Button btnClick;

    @FXML
    private Label lblUser;

    @FXML
    private TextField txtUser;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    void switchScene(ActionEvent event) throws IOException {
    	
    	String texto = txtUser.getText();
    	FXMLLoader laoder = FXMLLoader.load(getResource("Scene2.fxml"));
    	root = laoder.load();
    	Scene2Controller scene2Controller = laoder.getController();
    	scene2Controller.changeLlbl(texto);
    	
    	stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    
}