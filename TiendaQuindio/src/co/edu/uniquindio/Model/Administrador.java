package co.edu.uniquindio.Model;

public class Administrador {
	String id;
	String nombre;
	String direccion;
	String correo;
	String fechaNaciemiento;
	String estudios;
	public Administrador(String id, String nombre, String direccion, String correo, String fechaNaciemiento,
			String estudios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaNaciemiento = fechaNaciemiento;
		this.estudios = estudios;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getFechaNaciemiento() {
		return fechaNaciemiento;
	}
	public void setFechaNaciemiento(String fechaNaciemiento) {
		this.fechaNaciemiento = fechaNaciemiento;
	}
	public String getEstudios() {
		return estudios;
	}
	public void setEstudios(String estudios) {
		this.estudios = estudios;
	}
	
	
	
}
