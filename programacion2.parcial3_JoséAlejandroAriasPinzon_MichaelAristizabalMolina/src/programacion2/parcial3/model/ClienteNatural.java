package programacion2.parcial3.model;

import java.util.Objects;

public class ClienteNatural extends Cliente{
	
	
	private String apellido; 
	private String cedula, estrato; 
	
	//-----------CONSTRUCTOR-----------------

	public ClienteNatural(String nombre, String apellido, String cedula, String estrato) {
		super(nombre);
		this.cedula = cedula;
		this.estrato = estrato; 
		this.apellido = apellido; 
	}

	
	//---------MÈTODOS GENERADOS---------
	
	
	@Override
	public String toString() {
		return "ClienteNatural [apellido="+ "\n" + apellido + ", cedula=" + cedula + "\n"+ ", estrato=" + estrato
				+ ", getApellidos()=" + "\n"+getApellidos()+ "\n" + ", getCedula()=" + getCedula() + ", getEstrato()="
				+ "\n"+ getEstrato() + ", getNombre()=" + getNombre() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + "\n"+ super.toString() + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido, cedula, estrato);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ClienteNatural))
			return false;
		ClienteNatural other = (ClienteNatural) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(cedula, other.cedula)
				&& Objects.equals(estrato, other.estrato);
	}


	/**
	 * Mètodo que comprara el id por parametro y la cedula
	 * @param identificacion
	 * @return
	 */
	public boolean compararId(String identificacion) {
		if(cedula.equals(identificacion)) return true; 
		return false;
	}

	//-------GETTERS AND SETTERS---------------
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellido;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellido = apellidos;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the estrato
	 */
	public String getEstrato() {
		return estrato;
	}

	/**
	 * @param estrato the estrato to set
	 */
	public void setEstrato(String estrato) {
		this.estrato = estrato;
	}

}
