package ejercicios;

public class Estudiante {
	private String nombre;
	private String ID;
	private String facultad;
	private String grupo;
	private double nota1;
	private double nota2;
	private double nota3;
	private double nota4;
	private double nota5;
	/**
	 * @param nombre
	 * @param iD
	 * @param facultad
	 * @param grupo
	 * @param nota1
	 * @param nota2
	 * @param nota3
	 * @param nota4
	 * @param nota5
	 */
	public Estudiante(String nombre, String ID, String facultad, String grupo, double nota1, double nota2, double nota3,
			double nota4, double nota5) {
		this.nombre = nombre;
		this.ID = ID;
		this.facultad = facultad;
		this.grupo = grupo;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.nota5 = nota5;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public double getNota4() {
		return nota4;
	}
	public void setNota4(double nota4) {
		this.nota4 = nota4;
	}
	public double getNota5() {
		return nota5;
	}
	public void setNota5(double nota5) {
		this.nota5 = nota5;
	}
	
	
	
	

}
