package co.edu.uniquindio.application;

import java.util.ArrayList;

import co.edu.uniquindio.controller.AlertaController;
import co.edu.uniquindio.controller.ControllerLogin;
import co.edu.uniquindio.model.Cliente;
import co.edu.uniquindio.model.DetalleFactura;
import co.edu.uniquindio.model.Singleton;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage frameLogin, frameCliente, frameAdmin, inputDialog, frameLoginAdmin, frameCreateAdmin, frameUpdateAdmin, frameCantProd,
	frameLoginFacturas;
	
	private static Cliente clienteActivo; 
	private static ArrayList<DetalleFactura> detallesClienteActivo; 
	
	@Override
	public void start(Stage primaryStage) {
		try {
			frameLogin = primaryStage;
			//INICIALIZO LA VARIABLE PRINCIPAL
			Singleton.createInstance("Tienda quindío");
			//ABRO LA VENTANA PRINCIPAL
			ControllerLogin login = new ControllerLogin(); 
			login.mostrarLogin(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cerrarInputDialog() {
		inputDialog.close();
	}
	
	
	/**
	 * @return the frameLogin
	 */
	public static Stage getFrameLogin() {
		return frameLogin;
	}

	/**
	 * @param frameLogin the frameLogin to set
	 */
	public static void setFrameLogin(Stage frameLogin) {
		Main.frameLogin = frameLogin;
	}

	/**
	 * @return the frameCliente
	 */
	public static Stage getFrameCliente() {
		return frameCliente;
	}

	/**
	 * @param frameCliente the frameCliente to set
	 */
	public static void setFrameCliente(Stage frameCliente) {
		Main.frameCliente = frameCliente;
	}

	/**
	 * @return the frameAdmin
	 */
	public static Stage getFrameAdmin() {
		return frameAdmin;
	}

	/**
	 * @param frameAdmin the frameAdmin to set
	 */
	public static void setFrameAdmin(Stage frameAdmin) {
		Main.frameAdmin = frameAdmin;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void cerrarLogin() {
		frameLogin.close();
	} 

	public static void cerrarPanelCliente() {
		frameCliente.close();
	}
	
	public static void mostrarLogin() {
		frameLogin.show();
	}
	
	public static void cerrarApplication() {
		System.exit(0); 
	}
	
	public static void abrirAlerta(String string) {
		AlertaController alerta = new AlertaController(); 
		alerta.mostrarFrame(string);
	}

	public static Stage getInputDialog() {
		return inputDialog;
	}

	public static void setInputDialog(Stage inputDialog) {
		Main.inputDialog = inputDialog;
	}

	public static void cerrarFrameLoginAdmin() {
		frameLoginAdmin.close();
	}

	public static Stage getFrameLoginAdmin() {
		return frameLoginAdmin;
	}

	public static void setFrameLoginAdmin(Stage frameLoginAdmin) {
		Main.frameLoginAdmin = frameLoginAdmin;
	}
	public static void cerrarFrameAdmin() {
		Main.frameAdmin.close();
	}

	public static Stage getFrameCreateAdmin() {
		return frameCreateAdmin;
	}

	public static void setFrameCreateAdmin(Stage frameCreateAdmin) {
		Main.frameCreateAdmin = frameCreateAdmin;
	}
	public static void cerrarFrameCreateAdmin() {
		frameCreateAdmin.close();
	}

	public static Stage getFrameUpdateAdmin() {
		return frameUpdateAdmin;
	}

	public static void setFrameUpdateAdmin(Stage frameUpdateAdmin) {
		Main.frameUpdateAdmin = frameUpdateAdmin;
	}
	
	public static void cerrarUpdateAdmin() {
		frameUpdateAdmin.close();
	}

	public static void cerrarFrameCliente() {
		frameCliente.close();
	}

	public static Stage getFrameCantProd() {
		return frameCantProd;
	}

	public static void setFrameCantProd(Stage frameCantProd) {
		Main.frameCantProd = frameCantProd;
	}
	
	public static void cerrarFrameCantProd() {
		Main.frameCantProd.close();
	}

	public static Cliente getClienteActivo() {
		return clienteActivo;
	}

	public static void setClienteActivo(Cliente clienteActivo) {
		Main.clienteActivo = clienteActivo;
	}

	public static Stage getFrameLoginFacturas() {
		return frameLoginFacturas;
	}

	public static void setFrameLoginFacturas(Stage frameLoginFacturas) {
		Main.frameLoginFacturas = frameLoginFacturas;
	}

	public static ArrayList<DetalleFactura> getDetallesClienteActivo() {
		return detallesClienteActivo;
	}

	public static void setDetallesClienteActivo(ArrayList<DetalleFactura> detallesClienteActivo) {
		Main.detallesClienteActivo = detallesClienteActivo;
	}
	
}
