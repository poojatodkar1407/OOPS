package Json_Programs;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Management_Inventory implements Serializable {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter Your choice to make a list :");
		System.out.println("1.Rice\n2.Wheat\n3.Pulses");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:

			Rice rice = new Rice();
			System.out.println("enter Rice Name:");
			rice.setName(scanner.next());
			System.out.println("enter weight of rice:");
			rice.setWeight(scanner.nextInt());
			System.out.println("enter the price of rice :");
			rice.setPrice(scanner.nextDouble());
			String jsonRice = Utility.convertJavaToJson(rice);
			System.out.println(jsonRice);
			break;

		case 2:

			Wheat wheat = new Wheat();
			System.out.println("enter Wheat Name:");
			wheat.setName(scanner.next());
			System.out.println("enter weight of Wheat:");
			wheat.setPrice(scanner.nextInt());
			System.out.println("enter the price of Wheat :");
			wheat.setPrice(scanner.nextDouble());
			System.out.println("enter Wheat Name");
			String jsonWheat = Utility.convertJavaToJson(wheat);
			System.out.println(jsonWheat);
			break;

		case 3:

			Pulses pulse = new Pulses();
			System.out.println("enter Pulse name:");
			pulse.setName(scanner.next());
			System.out.println("enter pulse weight :");
			pulse.setWeight(scanner.nextInt());
			System.out.println("enter pulse price: ");
			pulse.setPrice(scanner.nextDouble());
			String jsonPulses = Utility.convertJavaToJson(pulse);
			System.out.println(jsonPulses);
			break;

		}
	}
}