package pk;

import javax.swing.JOptionPane;

public class ClaseInternaExample {
	
	enum Color{
		azul("b"), rojo("r"), verde("g");
		private String letra;
		private Color(String letra) {
			this.setLetra(letra);
		}
		public String getLetra() {
			return letra;
		}
		public void setLetra(String letra) {
			this.letra = letra;
		}
	}
	
	public static void main(String[] args) {
		String colores = JOptionPane.showInputDialog("Ingrese un color: ");
		Color colorElegido = Enum.valueOf(Color.class, colores);
		System.out.println("El color elegido: "+colorElegido);
		System.out.println("Abreviado    "+colorElegido.getLetra());
	}
}
