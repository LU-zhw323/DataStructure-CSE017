//Zhenyu Wu, CSE 017
import java.util.InputMismatchException;

public class InvalidAccountNumber extends InputMismatchException{
	
	//Constructor
	public InvalidAccountNumber() {
		System.out.println("Invalid account number");
	}
	public InvalidAccountNumber(String message) {
		super(message);
	}
}
