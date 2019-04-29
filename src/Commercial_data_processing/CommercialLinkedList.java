package Commercial_data_processing;

import java.util.Scanner;

public class CommercialLinkedList {
	
	public static void main(String[] args) throws Exception   {
	
		Scanner scanner = new Scanner(System.in);
		Utility utility = new Utility();
		CommercialLLMethods stock1 = new CommercialLLMethods();
		char ch;
		do {
			System.out.println("1. Add Details\n2. Buy\n3. Sell\n4. Print Report ");
			int choice = utility.inputinteger();
			switch (choice) {
			case 1:
				stock1.addDetails();
				break;
			case 2:
				stock1.buyStock();
				stock1.linkedlist();
				break;
			case 3:
				stock1.sellStock();
				stock1.linkedlist();
				break;
			case 4:
				stock1.printReport();
				break;
			default:
				System.out.println("Invalid Choice..!!!");
				break;
			}
			System.out.println("Do you wants to continue...(Y/N)");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}
