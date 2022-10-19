package co.edu.uniquindio.model;

public enum TipoPago {
	
	//-----TIPOS DE PAGO DE LAS FACTURAS------
	TARJETA_CREDITO(0),TARJETA_DEBITO(1);

	private int tipoPago;
	
	//-------CONSTRUCTOR--------------------
	TipoPago(int tipoPago){
		this.tipoPago = tipoPago;
	}
	
	//---------GET----------------
	public int getNumTipoPago() {
		return tipoPago;
	}
	
}
