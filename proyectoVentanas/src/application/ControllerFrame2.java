package application;

import javafx.event.ActionEvent;

public class ControllerFrame2 {
	
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
		main.abrirFrame("/application/Frame1.fxml"); 
	}
	
	public void cambiarFrame() {
		main.abrirFrame("/application/Frame1.fxml"); 
	}
}
