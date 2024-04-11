//Zhenyu WU, CSE 017
public abstract class BankAccount implements Comparable<BankAccount>, Filter {
	//Variable
	private int number;
	private String owner;
	protected double balance;
	
	//Constructor
	protected  BankAccount(int n , String o, double b) {
		number = n;
		owner = o;
		balance = b;
	}
	protected BankAccount( String o, double b) {
		owner = o;
		balance = b;
		number = (int) ((Math.random()*9 + 1) *100000);
	}
	
	//Method
	public String getOwner() {
		return owner;
	}
	public int getNumber() {
		return number;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		balance += amount;
	}
	public boolean withdraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			return true;
		}
		else {
			return false;
		}
	}
	public int compareTo(BankAccount ba) {
		if(getBalance() == ba.getBalance()) {
			return 0;
		}
		else if(getBalance() < ba.getBalance()) {
			return -1;
		}
		else {
			return 1;
		}
	}
	public abstract boolean pass(String filter);
	
	public boolean equals(Object o) {
		if(getNumber() == ((BankAccount) o).getNumber()) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		String str = String.format("%-10d\t%-40s\t%-20.2f\t", number , owner, balance);
		return str;
	}
}
