package programacion2.parcial3.model;

public interface IEmpresa {
	
	//métodos que debe implementar la empresa
	public Cliente buscarCliente(String identificacion);
	//método que debe implemetar la empresa
	public String registrarFactura(Factura factura); 
}
