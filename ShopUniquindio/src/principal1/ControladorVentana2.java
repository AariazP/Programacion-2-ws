package principal1;

import java.util.Optional;

import clases.Empleado;
import clases.Estudiante;
import clases.Factura;
import clases.Producto;
import clases.Reporte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.shape.Line;

public class ControladorVentana2 {
	private int numEmpleado = 0, numEstudiante = 0, numProducto = 0, numFactura = 0;
	@FXML
	private Button btnNewEmpleado = new Button();
	@FXML
	private Label lblTituloEmpleado = new Label();
	@FXML
	private Label lblNombreEmpleado = new Label();
	@FXML
	private TextField txtAreaNombreEmpleado = new TextField();
	@FXML
	private Label lblIdenticacionNewEmpleado = new Label();
	@FXML
	private Line lnlLinea = new Line();
	@FXML
	private TextField txtAreaIdentifcacionNewEmpleado = new TextField();
	@FXML
	private TextField txtAniosTrabajosNewEmpleados = new TextField();
	@FXML
	private Label lblAniosTrabajados = new Label();
	@FXML
	private Button btnAniadirEmpleado = new Button();
	@FXML
	private Button btnNewEstudiante = new Button();
	@FXML
	private Line lnlLinea1 = new Line(); 
	@FXML
	private Line lnlLinea11 = new Line();
	//ESTUDIANTES
	@FXML
	private Label lblNuevoStudent = new Label();
	@FXML
	private Label lblNombreEstudiante = new Label();
	@FXML
	private TextField txtNombreEstudiante = new TextField();
	@FXML
	private TextField txtIdentificacionEstudiante = new TextField();
	@FXML
	private Button btnAniadirEstudiante = new Button();
	@FXML
	private Label lblEstudianteAgregado = new Label();
	@FXML
	private Label lblSoloTresEstudiantes = new Label();
	@FXML
	private Label lblIdentificacionEstudiante = new Label();
	@FXML
	private Label lblSlTresEstudiantes = new Label();
	//ADMINISTRAR PRODUCTOS
	@FXML
	private TextField txtNomPro = new TextField();
	@FXML
	private Button BtnSavePro = new Button();
	@FXML
	private Button btnProdCod = new Button();
	@FXML
	private Button btnCantFact = new Button();
	@FXML
	private Button btnReplacePro = new Button();
	@FXML
	private Label lblNewProd = new Label();
	@FXML
	private Label lblNomProd = new Label();
	@FXML
	private Button btnAdmProduct = new Button();
	@FXML
	private Label lblCantPro = new Label();
	@FXML
	private TextField txtCantProd = new TextField();
	@FXML
	private Label lblValorProd = new Label();
	@FXML
	private TextField txtValorProd = new TextField();
	//FACTURAS
	@FXML
	private CheckBox checkProd1 = new CheckBox(); 
	@FXML
	private CheckBox checkProd2 = new CheckBox();
	@FXML
	private CheckBox checkProd3 = new CheckBox();
	@FXML
	private Label lblGenFact = new Label(); 
	@FXML
	private Label lblEmpleadoFactura = new Label(); 
	@FXML
	private TextField txtNomEmpleFactura = new TextField();
	@FXML
	private Button btnFacturaCodigo = new Button();
	@FXML
	private Button btnFacturasEmpleado = new Button();
	@FXML
	private Button btnGenerarFactura = new Button();
	@FXML
	private Button btnAdmFact = new Button();
	//REPORTES
	@FXML
	private Button btnReport = new Button();
	@FXML
	private Button btnEstudianteMoreF = new Button();
	@FXML
	private Button btnPagoEm = new Button();
	@FXML
	private Button btnDineroRecaudado = new Button();
	@FXML
	private Label lblReportes = new Label(); 
	








	private Empleado empleado1,empleado2, empleado3;

	private Estudiante estudiante1, estudiante2, estudiante3;

	private Factura factura1, factura2, factura3; 

	private Producto producto1, producto2, producto3;

	private Reporte reporte = new Reporte(); 
	
	private double valorNewProd = 0;  
	
	public void mostrarNuevoEmpleado(ActionEvent e) {
		ocultarEstudiante();
		ocultarAdmProducto();
		ocultarFactura();
		ocultarReporte();
		lblTituloEmpleado.setVisible(true);
		lblNombreEmpleado.setVisible(true);
		txtAreaNombreEmpleado.setVisible(true);
		lblIdenticacionNewEmpleado.setVisible(true);
		lnlLinea.setVisible(true);
		txtAreaIdentifcacionNewEmpleado.setVisible(true);
		txtAniosTrabajosNewEmpleados.setVisible(true);
		lblAniosTrabajados.setVisible(true);
		lnlLinea1.setVisible(true);
		lnlLinea11.setVisible(true);
		btnAniadirEmpleado.setVisible(true);
	}

	public void crearEmpleado(ActionEvent e) {

		if (numEmpleado == 0) {
			empleado1 = new Empleado(txtAreaNombreEmpleado.getText(), txtAreaIdentifcacionNewEmpleado.getText(), txtAniosTrabajosNewEmpleados.getText());
			numEmpleado++;
			showVentana("Usuario agregado");

		}
		else if (numEmpleado == 1){
			empleado2 = new Empleado(txtAreaNombreEmpleado.getText(), txtAreaIdentifcacionNewEmpleado.getText(), txtAniosTrabajosNewEmpleados.getText());
			numEmpleado++;
			showVentana("Usuario agregado");
		}else if(numEmpleado ==2){
			empleado3 = new Empleado(txtAreaNombreEmpleado.getText(), txtAreaIdentifcacionNewEmpleado.getText(), txtAniosTrabajosNewEmpleados.getText());
			numEmpleado++;
			showVentana("Usuario agregado");
		}else {
			showVentana("Solo tres Empleados");
		}
	}

	public void showVentana(String texto) {
		Alert alerta = new Alert(Alert.AlertType.INFORMATION);
		alerta.setHeaderText(texto);
		alerta.showAndWait();
	}

	public void ocultarCrearEmpleado() {
		lblTituloEmpleado.setVisible(false);
		lblNombreEmpleado.setVisible(false);
		txtAreaNombreEmpleado.setVisible(false);
		lblIdenticacionNewEmpleado.setVisible(false);
		lnlLinea.setVisible(false);
		txtAreaIdentifcacionNewEmpleado.setVisible(false);
		txtAniosTrabajosNewEmpleados.setVisible(false);
		lblAniosTrabajados.setVisible(false);
		lnlLinea1.setVisible(false);
		lnlLinea11.setVisible(false);
		btnAniadirEmpleado.setVisible(false);
	}

	public void mostrarEstudiante(ActionEvent e) {
		ocultarReporte();
		ocultarCrearEmpleado();
		ocultarAdmProducto();
		ocultarFactura();
		lblNombreEstudiante.setVisible(true);
		txtNombreEstudiante.setVisible(true);
		txtIdentificacionEstudiante.setVisible(true);
		btnAniadirEstudiante.setVisible(true);
		lblIdentificacionEstudiante.setVisible(true);
		lblNuevoStudent.setVisible(true);
	}

	public void ocultarEstudiante() {
		lblNuevoStudent.setVisible(false);
		lblNombreEstudiante.setVisible(false);
		txtNombreEstudiante.setVisible(false);
		txtIdentificacionEstudiante.setVisible(false);
		btnAniadirEstudiante.setVisible(false);
		lblIdentificacionEstudiante.setVisible(false);
	}

	public void crearEstudiante(ActionEvent e) {

		if (numEstudiante == 0) {
			estudiante1 = new Estudiante(txtNombreEstudiante.getText(), txtIdentificacionEstudiante.getText());
			numEstudiante++;
			showVentana("Estudiante agregado");
		}
		else if (numEstudiante == 1){
			estudiante2 = new Estudiante(txtNombreEstudiante.getText(), txtIdentificacionEstudiante.getText());
			numEstudiante++;
			showVentana("Estudiante agregado");
		}else if(numEstudiante ==2){
			estudiante3 = new Estudiante(txtNombreEstudiante.getText(),  txtIdentificacionEstudiante.getText());
			numEstudiante++;
			showVentana("Estudiante agregado");
		}else {
			showVentana("No puedes agregar mas de tres estudiantes");
		}
	}

	public void mostrarAdmProducto(ActionEvent e) {
		ocultarEstudiante();
		ocultarCrearEmpleado();
		ocultarFactura();
		ocultarReporte();
		txtNomPro.setVisible(true);
		BtnSavePro.setVisible(true);
		btnProdCod.setVisible(true);
		btnCantFact.setVisible(true);
		btnReplacePro.setVisible(true);
		lblNewProd.setVisible(true);
		lblNomProd.setVisible(true);
		btnAdmProduct.setVisible(true);
		lblCantPro.setVisible(true);
		txtCantProd.setVisible(true);
		lblValorProd.setVisible(true);
		txtValorProd.setVisible(true);
	}

	public void ocultarAdmProducto() {
		txtNomPro.setVisible(false);
		BtnSavePro.setVisible(false);
		btnProdCod.setVisible(false);
		btnCantFact.setVisible(false);
		btnReplacePro.setVisible(false);
		lblNewProd.setVisible(false);
		lblNomProd.setVisible(false);
		lblCantPro.setVisible(false);
		txtCantProd.setVisible(false);
		lblValorProd.setVisible(false);
		txtValorProd.setVisible(false);
	}

	public void crearProducto(ActionEvent e) {

		if(numProducto==0) {
			producto1 = new Producto(txtNomPro.getText(), Integer.parseInt(txtCantProd.getText()), Double.parseDouble(txtValorProd.getText()));
			checkProd1.setText(producto1.getNombre());
			numProducto++;
			showVentana("Producto añadido");
		}else if(numProducto ==1) {
			producto2 = new Producto(txtNomPro.getText(), Integer.parseInt(txtCantProd.getText()), Double.parseDouble(txtValorProd.getText()));
			checkProd2.setText(producto2.getNombre());
			showVentana("Producto añadido");
			numProducto++; 
		}else if(numProducto==2) {
			producto3 = new Producto(txtNomPro.getText(), Integer.parseInt(txtCantProd.getText()), Double.parseDouble(txtValorProd.getText()));
			checkProd3.setText(producto3.getNombre());
			numProducto++; 
			showVentana("Producto añadido");
		}else {
			showVentana("No puedes tener mas de tres productos sustituye uno");
		}
	}

	public void buscarProductoCodigo(ActionEvent e) {
		String codigo = getDataUser("Ingrese el código del producto que desea ver: ");
		codigo.toUpperCase();
		if(!(producto1 == null)) {
			if((producto1.getCodigo().equals(codigo))){
				showVentana(producto1.toString());
			}
		}else if(!(producto2 == null)) {
			if(producto2.getCodigo().equals(codigo)) {
				showVentana(producto2.toString());
			}
		}else if(!(producto3 == null)) {
			if(producto3.getCodigo().equals(codigo)) {
				showVentana(producto3.toString());
			}
		}else {
			showVentana("No existe un producto con ese código");
		}
	}

	public String getDataUser(String mensaje) {
		String dato; 
		TextInputDialog tid = new TextInputDialog();
		tid.setHeaderText(null);
		tid.setTitle("Tienda Uniquindío");
		tid.setContentText(mensaje);
		Optional<String> texto = tid.showAndWait();
		dato = texto.get();
		return dato; 
	}

	public void buscarCantFacturas(ActionEvent e) {
		String nomProd = getDataUser("Ingrese el nombre del producto del que quiere ver la cantidad de facturas: ");

		if(nomProd.equals(null)) {
			showVentana("No puede estar vacío el campo");
		}else {
			if(nomProd.equals(producto1.getNombre())) {
				showVentana("El producto está en un total de facturas de: "+producto1.getCntFact());
			}else if(nomProd.equals(producto2.getNombre())) {
				showVentana("El producto está en un total de facturas de: "+producto2.getCntFact());
			}else if(nomProd.equals(producto3.getNombre())) {
				showVentana("El producto está en un total de facturas de: "+producto3.getCntFact());
			}else {
				showVentana("No existe un producto con ese nombre");
			}
		}
	}

	public void reemplazarProductos(ActionEvent e) {
		int prodNum= 0;
		boolean flag = true;
		String mensaje =""; 
		int decision; 
		do {
			mensaje = "Los productos que se han ingresado al sistema son los siguientes: \n"; 

			if(producto1 != null) {
				prodNum++; 
				mensaje += prodNum + ". "+producto1.getNombre()+"\n"; 
				producto1.setNumProd(prodNum);
			}

			if(producto2 != null) {
				prodNum++; 
				mensaje += prodNum + ". "+producto2.getNombre()+"\n"; 
				producto2.setNumProd(prodNum);
			}

			if(producto3 != null) {
				prodNum++; 
				mensaje += prodNum+". "+producto3.getNombre()+"\n"; 
				producto3.setNumProd(prodNum);
			}

			mensaje += "Ingrese el numero del producto que desea reemplazar: "; 

			decision = Integer.parseInt(getDataUser(mensaje));

			if (decision == producto1.getNumProd() || decision == producto2.getNumProd() || decision==producto3.getNumProd()) {

				String nomNewProd = getDataUser("Ingrese el nombre del producto: "); 
				int cantNewProd = Integer.parseInt(getDataUser("Ingrese la cantidad del producto: "));
				valorNewProd = Double.parseDouble(getDataUser("Ingrese el valor del producto: "));

				if(producto1.getNumProd()==decision) {
					producto1 = new Producto(nomNewProd, cantNewProd, valorNewProd); 
					showVentana("El producto queda asi:\n"+producto1.toString());
					checkProd1.setText(producto1.getNombre());
					flag = false; 
				}else if(producto2.getNumProd()==decision) {
					producto2 = new Producto(nomNewProd, decision, cantNewProd); 
					showVentana("El producto queda asi:\n"+producto2.toString());
					checkProd2.setText(producto2.getNombre());
					flag = false; 
				}else {
					producto3 = new Producto(nomNewProd, decision, cantNewProd);
					showVentana("El producto queda asi:\n"+producto3.toString());
					checkProd3.setText(producto3.getNombre());
					flag = false; 
				}
			}else {
				showVentana("Ingrese una opción válida");
			}
		}while(flag); 
	}

	public void mostrarFactura(ActionEvent e) {
		ocultarAdmProducto();
		ocultarCrearEmpleado();
		ocultarEstudiante();
		ocultarReporte();
		checkProd1.setVisible(true);
		checkProd2.setVisible(true);
		checkProd3.setVisible(true);
		lblGenFact.setVisible(true);
		lblEmpleadoFactura.setVisible(true);  
		txtNomEmpleFactura.setVisible(true); 
		btnFacturaCodigo.setVisible(true); 
		btnFacturasEmpleado.setVisible(true);
		btnGenerarFactura.setVisible(true);
	}

	public void ocultarFactura() {
		checkProd1.setVisible(false);
		checkProd2.setVisible(false);
		checkProd3.setVisible(false);
		lblGenFact.setVisible(false);
		lblEmpleadoFactura.setVisible(false);  
		txtNomEmpleFactura.setVisible(false); 
		btnFacturaCodigo.setVisible(false); 
		btnFacturasEmpleado.setVisible(false);
		btnGenerarFactura.setVisible(false);
	}

	public void generarFacturas(ActionEvent e) {
		if(numFactura == 0) {
			aniadirProductosFactura(factura1);
			numFactura++; 
		}else if(numFactura == 1) {
			aniadirProductosFactura(factura2);
			numFactura++; 
		}else if(numFactura ==2) {
			aniadirProductosFactura(factura2);
			numFactura++; 
		}else {
			showVentana("No puedes hacer mas de tres facturas");
		}
	}

	public void obtenerFacturaCodigo(ActionEvent e) {
		String codigo = getDataUser("Ingrese el codigo de la factura: ");
		//codigo = codigo.toLowerCase();
		if(factura1.getCodigo().equals(codigo)) {
			showVentana(factura1.toString());
		}else if(factura2.getCodigo().equals(codigo)) {
			showVentana(factura2.toString());
		}else if(factura3.getCodigo().equals(codigo)) {
			showVentana(factura3.toString());
		}else {
			showVentana("No hay ninguna factura con tal código");
		}
	}

	private void comprarProducto(Producto producto1, Factura factura) {
		boolean flag = true; 
		do {
			int cantProd1 = Integer.parseInt(getDataUser("Ingrese el número de unidades de "+producto1.getNombre()+":")); 
	
			if(cantProd1==0) {
				showVentana("No hay de ese producto");
				flag = false;
			}
			else if(cantProd1<=producto1.getUnidades()) {
				showVentana("Vas a comprar "+cantProd1+" y tiene un valor de: "+cantProd1*producto1.getValorProducto());
				producto1.restarUnidades(cantProd1);
				reporte.sumarDinero(cantProd1*producto1.getValorProducto());
				producto1.setCntFact();
				factura.setTotal(cantProd1*producto1.getValorProducto());
				sumarFacturasEstudiante(); 
				flag= false;
	
			}else {
				showVentana("No hay tantos de ese producto");
			}
		}while(flag);
}

	private void aniadirProductosFactura(Factura factura) {
		
		if(txtNomEmpleFactura.getText().equals(empleado1.getNombre()) || txtNomEmpleFactura.getText().equals(empleado2.getNombre()) 
				|| txtNomEmpleFactura.getText().equals(empleado3.getNombre())) {
	
			if(txtNomEmpleFactura.getText().equals(empleado1.getNombre())) {
				
				factura = new Factura(empleado1); 
				empleado1.setCantFacturas();
	
				if(checkProd1.isSelected()) {
					comprarProducto(producto1,factura);
				}if(checkProd2.isSelected()) {
					comprarProducto(producto2,factura);
				}if(checkProd3.isSelected()) {
					comprarProducto(producto3,factura);
				}
				empleado1.setPago(factura.getTotal()*0.2);
				empleado1.setPago((factura.getTotal()*0.02)*Integer.parseInt(empleado1.getAnios()));
				factura1 = factura;
				showVentana(factura.toString());
			}else if(txtNomEmpleFactura.getText().equals(empleado2.getNombre())) {
				
				factura = new Factura(empleado2); 
				empleado2.setCantFacturas();
				if(checkProd1.isSelected()) {
					comprarProducto(producto1,factura);
				}if(checkProd2.isSelected()) {
					comprarProducto(producto2,factura);
				}if(checkProd3.isSelected()) {
					comprarProducto(producto3,factura);
				}
				empleado2.setPago(factura.getTotal()*0.2);
				empleado2.setPago((factura.getTotal()*0.02)*Integer.parseInt(empleado2.getAnios()));
				showVentana(factura.toString());
				factura2 = factura;
			}else{
				factura = new Factura(empleado3); 
				empleado3.setCantFacturas();
	
				if(checkProd1.isSelected()) {
					comprarProducto(producto1,factura);
				}if(checkProd2.isSelected()) {
					comprarProducto(producto2,factura);
				}if(checkProd3.isSelected()) {
					comprarProducto(producto3,factura);
				}
				empleado3.setPago(factura.getTotal()*0.2);
				empleado3.setPago((factura.getTotal()*0.02)*Integer.parseInt(empleado3.getAnios()));
				showVentana(factura.toString());
				factura3 = factura;
			}
		}else {
			showVentana("No hay un empleado con ese nombre.");
		}
		
	
	}

	public void obtenerFacturasNomEmpl(ActionEvent e) {
		String mensaje =""; 
		if(empleado1 != null) {
			mensaje +="El empleado "+empleado1.getNombre()+" vendió "+empleado1.getCantFacturas()+" pedidos";
		}if(empleado2 != null) {
			mensaje +="El empleado "+empleado2.getNombre()+" vendió "+empleado2.getCantFacturas()+" pedidos";
		}if(empleado3 != null) {
			mensaje +="El empleado "+empleado3.getNombre()+" vendió "+empleado3.getCantFacturas()+" pedidos";
		}
		if(mensaje.equals("")) {
			mensaje +="Ningún emplado a vendido facturas aún"; 
		}
		showVentana(mensaje);
	}

	public void mostrarReporte(ActionEvent e) {
		
		ocultarAdmProducto();
		ocultarCrearEmpleado();
		ocultarEstudiante();
		ocultarFactura();
		btnEstudianteMoreF.setVisible(true); 
		btnPagoEm.setVisible(true);
		btnDineroRecaudado.setVisible(true);
		lblReportes.setVisible(true);
	}

	private void ocultarReporte() {
		btnEstudianteMoreF.setVisible(false); 
		btnPagoEm.setVisible(false);
		btnDineroRecaudado.setVisible(false);
		lblReportes.setVisible(false);
	}

	public void obtenerEstudianteMasFacturas(ActionEvent e) {
		
		if(estudiante1 != null ) {
			Estudiante estudianteMasFacturas = estudiante1; 
			if(estudiante2 != null) {
				if(estudianteMasFacturas.getCantFact()<estudiante2.getCantFact()) {
					estudianteMasFacturas=estudiante2;
				}
			}
			
			if(estudiante3 != null) {
				if(estudianteMasFacturas.getCantFact()<estudiante3.getCantFact()) {
					estudianteMasFacturas=estudiante3; 
				}
			}
			showVentana("El estudiante con mas factura es: "+estudianteMasFacturas.getNombre()
				+"\n Tiene un total de: "+estudianteMasFacturas.getCantFact()+" facturas");
		}else {
			showVentana("No hay estudiantes aún");
		}
		
	}

	private void sumarFacturasEstudiante() {
		boolean flag = true; 
		String nombre;
		do {
			nombre = getDataUser("Ingrese el nombre del estudiante que compra: "); 
			
			if(estudiante1!= null && estudiante1.getNombre().equals(nombre)) {
					 estudiante1.setCantFact(); 
					 flag= false; 
			}else if(estudiante2!= null && estudiante2.getNombre().equals(nombre)) {
					 estudiante2.setCantFact();
					 flag= false;
			}else if(estudiante3!= null && estudiante2.getNombre().equals(nombre)) {
					estudiante3.setCantFact();
					flag= false;
			}else {
				showVentana("No hay un estudiante con ese nombre");
			}
		}while(flag); 
	}

	public void getDineroRecaudado(ActionEvent e) {
		showVentana("El total de diner recaudado es: "+reporte.getDineroTotal());
	}

	public void getPagoEmpleados(ActionEvent e) {
		String mensaje = ""; 
		mensaje+= "El pago del empleado 1 es: "+empleado1.getPago()+"\n"; 
		mensaje+= "El pago del empleado 2 es: "+empleado2.getPago()+"\n"; 
		mensaje+= "El pago del empleado e es: "+empleado3.getPago()+"\n";
		mensaje+= "El pago total es: "+(empleado1.getPago()+empleado2.getPago()+empleado3.getPago()); 
		showVentana(mensaje);
	}
	
}
