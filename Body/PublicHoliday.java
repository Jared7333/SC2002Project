package Body;

import java.util.Scanner;

public class PublicHoliday {
	public static void configureHoliday() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select Action:"
				+ "\n(1) Add holiday"
				+ "\n(2) Delete holiday"
				+ "\n(0) Exit");
		int choice = sc.nextInt();
		switch(choice) {
		case 1: 
			addHoliday();
			break;
		case 2: 
			deleteHoliday();
			break;
		case 0:
			break;
		}
	}

	private static void deleteHoliday() {
		// TODO Auto-generated method stub
		
	}

	private static void addHoliday() {
		// TODO Auto-generated method stub
		
	}
}
