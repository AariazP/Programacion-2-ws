package clases;

public class Producto {
	 private String codigo = "ppp", nombre; 
	 private int cntFact, unidades;
	 private static int vlrEstatico = 1; 
	 private double valorProducto; 
	 private int numProd = -1; 

	 /**
	 * @param codigo
	 * @param nombre
	 * @param cntFact
	 */
	public Producto( String nombre, int unidades, double valorProducto) {
		this.codigo = codigo+vlrEstatico;
		this.nombre = nombre;
		vlrEstatico ++;
		this.unidades = unidades;
		this.valorProducto = valorProducto;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", \nnombre=" + nombre + ", \ncntFact=" + cntFact + ", \nunidades=" + unidades
				+ ", \nvalorProducto=" + valorProducto + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCntFact() {
		return cntFact;
	}

	public void setCntFact() {
		this.cntFact ++;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getValorProducto() {
		return valorProducto;
	}

	public void setValorProducto(double valorProducto) {
		this.valorProducto = valorProducto;
	}

	public int getNumProd() {
		return numProd;
	}

	public void setNumProd(int numProd) {
		this.numProd = numProd;
	}
	public void restarUnidades(int unidadesMenos) {
		unidades-=unidadesMenos; 
	}
}
