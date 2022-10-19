package co.edu.uniquindio.Model;

public class Cita {
	

	private String fecha, hora, asunto;

	public Cita(String fecha, String hora, String asunto) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.asunto = asunto;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	} 
}
