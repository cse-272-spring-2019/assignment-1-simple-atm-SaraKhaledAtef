package application;
import application.Atm;
public class Validation {
public boolean validate(String num) {
	int number= Integer.parseInt(num);
	Atm check = new Atm();
	if (number==check.num)
		return true ;
	else 
		return false;
}
	  
}
