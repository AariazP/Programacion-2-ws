/**
 * Sample Skeleton for 'Vista.fxml' Controller Class
 */

package co.edu.uniquindio.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class ControllerVista {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="BtnCrearCliente"
    private Button BtnCrearCliente; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarAdmin"
    private Button btnActualizarAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarCliente"
    private Button btnActualizarCliente; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddSedes"
    private Button btnAddSedes; // Value injected by FXMLLoader

    @FXML // fx:id="btnBuscarAdmin"
    private Button btnBuscarAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="btnBuscarCliente"
    private Button btnBuscarCliente; // Value injected by FXMLLoader

    @FXML // fx:id="btnClienteMasCompras"
    private Button btnClienteMasCompras; // Value injected by FXMLLoader

    @FXML // fx:id="btnComputacional"
    private Button btnComputacional; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearAdmin"
    private Button btnCrearAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearProductoEmpre"
    private Button btnCrearProductoEmpre; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearProductoHogar"
    private Button btnCrearProductoHogar; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearProductoMovil"
    private Button btnCrearProductoMovil; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearProductosMusica"
    private Button btnCrearProductosMusica; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteSedes"
    private Button btnDeleteSedes; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarAdmin"
    private Button btnEliminarAdmin; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarCliente"
    private Button btnEliminarCliente; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarProductoEmpre"
    private Button btnEliminarProductoEmpre; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarProductoHogar"
    private Button btnEliminarProductoHogar; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarProductoMovil"
    private Button btnEliminarProductoMovil; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarProductosMusica"
    private Button btnEliminarProductosMusica; // Value injected by FXMLLoader

    @FXML // fx:id="btnEmpresarial"
    private Button btnEmpresarial; // Value injected by FXMLLoader

    @FXML // fx:id="btnFacturasCliente"
    private Button btnFacturasCliente; // Value injected by FXMLLoader

    @FXML // fx:id="btnHogar"
    private Button btnHogar; // Value injected by FXMLLoader

    @FXML // fx:id="btnInfoSedes"
    private Button btnInfoSedes; // Value injected by FXMLLoader

    @FXML // fx:id="btnMovil"
    private Button btnMovil; // Value injected by FXMLLoader

    @FXML // fx:id="btnMusica"
    private Button btnMusica; // Value injected by FXMLLoader

    @FXML // fx:id="btnPerfil"
    private Button btnPerfil; // Value injected by FXMLLoader

    @FXML // fx:id="btnProductoMasVendidoFecha"
    private Button btnProductoMasVendidoFecha; // Value injected by FXMLLoader

    @FXML // fx:id="btnProductosMasVendidos"
    private Button btnProductosMasVendidos; // Value injected by FXMLLoader

    @FXML // fx:id="btnReemplazarContactos"
    private Button btnReemplazarContactos; // Value injected by FXMLLoader

    @FXML // fx:id="btnReemplazarProductoEmpre"
    private Button btnReemplazarProductoEmpre; // Value injected by FXMLLoader

    @FXML // fx:id="btnReemplazarProductoHogar"
    private Button btnReemplazarProductoHogar; // Value injected by FXMLLoader

    @FXML // fx:id="btnReemplazarProductoMovil"
    private Button btnReemplazarProductoMovil; // Value injected by FXMLLoader

    @FXML // fx:id="btnReemplazarProductosMusica"
    private Button btnReemplazarProductosMusica; // Value injected by FXMLLoader

    @FXML // fx:id="btnReporteFacturas"
    private Button btnReporteFacturas; // Value injected by FXMLLoader

    @FXML // fx:id="btnSalir"
    private Button btnSalir; // Value injected by FXMLLoader

    @FXML // fx:id="panelEmpresarial"
    private Pane panelEmpresarial; // Value injected by FXMLLoader

    @FXML // fx:id="panelHogar"
    private Pane panelHogar; // Value injected by FXMLLoader

    @FXML // fx:id="panelMovil"
    private Pane panelMovil; // Value injected by FXMLLoader

    @FXML // fx:id="panelMusica"
    private Pane panelMusica; // Value injected by FXMLLoader

    @FXML // fx:id="panelPerfil"
    private Pane panelPerfil; // Value injected by FXMLLoader
    
    @FXML // fx:id="panelPerfil"
    private Pane panelComputacional; // Value injected by FXMLLoader

    @FXML // fx:id="tblAdmi"
    private TableView<?> tblAdmi; // Value injected by FXMLLoader

    @FXML // fx:id="tblClientes"
    private TableView<?> tblClientes; // Value injected by FXMLLoader

    @FXML // fx:id="tblFacturas"
    private TableView<?> tblFacturas; // Value injected by FXMLLoader

    @FXML // fx:id="tblProductosEmpresarial"
    private TableView<?> tblProductosEmpresarial; // Value injected by FXMLLoader

    @FXML // fx:id="tblProductosMoviles"
    private TableView<?> tblProductosMoviles; // Value injected by FXMLLoader

    @FXML // fx:id="tblProductosMusica"
    private TableView<?> tblProductosMusica; // Value injected by FXMLLoader

    @FXML // fx:id="tblSedes"
    private TableView<?> tblSedes; // Value injected by FXMLLoader

    @FXML // fx:id="tblproductosHogar"
    private TableView<?> tblproductosHogar; // Value injected by FXMLLoader

    @FXML
    void CrearProductohogar(ActionEvent event) {

    }

    @FXML
    void agregarSede(ActionEvent event) {

    }

    @FXML
    void buscarAdmin(ActionEvent event) {

    }

    @FXML
    void buscarFacturasCliente(ActionEvent event) {

    }

    @FXML
    void crearProductoMovil(ActionEvent event) {

    }

    @FXML
    void crearProductosEmpresarial(ActionEvent event) {

    }

    @FXML
    void createAdmin(ActionEvent event) {

    }

    @FXML
    void createCliente(ActionEvent event) {

    }

    @FXML
    void deleteAdmin(ActionEvent event) {

    }

    @FXML
    void deleteCliente(ActionEvent event) {

    }

    @FXML
    void eliminarProductoHogar(ActionEvent event) {

    }

    @FXML
    void eliminarProductoMovil(ActionEvent event) {

    }

    @FXML
    void eliminarProductosEmpresarial(ActionEvent event) {

    }

    @FXML
    void eliminarSede(ActionEvent event) {

    }

    @FXML
    void getClienteMasCompras(ActionEvent event) {

    }

    @FXML
    void obtenerInfoSede(ActionEvent event) {

    }

    @FXML
    void obtenerProductoMasVendido(ActionEvent event) {

    }

    @FXML
    void obtenerProductosMasVendidos(ActionEvent event) {

    }

    @FXML
    void obtenerReporteFacturas(ActionEvent event) {

    }

    @FXML
    void reemplazarProductoEmpre(ActionEvent event) {

    }

    @FXML
    void reemplazarProductoHogar(ActionEvent event) {

    }

    @FXML
    void reemplazarProductoMovil(ActionEvent event) {

    }

    @FXML
    void replaceAdmin(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void searchCliente(ActionEvent event) {

    }

 
    @FXML
    void updateAdmin(ActionEvent event) {

    }

    @FXML
    void updateCliente(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert BtnCrearCliente != null : "fx:id=\"BtnCrearCliente\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnActualizarAdmin != null : "fx:id=\"btnActualizarAdmin\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnActualizarCliente != null : "fx:id=\"btnActualizarCliente\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnAddSedes != null : "fx:id=\"btnAddSedes\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnBuscarAdmin != null : "fx:id=\"btnBuscarAdmin\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnBuscarCliente != null : "fx:id=\"btnBuscarCliente\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnClienteMasCompras != null : "fx:id=\"btnClienteMasCompras\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnComputacional != null : "fx:id=\"btnComputacional\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnCrearAdmin != null : "fx:id=\"btnCrearAdmin\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnCrearProductoEmpre != null : "fx:id=\"btnCrearProductoEmpre\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnCrearProductoHogar != null : "fx:id=\"btnCrearProductoHogar\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnCrearProductoMovil != null : "fx:id=\"btnCrearProductoMovil\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnCrearProductosMusica != null : "fx:id=\"btnCrearProductosMusica\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnDeleteSedes != null : "fx:id=\"btnDeleteSedes\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnEliminarAdmin != null : "fx:id=\"btnEliminarAdmin\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnEliminarCliente != null : "fx:id=\"btnEliminarCliente\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnEliminarProductoEmpre != null : "fx:id=\"btnEliminarProductoEmpre\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnEliminarProductoHogar != null : "fx:id=\"btnEliminarProductoHogar\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnEliminarProductoMovil != null : "fx:id=\"btnEliminarProductoMovil\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnEliminarProductosMusica != null : "fx:id=\"btnEliminarProductosMusica\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnEmpresarial != null : "fx:id=\"btnEmpresarial\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnFacturasCliente != null : "fx:id=\"btnFacturasCliente\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnHogar != null : "fx:id=\"btnHogar\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnInfoSedes != null : "fx:id=\"btnInfoSedes\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnMovil != null : "fx:id=\"btnMovil\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnMusica != null : "fx:id=\"btnMusica\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnPerfil != null : "fx:id=\"btnPerfil\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnProductoMasVendidoFecha != null : "fx:id=\"btnProductoMasVendidoFecha\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnProductosMasVendidos != null : "fx:id=\"btnProductosMasVendidos\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnReemplazarContactos != null : "fx:id=\"btnReemplazarContactos\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnReemplazarProductoEmpre != null : "fx:id=\"btnReemplazarProductoEmpre\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnReemplazarProductoHogar != null : "fx:id=\"btnReemplazarProductoHogar\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnReemplazarProductoMovil != null : "fx:id=\"btnReemplazarProductoMovil\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnReemplazarProductosMusica != null : "fx:id=\"btnReemplazarProductosMusica\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnReporteFacturas != null : "fx:id=\"btnReporteFacturas\" was not injected: check your FXML file 'Vista.fxml'.";
        assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'Vista.fxml'.";
        assert panelEmpresarial != null : "fx:id=\"panelEmpresarial\" was not injected: check your FXML file 'Vista.fxml'.";
        assert panelHogar != null : "fx:id=\"panelHogar\" was not injected: check your FXML file 'Vista.fxml'.";
        assert panelMovil != null : "fx:id=\"panelMovil\" was not injected: check your FXML file 'Vista.fxml'.";
        assert panelMusica != null : "fx:id=\"panelMusica\" was not injected: check your FXML file 'Vista.fxml'.";
        assert panelPerfil != null : "fx:id=\"panelPerfil\" was not injected: check your FXML file 'Vista.fxml'.";
        assert panelComputacional != null : "fx:id=\"panelPerfil\" was not injected: check your FXML file 'Vista.fxml'.";
        assert tblAdmi != null : "fx:id=\"tblAdmi\" was not injected: check your FXML file 'Vista.fxml'.";
        assert tblClientes != null : "fx:id=\"tblClientes\" was not injected: check your FXML file 'Vista.fxml'.";
        assert tblFacturas != null : "fx:id=\"tblFacturas\" was not injected: check your FXML file 'Vista.fxml'.";
        assert tblProductosEmpresarial != null : "fx:id=\"tblProductosEmpresarial\" was not injected: check your FXML file 'Vista.fxml'.";
        assert tblProductosMoviles != null : "fx:id=\"tblProductosMoviles\" was not injected: check your FXML file 'Vista.fxml'.";
        assert tblProductosMusica != null : "fx:id=\"tblProductosMusica\" was not injected: check your FXML file 'Vista.fxml'.";
        assert tblSedes != null : "fx:id=\"tblSedes\" was not injected: check your FXML file 'Vista.fxml'.";
        assert tblproductosHogar != null : "fx:id=\"tblproductosHogar\" was not injected: check your FXML file 'Vista.fxml'.";

    }
    


@FXML
void switchPanel(ActionEvent event) {
	
	
	if(event.getSource() == btnPerfil) {
		
		panelPerfil.toFront();
		panelPerfil.setVisible(true);
		panelMovil.setVisible(false);
		panelComputacional.setVisible(false);
		panelMusica.setVisible(false);
		panelHogar.setVisible(false);
		panelEmpresarial.setVisible(false);
		
	}if(event.getSource() == btnMovil) {
		
		panelMovil.toFront();
		panelMovil.setVisible(true);
		panelPerfil.setVisible(false);
		panelComputacional.setVisible(false);
		panelMusica.setVisible(false);
		panelHogar.setVisible(false);
		panelEmpresarial.setVisible(false);
		
	}if(event.getSource() == btnComputacional) {
		
		panelComputacional.toFront();
		panelComputacional.setVisible(true);
		panelPerfil.setVisible(false);
		panelMovil.setVisible(false);
		panelMusica.setVisible(false);
		panelHogar.setVisible(false);
		panelEmpresarial.setVisible(false);
		
	}if(event.getSource() == btnMusica) {
		
		panelMusica.toFront();
		panelMusica.setVisible(true);
		panelPerfil.setVisible(false);
		panelMovil.setVisible(false);
		panelHogar.setVisible(false);
		panelEmpresarial.setVisible(false);
		panelComputacional.setVisible(false);
		
	}if(event.getSource() == btnHogar) {
		
		panelHogar.toFront();
		panelHogar.setVisible(true);
		panelMusica.setVisible(false);
		panelPerfil.setVisible(false);
		panelMovil.setVisible(false);
		panelEmpresarial.setVisible(false);
		panelComputacional.setVisible(false);
		
		
	}if(event.getSource() == btnEmpresarial) {
		panelEmpresarial.toFront();
		panelEmpresarial.setVisible(true);
		panelHogar.setVisible(false);
		panelMusica.setVisible(false);
		panelPerfil.setVisible(false);
		panelMovil.setVisible(false);
		panelComputacional.setVisible(false);
	}
	
}

  
}

