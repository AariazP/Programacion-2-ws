package co.edu.uniquindio.Model;

public class Agenda {
	private int n; 
	private Contacto[] listaContactos = new Contacto[n];  
	private String titulo;

	public Agenda(String titulo) {
		super();
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Contacto[] getContactos() {
		return contactos;
	}

	public void setContactos(Contacto[] contactos) {
		this.contactos = contactos;
	} 
}
