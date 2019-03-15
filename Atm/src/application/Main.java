package application;
	
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Main  {
	Stage stage ;
	Scene scene ;
	Home home ;
	Message message ;
	 public Main (Stage stage) {
		 this.stage=stage ;
	 }
	public void prepareScene() {
		Label cardnumberLabel = new Label("Please enter your Card Number : ");
		TextField cardnumberField = new TextField(null);
		Validation validation = new Validation();
		Button enter =new Button("Enter");
		Button num0 =new Button("0");
		Button num1 =new Button("1");
		Button num2 =new Button("2");
		Button num3 =new Button("3");
		Button num4 =new Button("4");
		Button num5 =new Button("5");
		Button num6 =new Button("6");
		Button num7 =new Button("7");
		Button num8 =new Button("8");
		Button num9 =new Button("9");
		Button clear =new Button("Clear");
		Label error = new Label();
		
		GridPane grid = new GridPane();
		grid.add(cardnumberLabel,0, 0);
		grid.add(cardnumberField,0,5);
		grid.add(num1,1, 2);
		grid.add(num2,2, 2);
		grid.add(num3,3, 2);
		grid.add(num4,1, 3);
		grid.add(num5,2, 3);
		grid.add(num6,3,3);
		grid.add(num7,1, 4);
		grid.add(num8,2, 4);
		grid.add(num9,3, 4);
		grid.add(num0,2, 5);
		grid.add(enter,3,5);
		grid.add(clear,4,2);
		grid.add(error,0,6);
		
		num0.setOnAction(event -> {
	    cardnumberField.appendText("0");
		});
		num1.setOnAction(event -> {
		    cardnumberField.appendText("1");
			});
		num2.setOnAction(event -> {
		    cardnumberField.appendText("2");
			});
		num3.setOnAction(event -> {
		    cardnumberField.appendText("3");
			});
		num4.setOnAction(event -> {
		    cardnumberField.appendText("4");
			});
		num5.setOnAction(event -> {
		    cardnumberField.appendText("5");
			});
		num6.setOnAction(event -> {
		    cardnumberField.appendText("6");
			});
		num7.setOnAction(event -> {
		    cardnumberField.appendText("7");
			});
		num8.setOnAction(event -> {
		    cardnumberField.appendText("8");
			});
		num9.setOnAction(event -> {
		    cardnumberField.appendText("9");
			});
		enter.setOnAction(event -> {
        	if (cardnumberField.getText()==null) {
        	error.setText("You haven't enterd the number yet! ");
        	}
        	else {
		    String number =cardnumberField.getText();
		    boolean valid=validation.validate(number);
		    if(!valid)
		    	stage.setScene(message.getScene());
		    else {
		    	stage.setScene(home.getScene());
		    }
		    cardnumberField.setText(null);
		    error.setText(null);}});
		
		clear.setOnAction(event -> {
		    cardnumberField.setText(null);});
		
		scene = new Scene(grid,400,200);
	} 
	
	public Scene getScene() {
		return this.scene ;
	}
	
	public void setHome(Home home) {
		this.home=home ;
	}
	
	public void setMessage(Message message) {
		this.message=message ;
	}
}
