package co.edu.uniquindio.model;

public class Puesto {
	
	private Parqueadero parqueadero; 
	private String estado = "Disponible";
	private int numero = 0; 
	private Double precio = 2000.0;
	private TipoVehiculo tipoVehiculo;
	
	//Constructor
	
	
	//------------------------------------------------Métodos----------------------------------------------------------------
	
	public void cambiarEstado() {
		this.estado = "Usado"; 
		this.setNumero(this.getNumero() + 1); 
	}
	
	
	/**
	 * Método que verifica la disponibilidad de un puesto
	 * @return
	 */
	public boolean obtenerDisponibilidad() {
		if(estado.equalsIgnoreCase("Disponible")) {
			return true; 
		}else {
			return false; 
		}
	}
	
	//getters and Setters
	public Parqueadero getParqueadero() {
		return parqueadero;
	}
	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	} 
}
