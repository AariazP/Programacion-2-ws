package co.uniquindio.edu.estacionamiento.model;

/**
 * Esta clase representa un puesto dentro del parqueadero
 * @author
 *
 */
public class Puesto {


	//---------------------------------------------------------------------------
	//ATRIBUTOS
	//---------------------------------------------------------------------------

	private String numero;
	private String estado;
	private double precio;
	private TipoVehiculo tipoVehiculo;


	//---------------------------------------------------------------------------
	//CONSTRUCTOR
	//---------------------------------------------------------------------------

	/**
	 * Metodo constructor clase puesto
	 */
	public Puesto() {

	}


	/**
	 * Metodo constructor clase puesto
	 * @param numero
	 * @param estado
	 * @param precio
	 * @param tipoVehiculo
	 */
	public Puesto(String numero, String estado, double precio, TipoVehiculo tipoVehiculo) {
		super();
		this.numero = numero;
		this.estado = estado;
		this.precio = precio;
		this.tipoVehiculo = tipoVehiculo;
	}


	//---------------------------------------------------------------------------
	//METODOS SET Y GET
	//---------------------------------------------------------------------------

	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}


	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puesto other = (Puesto) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Puesto [numero=" + numero + ", estado=" + estado + ", precio=" + precio + ", tipoVehiculo="
				+ tipoVehiculo + "]";
	}

	/**
	 * Método que compara dos tipos de vehiculo
	 * @param vehiculo
	 * @return
	 */
	public boolean compararTipoVehiculo(Vehiculo vehiculo) {
		if(vehiculo.getTipoVehiculo() == tipoVehiculo) return true; 
		return false;
	}








}
