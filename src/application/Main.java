package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			FXMLLoader loader = new FXMLLoader();
//			Parent root = loader.load(new FileInputStream("src/application/HomeWindow.fxml"));
//			
//			BudgetController controller = (BudgetController)loader.getController();
//			controller.mainStage = primaryStage;
//			
//			Scene scene = new Scene(root,650,450);
//
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("Budgeting Application");
//			primaryStage.show();
			
			Parent root = FXMLLoader.load(getClass().getResource("HomeWindow.fxml"));
			Scene scene = new Scene(root,650, 450);
			primaryStage.setScene(scene);
			primaryStage.show();

			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
