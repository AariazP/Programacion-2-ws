package poo.Arias.repositorio.Interface;

import java.util.List;

import poo.Arias.Exceptions.CRUDExceptions;


public interface PaginableRepositorio<T> {
	
	List<T> listar(int min, int max)  throws CRUDExceptions; 
}
