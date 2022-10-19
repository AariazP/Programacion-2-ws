package poo.Arias.repositorio.modelo;

import java.util.ArrayList;
import java.util.List;
import poo.Arias.repositorio.Interface.CRUDRepositorio;
import poo.Arias.repositorio.Interface.TipoOrden;

public class IProducto implements CRUDRepositorio<Producto> {

	private ArrayList<Producto> dataSource; 

	private IProducto() {
		dataSource = new ArrayList<>(); 
	}

	@Override
	public ArrayList<Producto> listar(String atributo, TipoOrden orden) {
		ArrayList<Producto> dataSource = clonarDataSource();  
		//ORDENO UN NUEVO ARREGLO
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

	private int definirOrden(String atributo, Producto o2, Producto o1) {
		switch(atributo) {
		case "id":
			return o1.getId().compareTo(o2.getId());
		case "nombre":
			return o1.getNombre().compareTo(o2.getNombre());
		case "precio":
			return o1.getPrecio().compareTo(o2.getPrecio());
		}
		return 0;
	}

	private ArrayList<Producto> clonarDataSource() {
		ArrayList<Producto> array  = new ArrayList<>(); 
		
		for (Producto producto : dataSource) {
			array.add(producto);
		}
		
		return array;
	}

	@Override
	public List<Producto> listar(int min, int max) {
		return dataSource.subList(min, max);
	}

	@Override
	public ArrayList<Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void crear(Producto obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(Producto obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Eliminar(Producto obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Producto buscarId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
