package co.edu.uniquindio.Model;

public class Grupo {
	
	private Agenda agenda;
	private String nombre;
	private Contacto[] listaContactosGrupo;
	private Cita[] listaCitasGrupo; 

	public Grupo(Agenda agenda, String nombre) {
		super();
		this.setAgenda(agenda);
		this.nombre = nombre;
	}

	public Grupo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cita[] getListaCitasGrupo() {
		return listaCitasGrupo;
	}

	public void setListaCitasGrupo(Cita[] listaCitasGrupo) {
		this.listaCitasGrupo = listaCitasGrupo;
	}

	public Contacto[] getListaContactosGrupo() {
		return listaContactosGrupo;
	}

	public void setListaContactosGrupo(Contacto[] listaContactosGrupo) {
		this.listaContactosGrupo = listaContactosGrupo;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	} 
}
