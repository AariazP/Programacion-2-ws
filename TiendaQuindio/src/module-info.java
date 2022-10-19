module TiendaQuindio {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens co.edu.uniquindio.Application to javafx.graphics, javafx.fxml;
	opens co.edu.uniquindio.Controller to javafx.fxml;
	exports  co.edu.uniquindio.Controller to javafx.fxml;
}
