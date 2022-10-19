package paquete;

import javax.swing.JOptionPane;

public class Application {
	
	public static void main(String[] args) {
		
		//Se inicializa la matriz
		int tamanio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas: "));
		int[][] matriz = new int[tamanio][tamanio];
		
		
		//Se leen los datos de la matriz
		matriz = leerMatriz(matriz); 
		
		//Se imprime la matriz ingresada
		imprimirMatriz(matriz);
		
		//Se le pide al usuario que ingrese las veces que se girar la matriz
		int numVecesGiro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de veces que se quiere rotar la matriz: "));
		
		//se invoca al método que gira la matriz
		matriz = girarMatrizVeces(numVecesGiro, matriz);
		
		
		//Se imprime la matriz que ya se ha rotado
		imprimirMatriz(matriz);
		
		
	}
	
	private static int[][] leerMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero "+i+""+j+":"));
			}
		}
		return matriz;
	}

	/**
	 * Método que rota la matriz n veces haciendo uso de matemática modular
	 * @param numVecesGiro
	 * @param matriz
	 * @return
	 */
	private static int[][] girarMatrizVeces(int numVecesGiro, int[][] matriz) {
		
		//resto a numVecesGiro hasta tener un valor entre 0 y 4
		int contador = 0; 
		while (numVecesGiro>4) {
			numVecesGiro -=4;
		}
		//roto la matriz
		while(contador<numVecesGiro) {
			matriz = rotarMatriz(matriz);
			//muestro que la matriz si está girando
			imprimirMatriz(matriz);
			System.out.println();
			contador++;
		}
		
        return matriz;
		
	}
	
	/**
	 * Método que rota la matriz una vez 
	 * @param matriz
	 * @return
	 */
	public static int[][] rotarMatriz(int[][] matriz){

		int [][] matriz2 = new int[matriz.length][matriz.length];
		int [] arreglo;
		int columna = matriz.length-1;

		for (int i = 0; i < matriz.length; i++) {
			//se obtiene el arreglo que se va a cambiar de posicion
			arreglo = matriz[i];
			//este bucle cambia el sentido de la columna
			for (int k = 0; k < arreglo.length; k++) {
				matriz2[k][columna] = arreglo[k];
			}
			
			columna--;

		}

		return matriz2; 

	}
	
	public static void imprimirMatriz(int[][] matriz) {
		System.out.println();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
