package co.edu.uniquindio.model;

public class RevistaNacional extends Revista{

	private String instPublico; 
	
	//--------------CONSTRUCTOR--------------
	
	public RevistaNacional(String nombre, String fechaPublicacion, String iSSN, String instPublico) {
		super(nombre, fechaPublicacion, iSSN);
		this.instPublico = instPublico; 
	}
	
	//----------------GETTER AND SETTERS-----------------
	public String getInstPublico() {
		return instPublico;
	}
	public void setInstPublico(String instPublico) {
		this.instPublico = instPublico;
	}

}
