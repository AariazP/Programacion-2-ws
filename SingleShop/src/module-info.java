module SingleShop {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.base;
	requires transitive javafx.graphics;
	requires java.desktop;
	
	opens co.edu.uniquindio.application to javafx.graphics, javafx.fxml;
	opens co.edu.uniquindio.controller to javafx.fxml;
	opens co.edu.uniquindio.model to javafx.base;
	exports  co.edu.uniquindio.controller to javafx.fxml;
	
}
