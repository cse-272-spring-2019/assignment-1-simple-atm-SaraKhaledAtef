package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Message {
	Stage stage ;
	Scene scene ;
	Main layout ;
	public Message (Stage stage) {
		 this.stage=stage ;
	 }
	public void prepareScene() {
		Label error = new Label("Error you have entered the wrong Card Number ! ");
		Button back =new Button("Back");
		GridPane grid = new GridPane();
		grid.add(back,0, 0);
		grid.add(error,0, 1);
		back.setOnAction(event -> {
			stage.setScene(layout.getScene());
			});
	     scene = new Scene(grid,400,100);
	}
	public Scene getScene() {
		return this.scene ;
	}
	public void setMain(Main layout) {
		this.layout=layout ;
	}
}
