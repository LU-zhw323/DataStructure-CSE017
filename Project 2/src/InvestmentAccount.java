//Zhenyu Wu, CSE 017
public class InvestmentAccount extends BankAccount{
	
	//Variable
	private String type;
	
	//Constructor
	public InvestmentAccount(int n, String o, double b, String t) {
		super(n, o, b);
		type = t;
	}
	public InvestmentAccount(String o, double b, String t) {
		super(o,b);
		type = t;
	}
	
	//method
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double applyRisk() {
		double risk = Math.random();
		double rate = Math.random();
		if(risk > 0.5) {
			double profitLoss = balance * rate / 100;
			return balance + profitLoss;
		}
		else {
			double profitLoss = - (balance * rate/100);
			return balance + profitLoss;
		}
	}
	public boolean pass(String filter) {
		if(filter.equals("Investment")) {
			return true;
		}
		else{
			return false;
		}
	}
	public String toString() {
		String str = String.format("%-10s\t%-75s\t%-10s\t","Investment", super.toString(), type);
		return str;
	}
	
	
}
