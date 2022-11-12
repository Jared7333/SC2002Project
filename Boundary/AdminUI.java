package Boundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Body.Admin;
import Body.Movie;
import Body.PublicHoliday;

public class AdminUI {
	// login
	public void main(ArrayList<Admin> adminList, Admin inUse, Admin mainAdmin, ArrayList<Movie> movieList)
			throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);

		boolean loop = true;
		while (loop) {
			System.out.println("""

					Select Action
					(1) Upload Movie
					(2) See All Movies
					(3) Update Movie Information
					(4) Remove Movie
					(5) Admin Account Related
					(6) Delete Admin Account (ONLY FOR MAIN ADMIN)
					(7) Configure Holiday
					(0) Logout""");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": // Upload new movies via csv to simulate getting information from webscrapping
				inUse.uploadMovie(movieList);
				break;
			case "2": // Printing of movie information in 2 ways
				System.out.println(
						"(1) Summarised\n(2) Detailed\n(3) Sorted by Ticket Sales\n(4) Sorted by Rating\n(0) Exit");
				int printChoice = sc.nextInt();
				sc.nextLine();
				if (printChoice == 1) {
					inUse.printMovies(movieList);
				} else if (printChoice == 2) {
					inUse.printMovieDetailed(movieList);
				} else if (printChoice == 3) {
					inUse.printMovieSales(movieList);
				} else if (printChoice == 4) {
					inUse.printMovieRating(movieList);
				} else if (printChoice == 0) {
					break;
				} else {
					System.out.println("Invalid Selection");
					continue;
				}
				break;
			case "3": // Update movie information
				inUse.updateMovie(movieList);
				break;
			case "4": // Remove movie
				inUse.removeMovie(movieList);
				break;
			case "5": // Change current account password or create new admin account
				inUse.configureSettings(adminList);
				break;
			case "6": // Delete admin account but only possible with main admin account
				if (inUse.getLoginID().matches(mainAdmin.getLoginID())) {
					System.out.println("Main Admin Account Detected, Delete Other Admin Account? [Y/N]");
					String delete = sc.nextLine();
					delete.toLowerCase();
					if (delete.matches("y") || delete.matches("yes")) {
						for (Admin a : adminList) {
							if (a.getLoginID() != null && !a.getLoginID().matches(mainAdmin.getLoginID())) {
								a.printInfo();
							}
						}
						System.out.println("Enter Admin Username to be DELETED:");
						String toDelete = sc.nextLine();
						for (Admin a : adminList) {
							if (a.getLoginID() != null && a.getLoginID().matches(toDelete)) {
								adminList.remove(a);
								System.out.println("Successfully Deleted");
								break;
							}
						}
					} else {
						System.out.println("Cancel Deletion of Admin Account");
					}
				} else {
					System.out.println("Not Main Admin");
				}
				break;
				
			case "7": 
				PublicHoliday.configureHoliday();
				break;
			case "0": // Exit
				loop = false;
				break;
			}
		}
	}
}