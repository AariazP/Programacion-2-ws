package co.edu.uniquindio.model;

import java.util.Objects;

public class Administrador {


	//------------ATRIBUTOS------------------
	private static int id; 
	private int idAdmin; 
	private String nombre, direccion, correo, fechaNacimiento, usuario, contrasenia;
	private Empresa empresa; 
	private Sede sede;
	private double sueldo; 


	//------------CONSTRUCTORES ------------------
	public Administrador(String nombre, String direccion, String correo, String fechaNacimiento,
			Sede sede) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.sede = sede;
		setIdAdmin(id); 
		id++; 
	}
	
	//--------------- CONSTRUCTOR VACIO -------------------------
	public Administrador() {

	}

	//-----------------MÉTODOS------------------------------


	@Override
	public int hashCode() {
		return Objects.hash(contrasenia, correo, direccion, empresa, fechaNacimiento, idAdmin, nombre, sede, sueldo,
				usuario);
	}
	/**
	 * ESTE METODO NOS PERMITE HACER UN IQUALS DE LO QUE NECESITEMOS 
	 * O TAMBIEN DE TODOS LOS ATRIBUTOS DE ESTA CLASE
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Administrador))
			return false;
		Administrador other = (Administrador) obj;
		return Objects.equals(contrasenia, other.contrasenia) && Objects.equals(correo, other.correo)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(empresa, other.empresa)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento) && idAdmin == other.idAdmin
				&& Objects.equals(nombre, other.nombre) && Objects.equals(sede, other.sede)
				&& Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo)
				&& Objects.equals(usuario, other.usuario);
	}
	/**
	 * VERIFICAMOS QUE LA CONTRASEÑA Y EL USUARIO SEAN IGUAL 
	 * PARA QUE PUEDA ENTRAR AL PANEL DEL ADMIN
	 * @param contrasenia2
	 * @param usuario2
	 * @return
	 */
	public boolean verificarAdmin(String contrasenia2, String usuario2) {
		//SI SON IGUALES LOS DOS PARAMETROS PASADOS CON LOS ATRIVUTOS, SE RETORNA UN TRUE
		if(contrasenia2.equals(contrasenia) && usuario2.equals(usuario)) return true;
		return false;//SI NO SE CUMPLE AUNQUE SEA UNO DE LOS DOS SE RETORNA FALSE
	} 


	//-------GETTERS AND SETTERS------------------------------------
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
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Administrador.id = id;
	}
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

}
