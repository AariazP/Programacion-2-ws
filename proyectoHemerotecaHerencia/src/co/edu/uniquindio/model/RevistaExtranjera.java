package co.edu.uniquindio.model;

public class RevistaExtranjera extends Revista {

	private String paisOrigen; 

	//--------------CONSTRUCTOR---------------------
	
	public RevistaExtranjera(String nombre, String fechaPublicacion, String iSSN, String paisOrigen) {
		super(nombre, fechaPublicacion, iSSN);
		this.paisOrigen = paisOrigen; 
	}
	
	
	//----------------GETTER AND SETTERS-----------------
	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}



}
