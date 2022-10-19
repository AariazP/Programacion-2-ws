package co.edu.uniquindio.Model;

public class Cliente {
	String id;
	String nombre;
	String direccion;
	String correo;
	String fechaNacimiento;
	String ciudad;
	String departamento;
	
	public Cliente(String id, String nombre, String direccion, String correo, String fechaNacimiento, String ciudad,
			String departamento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.ciudad = ciudad;
		this.departamento = departamento;
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
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	
	
}
