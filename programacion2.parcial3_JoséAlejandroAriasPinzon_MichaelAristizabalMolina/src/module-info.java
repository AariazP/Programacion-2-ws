module programacion2.parcial3 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.desktop;
	requires transitive javafx.base;
	
	
	exports programacion2.parcial3.controller to javafx.fxml; 
	opens programacion2.parcial3.model to javafx.base;
	opens programacion2.parcial3.controller to javafx.fxml;
	opens programacion2.parcial3.application to javafx.graphics, javafx.fxml;
}
