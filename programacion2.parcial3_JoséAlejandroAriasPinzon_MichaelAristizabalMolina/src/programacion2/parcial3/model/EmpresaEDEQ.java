package programacion2.parcial3.model;

import java.util.ArrayList;

public class EmpresaEDEQ implements IEmpresa{

	private ArrayList<Cliente> listaClientes; 
	private ArrayList<Factura> listaFacturas;
	private String nombre; 


	//------------CONSTRUCTOR---------------
	public EmpresaEDEQ(String nombre) {
		super();
		this.nombre = nombre;
		listaClientes = new ArrayList<Cliente>(); 
		listaFacturas = new ArrayList<Factura>();
		creaClientesQuemados();
	}


	//-------------------------MÉTODOS DE LA INTERFAZ-------------------------
	/**
	 * MÉTODO QUE BUSCA UN CLIENTE EN LA EMPRESA DADA LA IDENTIFICACIÓN
	 */
	@Override
	public Cliente buscarCliente(String identificacion) {
		boolean flag = true; 
		for (int i = 0; i < listaClientes.size() && flag; i++) {
			//el cliente aux en la lista clientes
			Cliente clienteAux = listaClientes.get(i); 
			if( clienteAux instanceof ClienteNatural){
				ClienteNatural clienteAux2 = (ClienteNatural) clienteAux;
				//comparo el id del cliente
				if(clienteAux2.compararId(identificacion)){
					flag = false; 
					return clienteAux2; 
				}

			}


		}
		return null;
	}
	/**
	 * MÉTODO QUE PERMITE REGISTRAR UNA FACTURA
	 */
	@Override
	public String registrarFactura(Factura factura) {
		//mensaje de respuesta al usuario
		String mensaje = "Factura creada correctamente"; 
		//la variable booleana me permite frenar el recoorrido una vez se encuentran las condiciones
		boolean existeFacturaCliente = false; 
		//recorro la lista factura para verificar factura a factura si es el mismo
		//cliente y la misma fecha
		for (int i = 0; i < listaFacturas.size() && ! existeFacturaCliente; i++) {
			//fecha de la factura en la iteración
			String fecha = listaFacturas.get(i).getFechaFactura();
			//cliente de la factura de la iteración
			Cliente cliente = listaFacturas.get(i).getCliente();
			//comparo los datos anteriores con la factura
			if(factura.compararFechaCliente(fecha, cliente)) {
				existeFacturaCliente = true;
				//cambio el mensaje
				mensaje = "No se ha podido crear la factura"; 
			}
		}
		//verificio si la factura no existe y si cumple la añado a la lista facturas
		if(!existeFacturaCliente) {
			listaFacturas.add(factura); 
		}
		
		return mensaje;
	}


	//--------Mètodos de la empresa---------
	
	/**
	 * MÈTODO QUE CREA PERMITE CREAR TODO TIPO DE CLIENTES QUEMADOS
	 */
	public void creaClientesQuemados() {
		crearClientesQuemadosJuridico();
		crearClientesQuemadosNatural();
	}
	
	/**
	 * MÈTODOS QUE PERMITE CREAR CLIENTES Naturales QUEMADOS
	 */
	public void crearClientesQuemadosNatural() {
		//creo los cliente
		ClienteNatural cliente1 = new ClienteNatural("michael","Arias", "12345", "2 Bajo");
		ClienteNatural cliente2 =  new ClienteNatural("Stiven","Molina", "67891", "2 Alto");
		ClienteNatural cliente3 = new ClienteNatural("Alejandro","Duque", "19283", "3 Medio");
		ClienteNatural cliente4 = new ClienteNatural("Nataly","Betancourth", "67402", "4 Bajo");
		ClienteNatural cliente5 = new ClienteNatural("Mariano","Aristizabal", "21590", "1 Alto");
		//los añado a la lista clientes
		listaClientes.add(cliente1); 
		listaClientes.add(cliente2);
		listaClientes.add(cliente3); 
		listaClientes.add(cliente4); 
		listaClientes.add(cliente5);
	}
	/**
	 * MÈTODOS QUE PERMITE CREAR CLIENTES JURIDICOS QUEMADOS
	 */
	public void crearClientesQuemadosJuridico() {
		//creo los clientes
		ClienteJuridico cliente1 = new ClienteJuridico("Alejandra","54321","3116674102",  "PRIVADA");
		ClienteJuridico cliente2 = new ClienteJuridico ("Kevin","19876","3217122375",  "PRIVADA");
		ClienteJuridico cliente3 = new ClienteJuridico("Jose", "10764", "3117424269","PRIVADA");
		ClienteJuridico cliente4 = new ClienteJuridico("Carolina","01973", "3118770823", "PRIVADA");
		ClienteJuridico cliente5 = new ClienteJuridico ("Mariana", "77898", "1234567890","PRIVADA");
		//los añado a la lista clientes
		listaClientes.add(cliente1); 
		listaClientes.add(cliente2);
		listaClientes.add(cliente3); 
		listaClientes.add(cliente4); 
		listaClientes.add(cliente5);
	}


	//------------GETTERS AND SETTERS---------------
	/**
	 * @return the listaClientes
	 */
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}


	/**
	 * @param listaClientes the listaClientes to set
	 */
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	/**
	 * @return the listaFacturas
	 */
	public ArrayList<Factura> getListaFacturas() {
		return listaFacturas;
	}


	/**
	 * @param listaFacturas the listaFacturas to set
	 */
	public void setListaFacturas(ArrayList<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
