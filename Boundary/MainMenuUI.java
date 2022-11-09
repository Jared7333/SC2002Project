package Boundary;

import java.io.IOException;
//import Body.*;
import java.util.Scanner;

public class MainMenuUI {
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);

		LoginUI login = new LoginUI();
		while (true) {
			System.out.println("Welcome to MOBLIMA");
			boolean loop = true;
			String accType = null;
			while (loop) {
				System.out.println("(1) Customer,(2) Admin or (3) Exit MOBLIMA:");
				accType = sc.nextLine();
				accType.toLowerCase();
				if (accType.equals("customer") || accType.equals("admin") || accType.equals("1") || accType.equals("2") || accType.equals("exit") || accType.equals("3")) {
					loop = false;
				}
			}

			if (accType.equals("1") || accType.equals("customer")) {
				if (login.customer()) {
					CustomerUI customer = new CustomerUI();
					customer.main();
				}
			} else if (accType.equals("2") || accType.equals("admin")) {
				login.admin();
				AdminUI admin = new AdminUI();
				admin.main();
			}
			else 
				break;
			
		}
	}
}
