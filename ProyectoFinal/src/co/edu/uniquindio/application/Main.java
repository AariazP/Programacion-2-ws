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
	
	/**
	 * METODO QUE CIERRA UNA VENTANA
	 */
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

	/**
	 * METODO QUE CIERRRA EL FRAME DEL PANEL DE CLIENTE
	 */
	public static void cerrarLogin() {
		frameLogin.close();
	} 

	/**
	 * METODO QUE CIERRRA EL FRAME DEL PANEL DE CLIENTE
	 */
	public static void cerrarPanelCliente() {
		frameCliente.close();
	}
	
	/**
	 * METODO QUE MUESTRA EL FRAME DE INICIAR SECION
	 */
	public static void mostrarLogin() {
		frameLogin.show();
	}
	
	/**
	 * METODO QUE CIERRA EL FRAME DE LA APLICACION
	 */
	public static void cerrarApplication() {
		System.exit(0); 
	}
	
	/**
	 * METODO QUE MUESTRA UNA ALERTA CUANDO ES NECESARIA
	 * EN EL FUNCIONAMIENTO DEL PROGRAMA
	 * @param string
	 */
	public static void abrirAlerta(String string) {
		AlertaController alerta = new AlertaController(); 
		alerta.mostrarFrame(string);
	}

	//-----------------GETTER AND SETTER DEL INPUT DIALOG---------------------------------------
	public static Stage getInputDialog() {
		return inputDialog;
	}

	public static void setInputDialog(Stage inputDialog) {
		Main.inputDialog = inputDialog;
	}

	//------------------------------------------------------------------------
	/**
	 * METODO QUE CIERRA EL FRAME QUE MUESTRA EL INICIO DE SECION DEL ADMINISTRADOR
	 */
	public static void cerrarFrameLoginAdmin() {
		frameLoginAdmin.close();
	}

	//----------------GETTER AND SETTER DEL LOGIN DEL ADMIN---------------------------------------
	public static Stage getFrameLoginAdmin() {
		return frameLoginAdmin;
	}

	public static void setFrameLoginAdmin(Stage frameLoginAdmin) {
		Main.frameLoginAdmin = frameLoginAdmin;
	}
	
	//------------------------------------------------------------------------
	/**
	 * METODO QUE CIERRA EL FRAME QUE MUESTRA LAS OPCIONES DEL ADMINISTRADOR (PANEL ADMIN)
	 */
	public static void cerrarFrameAdmin() {
		Main.frameAdmin.close();
	}

	//-----------------GETTER AND SETTER PARA EL CREAR DEL ADMIN------------------------------------
	public static Stage getFrameCreateAdmin() {
		return frameCreateAdmin;
	}

	public static void setFrameCreateAdmin(Stage frameCreateAdmin) {
		Main.frameCreateAdmin = frameCreateAdmin;
	}
	
	//-------------------------------------------------------------------------
	/**
	 * METODO QUE CIERRA EL FRAME QUE MUESTRA COMO CREAR UN ADMINISTRADOR
	 */
	public static void cerrarFrameCreateAdmin() {
		frameCreateAdmin.close();
	}

	//----------------GETTER AND SETTER DE UPDATEADMIN---------------------------
	public static Stage getFrameUpdateAdmin() {
		return frameUpdateAdmin;
	}

	public static void setFrameUpdateAdmin(Stage frameUpdateAdmin) {
		Main.frameUpdateAdmin = frameUpdateAdmin;
	}
	
	//------------------------------------------------------------------
	/**
	 * METODO QUE CIERRA EL FRAME QUE MUESTRA LA ACTUALIZACION DE UN CLIENTE
	 */
	public static void cerrarUpdateAdmin() {
		frameUpdateAdmin.close();
	}

	/**
	 * METODO QUE CIERRA EL FRAME QUE MUESTRA LA INTERFAZ DE CLIENTE (PANEL DEL CLIENTE)
	 */
	public static void cerrarFrameCliente() {
		frameCliente.close();
	}

	//------------------GETTERS AND SETTERS DEL FRAME PRODUCTO----------------------------------------
	public static Stage getFrameCantProd() {
		return frameCantProd;
	}

	public static void setFrameCantProd(Stage frameCantProd) {
		Main.frameCantProd = frameCantProd;
	}
	
	/**
	 * METODO QUE CIERRA EL FRAME QUE MUESTRA LA CANTIDAD DE PRODUCTOS DEL CLIENTE 
	 */
	public static void cerrarFrameCantProd() {
		Main.frameCantProd.close();
	}

	//------------------GETTERS AND SETTERS INTERFACE----------------------------------------
	public static Cliente getClienteActivo() {
		return clienteActivo;
	}

	public static void setClienteActivo(Cliente clienteActivo) {
		Main.clienteActivo = clienteActivo;
	}

	//------------------GETTERS AND SETTERS DE REGISTRAR LA FACRUTRA----------------------------------------
	public static Stage getFrameLoginFacturas() {
		return frameLoginFacturas;
	}

	public static void setFrameLoginFacturas(Stage frameLoginFacturas) {
		Main.frameLoginFacturas = frameLoginFacturas;
	}

	//------------------GETTERS AND SETTERS DE LA LSITA DE DETALLES FACTURAS DEL COMPRADOR ACTIVO----------------------------------------
	public static ArrayList<DetalleFactura> getDetallesClienteActivo() {
		return detallesClienteActivo;
	}

	public static void setDetallesClienteActivo(ArrayList<DetalleFactura> detallesClienteActivo) {
		Main.detallesClienteActivo = detallesClienteActivo;
	}
	
}
