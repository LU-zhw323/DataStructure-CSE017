import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//Zhenyu Wu, CSE 017
public class Bank {
	//Variable
	private String name;
	private String branch;
	private BankAccount[]bankAccounts;
	public double monthlyFee ;
	private int count;
	
	
	
	
	//Constructor
	public Bank(String name , String branch) {
		this.name = name;
		this.branch = branch;
		bankAccounts = new BankAccount [10];
		count = 0;
		monthlyFee = 20.0;
	}
	public Bank(String n, String b, int capacity, String filename) {
		name = n;
		branch = b;
		bankAccounts = new BankAccount[capacity];
		count = 0;
		//to avoid NullPointerException , I still initialize the count and use count for further operation
		monthlyFee = 20.0;
		readFile(filename);
	}
	
	//method
	private void readFile(String filename) {
		File file = new File(filename);
		try {
			Scanner fileReader = new Scanner(file);
			if(!file.exists()) {
				throw new FileNotFoundException("File not found");
			}//to determine whether the file is found
			else {
				for(int i = 0 ; i < bankAccounts.length ; i++) {
					String account = fileReader.nextLine();
					int space1 = account.indexOf(" ");
					String accountType = account.substring(0, space1);
					//case for account is investment
					if(accountType.equals("Investment")) {
						int space2 = account.indexOf(" ", space1+1);
						String accountOwner = account.substring(space1+1 , space2);
						int space3 = account.indexOf(" ", space2+1);
						int accountNumber = Integer.parseInt(account.substring(space2+1, space3));
						int space4 = account.indexOf(" ", space3+1);
						double accountBalance = Double.parseDouble(account.substring(space3+1, space4));
						String investmentType = account.substring(space4+1, account.length());
						InvestmentAccount IA = new InvestmentAccount(accountNumber, accountOwner, accountBalance, investmentType);
						bankAccounts[i] = IA;
						count ++;
					}
					//case for account is Saving
					else if(accountType.equals("Savings")) {
						int space2 = account.indexOf(" ", space1+1);
						String accountOwner = account.substring(space1+1 , space2);
						int space3 = account.indexOf(" ", space2+1);
						int accountNumber = Integer.parseInt(account.substring(space2+1, space3));
						int space4 = account.indexOf(" ", space3+1);
						double accountBalance = Double.parseDouble(account.substring(space3+1, space4));
						double interestRate = Double.parseDouble(account.substring(space4+1, account.length()));
						SavingsAccount SA = new SavingsAccount(accountNumber, accountOwner, accountBalance, interestRate);
						bankAccounts[i] = SA;
						count ++;
					}
					//case for account is Checking
					else {
						int space2 = account.indexOf(" ", space1+1);
						String accountOwner = account.substring(space1+1 , space2);
						int space3 = account.indexOf(" ", space2+1);
						int accountNumber = Integer.parseInt(account.substring(space2+1, space3));
						double accountBalance = Double.parseDouble(account.substring(space3+1, account.length()));
						CheckAccount CA = new CheckAccount(accountNumber, accountOwner, accountBalance);
						bankAccounts[i] = CA;
						count++;
					}
				}
			}
			fileReader.close();
		}
		catch(FileNotFoundException f){
			System.out.println(f.getMessage());
		}
	}
	public void saveFile(String filename) {
		File file = new File(filename);
		try {
			PrintWriter fileWriter = new PrintWriter(filename);
			if(!file.exists()) {
				throw new FileNotFoundException("File not found");
			}//to determine whether the file is found
			else {
				for(int i = 0; i < count; i++) {
					//case for Investment
					if(bankAccounts[i] instanceof InvestmentAccount) {
						fileWriter.println("Investment" + "\t" + bankAccounts[i].getOwner() + "\t" + bankAccounts[i].getNumber() + "\t" + bankAccounts[i].getBalance() + "\t" + ((InvestmentAccount) bankAccounts[i]).getType());
					}
					//case for Saving
					else if(bankAccounts[i] instanceof SavingsAccount) {
						fileWriter.println("Savings" + "\t" + bankAccounts[i].getOwner() + "\t" + bankAccounts[i].getNumber() + "\t" + bankAccounts[i].getBalance() + "\t" + ((SavingsAccount) bankAccounts[i]).getYearlyInterest());
					}
					//case for check
					else {
						fileWriter.println("Checking" + "\t" + bankAccounts[i].getOwner() + "\t" + bankAccounts[i].getNumber() + "\t" + bankAccounts[i].getBalance());
					}
				}
			}
			fileWriter.close();
		}
		catch(FileNotFoundException f) {
			System.out.println(f.getMessage());
		}
	}
	public BankAccount getAccount(int number) {
		int index = -1;
		for(int i = 0; i < count ; i++) {
			if(number == bankAccounts[i].getNumber()) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			return null;
		}
		else {
			return bankAccounts[index];
		}
	}
	public  void applyMonthlyFee() {
		for(int i = 0; i < count ; i++) {
			bankAccounts[i].withdraw(monthlyFee);
		}
	}
	public void viewAllAccounts() {
		System.out.println("Bank name: " + name + "\t" + "Bank Branch: " + branch);
		System.out.printf("%-10s\t%-10s\t%-40s\t%-20s\t%-10s\n","Tyep", "Account Number", "Owner", "Balance", "Interest/Investment type");
		for(int i = 0; i < count ; i++) {
			System.out.println(bankAccounts[i].toString());
		}
	}
	public BankAccount[] filterAccounts(String filter) {
		int size = 0;
		for(int i = 0; i < count ; i++) {
			boolean result = bankAccounts[i].pass(filter);
			if(result == true) {
				size++;
			}
		}
		BankAccount [] filterList = new BankAccount[size];
		int counts = 0;
		for(int i = 0 ; i < count; i++) {
			boolean result = bankAccounts[i].pass(filter);
			if(result == true) {
				filterList[counts] = bankAccounts[i];
				counts ++;
			}
		}
		return filterList;
	}
	public void sortAccounts() {
		java.util.Arrays.sort(bankAccounts);
	}
	
	
	
}
