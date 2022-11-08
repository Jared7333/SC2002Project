import java.util.Scanner;

public class LoginUI {
	public static boolean customer() {// both customer and admin should login via here,
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
				return true;

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
		return false;
	}

	public void admin() {// both customer and admin should login via here,
		System.out.println("Login for Admin");
		// insert login admin here

		// after successful verification return
		return;
	}

}