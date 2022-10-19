package co.edu.uniquindio.model;

import java.util.ArrayList;

public class GestionHumana {
		
	private ArrayList<Docente> listaDocentes; 
			
	public GestionHumana() {
		setListaDocentes(new ArrayList<Docente>()); 
	}
	//------------------MÉTODOS DE LA GESTION HUMANA----------------
	public void crearDocentePlanta(String nombre, int cantidadPuntos) {
		DocentePlanta docente = new DocentePlanta(nombre, cantidadPuntos); 
		listaDocentes.add(docente); 
	}	
	
	public void crearDocenteContrato(String nombre, String rol) {
		
		DocenteContrato docente = new DocenteContrato(nombre, rol); 
		listaDocentes.add(docente); 
	}	
	
	public String calcularSueldosDocentesPlanta() {
		for (int i = 0; i < listaDocentes.size(); i++) {
			
			if(listaDocentes.get(i) instanceof DocentePlanta) {
				listaDocentes.get(i).calcularSueldo(); 
			}
		}
		return "Se han calculado los sueldos"; 
	}
	
	public String calcularSueldosDocentesContrato() {
		for (int i = 0; i < listaDocentes.size(); i++) {
			
			if(listaDocentes.get(i) instanceof DocenteContrato) {
				
				listaDocentes.get(i).calcularSueldo();
			}
		}
		
		return "Se han calculado los sueldos"; 
	}
	
	public String mostrarSueldoDocentesPlanta() {
		String mensaje = ""; 
		
		for (int i = 0; i <listaDocentes.size(); i++) {
			
			if(listaDocentes.get(i) instanceof DocentePlanta) {
				mensaje += listaDocentes.get(i).toString(); 
			}
			
		}
		
		return mensaje;
	}
	public String mostrarSueldoDocentesContrato() {
		String mensaje = ""; 
		
		for (int i = 0; i <listaDocentes.size(); i++) {
			
			if(listaDocentes.get(i) instanceof DocenteContrato) {
				mensaje += listaDocentes.get(i).toString(); 
			}
			
		}
		
		return mensaje;
	}
	//-----------GETTERS AND SETTERS-----------
	public ArrayList<Docente> getListaDocentes() {
		return listaDocentes;
	}
	public void setListaDocentes(ArrayList<Docente> listaDocentes) {
		this.listaDocentes = listaDocentes;
	}
	
}
