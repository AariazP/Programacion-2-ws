package pk;

public class application {
	
	public static void main(String[] args) {
		String cadena ="Esta es una cadena sobre la que se aplicarán métodos"; 
		System.out.println("La letra en 0 de la cadena es: "+cadena.charAt(0));
		System.out.println("Esta cadena no contiene ´z´ por eso es: "+cadena.contains("z"));
		System.out.println("El tamaño de la caden es "+cadena.length());
		System.out.println("Una subcadena es: "+cadena.substring(4, 10));
		System.out.println("La cadena en mayúsuculas es: "+cadena.toUpperCase());
		char[] letras = cadena.toCharArray();
		for (int i = 0; i < letras.length; i++) {
			System.out.println(letras[i]);
		}
		System.out.println("Este método elimina los espacios en blanco finales de la cadena: "+cadena.strip());
		System.out.println("La cadena en mayúsculas:"+cadena.toUpperCase());
		System.out.println("La cadena en minusculas:"+cadena.toLowerCase());
		System.out.println("La cadena susitituyendo la primera aparición de d por p:"+cadena.replaceFirst("d", "p"));
		System.out.println("La cadena susitituyendo a por z en cada aparición:"+cadena.replace("a", "z"));
		System.out.println("-------------------------------------------------------------");
		int[] numeros = {5, 9, 8, 7, 3, 4, 1, 2, 6}; 
		String mensaje = ""; 
		for (int i = 0; i < numeros.length; i++) {
			mensaje += numeros[i]+" "; 
		}
		System.out.println("Los números sin ordenar");
		System.out.println(mensaje);
		mensaje =""; 
		numeros = ordenarBurbuja(numeros); 
		for (int i = 0; i < numeros.length; i++) {
			mensaje += numeros[i]+" "; 
		}
		System.out.println("Los números ordenados");
		System.out.println(mensaje);
		System.out.println("---------------------------------------");
		System.out.println("¡¡¡Uso de stringBuilder!!!!!");
		StringBuilder cadenaBuilder = new StringBuilder("Esta es una cadena con string builder"); 
		System.out.println("Capacidad del objeto en cantidad de caracteres: "+cadenaBuilder.capacity());
		System.out.println("Largo de la cadena "+cadenaBuilder.length());
		System.out.println("Cadena al revés:"+cadenaBuilder.reverse());
	}
	
	
	public static int[] ordenarBurbuja(int[] arreglo) {
		int auxiliar;
	      int[] arregloOrdenado;
	      for(int i = 2; i < arreglo.length; i++)
	      {
	        for(int j = 0;j < arreglo.length-i;j++)
	        {
	          if(arreglo[j] > arreglo[j+1])
	          {
	            auxiliar = arreglo[j];
	            arreglo[j] = arreglo[j+1];
	            arreglo[j+1] = auxiliar;
	          }   
	        }
	      }
	      arregloOrdenado = arreglo;
	      return arregloOrdenado;
	}
}
