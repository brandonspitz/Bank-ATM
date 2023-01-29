import java.util.Scanner;
import java.text.DecimalFormat;

public class BankATM {
	public static void main(String[] args) {
		
		try (Scanner scan = new Scanner (System.in)) {
			DecimalFormat df2 = new DecimalFormat("#.00"); //Defines formatting for numbers when specified
			
			int choice = 1; // These declared integers are used for the menu system
			int choicedeposit = 1;
			int choicewithdraw = 1;
			int choicetransfer = 1;
			
			System.out.println("Welcome to Brandon's Bank"); //Prints welcome statement
			System.out.println("What is your name? "); //Asks for name and saves it as a string
			String fullname = scan.nextLine();
			System.out.println("Initial deposit into Savings: "); // Asks for initial savings deposit and savings it as a double
			double savings = scan.nextDouble();
			System.out.println("Initial deposit into Checking: "); // Asks for initial savings deposit and checking it as a double
			double checking = scan.nextDouble();
			
			double initialbalance = savings + checking; // Declares initial balance variable used for deciding account type
			double balance;
			
			if (initialbalance < 1000) { // This if-else/ else-if section uses boolean statements to determine account type with initial balance and then prints one of the statements below
				System.out.println(fullname + "'s Basic Account balance: $" + df2.format(initialbalance) + " (S: $" + df2.format(savings) + ", C: $" + df2.format(checking) + ")");
			} else if (initialbalance >= 1000 && initialbalance <= 5000) {
				System.out.println(fullname + "'s Premium Account balance: $" + df2.format(initialbalance) + " (S: $" + df2.format(savings) + ", C: $" + df2.format(checking) + ")");
			} else if (initialbalance > 5000) {
				System.out.println(fullname + "'s Platinum Account balance: $" + df2.format(initialbalance) + " (S: $" + df2.format(savings) + ", C: $" + df2.format(checking) + ")");
			} // These statements also print the total balance and balance of checking and savings accounts
			
				displayMenu(); //Prints menu that is defined at the end of this code
				choice = scan.nextInt(); // With use of switch statement, the user must choose an integer from 1-4
				
				switch (choice) { //Switch statement is used to control the flow of the menu
				case 1: depositMenu(); //If option 1 is selected, a new menu is prompted (This menu is also defined at the end of the code)
						choicedeposit = scan.nextInt();
						// This menu displays the deposit option where the user can choose from 3 options
						switch (choicedeposit) {
						case 1: System.out.println("Amount to deposit to Checking: "); // The user can deposit money into their checking with option 1
								double checkingDeposit = scan.nextDouble();
								checking = checking + checkingDeposit; // These statements update the variables with the new information
								balance = checking + savings; 
								System.out.println("You deposited $" + df2.format(checkingDeposit) + " to Checking."); // Prints a statement confirming the amount deposited
								System.out.println("After this transaction your balance is $" + df2.format(balance) + " (S: $" + df2.format(savings) + ", C: $" + df2.format(checking) + ")");
						break; // break statement ensures only case 1 is executed
						case 2: System.out.println("Amount to deposit to Savings: "); // Case 2 will do the same thing as case 1 if chosen except it deposits to savings instead of checking
								double savingsDeposit = scan.nextDouble();
								savings = savings + savingsDeposit;
								balance = checking + savings;
								System.out.println("You deposited $" + df2.format(savingsDeposit) + " to Savings.");
								System.out.println("After this transaction your balance is $" + df2.format(balance) + " (S: $" + df2.format(savings) + ", C: $" + df2.format(checking) + ")");
						break;
						case 3: System.out.println("Canceled");	// If case 3 is chosen, the program will be terminated
						} 
				break; // This break statement finishes the deposit menu option
				case 2: withdrawMenu(); // Case 2 will print the withdraw menu if that option is chosen
						choicewithdraw = scan.nextInt();
						// This menu is very similar to the deposit menu with its functions
						switch (choicewithdraw) {
						case 1: System.out.println("Amount to withdraw from Checking: ");
								double checkingwithdrawel = scan.nextDouble();
								checking = checking - checkingwithdrawel; // However, instead of depositing money, it takes it out
								balance = checking + savings; // These statements subtract money from the balance instead of adding it
								System.out.println("You withdrew $" + df2.format(checkingwithdrawel) + " from Checking.");
								System.out.println("After this transaction your balance is $" + df2.format(balance) + " (S: $" + df2.format(savings) + ", C: $" + df2.format(checking) + ")");
						break; // Confirmation messages still print but with a slightly altered message
						case 2: System.out.println("Amount to withdraw from Savings: "); // Case 2 will do the same as case one but for savings
								double savingswithdrawel = scan.nextDouble();
								savings = savings - savingswithdrawel;
								balance = checking + savings;
								System.out.println("You withdrew $" + df2.format(savingswithdrawel) + " from Savings.");
								System.out.println("After this transaction your balance is $" + df2.format(balance) + " (S: $" + df2.format(savings) + ", C: $" + df2.format(checking) + ")");
						break;
						case 3: System.out.println("Canceled");
						}
				break;
				case 3:	transferMenu(); // The final menu option that can be chosen is the transfer money menu
						choicetransfer = scan.nextInt();
						
						switch (choicetransfer) {
						case 1: System.out.println("Amount to transfer from Checking to Savings: "); // Asks for input amount to transfer from checking to savings
								double checkingtransfer = scan.nextDouble();
								checking = checking - checkingtransfer; // The following statements update the amount taken away from checking and adds it to savings
								savings = savings + checkingtransfer;
								balance = checking + savings;
								System.out.println("You transferred $" + df2.format(checkingtransfer) + " from Checking to Savings");
								System.out.println("After this transaction your balance is $" + df2.format(balance) + " (S: $" + df2.format(savings) + ", C: $" + df2.format(checking) + ")");
						break; // The same confirmation messages appear with the transfer variant
						case 2: System.out.println("Amount to transfer from Savings to Checking: "); // Case 2 will perform the same task but transfers from savings to checking instead
								double savingstransfer = scan.nextDouble();
								savings = savings - savingstransfer;
								checking = checking + savingstransfer;
								balance = checking + savings;
								System.out.println("You transferred $" + df2.format(savingstransfer) + " from Savings to Checking");
								System.out.println("After this transaction your balance is $" + df2.format(balance) + " (S: $" + df2.format(savings) + ", C: $" + df2.format(checking) + ")");
						break;
						case 3: System.out.println("Canceled");
						}
				break;
				case 4: System.out.println(" "); // The final case for the main menu will also terminate the program if chosen.
				}
// After the menus have been used and terminated, the code moves down to these familiar if-else statements
			if (initialbalance < 1000) { // They use the same variables and boolean statements that were used at the beginning of the code
				double interest = .025; // This time they calculate interest based on account type
				System.out.println("We have added interest to your account! (S: " + df2.format((savings + (savings * interest))) + ", C: $" + df2.format((checking + (checking * interest))) + ")");
			} else if (initialbalance >= 1000 && initialbalance <= 5000) {
				double interest = .035; // A formula updates each account adding interest within these printed messages
				System.out.println("We have added interest to your account! (S: " + df2.format((savings + (savings * interest))) + ", C: $" + df2.format((checking + (checking * interest))) + ")");
			} else if (initialbalance > 5000) {
				double interest = .045; // Interest varies depending on how much the user initially inputed into their accounts
				System.out.println("We have added interest to your account! (S: " + df2.format((savings + (savings * interest))) + ", C: $" + df2.format((checking + (checking * interest))) + ")");
			} // This will be the final message that prints before the entire program terminates
		}
		
	}
	
		private static void displayMenu() { //This defines the main menu that is used in the original switch statement above
			System.out.println("Bank Options:");
			System.out.println("1. Deposit Money"); // The user can choose between these options
			System.out.println("2. Withdraw Money");
			System.out.println("3. Transfer Money");
			System.out.println("4. Quit");
		}
		
		private static void depositMenu() { // The next 3 menus are nested within the above menu's switch statement
			System.out.println("Deposit Money Options:");
			System.out.println("1. Deposit to Checking");
			System.out.println("2. Deposit to Savings");
			System.out.println("3. Cancel");
		}
		
		private static void withdrawMenu() { // These menus hold their own switch statements that perform their own unique needs
			System.out.println("Withdraw Money Options:");
			System.out.println("1. Withdraw from Checking");
			System.out.println("2. Withdraw from Savings");
			System.out.println("3. Cancel");
		}
		
		private static void transferMenu() {
			System.out.println("Transfer Money Options:");
			System.out.println("1. Transfer from Checking to Savings");
			System.out.println("2. Transfer from Savings to Checking");
			System.out.println("3. Cancel");
		}
}