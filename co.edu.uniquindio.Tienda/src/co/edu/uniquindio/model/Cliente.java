package co.edu.uniquindio.model;

public class Cliente {
	
	private String nombre, identificacion, direccion, telefono, correo;
	private int edad;
	private TipoDocumento tipoDocumento; 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Cliente(String nombre, String identificacion, String direccion, String telefono, String correo, int edad) {
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.edad = edad;
	}
	
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	private enum TipoDocumento{
		TARJETA_IDENTIDAD(1),CEDULA_CIUDADANIA(0),CEDULA_EXTRANJERIA(2);

		private int numTipo;

		TipoDocumento(int tipo){
			numTipo = tipo;
		}
S
		public int getNumTipo() {
			return numTipo;
		}
	}
}
