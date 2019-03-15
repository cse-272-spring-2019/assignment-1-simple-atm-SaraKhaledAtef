package application;
import application.Transaction;
public class Atm {
public int num;
public int balance=0 ;
Transaction[] history=new Transaction[5];
Transaction[] empty =new Transaction[5];
public int counter=0;
public int i=0 ; 
  Atm(){
	  num=118;
  }
  public void deposit(int amount) {
	  balance=balance+amount;
	  checkArray(counter);
	  Transaction obj =new Transaction("deposit",amount);
	  history[counter]=obj ;
	  counter ++;
	  i=counter;

  }
  public int withdraw (int amount) {
	  if(balance==0)
		  return 0;
	  else if(amount>balance)
		  return -1 ;
	  else { 
		  balance=balance-amount;
		  checkArray(counter);
		  Transaction obj =new Transaction("Withdraw",amount);
		  history[counter]=obj ;
		  counter ++;
		  i=counter ;
		  return 1;
  } 
  }
  public void getBalance() {
	  checkArray(counter);
	  Transaction obj =new Transaction("Balance Check",balance);
	  history[counter]=obj ;
	  counter ++;
	  i=counter;

  }
  public void checkArray(int counter) {
	  if (counter >4) {
		  for(int i=0 ; i<4 ; i++)
			  history[i]=history[i+1];
           this.counter=4;
           i=this.counter ;
	  }
} 
  public Transaction getPrevious() {
	  if(i>=1) 
		  i--;
	  return history[i];
		  
	  }
  public Transaction getNext() {
	  if(i<=3) 
		  i++;  
	  return history[i];
	  }
}