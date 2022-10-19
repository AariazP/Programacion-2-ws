module Física {
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires transitive javafx.base;
	
	
	opens co.edu.uniquindio.application to javafx.graphics, javafx.fxml;
	opens co.edu.uniquindio.controller to javafx.fxml;
	exports co.edu.uniquindio.controller to javafx.fxml;
}
