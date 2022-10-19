package co.edu.uniquindio.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControllerLogin {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnSalir;

    @FXML
    private AnchorPane panel;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtUsuario;

    @FXML
    void IngresarAdmin(ActionEvent event) {

    }

    @FXML
    void ingresarUsuario(ActionEvent event) {
    	System.out.println(txtUsuario.getText());
    }

    @FXML
    void salir(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void initialize() {
        assert btnAdmin != null : "fx:id=\"btnAdmin\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'Login.fxml'.";
        assert panel != null : "fx:id=\"panel\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtContraseña != null : "fx:id=\"txtContraseña\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtUsuario != null : "fx:id=\"txtUsuario\" was not injected: check your FXML file 'Login.fxml'.";

    }
}

