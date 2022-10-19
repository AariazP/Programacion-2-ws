package poo.Arias.repositorio.Interface;

import java.util.ArrayList;

import poo.Arias.Exceptions.CRUDExceptions;


public interface OrdenableRepositorio<T> {

	ArrayList<T> listar(String atributo, TipoOrden orden)  throws CRUDExceptions; 
}
