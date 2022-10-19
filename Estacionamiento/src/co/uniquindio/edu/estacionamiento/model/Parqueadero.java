package co.uniquindio.edu.estacionamiento.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;




/**
 * Clase parqueadero
 * @author Admin
 *
 */
public class Parqueadero {

	//---------------------------------------------------------------------------
	//ATRIBUTOS
	//---------------------------------------------------------------------------
	private String nombre;
	private Puesto [][]listaPuestos;
	private ArrayList<Vehiculo> listaVehiculos;
	private Propietario[] listaPropietarios;
	private ArrayList<RegistroParqueo> listaRegistroParqueo;

	/**
	 * Constructor de la clase parqueadero
	 */
	public Parqueadero(String nombre,int tamanioPuestos,int tamanioPropietarios){
		listaPuestos = new Puesto[tamanioPuestos][tamanioPuestos];
		listaVehiculos = new ArrayList<>();
		listaPropietarios = new Propietario[tamanioPropietarios];
		listaRegistroParqueo = new ArrayList<>();

		this.nombre = nombre;

		inicilializarPuestos();

		inicializarDatos();
	}

	//---------------------------------------------Parcial II ---------------------------------------------

	//---------------------------Punto 1------------------------------------

	/**
	 * Método que obtiene en la primera fila vehiculos de tipo carro que tiene fecha 06-06-22 y el total de parqueo 
	 * supere el valor de 10000
	 * @return
	 */
	public Vehiculo[][] obtenerMatrizVehiculosCaracterísticas(){
		//creo la matriz de vehiculos
		Vehiculo[][] matriz = new Vehiculo[2][];
		//añados los carros a la primer fila
		matriz[0] = obtenerCarrosFecha("06-06-22", 10000);
		//añado la motos a la segunda fila
		matriz[1] = obteMotosNumero("348"); 
		//retorno la matriz
		return matriz; 
	}

	//---------------------------Punto 2------------------------------------

	/**
	 * Método que obtiene un arraylist de puestos disponibles
	 * @return
	 */
	public ArrayList<Puesto> obtenerPuestosDisponibles(){

		//creo el arraylist 
		ArrayList<Puesto> puestosDisponibles = new ArrayList<>(); 
		//recorro la matriz
		for (int i = 0; i < listaPuestos.length; i++) {
			for (int j = 0; j < listaPuestos[i].length; j++) {
				
				//verifico si está en la primera fila y cumple las condiciones
				if(i==0 && verificarPuesto(listaPuestos[i][j])) {
					
					//añado los puestos al arreglo
					puestosDisponibles.add(listaPuestos[i][j]); 
					//verifico si está en la primera columnas
				}else if(j == 0 && verificarPuesto(listaPuestos[i][j])) {
					
					puestosDisponibles.add(listaPuestos[i][j]);
					//verifio si estoy en la ultima columna
					
				}else if(j == listaPuestos[0].length-1 && verificarPuesto(listaPuestos[i][j])) {
					
					puestosDisponibles.add(listaPuestos[i][j]);
					//verifico si estoy en la ultima fila
					
				}else if(i == listaPuestos.length-1 && verificarPuesto(listaPuestos[i][j])) {
					puestosDisponibles.add(listaPuestos[i][j]); 
				}
			}
		}
		//retorno el arrayList
		return puestosDisponibles; 
	}
	
	
	/**
	 * Método que verifica si un puesto cumple con las condiciones de ocupado, tiene una moto 
	 * Return boolean
	 */
	
	public boolean verificarPuesto(Puesto puesto) {
		//verifico si el puesto está ocupado y el puesto tiene una moto
		if(puesto.getEstado().equals("ocupado") && verificarRegistroPuestoMoto(puesto)) return true; 
		// si no retorno false
		return false; 
	}
	
	
	//---------------------------Punto 3------------------------------------
	
	
	/**
	 * Método que obtiene una lista de propietarios con las condiciones dadas
	 * @return
	 */
	
	public Propietario[] obtenerPropietario() {
		
		int contador = 0; 
		Propietario[] propietarios = new Propietario[contarPropietarios()]; 
		//lleno el arreglo de propietarios
		for (int i = 0; i < propietarios.length; i++) {
			
			//recorro la lista de propietarios
			for (int j = 0; j < listaPropietarios.length; j++) {
				
				//verifico si el id del propietario es capicua
				// verifico si el propietario tiene una moto
				
				if(listaPropietarios[j].verificarIdCapicua() && verificarTipoVehiculoPropietario(listaPropietarios[j])) {
					//lo pongo en el arreglo
					propietarios[contador] = listaPropietarios[j];
					//incremento contador
					contador ++; 
				}
			}
		}
		return propietarios; 
	}
	//---------------------------Punto 4------------------------------------
	
	/**
	 * Método que obtiene un arrayList con vehiculos con nombre y modelo menor a 200
	 * @return
	 */
	public ArrayList<Vehiculo> obtenerVehiculosNombre(String nombre, String modelo){
		//cambio el nombre a Diana
		nombre = "Diana"; 
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<>(0); 
		//recorro los registros
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			
			//verifico si el nombre y modelo cumplen
			if(listaRegistroParqueo.get(i).verificarNombreModelo(nombre, nombre)) {
				//añado a la lista vehiculos
				listaVehiculos.add(listaRegistroParqueo.get(i).getVehiculo()); 
			}
		}
		//retorno la lista vehiculos
		return listaVehiculos; 
	}
	
	
	
	/**
	 * Método que obtiene el total de propietarios que cumplen la condición
	 * @return
	 */
	private int contarPropietarios() {
		//creo el contador
		int contador = 0; 
		//recorro la lista de propietarios
		for (int i = 0; i < listaPropietarios.length; i++) {
			
			//verifico si el id del propietario es capicua
			// verifico si el propietario tiene una moto
			if(listaPropietarios[i].verificarIdCapicua() && verificarTipoVehiculoPropietario(listaPropietarios[i])) {
				contador ++; 
			}
		}
		
		//retorno el contador
		return contador;
	}

	private boolean verificarTipoVehiculoPropietario(Propietario propietario) {
		
		// recorro los registros
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			//verifico si es el mismo propietario y tiene moto
			if(listaRegistroParqueo.get(i).cumpleMotoPropietario(propietario)) return true; 
		}
		
		return false;
	}

	/**
	 * Método que verifica si en un puesto hay una moto
	 * @param puesto
	 * @return
	 */
	private boolean verificarRegistroPuestoMoto(Puesto puesto) {
		//recorro los registros
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			//si el puesto es el mismo y el tipo de vehiculo es moto retorno true
			if(listaRegistroParqueo.get(i).compararPuesto(puesto) && listaRegistroParqueo.get(i).verificarTipoVehiculo(TipoVehiculo.MOTO)) return true; 
		}
		// si no cumple alguna condicion retorno false
		return false;
	}

	/*
	 * Método que obtiene las motos que cumplen las condiciones
	 */
	private Vehiculo[] obteMotosNumero(String numero) {
		//creo el arreglo de vehiculos
		Vehiculo[] motos = new Vehiculo[contarMotosCumplen(numero)];

		//retorno el arreglo de vehiculos
		return motos;
	}

	/**
	 * Método que cuenta las motos que tiene el numero
	 * @param numero
	 * @return
	 */
	private int contarMotosCumplen(String numero) {
		int contador = 0; 
		//recorro los registros
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			//verifico el registro
			if(listaRegistroParqueo.get(i).cumpleCondicionesMotoTelefono(numero)) {
				contador ++; 
			}
		}

		return contador;
	}

	/**
	 * Metodo que obtiene los carros que cumplen las condicieones
	 * @param string
	 * @param i
	 * @return
	 */
	private Vehiculo[] obtenerCarrosFecha(String fecha, int dinero) {
		int contador = 0; 
		Vehiculo[] vehiculos = new Vehiculo[contarCarrosCumplen(fecha, dinero)]; 
		//recorro los registros
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			//verifico si cumple las condiciones
			if(listaRegistroParqueo.get(i).cumpleCondiciones( fecha, dinero)) {
				//guardamos vehiculos
				vehiculos[contador] = listaRegistroParqueo.get(i).getVehiculo(); 
				contador ++; 
			}
		}
		//retorno los vehiculos
		return vehiculos;
	}
	/**
	 * Método que cuenta cuantos carros cumplen las dos condiciones
	 * @return
	 */
	private int contarCarrosCumplen(String fecha, int dinero) {
		//creo el contador
		int contador = 0;
		//recorro los registro
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			//verifico el registro
			if(listaRegistroParqueo.get(i).cumpleCondiciones( fecha, dinero)) {
				contador ++; 
			}
		}

		return contador;
	}

	private void inicializarDatos() {




	}
	/**
	 * Método que inicializa los puestos en una fila carro y otra fila moto
	 */
	private void inicilializarPuestos() {


	}


	//---------------------------------------------------------------------------
	//METODOS SET Y GET
	//---------------------------------------------------------------------------


	public Puesto[][] getListaPuestos() {
		return listaPuestos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setListaPuestos(Puesto[][] listaPuestos) {
		this.listaPuestos = listaPuestos;
	}


	public ArrayList<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public Propietario[] getListaPropietarios() {
		return listaPropietarios;
	}

	public void setListaPropietarios(Propietario[] listaPropietarios) {
		this.listaPropietarios = listaPropietarios;
	}

	public ArrayList<RegistroParqueo> getListaRegistroParqueo() {
		return listaRegistroParqueo;
	}

	public void setListaRegistroParqueo(ArrayList<RegistroParqueo> listaRegistroParqueo) {
		this.listaRegistroParqueo = listaRegistroParqueo;
	}

	@Override
	public String toString() {
		return "Parqueadero [listaPuestos=" + Arrays.toString(listaPuestos) + ", listaVehiculos=" + listaVehiculos
				+ ", listaPropietarios=" + listaPropietarios + ", listaRegistroParqueo=" + listaRegistroParqueo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Parqueadero other = (Parqueadero) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------------------------------------------Taller estacionamiento----------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Este metodo inicializa la matriz de puestos una fila carro otra fila moto
	 */
	public void inicializarMatriz() {
		//Recorro la matriz
		for (int i = 0; i < listaPuestos.length; i++) {
			for (int j = 0; j < listaPuestos[i].length; j++) {
				Puesto puesto = listaPuestos[i][j];
				//si es par le asigno el tipo moto
				if(i%2 ==0) {
					puesto.setTipoVehiculo(TipoVehiculo.MOTO);
					//si es impar le asigno el tipo carro
				}else {
					puesto.setTipoVehiculo(TipoVehiculo.CARRO);
				}
			}
		}
	}
	/**
	 * Este método retorna  los vehículos de tipo carro que han parqueado en la diagonal principal de la zona de parqueo.
	 * @return
	 */
	public ArrayList<Vehiculo> obtenerVehiculosDiagonalPrincipal() {
		ArrayList<Vehiculo>  vehiculosDiagonal = new ArrayList<>(0); 
		//recorro la matriz de puestos y obtengo el puesto
		for (int i = 0; i < listaPuestos.length; i++) {
			for (int j = 0; j < listaPuestos[i].length; j++) {
				Puesto puesto = listaPuestos[i][j];
				if(i==j) {
					vehiculosDiagonal.addAll(obtenerVehiculosPuesto(puesto)); 
				}
			}
		}
		return vehiculosDiagonal;

	}
	/**
	 * Este método obtiene todos los vehiculos en un puesto
	 * @param puesto
	 * @return
	 */
	private ArrayList<Vehiculo> obtenerVehiculosPuesto(Puesto puesto) {
		//arreglo de vehiculos
		ArrayList<Vehiculo> vehiculosPuesto = new ArrayList<>();
		//recorro los registros y comparo los puestos
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			RegistroParqueo registro = listaRegistroParqueo.get(i); 
			if(registro.compararPuesto(puesto)) {
				vehiculosPuesto.add(registro.getVehiculo());
			}
		}
		return null;
	}

	/**
	 * Este método devuelve un arreglo de vehiculos que tienen un modelo mayo a 2016
	 * @return
	 */
	public ArrayList<Vehiculo> obtenerVehiculosModeloMayor2016() {
		//declaro el arraylist
		ArrayList<Vehiculo> vehiculosModeloSuperior2016 = new ArrayList<>(0);
		//recorro los registros
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			RegistroParqueo registro = listaRegistroParqueo.get(i);
			//verifico si el modelo es superior al requerido
			if(registro.verificarModeloSuperior(2016)) {
				vehiculosModeloSuperior2016.add(registro.getVehiculo()); 
			}
		}
		return vehiculosModeloSuperior2016; 
	}

	/**
	 * Este método Devuelve un listado ordenado con
	 *  los nombres de los Propietarios de los vehículos que tienen modelo superior al indicado por el usuario.
	 * @return
	 */
	public ArrayList<String> obtenerListadoNombresPropietariosMayorModelo(int modelo){
		//declaro el arreglo
		ArrayList<String> nombres = new ArrayList<>(0);
		//recorro los registros
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			RegistroParqueo registro = listaRegistroParqueo.get(i);
			//verifico los registros que tengan un modelo superior o igual al indicado
			if(registro.verificarModeloSuperior(modelo)) {
				//si el registro cumple entonce obtengo el vehiculo del registro
				Vehiculo vehiculo = registro.getVehiculo();
				//busco el propietario de ese vehiculo
				Propietario propietario = vehiculo.getPropietario();
				//obtengo el nombre del propietario del vehiculo
				String nombre = propietario.getNombre();
				//añado el nombre a la lista
				nombres.add(nombre);
			}
		}
		Collections.sort(nombres);
		return nombres;
	}


	/**
	 * Método que Devolver los propietarios de los vehículos
	 *  (que están en este momento en el parqueadero) cuyas  placas tienen dos vocales seguidas y 
	 *  dos números repetidos.
	 * @return
	 */
	public ArrayList<Propietario> obtenerPropietariosActualesConVocalSeguida() {

		ArrayList<Propietario> propietarios = new ArrayList<>(0); 

		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			RegistroParqueo registro = listaRegistroParqueo.get(i); 
			if(registro.cumpleCondicionesVocalesNumeros()) {
				Vehiculo vehiculo = registro.getVehiculo(); 
				propietarios.add(vehiculo.getPropietario()); 
			}
		}

		return propietarios; 
	}




	/**
	 * Devolver la cantidad de registros que tiene un puesto dado(parametro puesto), usar el método equals().
	 * @param puesto
	 * @return
	 */
	public int obtenerRegistroPuesto(Puesto puesto){
		//variable contadora de los puestos
		int cantRegistros = 0; 
		//recorro los registros
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			RegistroParqueo registro = listaRegistroParqueo.get(i);
			//comparo los puestos
			if(registro.compararPuesto(puesto)) {
				//si el registro tiene el mismo puesto aumento el contador 
				cantRegistros++; 
			}
		}
		return cantRegistros; 
	}

	/**
	 * Método que determina si en la matriz de puestos 
	 * existen por lo menos dos vehículos con  placas que terminan en número par consecutivos en una misma fila, o en la misma columna.
	 * 
	 * @return
	 */
	public boolean verificarSihayPlacasParesConsecutivas() {
		//variables locales
		Puesto puesto1; 
		Puesto puesto2; 
		Vehiculo vehiculo1; 
		Vehiculo vehiculo2;

		//recorro las filas, obtengo los puestos y comparo
		for (int i = 0; i < listaPuestos.length; i++) {
			for (int j = 0; j < listaPuestos[i].length-1; j++) {
				//obtengo dos puestos el del recorrido de la matriz y el siguiente en la misma fila
				puesto1 = listaPuestos[i][j]; 
				puesto2 = listaPuestos[i][j+1]; 
				//busco el vehiculo por su puesto
				vehiculo1 = buscarVehiculoPuesto(puesto1); 
				vehiculo2 = buscarVehiculoPuesto(puesto2);
				//verifico que las placas de los vehiculos sean pares
				if(vehiculo1.verificarPlacasPares() && vehiculo2.verificarPlacasPares()) {
					return true;
				}
			}
		}

		//Ahora recorro las columas y verifico si están seguidas en una columna

		for (int i = 0; i < listaPuestos.length; i++) {
			for (int j = 0; j < listaPuestos[i].length-1; j++) {
				//obtengo el puesto por columnas
				puesto1 = listaPuestos[j][i]; 
				puesto2 = listaPuestos[j+1][i];
				//busco el vehiculo por su puesto
				vehiculo1 = buscarVehiculoPuesto(puesto1); 
				vehiculo2 = buscarVehiculoPuesto(puesto2);
				//verifico que las placas de los vehiculos sean pares
				if(vehiculo1.verificarPlacasPares() && vehiculo2.verificarPlacasPares()) {
					return true;
				}
			}
		}

		return false; 
	}


	//-----------------------------------------------------------------------------------------------------------

	/**
	 * Este método buca un vehiculo por su puesto y lo retorna
	 * @param puesto
	 * @return
	 */
	private Vehiculo buscarVehiculoPuesto(Puesto puesto) {
		//declaro el vehiculo
		Vehiculo vehiculo = null; 
		//recorro los registros buscando el puesto
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			RegistroParqueo registro = listaRegistroParqueo.get(i);
			//verifico el puesto de ese registro
			if(registro.compararPuesto(puesto)) {
				vehiculo = registro.getVehiculo(); 
			}
		}
		return vehiculo; 
	}

	/**
	 * 
	 * @param nuevoVehiculo
	 * @param identificacionPropietario
	 * @return
	 */
	public String crearVehiculo(Vehiculo nuevoVehiculo,String identificacionPropietario) {
		String resultado 			= "";
		Vehiculo vehiculoEncontrado = null;
		Propietario propietario 	= null;
		// verificar si existe el vehiculo
		vehiculoEncontrado = buscarVehiculo(nuevoVehiculo.getPlaca());
		if(vehiculoEncontrado == null){
			// verificar si existe el propietario
			propietario = obtenerPropietario(identificacionPropietario);
			if(propietario == null){
				return ("NO existe un propietario para este vehiculo");
			}
			else{
				listaVehiculos.add(nuevoVehiculo);
				resultado = "Vehiculo Registrado";
			}
		}else{
			return ("Este vehiculo ya se encunttra registrado");
		}
		return resultado;
	}

	/**
	 * Método que obtiene un propietario por su identificación
	 * @param identificacionPropietario
	 * @return
	 */
	private Propietario obtenerPropietario(String identificacionPropietario) {
		//recorro la lista propietarios
		for (Propietario propietario : listaPropietarios) {
			if(propietario != null && propietario.getIdentificacion().equals(identificacionPropietario)){
				return propietario;
			}
		}
		return null;
	}

	/** 
	 * Método que busca un vehiculo por su placa
	 * @param placa
	 * @return
	 */
	private Vehiculo buscarVehiculo(String placa) {
		//recorro lista vehiculos
		for (Vehiculo vehiculo : listaVehiculos) {
			if(vehiculo != null && vehiculo.getPlaca().equals(placa)){
				return vehiculo;
			}
		}

		return null;
	}

	//	1.0 Obtener una matriz con las siguientes condiciones: dos filas una
	//	fila para carros y otra para motos : en la primera fila se ubican
	//	los vehículos de tipo carro que han parqueado más de dos veces
	//	en el parqueadero, en la segunda fila los vehículos de tipo moto
	//	que han parqueado más de tres veces en el parqueadero.


	public Vehiculo[][] obtenerMatrizCondiciones(){
		//creo la matriz
		Vehiculo[][] matriz = new Vehiculo[2][]; 
		//lleno los arreglos
		matriz[0] = obtenerCarrosMasDosVeces(); 
		matriz[1] = obtenerMotosMasDosVeces(); 
		//retorno la matriz
		return matriz; 
	}


	//Realizar un método que retorne la suma de los valores cobrados(Recaudo total fila)
	//en los Registros de una fila dada por el usuario correspondiente a la zona de parqueo.

	public double obtenerTotalCobrado(int fila) {
		//variable local
		double total = 0; 
		//ciclo que itera en la lista de los puestos
		for (int i = 0; i < listaPuestos[fila].length; i++) {
			Puesto puesto = listaPuestos[fila][i]; 
			total += obtenerTotalPuesto(puesto); 
		}
		return total; 
	}

	//obtener un arrelo de vehiculos que sean de un modelo dado por el usuario

	public Vehiculo[] obtenerVehiculosModelo(String modelo) {
		int contador = 0;
		//creo el arreglo de vehiculos
		Vehiculo[] vehiculos = new Vehiculo[contarVehiculosModelo(modelo)]; 
		//recorro la lista de vehiculos
		for (int i = 0; i < listaVehiculos.size(); i++) {
			Vehiculo vehiculo = listaVehiculos.get(i); 
			if(vehiculo.compararModelo(modelo)) {
				vehiculos[contador] = vehiculo; 
				contador++; 
			}
		}
		return vehiculos; 
	}

	// obtener los propietarios de un un vehiculo que tenga una placa que termine en impar;

	public ArrayList<Propietario> obtenerPropietariosPlacaImpar() {
		//arreglo de propietarios
		ArrayList<Propietario> propietariosImpar = new ArrayList<>(0);
		//recorro la lista de vehiculos
		for (int i = 0; i < listaVehiculos.size(); i++) {
			Vehiculo vehiculo = listaVehiculos.get(i); 
			if(vehiculo.verificarPlacaImpar()) {
				propietariosImpar.add(vehiculo.getPropietario()); 
			}
		}
		return propietariosImpar; 
	}



	/**
	 * Método que cuenta cuantos vehiculos hay de un modelo en especifico
	 * @param modelo
	 * @return
	 */
	private int contarVehiculosModelo(String modelo) {
		int contador = 0;
		//bucle para recorrer los vehiculos
		for (int i = 0; i < listaVehiculos.size(); i++) {
			Vehiculo vehiculo = listaVehiculos.get(i); 
			if(vehiculo.compararModelo(modelo)) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Método que obtiene el total de un puesto en todos sus registros
	 * @param puesto
	 * @return
	 */
	private double obtenerTotalPuesto(Puesto puesto) {
		double total = 0; 
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			RegistroParqueo registro = listaRegistroParqueo.get(i); 
			if(registro.compararPuesto(puesto)) {
				total += registro.getTotal(); 
			}
		}

		return total;
	}

	/**
	 * Método que obtiene un arreglo de motos que han estado mas de tres veces y son de tipo moto
	 * @return
	 */
	private Vehiculo[] obtenerMotosMasDosVeces() {
		int contador = 0; 
		Vehiculo[] motos = new Vehiculo[contarVehiculoMasDosVeces(TipoVehiculo.MOTO)]; 
		//Bucle
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			RegistroParqueo registro = listaRegistroParqueo.get(i);
			if(registro.verificarTipoVehiculo(TipoVehiculo.MOTO) && verificarVehiculoMasTresVeces(registro)) {
				motos[contador] = registro.getVehiculo(); 
				contador++; 
			}
		}

		return motos;
	}
	/**
	 * Método que verifica si un vehiculo se ha registrado mas de tres veces
	 * @param registro
	 * @return
	 */
	private boolean verificarVehiculoMasTresVeces(RegistroParqueo registro) {
		//variable que cuenta cuantas veces está en el registro
		int contador = 0; 
		//obtengo el vehiculo del registro
		Vehiculo vehiculo = registro.getVehiculo();
		//busco el vehiculo en el registro
		for (int i = 0; i < listaVehiculos.size() && contador<3; i++) {
			//verifico si es el mismo vehiculo
			if(vehiculo.equals(listaVehiculos.get(i))) {
				//si existe en el registro sumo a contador
				contador++; 
			}
		}
		//si existe mas de uno de eso vehiculos retorno true
		if(contador == 3) {
			return true; 
		}

		return false;
	}

	/**
	 * Método que devuelve un arreglo de los carros que se han parqueado
	 * mas de dos veces
	 * @return
	 */
	private Vehiculo[] obtenerCarrosMasDosVeces() {
		int contador = 0;
		//creo el arreglo de tipo carro 
		Vehiculo[] carros = new Vehiculo[contarVehiculoMasDosVeces(TipoVehiculo.CARRO)]; 
		//obtengo los carros que cumplen la condicion
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			//obtengo el registro
			RegistroParqueo registro = listaRegistroParqueo.get(i);
			//verifico que cumpla las condiciones
			if(registro.verificarTipoVehiculo(TipoVehiculo.CARRO) && verificarVehiculoMasDosVeces(registro)) {
				carros[contador] = registro.getVehiculo(); 
				contador++; 
			}
		}
		return carros;
	}



	/**
	 * Método que cuenta cuantas carros hay y que hallan pasado mas de dos veces
	 * @return
	 */
	private int contarVehiculoMasDosVeces(TipoVehiculo tipo) {
		int contador = 0; 
		for (int i = 0; i < listaRegistroParqueo.size(); i++) {
			RegistroParqueo registro = listaRegistroParqueo.get(i);
			if(registro.verificarTipoVehiculo(tipo) && verificarVehiculoMasDosVeces(registro) ){
				contador ++; 
			}
		}
		return contador;
	}

	/**
	 * Método que verifica si un vehiculo está mas de dos veces en un registro
	 * @param registro
	 * @return
	 */
	private boolean verificarVehiculoMasDosVeces(RegistroParqueo registro) {
		//variable que cuenta cuantas veces está en el registro
		int contador = 0; 
		//obtengo el vehiculo del registro
		Vehiculo vehiculo = registro.getVehiculo();
		//busco el vehiculo en el registro
		for (int i = 0; i < listaVehiculos.size() && contador<2; i++) {
			//verifico si es el mismo vehiculo
			if(vehiculo.equals(listaVehiculos.get(i))) {
				//si existe en el registro sumo a contador
				contador++; 
			}
		}
		//si existe mas de uno de eso vehiculos retorno true
		if(contador >= 2) {
			return true; 
		}

		return false;
	}

	public String eliminarVehiculo(String placa){

		String mensaje = "";

		for (Vehiculo vehiculo : listaVehiculos) {
			if(vehiculo.getPlaca().equalsIgnoreCase(placa)){
				listaVehiculos.remove(vehiculo);
				mensaje = "Vehiculo Eliminado";
				break;
			}
		}

		if(mensaje.equalsIgnoreCase("")){
			return ("Vehiculo no se encuentra registardo");
		}

		return mensaje;


	}

	public String actualizarVehiculo(String placaAnterior, String placaNueva, String modeloNuevo,
			TipoVehiculo tipoNuevo, String propietarioNuevo) {


		Vehiculo vehiculo = buscarVehiculo(placaAnterior);

		if(vehiculo != null){
			vehiculo.setPlaca(placaNueva);
			vehiculo.setModelo(modeloNuevo);
			vehiculo.setTipoVehiculo(tipoNuevo);

			Propietario propietario = obtenerPropietario(propietarioNuevo);
			if(propietario != null){
				vehiculo.setPropietario(propietario);
			}else{
				return ("No hay propietario");
			}
		}else{
			return ("No hay vehiculo");
		}
		return "OK";
	}

}
