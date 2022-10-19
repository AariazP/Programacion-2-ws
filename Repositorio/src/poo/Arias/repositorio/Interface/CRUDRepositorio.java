package poo.Arias.repositorio.Interface;

import java.util.ArrayList;

import poo.Arias.Exceptions.CRUDExceptions;


public interface CRUDRepositorio<T> extends OrdenableRepositorio<T>, 
		PaginableRepositorio<T>{
	
	/**
	 * M�TODO QUE DEVUELVE UNA LISTA DE PRODUCTOS DE TIPO T
	 * @return
	 */
	ArrayList<T> listar() throws CRUDExceptions; 
	
	
	/**
	 * M�TODO QUE PERMITE BUSCAR UN PRODUCTO DADO SU ID
	 * @param id
	 * @return
	 */
	T buscarId(Integer id) throws CRUDExceptions; 
	
	/**
	 * M�TODO QUE PERMITE CREAR UN PRODUCTO DE TIPO T
	 * @param obj
	 */
	void crear(T obj) throws CRUDExceptions; 
	
	/**
	 * M�TODO QUE PERMITE CREAR UN PRODUCTO DE TIPO T
	 * @param obj
	 */
	void actualizar(T obj)  throws CRUDExceptions; 
	/**
	 * M�TODO QUE PERMITE ELIMINAR UN PRODUCTO DE TIPO T
	 * @param obj
	 */
	void Eliminar(T obj)  throws CRUDExceptions; 
}
