package co.edu.uniquindio.Model;

public class Contacto {
	
	private Agenda agenda;
	private Grupo[] listaGrupos; 
	private Cita[] listaContactos;
	private String nombre, telefono, direccion, correo;
	
	public Contacto(String nombre, String telefono, String direccion, String correo, int edad) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.edad = edad;
	}

	private int edad;
	
	public 	Contacto (String nombre, String telefono, int edad) {
		this.edad= edad;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Contacto(String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Grupo[] getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(Grupo[] listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public Cita[] getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(Cita[] listaContactos) {
		this.listaContactos = listaContactos;
	}
}
