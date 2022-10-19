package clases;

public class Factura {
	
	private Producto producto1, producto2, producto3;
	private int cantidadP1, cantidadP2, cantidadP3; 
	private Empleado empleado; 
	private static int contador; 
	private String codigo="fff";
	private double total; 
	private Estudiante estudiante; 
	
	
	@Override
	public String toString() {
		String mensaje =""; 
		
		if(producto1 != null) {
			mensaje += "Se vendió: " +producto1.getNombre()+"\n"; 
			mensaje +=""+cantidadP1+" Unidades\n";
			mensaje +=" Queda un total de "+producto1.getUnidades()+" Unidades"; 
		}if(producto2 != null) {
			mensaje += "Se vendió: " +producto2.getNombre()+"\n"; 
			mensaje +=+cantidadP2+" Unidades\n";
			mensaje +=" Queda un total de "+producto2.getUnidades()+" Unidades"; 
		}if(producto3 != null) {
			mensaje += "Se vendió: " +producto3.getNombre()+"\n"; 
			mensaje +=+cantidadP3+" Unidades'n";
			mensaje +=" Queda un total de "+producto3.getUnidades()+" Unidades"; 
		}
		mensaje+="Fue vendida por "+empleado.getNombre()+"\n"; 
		mensaje += "Ha hecho un total de "+empleado.getCantFacturas()+" facturas\n"; 
		mensaje += "El código de la factura es: "+codigo+"\n";
		mensaje += "El total de la factura: "+total; 
		return mensaje;
	}


	public Factura(Empleado empleado) {
		this.empleado = empleado; 
		contador++; 
		this.codigo += contador;  
	}
	public Producto getProducto3() {
		return producto3;
	}

	public void setProducto3(Producto producto3) {
		this.producto3 = producto3;
	}

	public Producto getProducto2() {
		return producto2;
	}

	public void setProducto2(Producto producto2) {
		this.producto2 = producto2;
	}

	public Producto getProducto1() {
		return producto1;
	}

	public void setProducto1(Producto producto1) {
		this.producto1 = producto1;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total += total;
	}


	public Estudiante getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
}
