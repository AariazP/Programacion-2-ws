package programacion2.parcial3.model;

public interface IEmpresa {
	
	//m�todos que debe implementar la empresa
	public Cliente buscarCliente(String identificacion);
	//m�todo que debe implemetar la empresa
	public String registrarFactura(Factura factura); 
}
