package co.edu.uniquindio.model;

public class RegistroParqueo {
	
	private Parqueadero parqueadero;
	private String fecha, horaLlegada, horaSalida; 
	private Double total; 
	private Vehiculo vehiculo; 
	private Puesto puesto; 
	
	//Constructor
	public RegistroParqueo(String fecha, String horaLlegada, String horaSalida, Vehiculo vehiculo) {
		
		super();
		this.fecha = fecha;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.vehiculo = vehiculo;
		
	}

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	} 
}
