package poo.Arias.Application;

import poo.Arias.repositorio.modelo.Cliente;
import poo.Arias.repositorio.modelo.ICliente;

public class Application {

	public static void main(String[] args) {
		
		ICliente implClie = new ICliente(); 
		implClie.crear(new Cliente("Alejandro", "Arias"));
		implClie.crear(new Cliente("Jose", "Pinzon"));
		implClie.crear(new Cliente("Nora", "Arias"));
		implClie.ordenar();
		System.out.println(implClie.getDataSource());
	}

	/**
	 * MÉTODO QUE RECIBE TRES OBJETOS Y DEVUELVE EL MAYOR
	 * @param <T>
	 * @param t1
	 * @param t2
	 * @param t3
	 * @return
	 */
	public static <T extends Comparable<T>> T calcularMaximoTres(T t1, T t2, T t3) {
		//MÁXIMO
		T max = t1; 
		//SE VERIFICA
		if(t2.compareTo(max) > 0) {
			max = t2; 
		}else if(t3.compareTo(max)>0 ) {
			max = t3; 
		}
		return max; 
	}

}
