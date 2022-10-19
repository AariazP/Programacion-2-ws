package clases;

public class Reporte {
	
	private double dineroTotal=0;
	
	public double getDineroTotal() {
		return dineroTotal;
	}
	
	public void sumarDinero(double dinero) {
		dineroTotal += dinero; 
	}
}
