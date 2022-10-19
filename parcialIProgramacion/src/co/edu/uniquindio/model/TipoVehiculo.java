package co.edu.uniquindio.model;

public enum TipoVehiculo {
	
	MOTO(0), CARRO(1);
	private int numTipo; 
	
	TipoVehiculo(int i) {
		this.numTipo = i; 
	}
	public int getNumTipo() {
		return numTipo;
	}
}
