package aplication;

public class Tarea {
	
	private int[] arreglo;
	//getter and setters
	public int[] getArreglo() {
		return arreglo;
	}
	public void setArreglo(int[] arreglo) {
		this.arreglo = arreglo;
	}
	/**
	 * Este método busca en un arreglo el numero que mas veces se repite y lo retorna
	 * @param arreglo
	 * @return
	 */
	public int getNumeroMasRepetido(int[] arreglo) {
		//variables globales y locales
		this.arreglo = arreglo;
		int mayor = 0;
		//verifico que el arreglo que se pasa por parametro no sea nulo
		if(arreglo != null ) {
			//inicialmente el mayor es el primero
			mayor = arreglo[0];
			for(int i=0; i<arreglo.length; i++) {
				//el metodo contarVecesNumero cuenta las veces de cada numero y verifica si 
				//tiene mas veces que el que se ha definido
				if(contarVecesNumero(arreglo[i])>contarVecesNumero(mayor)) {
					mayor = arreglo[i]; 
				}
			}
		}
		return mayor;
	}
	/**
	 * Este metodo cuenta las veces que un número está en un arreglo
	 * @param numero
	 * @return contador
	 */
	private int contarVecesNumero(int numero) {
		//variable local
		int contador = 0;
		//bucle para contar las veces en el arreglo
		for(int i = 0; i<arreglo.length; i++) {
			if(arreglo[i] == numero) {
				contador++;
			}
		}
		return contador;
	}
}
