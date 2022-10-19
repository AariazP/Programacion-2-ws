package co.edu.uniquindio.Model;

public class Cita {
	
	private Agenda agenda; 
	private Contacto[] listaContactosCita;
	private Grupo grupoCita; 
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

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Contacto[] getListaContactosCita() {
		return listaContactosCita;
	}

	public void setListaContactosCita(Contacto[] listaContactosCita) {
		this.listaContactosCita = listaContactosCita;
	}

	public Grupo getGrupoCita() {
		return grupoCita;
	}

	public void setGrupoCita(Grupo grupoCita) {
		this.grupoCita = grupoCita;
	} 
}
