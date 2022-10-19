package co.edu.uniquindio.model;

public enum TipoProducto {

	//-----TIPOS DE PRODUCTOS------
		TECNOLOGIA_MOVIL(0),TECNOLOGIA_COMPUTACIONAL(1), MUSICA(2),
		HOGAR(3), EMPRESARIAL(4);

		private int tipoProducto;
		
		//-------CONSTRUCTOR--------------------
		TipoProducto(int tipoProducto){
			this.tipoProducto = tipoProducto;
		}
		
		//---------GET----------------
		public int getTipoProucto() {
			return tipoProducto;
		}
}
