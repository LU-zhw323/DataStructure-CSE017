//Zhenyu Wu, CSE 017
import java.util.Scanner;
public class Test {

	public static void main(String[] args) {
		//Create instance
		Bank myBank = new Bank("LEHIGH UNIVERSITY BANK", "BETHLEHEM", 500, "accounts.txt");
		Scanner input = new Scanner(System.in);
		
		//Start operation
		int operation = 0;
		do {
			operation = getOperation(input);
			input.nextLine();
			switch(operation) {
				case 1:
					try {
						System.out.println("Enter the number of account:");
						int num = input.nextInt();
						input.nextLine();
						if(99999 > num || num > 999999) {
							throw new InvalidAccountNumber("Invalid Account Number");
						}
						else {
							BankAccount target = myBank.getAccount(num);
							if(target == null) {
								System.out.println("Account not found");
							}
							else {
								System.out.println(target.getOwner() + "\t" + target.getNumber() + "\t" + target.getBalance() +" has been found");
								int management = 0;
								do {
									management = getManagement(input);
									input.nextLine();
									switch(management) {
										case 1:
											System.out.println("Balance: " + target.getBalance());
											break;
										case 2:
											System.out.println("Enter amount to deposit:");
											double deposit = input.nextInt();
											input.nextLine();
											target.deposit(deposit);
											System.out.println("New balance: " + target.getBalance());
											break;
										case 3:
											System.out.println("Enter amount to withdraw:");
											double withdraw = input.nextInt();
											input.nextLine();
											boolean result = target.withdraw(withdraw);
											if(result == true) {
												System.out.println("Withdraw successfully");
												System.out.println("New balance: " + target.getBalance());
											}
											else {
												System.out.println("Do not have enough money to withdraw");
											}
											break;
										case 4:
											if(target instanceof SavingsAccount) {
												System.out.println("New balance: " + ((SavingsAccount) target).applyMonthlyInterest());
											}
											else {
												System.out.println("Account is not a Savings Account");
											}
											break;
										case 5:
											if(target instanceof InvestmentAccount) {
												double initialBalance = target.getBalance();
												double newBalance = ((InvestmentAccount) target).applyRisk();
												if(newBalance > initialBalance) {
													System.out.println("Profit, new balance: " + newBalance);
												}
												else {
													System.out.println("Loss, new balance: " + newBalance);
												}
											}
											else {
												System.out.println("Account is not an Investment Account");
											}
										case 6:
											break;	
									}
								}while(management != 6);
							}	
						}
					}
					
					catch(InvalidAccountNumber a) {
						System.out.println(a.getMessage());
					}
					break;
				
				case 2:
					myBank.viewAllAccounts();
					break;
				case 3:
					myBank.applyMonthlyFee();
					break;
				case 4:
					myBank.sortAccounts();
					break;
				case 5:
					System.out.println("Enter the type of account(Checking, Saving, or Investment");
					String filter = input.nextLine();
					BankAccount[]filterList = myBank.filterAccounts(filter);
					System.out.println("Number of accounts: " + filterList.length);
					System.out.println("Do you want to display the list of filtered accounts? (yes/no):");
					String decision = input.nextLine();
					if(decision.equals("yes")) {
						for(int i = 0; i < filterList.length; i++) {
							System.out.println(filterList[i].toString());
						}
					}
					break;
				case 6:
					myBank.saveFile("accounts.txt");
					break;
			}
			
			
		}while(operation!=6);
		

	}
	public static int getOperation(Scanner input) {
		int op = 0;
		do {
			System.out.println("\nSelect an operation: ");
			System.out.println(" 1: Manage Existing Account");
			System.out.println(" 2: View All Account");
			System.out.println(" 3: Apply Monthly Fee");
			System.out.println(" 4: Sort Account");
			System.out.println(" 5: Filter Account");
			System.out.println(" 6: Exit");
			if (input.hasNextInt()) {
				op = input.nextInt();
				if (op >= 1 && op <= 6)
					break;
				else
					System.out.println("Invalid operation. Must be an integer from 1 to 6.");
			}
			else {
				input.nextLine();
				System.out.println("Invalid operation. Must be an integer.");
			}
		} while (true);
		return op;
	}//method to get operation
	
	
	public static int getManagement(Scanner input) {
		int op = 0;
		do {
			System.out.println("\nSelect an operation: ");
			System.out.println(" 1: View Balance");
			System.out.println(" 2: Deposit");
			System.out.println(" 3: Withdraw");
			System.out.println(" 4: View the monthly interest");
			System.out.println(" 5: View the current profit/loss");
			System.out.println(" 6: Exit");
			if (input.hasNextInt()) {
				op = input.nextInt();
				if (op >= 1 && op <= 6)
					break;
				else
					System.out.println("Invalid operation. Must be an integer from 1 to 6.");
			}
			else {
				input.nextLine();
				System.out.println("Invalid operation. Must be an integer.");
			}
		} while (true);
		return op;
	}//method to get operation
}
