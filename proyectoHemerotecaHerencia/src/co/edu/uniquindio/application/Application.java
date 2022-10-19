package co.edu.uniquindio.application;

import co.edu.uniquindio.model.Hemeroteca;

public class Application {

	public static void main(String[] args) {
		Hemeroteca hemeroteca = new Hemeroteca(); 
		hemeroteca.crearRevistaExtranjera("Revista", "12/94", "HQDWI7", "USA"); 
		hemeroteca.crearRevistaNacional("Datos", "6/12", "IWUQ87", "Gobierno"); 
	}
}
