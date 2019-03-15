package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class App extends Application {
		@Override
		public void start(Stage primaryStage) throws Exception {
			try {
				BorderPane root = new BorderPane();
				Scene scene = new Scene(root,600,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
			primaryStage.setTitle("Atm Login");
			Main layout =new Main(primaryStage) ;
			Home home =new Home(primaryStage);
			Message message = new Message(primaryStage);
			layout.prepareScene();
			home.prepareScene();
			message.prepareScene();
			layout.setHome(home);
			home.setMain(layout);
			message.setMain(layout);
			layout.setMessage(message);
			
			primaryStage.setScene(layout.getScene());
			primaryStage.show();
}

	public static void main(String[] args) {
		launch(args);
	}}