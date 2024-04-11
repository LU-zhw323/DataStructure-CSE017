//Zhenyu Wu, CSE 017
public class SavingsAccount extends BankAccount{
	//Variable
	private double yearlyInterest;
	
	//Constructor
	public SavingsAccount(int n, String o, double b, double yi) {
		super(n, o, b);
		yearlyInterest = yi;
	}
	public SavingsAccount(String o, double b, double yi) {
		super(o, b);
		yearlyInterest = yi;
	}
	
	//method
	public double getYearlyInterest() {
		return yearlyInterest;
	}
	public void setYearlyInterest(double yearlyInterest) {
		this.yearlyInterest = yearlyInterest;
	}
	public double applyMonthlyInterest() {
		return balance + (balance * yearlyInterest/12)/100;
	}
	public boolean pass(String filter) {
		if(filter.equals("Savings")) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		String str = String.format("%-10s\t%-75s\t%-4.2f%-1s\t", "Savings", super.toString(), yearlyInterest, "%");
		return str;
	}
	
	
}
