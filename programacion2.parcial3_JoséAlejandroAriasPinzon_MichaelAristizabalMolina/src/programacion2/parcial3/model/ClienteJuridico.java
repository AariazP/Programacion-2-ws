package programacion2.parcial3.model;

import java.util.Objects;

public class ClienteJuridico extends Cliente{
	
	private String nit, telefono, tipoEmpresa; 
	
	
	//------------CONSTRUCTOR----------------
	public ClienteJuridico(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	public ClienteJuridico(String nombre, String nit, String telefono, String tipoEmpresa) {
		super(nombre);
		this.nit = nit;
		this.telefono = telefono;
		this.tipoEmpresa = tipoEmpresa;
		this.setNombre(nombre);
	}
	
	//---------MÉTODOS--------
	
	@Override
	public int hashCode() {
		return Objects.hash(nit, telefono, tipoEmpresa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ClienteJuridico))
			return false;
		ClienteJuridico other = (ClienteJuridico) obj;
		return Objects.equals(nit, other.nit) && Objects.equals(telefono, other.telefono)
				&& Objects.equals(tipoEmpresa, other.tipoEmpresa);
	}
	
	//------------GETTERS AND SETTERS
	/**
	 * @return the nit
	 */
	public String getNit() {
		return nit;
	}

	/**
	 * @param nit the nit to set
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the tipoEmpresa
	 */
	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	/**
	 * @param tipoEmpresa the tipoEmpresa to set
	 */
	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	
	
}
