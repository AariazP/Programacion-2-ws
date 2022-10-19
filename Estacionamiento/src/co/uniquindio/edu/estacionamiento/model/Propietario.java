package co.uniquindio.edu.estacionamiento.model;


/**
 * Clase propietario
 * @author Admin
 *
 */
public class Propietario {

	//---------------------------------------------------------------------------
	//ATRIBUTOS
	//---------------------------------------------------------------------------

	private String nombre;
	private String identificacion;
	private String telefono;


	//---------------------------------------------------------------------------
	//CONSTRUCTOR
	//---------------------------------------------------------------------------


	/**
	 * Constructor de la clase propietario
	 */
	public Propietario() {

	}


	/**
	 * Constructor
	 * @param nombre
	 * @param identificacion
	 * @param telefono
	 */
	public Propietario(String nombre, String identificacion, String telefono) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.telefono = telefono;
	}


	//---------------------------------------------------------------------------
	//METODOS SET Y GET
	//---------------------------------------------------------------------------


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propietario other = (Propietario) obj;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Propietario [nombre=" + nombre + ", identificacion=" + identificacion + ", telefono=" + telefono + "]";
	}

	/**
	 * Método que verifica si el número de telefono contiene el numero
	 * @param numero
	 * @return
	 */
	public boolean contieneNumero(String numero) {
		//arreglo de numero
		char[] numeros = numero.toCharArray();
		//areglo de numeros de telefono
		char[] numerosTelefono = telefono.toCharArray(); 
		//recorro el numero
		for (int i = 0; i < numeros.length; i++) {
			
			boolean aux = false; 
			//Obtengo el primer número a compararar
			char numAux = numeros[i]; 
			//recorro el numero de telefono
			for (int j = 0; j < numerosTelefono.length; j++) {
				//comparo si existe el número
				if(numerosTelefono[j] == numAux) {
					aux = true; 
				}
			}
			//si el número no está en el telefono retorno false
			if(!aux) {
				return false; 
			}
		}
		
		return true;
	}

	/**
	 * Método que verifica si el id es capicua
	 * @return
	 */
	public boolean verificarIdCapicua() {
		//verifico si la identificaión es nula
		if(identificacion != null) {
			//variable que recorre desde el final  hasta el inicio
			int aux1 = identificacion.length()-1; 
			//arreglo de char del id
			char[] numerosId = identificacion.toCharArray(); 
			//recorro el arreglo
			for (int i = 0; i < numerosId.length && aux1>=0; i++) {
				//verifico si es distinto algun char
				if(numerosId[i] != numerosId[aux1]) {
					//false en caso de que sí
					return false; 
				}
				// si no son distintos reduzco a la variable del final
				aux1--; 
			}
		}
		// si todos son iguales retorno true
		return true;
	}

	/**
	 * Método que compara dos nombres de propietarios
	 * @param nombre2
	 * @return
	 */
	public boolean compararNombre(String nombre2) {
		//si son iguales retorno true
		if(nombre2.equals(nombre)) return true; 
		
		return false;
	}



}
