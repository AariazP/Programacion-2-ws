package programacion2.parcial3.application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import programacion2.parcial3.controller.ControllerFrame1;
import programacion2.parcial3.model.EmpresaEDEQ;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	//variable empresa que crea el main
	private static EmpresaEDEQ empresa; 
	@Override
	public void start(Stage primaryStage) {
		try {
			//cargo el frame
			setEmpresa(new EmpresaEDEQ("EDEQ"));
			ControllerFrame1.setEmpresa(empresa);
			Parent root = FXMLLoader.load(getClass().getResource("/programacion2/parcial3/view/Frame1.fxml"));
            Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("EDEQ");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//corro la app
	public static void main(String[] args) {
		launch(args);
	}
	
	//getters y setter de la empresa
	public static EmpresaEDEQ getEmpresa() {
		return empresa;
	}

	public static void setEmpresa(EmpresaEDEQ empresa) {
		Main.empresa = empresa;
	}

	
}
