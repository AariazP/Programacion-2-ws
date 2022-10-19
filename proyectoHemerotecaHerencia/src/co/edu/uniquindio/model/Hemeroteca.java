package co.edu.uniquindio.model;

import java.util.ArrayList;

public class Hemeroteca {
		
	private ArrayList<Revista> listaRevista; 
	
	//---------------CONSTRUCTOR------------------------
	public Hemeroteca() {
		setListaRevista(new ArrayList<Revista>()); 
	}
	
	//----------MÉTODOS-------------
	public String crearRevistaNacional(String nombre, String fechaPublicacion, String iSSN, String instPublico) {
		 
		listaRevista.add(new RevistaNacional(nombre, fechaPublicacion, iSSN, instPublico));
		
		return "Revista nacional creada"; 
	}
	
	public String crearRevistaExtranjera(String nombre, String fechaPublicacion, String iSSN, String paisOrigen) {
		 
		listaRevista.add(new RevistaExtranjera(nombre, fechaPublicacion, iSSN, paisOrigen));
		
		return "Revista extranjera creada"; 
	}
	
	//----------------GETTER AND SETTERS-----------------

	public ArrayList<Revista> getListaRevista() {
		return listaRevista;
	}

	public void setListaRevista(ArrayList<Revista> listaRevista) {
		this.listaRevista = listaRevista;
	}
}
