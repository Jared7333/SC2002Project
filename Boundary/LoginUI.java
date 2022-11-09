import java.util.ArrayList;
import java.util.Scanner;

public class LoginUI {
	Scanner sc = new Scanner(System.in);

	public static int customer() {// both customer and admin should login via here,
		System.out.println("Programmer Note: Choose ID: 1 ~ 100");
		System.out.println("Programmer Note: Password: customerPASSWORD");
		System.out.println("Login for Customer");
		// insert login for customer here here
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter your User ID");
			int UserID = sc.nextInt();
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

	public Admin admin(ArrayList<Admin> adminList, Admin inUse) {// both customer and admin should login via here,
		System.out.println("Login for Admin");
		// insert login admin here

		// Login logic
		boolean login = false;
		System.out.println("mainADMIN");
		System.out.println("adminPASSWORD");
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