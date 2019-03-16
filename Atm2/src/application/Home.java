package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import application.Atm;

public class Home {
 Stage stage ;
 Scene scene ;
 Main layout ;
 Atm atm = new Atm ();
 int counter=atm.counter;
 Transaction history = new Transaction() ;
 int i=atm.i ;
  public Home (Stage stage) {
	 this.stage=stage ;
 }

 /**
 * 
 */
public void prepareScene() {
	 Label welcome = new Label("Welcome Sara ^_^ !");
	 Button logOut =new Button("LogOut");
	 Button deposit =new Button("Deposit");
	 Button withdraw =new Button("Withdraw");
	 Button getBalance =new Button("Blance Inquiry");
	 Button previous =new Button("Previous Transaction");
	 Button next =new Button("Next Transaction");
	 TextField numberField = new TextField(null);
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
	 TextField output = new TextField();
	 Button clear =new Button("Clear");
	 
		GridPane grid = new GridPane();
		grid.add(numberField, 26, 6);
		grid.add(welcome,18, 2);
		grid.add(logOut,0, 0);
		grid.add(deposit,0, 4);
		grid.add(withdraw,0, 6);
		grid.add(getBalance,0, 8);
		grid.add(previous,0, 10);
		grid.add(next,0, 12);
		grid.add(num1,20, 4);
		grid.add(num2,22, 4);
		grid.add(num3,24,4);
		grid.add(num4,20, 6);
		grid.add(num5,22, 6);
		grid.add(num6,24,6);
		grid.add(num7,20, 8);
		grid.add(num8,22, 8);
		grid.add(num9,24, 8);
		grid.add(num0,22, 10);
		grid.add(output,26, 8);
		grid.add(clear,26, 4);
		
		num0.setOnAction(event -> {
		    numberField.appendText("0");
		});
		
		num1.setOnAction(event -> {
			numberField.appendText("1");
			});
		
		num2.setOnAction(event -> {
			numberField.appendText("2");
			});
		
		num3.setOnAction(event -> {
			numberField.appendText("3");
			});
		
		num4.setOnAction(event -> {
			numberField.appendText("4");
			});
		
		num5.setOnAction(event -> {
			numberField.appendText("5");
			});
		
		num6.setOnAction(event -> {
			numberField.appendText("6");
			});
		
		num7.setOnAction(event -> {
			numberField.appendText("7");
			});
		
		num8.setOnAction(event -> {
			numberField.appendText("8");
			});
		
		num9.setOnAction(event -> {
			numberField.appendText("9");
			});
		
		logOut.setOnAction(event -> {
			output.setText(null);
			stage.setScene(layout.getScene());
			});
		
		clear.setOnAction(event -> {
		    numberField.setText(null);
		    output.setText(null);});
		
        deposit.setOnAction(Event ->{
        	if (numberField.getText()==null) {
        		output.setText("No amount is set !");
        	}
        	else {
       int amount = Integer.parseInt(numberField.getText());
        atm.deposit(amount);
        output.setText("Deposit :"+amount);
        numberField.setText(null);
        	}});
        
        withdraw.setOnAction(Event ->{
        	if (numberField.getText()==null) {
        		
        		output.setText("No amount is set !");
        	}
        	else {
       int amount = Integer.parseInt(numberField.getText());
        int i =atm.withdraw(amount);
        if (i==0)
        	output.setText("Error! Your Card is empty !");
        else if (i==-1)
        	output.setText("Error! Not enough balance");
        else 
        output.setText("Withdraw :"+amount);
        numberField.setText(null);
        	}});
        
		getBalance.setOnAction(event -> {
			atm.getBalance();
			output.setText("Balance Inquiry :"+atm.balance);
		});
		previous.setOnAction(event -> {
			if(counter<0) {
				output.setText("No history to show");
				}
			else {
			    history = atm.getPrevious();
				output.setText(history.type+ " "+history.amount);
			}
		});
		next.setOnAction(event -> {
			if(0<counter&&counter<4) {
			    history = atm.getNext();
				output.setText(history.type+ " "+history.amount);
			}	else 
			    output.setText("No history to show");
			
			});
     scene = new Scene(grid,600,400);
 }
	public Scene getScene() {
		return this.scene ;
	}
	public void setMain(Main layout) {
		this.layout=layout ;
	}
}
