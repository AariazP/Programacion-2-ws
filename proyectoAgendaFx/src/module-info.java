module proyectoAgendaFx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.desktop;
	requires transitive javafx.base;
	
	opens co.edu.uniquindio.Application to javafx.graphics, javafx.fxml;
	
	exports co.edu.uniquindio.Controller to javafx.fxml;
    opens co.edu.uniquindio.Controller to javafx.fxml;
    
}
