package co.uniquindio.edu.estacionamiento.model;

public class RegistroParqueo {


	//---------------------------------------------------------------------------
	//ATRIBUTOS
	//---------------------------------------------------------------------------

	private Vehiculo vehiculo;
	private Puesto puesto;
	private String fecha;
	private String horaLlegada;
	private String horaSalida;
	private double total;
	private String codigo;

	//---------------------------------------------------------------------------
	//CONSTRUCTOR
	//---------------------------------------------------------------------------


	public RegistroParqueo() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Metodo constructor clase RegistroParqueo
	 * @param vehiculo
	 * @param puesto
	 * @param fecha
	 * @param horaLlegada
	 * @param horaSalida
	 * @param total
	 */

	public RegistroParqueo(Vehiculo vehiculo, Puesto puesto, String fecha, String horaLlegada, String horaSalida,
			double total, String codigo) {
		super();
		this.vehiculo = vehiculo;
		this.puesto = puesto;
		this.fecha = fecha;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.total = total;
		this.codigo = codigo;
	}
	//---------------------------------------------------------------------------
	//METODOS SET Y GET
	//---------------------------------------------------------------------------

	public Vehiculo getVehiculo() {
		return vehiculo;
	}





	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public Puesto getPuesto() {
		return puesto;
	}


	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getHoraLlegada() {
		return horaLlegada;
	}


	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}


	public String getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "RegistroParqueo [vehiculo=" + vehiculo + ", puesto=" + puesto + ", fecha=" + fecha + ", horaLlegada="
				+ horaLlegada + ", horaSalida=" + horaSalida + ", total=" + total + ", codigo=" + codigo + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		RegistroParqueo other = (RegistroParqueo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	/**
	 * Método que verifica si en el registro hay un carro y está parqueado mas de dos veces
	 * @return
	 */
	public boolean verificarTipoVehiculo(TipoVehiculo tipo) {
		//verifico si es un carro
		if(vehiculo.getTipoVehiculo() == tipo) return true; 
		return false;
	}

	/**
	 * Método que compara dos puestos
	 * @param puesto2
	 * @return
	 */
	public boolean compararPuesto(Puesto puesto2) {
		//verifico si dos puestos son iguales
		if(puesto2.equals(puesto)) return true; 
		return false;
	}

	/**
	 * Este metodo compara un modelo pasado por parametro y el actual
	 * @param i
	 * @return
	 */
	public boolean verificarModeloSuperior(int i) {
		if(vehiculo.compararModelo(i+"")) return true;
		return false;
	}

	/**
	 * Método que verifica si un vehiculo cumple con las condiciones de dos vocales seguidas, dos numeros repetidos y tiene un puesto
	 * @return
	 */
	public boolean cumpleCondicionesVocalesNumeros() {

		if(puesto.getEstado().equals("ocupador") && puesto.compararTipoVehiculo(vehiculo) && vehiculo.verificarVocalesSeguidasPlaca() 
				&& vehiculo.verificarNumeroRepetidoPlaca()) return true; 

		return false;
	}

	/**
	 * Método que verifica si un vehiculo cumple condiciones del primer punto
	 * @return
	 */
	public boolean cumpleCondiciones(String fecha, int dinero) {
		//verifico si cumple las condiciones
		if(vehiculo.cumpleDosCondiciones() && fecha.equals(fecha) && dinero == total) return true; 
		//retorno falso si no
		return false;
	}

	/**
	 * Método que verifica si la moto tiene el numero pasado por parametro
	 * @return
	 */
	public boolean cumpleCondicionesMotoTelefono(String numero) {
		//verifico si cumple el numero y es una moto
		if(vehiculo.verificarNumero(numero) && TipoVehiculo.MOTO == vehiculo.getTipoVehiculo()) return true;  
		
		return false;
	}
	
	/**
	 * Verifico si es el mismo propietario y tiene moto
	 * @param propietario
	 * @return
	 */

	public boolean cumpleMotoPropietario(Propietario propietario) {
		//verifico si el vehiculo es una moto 
		if(verificarTipoVehiculo(TipoVehiculo.MOTO) && vehiculo.compararPropietario(propietario)) return true; 
		return false;
	}

	/**
	 * Método que verifica el nombre y el modelo 
	 * @param nombre
	 * @param modelo
	 * @return
	 */
	public boolean verificarNombreModelo(String nombre, String modelo) {
		//invoco el método que compara los nombres y el modelo
		if(vehiculo.compararCondiciones(nombre, modelo)) return true; 
		
		return false;
	}

	

}
