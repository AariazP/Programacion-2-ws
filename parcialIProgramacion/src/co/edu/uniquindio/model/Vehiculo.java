package co.edu.uniquindio.model;

public class Vehiculo {
	
	private Parqueadero parqueadero; 
	private String placa, modelo;
	private Propietario propietario; 
	private TipoVehiculo tipoVehiculo; 
	
	
	//Constructor
	public Vehiculo(String placa, String modelo) {
		super();
		this.placa = placa;
		this.modelo = modelo;
	}
	
	//---------------------------------------------------Méotodos------------------------------------------------------------------------------------------------------
	
	/**
	 * Método que compara dos vehiculos por sus placas
	 * @param placa2
	 * @return
	 */
	public boolean compararPlaca(String placa2) {
		if(placa2.equals(placa)) {
			return true; 
		}
		return false;
	} 
	
	
	//Getters and setters
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Parqueadero getParqueadero() {
		return parqueadero;
	}
	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
}
