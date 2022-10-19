package co.edu.uniquindio.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Random;

public class Parqueadero {
	
	private Propietario[] listaPropietario;
	private String nombre;
	private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>(0); 
	private ArrayList<RegistroParqueo> listaRegistroParqueo = new ArrayList<>(0);
	private Puesto[][] listaPuestos; 
	
	
	//Constructor
	public Parqueadero(String nombre) {
		super();
		this.nombre = nombre;
	}
	//------------------------------------------------------------Métodos---------------------------------------------------------------------------------------------------------
	
	//TERMINAR
	public void inicializarPuestos(int filas, int columnas) {
		listaPuestos = new Puesto[filas][columnas]; 
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				
				if(i%2 != 0) {
					RegistroParqueo registro = llenarRegistroAleatoriamente("Carro");
					//se debe devolver registro y cambiar el puesto 
					listaPuestos[i][j].setTipoVehiculo(TipoVehiculo.CARRO);
					listaPuestos[i][j].setParqueadero(this);
				}else {
					listaPuestos[i][j].setTipoVehiculo(TipoVehiculo.MOTO);
					listaPuestos[i][j].setParqueadero(this);
				}
				
			}
		}
		
	}
	/**
	 * Método que llena los registros aleatoriamente
	 * @param tipoVehiculo
	 * @return
	 */
	private RegistroParqueo llenarRegistroAleatoriamente(String tipoVehiculo) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String[] diaHoraEntrada = timeStamp.split(" ");  
		String horaSalida = generarHoraSalida(diaHoraEntrada[0]); 
		RegistroParqueo registro; 
		
		if(tipoVehiculo.equalsIgnoreCase("Carro")) {
			
			Vehiculo carro = generarCarroAleatorio();
			registro = new RegistroParqueo(diaHoraEntrada[0], diaHoraEntrada[1], horaSalida, carro);
			listaRegistroParqueo.add(registro); 
			
		}else {
			Vehiculo moto = generarMotoAleatoria(); 
			registro = new RegistroParqueo(diaHoraEntrada[0], diaHoraEntrada[1], horaSalida, moto);
			listaRegistroParqueo.add(registro); 
		}
		return registro;
	}
	
	
	
	/**
	 * Método que genera un número aleatorio entre dos parametros
	 * @param min
	 * @param max
	 * @return
	 */
	private int generarNumeroAleatorio(int min, int max) {
		//Maximo y minimo del modelo
		//objeto random
		Random random = new Random();
		//valor random
		int value = random.nextInt(max + min) + min;
		return value; 
	}
	
	/**
	 * Método que genera una hora de salida random
	 * @param string
	 * @return
	 */
	private String generarHoraSalida(String string) {
		
		int hora = Integer.parseInt(string); 
		int numRandom = generarNumeroAleatorio(1, 10); 
		hora = hora +numRandom; 
		return (hora+""); 
	}

	/**
	 * Método que genera una moto aleatoria
	 * @return moto
	 */
	private Vehiculo generarMotoAleatoria() {
		//Genero las placas aleatoriamente
		String placa = generarPlacaAleatoria();

		//genero el modelo aleatoriamente
		String modelo = generarModeloAleatorio();

		//creo la moto
		Vehiculo moto = new Vehiculo(placa, modelo);
		
		//asigno el parqueadero
		moto.setParqueadero(this);
		
		//asigno el tipo
		moto.setTipoVehiculo(TipoVehiculo.MOTO);
		
		//añado el carro a los vehiculos
		listaVehiculos.add(moto); 
		return moto; 
	}
	
	
	/**
	 * Método que genera un vehículo aleatoriamente
	 * @return
	 */
	private Vehiculo generarCarroAleatorio() {
		
		//Genero las placas aleatoriamente
		
		String placa = generarPlacaAleatoria();
		
		//genero el modelo aleatoriamente
		
		String modelo = generarModeloAleatorio();
		//creo el carro
		Vehiculo carro = new Vehiculo(placa, modelo);
		//asigno el parqueadero
		carro.setParqueadero(this);
		//asigno el tipo
		carro.setTipoVehiculo(TipoVehiculo.CARRO);
		//añado el carro a los vehiculos
		listaVehiculos.add(carro); 
		return null;
	}
	
	/**
	 * Método que genera un modelo aleatoriamente
	 * @return
	 */
	private String generarModeloAleatorio() {
		int value = generarNumeroAleatorio(2000, 2020);
		return (value+"");
	}

	/** 
	 * Método que genera una plca aleatoria usando un entero random
	 * y despues convertido a String
	 * @return
	 */
	private String generarPlacaAleatoria() {
		boolean flag = true; 
		int value;
		//bucle que genera la placa
		do {
			//genero la placa aleatoria
			value = generarNumeroAleatorio(1000, 9999); 
			//verifico que no haya una placa con ese valor
			if(!existeVehiculo(value+"")) {
				flag = false; 
			}
			
		}while(flag); 
		return (value+"");
	}

	/**
	 * Método que permite crear un vehiculo
	 * @param placa
	 * @param modelo
	 * @param tipo
	 * @return
	 */
	public String crearVehiculo(String placa, String modelo, String tipo) {
		//Verifico que no haya un vehículo con esa placa
		
		boolean hayVehiculoPlacaIgual = existeVehiculo(placa);
		
		//si es una moto y no existe un vehiculo con esa placa
		if(tipo.equalsIgnoreCase("Moto") && !hayVehiculoPlacaIgual) {
			Vehiculo v = new Vehiculo(placa, modelo); 
			v.setTipoVehiculo(TipoVehiculo.MOTO);
			listaVehiculos.add(v); 
			return "Moto creada"; 

			//si es un carro y no existe un vehiculo con esa placa
		}else if(tipo.equalsIgnoreCase("Carro") && !hayVehiculoPlacaIgual) {
			Vehiculo v = new Vehiculo(placa, modelo); 
			v.setTipoVehiculo(TipoVehiculo.CARRO);
			listaVehiculos.add(v);
			return "Carro creado";
			
		//si hay un vehiculo con una placa igual
		}else if(hayVehiculoPlacaIgual){
			
			return "Ya existe un vehiculo con esa placa"; 
			
		//si no se puede crear el vehiculo
		}else {
			return "No se puede crear el vehiculo"; 
		}
	}
	
	/**
	 * Método que verifica si existe un vehiculo
	 * @param placa
	 * @return
	 */
	private boolean existeVehiculo(String placa) {
		//recorro los vehiculos existentes
		for (Vehiculo vehiculo : listaVehiculos) {
			//verifico sus placas
			if(vehiculo.compararPlaca(placa)) {
				return true; 
			}
		}
		return false;
	}
	
	/**
	 * Método que busca un vehiculo por su placa
	 * @param placa
	 * @return
	 */
	public Vehiculo buscarVehiculo(String placa) {
		//recorro la lista de vehiculos
		for (Vehiculo i : listaVehiculos) {
			//comparo sus placas
			if(i.compararPlaca(placa)) {
				return i; 
			}
		}
		return null; 
	}
	
	/**
	 * Método que elimina un vehiculo
	 * @param placa
	 * @return
	 */
	public String eliminarVehiculo(String placa) {
		//Recorro los vehiculos
		for (Vehiculo i : listaVehiculos) {
			if(i.compararPlaca(placa)) {
				//elimino el vehiculo
				listaVehiculos.remove(i);
				return "Vehiculo eliminado"; 
			}
		}
		return "No existe un vehiculo con esa placa"; 
	}
	
	//HashCode
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	//Método equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Parqueadero))
			return false;
		Parqueadero other = (Parqueadero) obj;
		return Objects.equals(nombre, other.nombre);
	}

	//Getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Propietario[] getListaPropietario() {
		return listaPropietario;
	}
	public void setListaPropietario(Propietario[] listaPropietario) {
		this.listaPropietario = listaPropietario;
	}
	public Puesto[][] getListaPuestos() {
		return listaPuestos;
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

	public ArrayList<RegistroParqueo> getListaRegistroParqueo() {
		return listaRegistroParqueo;
	}

	public void setListaRegistroParqueo(ArrayList<RegistroParqueo> listaRegistroParqueo) {
		this.listaRegistroParqueo = listaRegistroParqueo;
	}

	
}
