package application;

import javafx.event.ActionEvent;

public class ControllerFrame1 {
	
	private Main main;

	/**
	 * @return the main
	 */
	public Main getMain() {
		return main;
	}

	/**
	 * @param main the main to set
	 */
	public void setMain(Main main) {
		this.main = main;
	} 
	
	
	public void cambiarFrame(ActionEvent e) {
		int contador = 0; 
		
		while(true) {
			main.abrirFrame("/application/Frame2.fxml"); 
		}
		
		
	}
	
}
