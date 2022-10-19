package co.edu.uniquindio.controller;
import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
 * 
 * @author Alejandro Arias 
 * Proyecto Fisica general
 *
 */
public class Controlador {
	
	@FXML
	private Button btnCalProdVecto = new Button();
	@FXML
	private Button BtnAceptarUsuario = new Button();
	@FXML
	private Label lblMensajeUsuario = new Label(); 
	@FXML
	private TextField cmpIVectorA = new TextField(); 
	@FXML
	private TextField cmpJVectorA = new TextField(); 
	@FXML
	private TextField cmpKVectorA = new TextField();
	@FXML
	private TextField cmpIVectorB = new TextField();
	@FXML
	private TextField cmpJVectorB = new TextField();
	@FXML
	private TextField cmpKVectorB = new TextField(); 
	@FXML
	private TextField txtVectorAPunto = new TextField();
	@FXML
	private TextField txtVectorBPunto = new TextField();
	
	@FXML
	private TextField txtVectorAAngulo = new TextField();
	@FXML
	private TextField txtVectorBAngulo = new TextField();
	@FXML
	private TextField txtCineDista = new TextField();
	@FXML
	private TextField txtCineTiempo = new TextField();
	
	
	@FXML
	private TextField txtCinePoIni = new TextField();
	@FXML
	private TextField txtCineTiem = new TextField();
	@FXML
	private TextField txtCineAce = new TextField();
	@FXML
	private TextField txtCineVelIni = new TextField();

	
	@FXML
	private TextField txtVectorModulo = new TextField();
	
	
	
	
	private int [] vectorA, vectorB;
	
	private double[] vectorAProdVectorial = new double[3];
	private double[] vectorBProdVectorial = new double[3]; 
	
	private double[] vectorAPunto, vectorBPunto, vectorAAngulo, vectorBAngulo; 
	
	private double[] vectorModulo; 

	

	public int [] getVectorA() {
		return vectorA;
	}

	
	
	public void calcularModulo(ActionEvent e) {
		if(vectorModulo != null) {
			double modulo = 0; 
			for (int i = 0; i < vectorModulo.length; i++) {
				modulo += Math.pow(vectorModulo[i], 2);
			}
			modulo = Math.sqrt(modulo); 
			String pattern = "#.#";
	        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
	        String formattedDouble = decimalFormat.format(modulo);
	        mostrarInfo("El modulo del vector es: "+formattedDouble);
		}else {
			mostrarInfo("Guarde el vector antes");
		}
	}
	
	public void guardarVectorModulo(ActionEvent e) {
		try {
			String[] NumerosString = txtVectorModulo.getText().trim().split(""); 
			int tamanioArreglo = contarNumeros(NumerosString); 
			vectorModulo = crearArreglo(NumerosString, tamanioArreglo);
			mostrarInfo("Vector guardado");
		}catch(Exception exception) {
			mostrarInfo("Ingrese valores válidos ó verifique la entrada del texto.\n\r");
		}
	}
	
	
	public void calcularPosicion(ActionEvent e) {
		try {
			double x; 
			double poInicial = Double.parseDouble(txtCinePoIni.getText());  
			double veInic = Double.parseDouble(txtCineVelIni.getText());  
			double tiempo = Double.parseDouble(txtCineTiem.getText());  
			double aceleracion = Double.parseDouble(txtCineAce.getText()); 
			x= (poInicial) + (veInic*tiempo) + (0.5*aceleracion*tiempo*tiempo); 
			mostrarInfo("La posicion final en metros es: "+x+" metros");
		}catch(Exception exception) {
			
		}
		
	}
	public void calcularVelocidad (ActionEvent e) {
		try {
			double distancia = Double.parseDouble(txtCineDista.getText()); 
			double tiempo = Double.parseDouble(txtCineTiempo.getText()); 
			double velocidad = distancia/tiempo;
			mostrarInfo("La velocidad es: "+velocidad+" m/s");
		}catch(Exception exception) {
			mostrarInfo("Verifique que la entrada de datos sea correcta");
		}
	}
	
	public void guardarTiempo(ActionEvent e) {
		
	}
	/**
	 * Método que permite mostrar la información usando una ventana emergente
	 * @param mensaje
	 */
	public void mostrarInfo(String mensaje) {
		Alert alert;
		DialogPane dialog;
		alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(mensaje);
		//alert.setGraphic(new ImageView("/src/co/edu/uniquindio/View/iconoAlertas.png"));
		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(this.getClass().getResource("/co/edu/uniquindio/view/IconoCuadroDialogo.jpg").toString()));
		dialog = alert.getDialogPane();
		dialog.getStylesheets().add(getClass().getResource("/co/edu/uniquindio/View/style.css").toString());
		dialog.getStyleClass().add("dialog");
		alert.showAndWait();
	}

	public int [] getVectorB() {
		return vectorB;
	}

	public void setVectorB(int [] vectorB) {
		this.vectorB = vectorB;
	}

	
	public void crearVectorAProdVecto(ActionEvent e) {
		try {
			vectorAProdVectorial[0] = Double.parseDouble(cmpIVectorA.getText());
			vectorAProdVectorial[1] = Double.parseDouble(cmpJVectorA.getText());
			vectorAProdVectorial[2] = Double.parseDouble(cmpKVectorA.getText());
			mostrarInfo("Vector guardado");
		}catch(Exception exception) {
			mostrarInfo("Ingrese datos válidos");
		}
	}
	
	public void crearVectorBProdVecto(ActionEvent e) {
		try {
			vectorBProdVectorial[0] = Double.parseDouble(cmpIVectorB.getText());
			vectorBProdVectorial[1] = Double.parseDouble(cmpJVectorB.getText());
			vectorBProdVectorial[2] = Double.parseDouble(cmpKVectorB.getText());
			mostrarInfo("Vector guardado");
		}catch(Exception exception) {
			mostrarInfo("Ingrese datos válidos");
		}
	}
	
	public void calcularProductoVectorial(ActionEvent e) {
		double [] resultado = new double[3]; 
		resultado[0] = ((vectorAProdVectorial[1]*vectorBProdVectorial[2]) - (vectorAProdVectorial[2]*vectorBProdVectorial[1]));
		resultado[1] = -1*((vectorAProdVectorial[0]*vectorBProdVectorial[2])-(vectorAProdVectorial[2]*vectorBProdVectorial[0]));
		resultado[2] = ((vectorAProdVectorial[0]*vectorBProdVectorial[1])-(vectorAProdVectorial[1]*vectorBProdVectorial[0]));
		double modulo = Math.sqrt( Math.pow(resultado[0], 2) + Math.pow(resultado[1], 2) +Math.pow(resultado[2], 2)); 
		
		String pattern = "#.#";
        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
        String formattedDouble = decimalFormat.format(modulo);
		
		String mensaje = "El Producto vectorial de los dos vectores ingresados es: \r\n"+"\n"+
				resultado[0] +" I " + resultado[1] +" J " +resultado[2] +"K" +"\r\n"+"Su modulo: "+formattedDouble; 
		mostrarInfo(mensaje);
	}

	public double[] getVectorAProdVectorial() {
		return vectorAProdVectorial;
	}

	public void setVectorAProdVectorial(double[] vectorAProdVectorial) {
		this.vectorAProdVectorial = vectorAProdVectorial;
	}
	
	public void guardarVectorBPunto(ActionEvent e) {
		try {
			String[] NumerosString = txtVectorBPunto.getText().trim().split(""); 
			int tamanioArreglo = contarNumeros(NumerosString); 
			vectorBPunto = crearArreglo(NumerosString, tamanioArreglo);
			mostrarInfo("Vector guardado");
		}catch(Exception exception) {
			mostrarInfo("Ingrese valores válidos ó verifique la entrada del texto.\n\r");
		}
	}
	
	public void guardarVectorAPunto(ActionEvent e) {
		try {
			String[] NumerosString = txtVectorAPunto.getText().trim().split(""); 
			int tamanioArreglo = contarNumeros(NumerosString); 
			vectorAPunto = crearArreglo(NumerosString, tamanioArreglo);
			mostrarInfo("Vector guardado");
		}catch(Exception exception) {
			mostrarInfo("Ingrese valores válidos ó verifique la entrada del texto.\n\r");
		}
	}
	
	public void guardarVectorAAngulo(ActionEvent e) {
		try {
			String[] NumerosString = txtVectorAAngulo.getText().trim().split(""); 
			int tamanioArreglo = contarNumeros(NumerosString); 
			vectorAAngulo = crearArreglo(NumerosString, tamanioArreglo);
			mostrarInfo("Vector guardado");
		}catch(Exception exception) {
			mostrarInfo("Ingrese valores válidos ó verifique la entrada del texto.\n\r");
		}
	}
	
	public void guardarVectorBAngulo(ActionEvent e) {
		try {
			String[] NumerosString = txtVectorBAngulo.getText().trim().split(""); 
			int tamanioArreglo = contarNumeros(NumerosString); 
			vectorBAngulo = crearArreglo(NumerosString, tamanioArreglo);
			mostrarInfo("Vector guardado");
		}catch(Exception exception) {
			mostrarInfo("Ingrese valores válidos ó verifique la entrada del texto.\n\r");
		}
	}

	
	public void calcularAnguloVectores(ActionEvent e) {
		
		if(vectorAAngulo != null && vectorBAngulo != null) {
			
			if(vectorAAngulo.length == vectorBAngulo.length) {
				double punto = 0; 
				for(int i=0; i<vectorAAngulo.length; i++) {
					punto += vectorAAngulo[i]*vectorBAngulo[i]; 
				}
				
				double moduloA, moduloB; 
				moduloA = calcularModulo(vectorAAngulo); 
				moduloB = calcularModulo(vectorBAngulo);
				
				double aux = ((punto)/(moduloA*moduloB));
				aux = Math.acos(aux);
				aux = Math.toDegrees(aux);
				
				String pattern = "#.#";
		        DecimalFormat decimalFormat =  new DecimalFormat(pattern);
		        String formattedDouble = decimalFormat.format(aux);
				
				mostrarInfo("El ángulo que separa los dos vectores es: "+formattedDouble+" grado sexagesimales"); 
				
			}else {
				mostrarInfo("Los vectores deben tener la misma dimensión");
			}
			
		}else {
			mostrarInfo("Debe crear y guardar los vectores");
		}
		
	}
	private double calcularModulo(double[] vectorAAngulo2) {
		double modulo = 0;
		for (int i = 0; i < vectorAAngulo2.length; i++) {
			modulo += Math.pow(vectorAAngulo2[i], 2);  
		}
		modulo = Math.abs(Math.sqrt(modulo)); 
		return modulo;
	}

	private double[] crearArreglo(String[] numerosString, int tamanioArreglo) {
		int contador = 0; 
		double[] arreglo = new double[tamanioArreglo]; 
		for (int i = 0; i < numerosString.length; i++) {
			if(!numerosString[i].equals(" ")) {
				arreglo[contador] = Integer.parseInt(numerosString[i]); 
				contador ++; 
			}
		}
		return arreglo;
	}
	
	public void hacerProductoPunto(ActionEvent e) {
		double punto = 0; 
		if(vectorAPunto != null && vectorBPunto != null ) {
			
			if(vectorAPunto.length == vectorAPunto.length){
				for (int i = 0; i < vectorBPunto.length; i++) {
					punto += vectorAPunto[i]*vectorBPunto[i]; 
				}
				mostrarInfo("El producto de los vectores es: "+punto);
			}else {
				mostrarInfo("los vectores deben tener la misma dimensión");
			}
			
		}else {
			mostrarInfo("Debe crear los vectores");
		}
		
	}

	private int contarNumeros(String[] numerosString) {
		int contador = 0; 
		for (int i = 0; i < numerosString.length; i++) {
			if(!numerosString[i].equals(" ")) {
				contador++; 
			}
		}
		return contador;
	}

	public double[] getVectorAPunto() {
		return vectorAPunto;
	}

	public void setVectorAPunto(double[] vectorAPunto) {
		this.vectorAPunto = vectorAPunto;
	}

	public double[] getVectorBPunto() {
		return vectorBPunto;
	}

	public double[] getVectorModulo() {
		return vectorModulo;
	}

	public void setVectorModulo(double[] vectorModulo) {
		this.vectorModulo = vectorModulo;
	}

}
