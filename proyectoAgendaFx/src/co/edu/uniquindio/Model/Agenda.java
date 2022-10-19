package co.edu.uniquindio.Model;

public class Agenda {
	private Contacto[] listaContactos;
	private Grupo[] listaGrupos; 
	private Cita[] listaCitas; 
	private int[] listaEdades;
	private String titulo;
	private String frase; 
	
	public Agenda(String titulo) {
		super();
		this.titulo = titulo;
	}
	
	public Agenda(int numContactos, int numGrupos, int numCitas, String titulo) {
		super();
		this.listaContactos = new Contacto[numContactos];
		this.listaGrupos = new Grupo[numGrupos];
		this.listaCitas = new Cita[numCitas];
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Contacto[] getContactos() {
		return listaContactos;
	}

	public void setContactos(Contacto[] listaContactos) {
		this.listaContactos = listaContactos;
	}

	public Cita[] getListaCitas() {
		return listaCitas;
	}

	public void setListaCitas(Cita[] listaCitas) {
		this.listaCitas = listaCitas;
	}

	public Grupo[] getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(Grupo[] listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public Contacto[] getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(Contacto[] listaContactos) {
		this.listaContactos = listaContactos;
	}


	
	 //Este es la edad que mas se repite 
    //METODO DOS
    public int numRepetido(){
        int edadMayor =0;
            for (int i = 0; i <= listaEdades.length; i++) {
                for (int j = 0; j < listaEdades.length; j++) {

                    if (i != j && listaEdades[i] == listaEdades[j]) {
                        return edadMayor = listaEdades[j];
                    }
                }
            }
        return edadMayor;    
    }
    
    // Este metodo es para saber el promedio edades
    //METODO TRES
    public double obtenerPromedioEdades(){
        double promedio = 0;
        double suma = 0;
        for (int i = 0; i < listaEdades.length; i++) {
            suma += listaEdades[i];
        }
        if (suma > 0){
            return promedio = suma / listaEdades.length;
        }
        return promedio;
    }
    
    //Este metodo es para saber cuantos contactos tiene una edad menor a 18
    //METODO CUATRO
    
    
    
  //Este metodo me saca el promedio de las edades contacto
   //METODO CINCO
    private double promedioEdad(int [] promedioEdadContacto){
        double suma= 0;
        double promedio;
        
        for(int i = 0; i < promedioEdadContacto.length; i++){
            suma+= promedioEdadContacto[i];
        }
        promedio = suma / 5;
        return promedio;
    }
    
    //Este metodo me saca la media de las edades contacto
    //METODO CINCO
    public double mediaEdad(int [] mediaEdadContacto){
        double resta= 0, suma= 0;
                  
        for (int i = 0; i < mediaEdadContacto.length; i++) {
            resta= mediaEdadContacto[i] - promedioEdad(mediaEdadContacto);
            suma += Math.pow(resta, 2);
            
        }
        return suma;
    }
    
    // Este metodo es para hayar la desviacion estandar
    //METODO CINCO
    public double desviacionEstandar(int [] desviacionEdadContacto){
        double restultado= 0;
        
        restultado = Math.sqrt(mediaEdad(desviacionEdadContacto)/ desviacionEdadContacto.length);
        
        return restultado;
    }
    
    //Este metodo se encarga de devolver el arreglo de nombres al revés
    //METODO SEIS
    public static String nombreInverso(String [] nombresContactos){
        String nombreInverso = null;
        for (int i = nombresContactos.length-1; i>=0; i--) {
            nombreInverso = nombresContactos[i];
            System.out.println("El nombre en la posición "+(i+1)+" es: "+nombreInverso );
        }
        return nombreInverso;
    }
    
	
	//Este metodo inicializa una edad
    //METODO NUEVE
	public int generarNumeroAleatorio() {
		int numero = 0;
		boolean bandera = true;
		while (bandera) {
			numero = (int) (Math.random() * ( 60 - 15 ));

			if(numero <= 60 && numero >= 15){
				bandera = false;
			}
		}
		return numero;

	}
	
	//Este metodo conviete una frase en un un arreglo de caracteres
    //METODO DIEZ
    public char [] fraseArregloCaracter(String nombre){
        char [] cadena = nombre.toCharArray();
        for (int i = 0; i < nombre.length(); i++) {
            System.out.println("El arreglo de la cadena es:"+cadena[i]);
        }
        return cadena;
    }
    

	/**
	 * METODO ONCE
	 */
	public void AsociarContactoGrupo() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * METODO DIEZ
	 */
	public String creaArregloLetrasFrase() {
		if(frase != null) {
			return frase;
		}
		else {
			return "Aun no se ha creado alguna frase para pasar a un arreglo";
		}
	}

	/**
	 * METODO NUEVE
	 */
	public void inicializarEdadAleatoriamente() {
		if(listaContactos != null) {
			for(int i = 0; i < listaContactos.length; i++){

			}
		}
	}

	/**
	 * METODO OCHO
	 */
	private void inicializarGruposAleatoriamente() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * METODO SIETE
	 */
	private void inicializarContactosAleatoriamente() {
		// TODO Auto-generated method stub
		
	}

	/**
	 *METODO SEIS
	 */
	public String imprimirContactosAtrasHaciaAdelante() {
		if(listaContactos != null) {
			String mensaje = " ";
			for (int i = 0; i < listaContactos.length; i++) {
				if(listaContactos[i] != null) {
					mensaje += listaContactos[i].toString();
				}
			}
			if(mensaje != " ") {
				return mensaje;
			}
			return "No hay informacion de los nombres en contactos para mostrar";
		}
		else {
			return "Aun no se ha creado los nombres en contacto";
		}
	}

	/**
	 * METODO CINCO
	 */
	public String calcularDesviacionEstandarEdades() {
		if(listaContactos != null) {
			String mensaje = " ";
			for (int i = 0; i < listaContactos.length; i++) {
				if(listaContactos[i] != null) {
					mensaje += listaContactos[i].toString();
				}
				
			}
			if(mensaje != " ") {
				return mensaje;
			}
			else {
				return "No hay informacion de edades en contacto para mostrar la desviacion estandar";
			}
		}
		else {
			return"Aun no se ha creado las edades en contacto";
		}
		
	}

	/**
	 * METODO CUATRO
	 */
	private void obtenerContactosMenoresEdad() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * METODO TRES
	 */
	private String obtenerPromedioEdadContactos() {
		if(listaContactos != null) {
			String mensaje = " ";
			for (int i = 0; i < listaContactos.length; i++) {
				if(listaContactos[i] != null) {
					mensaje += listaContactos[i].toString(); 
				}
			}
			if(!mensaje.equals(" ")) {
				return mensaje;
			}
			else {
				return "No hay informacion en contacto para mostrar el promedio de edades";
			}
		}
		else {
			return "Aun no se ha creado las edades en contacto";
		}
		
	}

	/**
	 * METODO DOS
	 */
	public String obtenerEdadMasRepetida() {
		if(listaContactos != null) {
			String mensaje = " ";
			for (int i = 0; i < listaContactos.length; i++) {
				if(listaContactos[i] != null) {
					mensaje += listaContactos[i].toString();
				}
			}
			if(!mensaje.equals(" ")) {
				return mensaje;
			}
			else {
				return "No hay informacion en los contactos para mostrar sobre las edades";
			}
		}
		else {
			return "Aun no se han creado las edades de contactos";
		}
		
	}
	
	/**
	 * METODO UNO
	 */
	public String imprimirPosicionesImpares() {
		if(listaContactos != null) {
			String mensaje = " ";
			for(int i = 1; i < listaContactos.length; i+=2){
				if(listaContactos[i] != null) {
					mensaje += listaContactos[i].toString();
				}

			}
			if(!mensaje.equals(" ")) {
				return mensaje;
			}
			else {
				return"No hay informacion de los contactos para mostrar";
			}
		}
		else {
			return "Aun no se ha creado contactos";
		}
		
	}

	public int[] getListaEdades() {
		return listaEdades;
	}

	public void setListaEdades(int[] listaEdades) {
		this.listaEdades = listaEdades;
	}

	public String getFrase() {
		return frase;
	}

	public void setFrase(String frase) {
		this.frase = frase;
	}
	
	
	//--------------------------------------------------------
	//CRUD CONTACTO
	
	public String crearContacto(String nombre, String correo, String direccion, String telefono) {
		String mensaje = "";
		int posicionDisponible = 0;
		boolean existeContacto = false;

		posicionDisponible = obtenerPosicionDisponibleContacto();

		if(posicionDisponible == -1){
			mensaje = "No hay posiciobes disponibles";
		}else{

			existeContacto = verificarExistenciaContacto(telefono);
			if(existeContacto == false){
				listaContactos[posicionDisponible] = new Contacto(nombre, correo, direccion, telefono);
			}else{
				mensaje = "Ya existe un contacto con este numero de telefono";
			}
		}

		return "El contacto fue creado";
	}

	private Contacto obtenerContacto(String telefono) {

		for (Contacto contacto : listaContactos) {
			if(contacto != null && contacto.getTelefono().equals(telefono)){
				return contacto;
			}
		}

		return null;
	}



	private boolean verificarExistenciaContacto(String telefono) {

		for (Contacto contacto : listaContactos) {
			if(contacto != null && contacto.getTelefono().equals(telefono)){
				return true;
			}
		}

		return false;
	}




	private int obtenerPosicionDisponibleContacto() {

		int pos = -1;

		for (int i = 0; i < listaContactos.length; i++) {
			if(listaContactos [i] == null){
				return i;
			}
		}
		return pos;
	}



	public String eliminarContacto (String telefono) throws ContactoExcepction{

		boolean existeContacto = false;

		existeContacto = verificarExistenciaContacto(telefono);

		if(existeContacto == false){
			throw new ContactoExcepction("El contacto no existe");
		}else{

			int posContacto = obtenerPosContacto(telefono);

			listaContactos [posContacto] = null;
		}

		return "Contacto eliminado";
	}

	private int obtenerPosContacto(String telefono) {


		int pos = 0;
		Contacto contactoAuxliar = null;

		for (int i = 0; i < listaContactos.length; i++) {
			contactoAuxliar = listaContactos[i];
			if(contactoAuxliar != null && contactoAuxliar.getTelefono().equals(telefono)){
				return i;
			}
		}
		return pos;
	}



	public String actualizarContacto(String telefonoAnterior, String telefonoNuevo,
			String nombreNuevo,String correpoNuevo,String direccionNueva) throws ContactoExcepction{

		String mensaje = "";
		Contacto contactoEncontrado= null;

		contactoEncontrado = obtenerContacto(telefonoAnterior);

		if(contactoEncontrado == null){
			 throw new ContactoExcepction("El contacto no existe");
		}
		else{
			 contactoEncontrado.setNombre(nombreNuevo);
			 contactoEncontrado.setCorreo(correpoNuevo);
			 contactoEncontrado.setDireccion(direccionNueva);
			 contactoEncontrado.setTelefono(telefonoNuevo);
		}

		return "El contacto ha sido actualizado";

	}
}
