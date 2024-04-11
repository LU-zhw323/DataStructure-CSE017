//Zhenyu Wu, CSE 017
public class CheckAccount extends BankAccount{
	//Constructor
	public CheckAccount(int n, String o, double b) {
		super(n, o, b);
	}
	public CheckAccount(String o, double b) {
		super(o, b);
	}
	public boolean pass(String filter) {
		if(filter.equals("Checking")) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		String str = String.format("%-10s\t%-75s\t", "Checking", super.toString());
		return str;
	}
	
}
