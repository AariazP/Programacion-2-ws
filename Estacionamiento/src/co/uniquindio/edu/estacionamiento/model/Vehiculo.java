package co.uniquindio.edu.estacionamiento.model;

public class Vehiculo {


	//---------------------------------------------------------------------------
	//ATRIBUTOS
	//---------------------------------------------------------------------------

	private String placa;
	private String modelo;
	private TipoVehiculo tipoVehiculo;
	private Propietario propietario;


	//---------------------------------------------------------------------------
	//CONSTRUCTOR
	//---------------------------------------------------------------------------

	public Vehiculo() {

	}


	/**
	 * Metodo constructor clase vehiculo
	 * @param placa
	 * @param modelo
	 */

	public Vehiculo(String placa, String modelo, TipoVehiculo tipoVehiculo, Propietario propietario) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.tipoVehiculo = tipoVehiculo;
		this.propietario = propietario;
	}

	//---------------------------------------------------------------------------
	//METODOS SET Y GET
	//---------------------------------------------------------------------------



	public String getPlaca() {
		return placa;
	}


	public Propietario getPropietario() {
		return propietario;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}


	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	@Override
	public String toString() {
		return "Vehiculo [placa=" + placa + ", modelo=" + modelo + ", tipoVehiculo=" + tipoVehiculo + ", propietario="
				+ propietario + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	/**
	 * Método que compara dos modelos de un vehiculo
	 * @param modelo2
	 * @return
	 */
	public boolean compararModelo(String modelo2) {

		if(modelo.equals(modelo2))return true; 

		return false;
	}

	/**
	 * Método que verifica si una placa es impar o no
	 * @return
	 */
	public boolean verificarPlacaImpar() {

		int placa = Integer.parseInt(this.placa); 

		if(placa %2 == 0)return true; 

		return false;
	}

	/**
	 * Este método verifica si la placa del vehiculo es par
	 * @return
	 */
	public boolean verificarPlacasPares() {
		int placa1 = Integer.parseInt(placa); 
		if(placa1 %2 == 0) return true; 
		return false; 
	}

	/**
	 * Método que verifica si hay dos vocales seguidas en la placa
	 * @return
	 */
	public boolean verificarVocalesSeguidasPlaca() {
		//genero el arreglo de char
		char[] letrasPlaca = placa.toCharArray(); 
		//recorro el arreglo
		for (int i = 0; i < letrasPlaca.length-1; i++) {
			//verifico si hay vocales consecutivas
			if(verificarVocal(letrasPlaca[i]) && verificarVocal(letrasPlaca[i+1])  ) {
				return true; 
			}
		}

		return false;
	}

	/**
	 * Método que verifica si un char es vocal
	 * @param c
	 * @return
	 */
	private boolean verificarVocal(char c) {

		if(c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u') {
			return true; 
		}

		return false;
	}

	/**
	 * Método que verifica si hay dos numeros repetidos
	 * @return
	 */

	public boolean verificarNumeroRepetidoPlaca() {
		//genero el arreglo de char
		char[] letrasPlaca = placa.toCharArray();
		//recorro el arreglo
		for (int i = 0; i < letrasPlaca.length; i++) {
			//creo un contador para verificar que si esté minimo dos veces
			int contador = 0; 
			//verifico si el char de la placa es un número
			if(verificarNumero(letrasPlaca[i])) {
				//el numero que voy a contar
				char numero = letrasPlaca[i];
				//recorro el arreglo otra vez y cuento cuantas veces está
				for (int j = 0; j < letrasPlaca.length; j++) {
					//le agrego al contador
					if(letrasPlaca[j] == numero) {
						contador++; 
					}
				}
				//retorno true si el contador es mayor a dos, o sea que está dos veces
				if(contador>=2) {
					return true; 
				}
			}
		}
		return false;
	}

	/**
	 * Verifico si un char es un número
	 * @param c
	 * @return
	 */
	private boolean verificarNumero(char c) {

		if(c=='1' || c=='2' ||c=='3' || c=='4' ||c=='5' || c=='6' ||c=='7' || c=='8' ||c=='9' || c=='0') return true; 

		return false;
	}

	/**
	 * Método que verifica si un carro cumple con la fecha y el valor
	 * @return
	 */
	public boolean cumpleDosCondiciones() {
		//verifica si es de tipo carro
		if(tipoVehiculo == TipoVehiculo.CARRO) return true;
		return false;
	}
	/**
	 * Métod que verifica si el propietario tiene el número
	 * @param numero
	 * @return
	 */

	public boolean verificarNumero(String numero) {
		
		if(propietario.contieneNumero(numero)) return true; 
		
		return false;
	}
	
	/**
	 * Método que verifica si el propietario pasado por parametro es el mismo
	 * @param propietario2
	 * @return
	 */
	public boolean compararPropietario(Propietario propietario2) {
		//verifico si es el mismo propietario
		if(propietario.equals(propietario2)) return true; 
		// si no es el mismo retorno false
		return false;
	}

	/**
	 * Método que compara los nombres de los propietarios y el modelo
	 * @param nombre
	 * @param modelo2
	 * @return
	 */
	public boolean compararCondiciones(String nombre, String modelo2) {
		//convierto el modelo a entero
		int modeloPara = Integer.parseInt(modelo2); 
		//verifico si el modelo es menor a 2000
		if(modeloPara<2000 && propietario.compararNombre(nombre)) return true; 
		//Si no cumplen las condiciones retorno falso
		return false;
	}


}
