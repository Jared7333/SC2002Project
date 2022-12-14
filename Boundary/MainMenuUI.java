package Boundary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//import Body.*;
import java.util.Scanner;

import Body.Admin;
import Body.Movie;
import Body.serialise;

/**
 * User interface for main menu that users see.
 */
public class MainMenuUI {

	/**
	 * Main menu user interface that all users will use before selecting their
	 * purpose, like Customer or Admin, and calls the user interface for the
	 * specified user. Imports Movie and Admin Objects from the previously
	 * serialised file if it exists.
	 *
	 * @throws IOException            Error check.
	 * @throws ClassNotFoundException Error check.
	 */
	public void main() throws IOException, ClassNotFoundException {

		// Copied admin stuffs from mainAPP
		ArrayList<Movie> movieList;
		String filenameMovie = "newMovie.txt";
		File f = new File(filenameMovie);
		f.createNewFile();
		serialise s = new serialise();
		movieList = s.importMovie(filenameMovie);
		CustomerUI customer = new CustomerUI();
		Admin inUse = null;
		ArrayList<Admin> adminList;
		String filenameAdmin = "admin.txt";
		File f2 = new File(filenameAdmin);
		f2.createNewFile();
		adminList = s.importAdmin(filenameAdmin);
		Admin mainAdmin = new Admin("Main Admin", "mainADMIN", "adminPASSWORD");
		int count = 0;
		for (Admin a : adminList) {
			if (a.getLoginID() != null) {
				if (!a.getLoginID().matches(mainAdmin.getLoginID())) {
					count++;
				}
			}
		}
		if (count == adminList.size()) {
			adminList.add(mainAdmin);
		}
		// End of admin stuffs Copied from mainAPP

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
				if (accType.equals("customer") || accType.equals("admin") || accType.equals("1") || accType.equals("2")
						|| accType.equals("exit") || accType.equals("3")) {
					loop = false;
				}
			}

			if (accType.equals("1") || accType.equals("customer")) {

				int CustomerID = login.customer();
				if (CustomerID > 0 && CustomerID < 101) {

					customer.main(CustomerID, movieList);
				} else if (CustomerID == 0) {
					continue;
				}
			} else if (accType.equals("2") || accType.equals("admin")) {

				inUse = login.admin(adminList, inUse);

				AdminUI admin = new AdminUI();
				admin.main(adminList, inUse, mainAdmin, movieList);
			} else
				break;

		}
	}
}