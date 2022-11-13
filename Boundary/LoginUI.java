package Boundary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Body.Admin;

/**
 * User interfaces that handles the login function for both Customer
 * and Admin users.
 */
public class LoginUI {
	Scanner sc = new Scanner(System.in);

	/**
	 * Login user interface for Customers.
	 *
	 * @return user ID if successful.
	 */
	public int customer() {// both customer and admin should login via here,
		System.out.println("Programmer Note: Choose ID: 1 ~ 100");
		System.out.println("Programmer Note: Password: customerPASSWORD");
		System.out.println("Login for Customer");
		// insert login for customer here here
		Scanner sc = new Scanner(System.in);
		int UserID;
		while (true) {
			System.out.println("Enter your User ID");

			try {
				UserID = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter valid User ID");
				sc.nextLine();
				continue;
			}
			sc.nextLine();

			System.out.println("Enter your Password");
			String Password = sc.nextLine();

			if ((UserID < 101 && UserID > 0) && Password.equals("customerPASSWORD")) {
				System.out.println("Login successful");
				return UserID;

			} else {
				System.out.println("Invalid UserID or Password");
				System.out.println("1. Try again.");
				System.out.println("Enter any number to exit Login Page.");
				int choice = sc.nextInt();
				if (choice == 1) {
					continue;
				} else {
					break;
				}
			}

		}

		// after successful verification return
		return 0;
	}

	/**
	 * Login user interface for Admin.
	 *
	 * @param adminList list of Admin accounts to check if login is valid.
	 * @param inUse Admin Object / Account that is logged in.
	 * @return Admin account that has been logged in.
	 */
	public Admin admin(ArrayList<Admin> adminList, Admin inUse) {// admin should login via here,
		System.out.println("Login for Admin");
		// insert login admin here

		// Login logic
		boolean login = false;
		System.out.println("Programmer Note: Username: mainADMIN");
		System.out.println("Programer Note: Password: adminPASSWORD");
		while (!login) {
			System.out.println("Enter Admin Username:");
			String username = sc.nextLine();
			for (Admin a : adminList) {
				if (a.getLoginID() != null && a.getLoginID().matches(username)) {
					System.out.println("Enter Admin Password:");
					String password = sc.nextLine();
					if (a.getPassword().matches(password)) {
						login = true;
						inUse = a;
					} else {
						System.out.println("Invalid Password");
					}
				}
			}
		}

		// after successful verification return
		return inUse;
	}

}