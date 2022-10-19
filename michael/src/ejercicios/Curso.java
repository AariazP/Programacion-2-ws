package ejercicios;

public class Curso {
	private String nombre;
	private String duracion;
	private int numCreditos;
	private Estudiante estudiante1;
	private Estudiante estudiante2;
	private Estudiante estudiante3;
	
	
	/**
	 * @param nombre
	 * @param duracion
	 * @param numCreditos
	 * @param estudiante1
	 * @param estudiante2
	 * @param estudiante3
	 */
	public Curso(String nombre, String duracion, int numCreditos, Estudiante estudiante1, Estudiante estudiante2,
			Estudiante estudiante3) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.numCreditos = numCreditos;
		this.estudiante1 = estudiante1;
		this.estudiante2 = estudiante2;
		this.estudiante3 = estudiante3;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getNumCreditos() {
		return numCreditos;
	}

	public void setNumCreditos(int numCreditos) {
		this.numCreditos = numCreditos;
	}

	public Estudiante getEstudiante1() {
		return estudiante1;
	}

	public void setEstudiante1(Estudiante estudiante1) {
		this.estudiante1 = estudiante1;
	}

	public Estudiante getEstudiante2() {
		return estudiante2;
	}

	public void setEstudiante2(Estudiante estudiante2) {
		this.estudiante2 = estudiante2;
	}

	public Estudiante getEstudiante3() {
		return estudiante3;
	}

	public void setEstudiante3(Estudiante estudiante3) {
		this.estudiante3 = estudiante3;
	}

	public String agregarEstudiante(String nombre, String ID, String faculta, String grupo, int nota1, int nota2, int nota3, int nota4, int nota5) {
		String estudiante = null;
		if(estudiante != null) {
			estudiante ="El estudiante ya esta agregado";
		}
		else if(estudiante1==null) {
			
			estudiante1 = new(nombre, ID, faculta,  grupo, nota1, nota2, nota3, nota4, nota5);
			
		}
		return estudiante;
	}

}
