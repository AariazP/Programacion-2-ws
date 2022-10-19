package poo.Arias.repositorio.modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import poo.Arias.Exceptions.CRUDExceptions;
import poo.Arias.repositorio.Interface.CRUDRepositorio;
import poo.Arias.repositorio.Interface.TipoOrden;

public class ICliente implements CRUDRepositorio<Cliente> {

	private ArrayList<Cliente> dataSource; 


	public ICliente() {
		dataSource = new ArrayList<>(); 
	}


	/**
	 * @return the dataSource
	 */
	public ArrayList<Cliente> getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(ArrayList<Cliente> dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Cliente> listar(String atributo, TipoOrden orden) {

		ArrayList<Cliente> dataSource = clonarDataSource();  

		dataSource.sort((o1,  o2) ->{
			int resultado = 0; 

			if(orden.equals(TipoOrden.Ascendente)) {

				resultado = definirOrden(atributo, o1, o2); 

			}else {
				resultado = definirOrden(atributo, o2, o1);
			}

			return resultado;
		});

		return dataSource;
	}

	protected int definirOrden(String atributo, Cliente o1, Cliente o2) {
		switch(atributo) {
		case "id":
			return o1.getId().compareTo(o2.getId());
		case "nombre":
			return o1.getNombre().compareTo(o2.getNombre());
		case "apellido":
			return o1.getApellido().compareTo(o2.getApellido());
		}
		return 0;
	}


	private ArrayList<Cliente> clonarDataSource() {
		ArrayList<Cliente> dataSource = new ArrayList<>(); 

		for(Cliente i: this.dataSource) {
			dataSource.add(i); 
		}

		return dataSource;
	}




	@Override
	public ArrayList<Cliente> listar() {
		return dataSource;
	}

	@Override
	public Cliente buscarId(Integer id) {

		Cliente cliente = null;
		for (Cliente i: dataSource) {
			Cliente clienteAux= i; 
			if(clienteAux.compararId(id)) return clienteAux;
		}

		return cliente; 
	}

	@Override
	public void crear(Cliente cliente) {
		dataSource.add(cliente); 
	}

	@Override
	public void actualizar(Cliente cliente) {
		buscarId(cliente.getId()).setAtributos(cliente);
	}

	@Override
	public void Eliminar(Cliente cliente) {
		dataSource.remove(cliente); 
	}


	public void ordenar() {
		dataSource.sort(Comparator.comparing(Cliente::getId).reversed());
	}


	@Override
	public List<Cliente> listar(int min, int max) throws CRUDExceptions {
		return dataSource.subList(min, max);
	}
}
