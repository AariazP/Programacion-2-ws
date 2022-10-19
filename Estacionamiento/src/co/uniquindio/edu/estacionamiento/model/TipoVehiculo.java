package co.uniquindio.edu.estacionamiento.model;

public enum TipoVehiculo {


	MOTO(0),CARRO(0);

	private int numTipoVehiculo;

	TipoVehiculo(int numTipoVehiculo){
		this.numTipoVehiculo = numTipoVehiculo;
	}

	public int getNumTipoVehiculo() {
		return numTipoVehiculo;
	}



}
