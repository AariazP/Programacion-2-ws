
package asociacionClases;

public class Principal {

	public static void main(String[] args) {
		Curso curso1 = new Curso(1,3,"programación","0918","diurna");
		curso1.aniadirEstudiante("Alejandro", "1027272", "03-D", "Ingeniería");
		
		System.out.println(curso1.retornarInformacionCurso());
		
		System.out.println();
		
		curso1.setProfesor("Pablo");
		System.out.println(curso1.retornarInformacionCurso());
	}

}
