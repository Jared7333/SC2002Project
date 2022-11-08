
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// on start
		Customer newCustomer = new Customer();

		String movieName = null;

		int seatId = 5;
		Transactions newTransaction = new TransactionID();
		Scanner sc = new Scanner(System.in);
		int time = 2000;

		ArrayList<Movie> movieList;
		ArrayList<Admin> adminList;

		String filenameMovie = "newMovie.txt";
		String filenameAdmin = "admin.txt";

		// checks if file exits and if not create
		File f = new File(filenameMovie);
		f.createNewFile();
		File f2 = new File(filenameAdmin);
		f2.createNewFile();

		serialise s = new serialise();
//		s.exportMovie(filenameMovie, movieList);
//		s.exportAdmin(filenameAdmin, adminList);

		movieList = s.importMovie(filenameMovie);
		adminList = s.importAdmin(filenameAdmin);

		// MainAdmin Creation
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

//		for (Movie movie : movieList) {
//			movie.printInfo();
//		}

		for (Admin admin : adminList) {
			System.out.println(admin.getLoginID());
			System.out.println(admin.getPassword());
		}

		// Program Start
		boolean loop1 = true;
		boolean loop = true;
		String accType = null;
		while (loop) {
			System.out.println("(1) Customer or (2) Admin:");
			accType = sc.nextLine();
			accType.toLowerCase();
			if (accType.equals("customer") || accType.equals("admin") || accType.equals("1") || accType.equals("2")) {
				loop = false;
			}
		}

		if (accType.equals("1") || accType.equals("customer")) {
			loop1 = true;
			Admin forCustomerUse = null;
			forCustomerUse = new Admin(accType, accType, accType);
			forCustomerUse.uploadMovie(movieList);
			ArrayList<ArrayList<ArrayList<Screening>>> cineplexScreeningList = AssignScreening.allScreenings(1000, 1,
					movieList);

			while (loop1) {
				int chosenCineplex;
				System.out.println("""
						Welcome To Movie.com
						Please Select Action:
						(1)Choose Cineplex
						(2)Check Past Booking
						(0)Exit""");
				String choice1 = sc.nextLine();
				switch (choice1) {
				case "1":
					Cineplex.showCineplex();
					System.out.println("Choose your Cineplex");
					int cineplex = sc.nextInt();
					sc.nextLine();
					chosenCineplex = cineplex - 1;

					loop = true;
					while (loop) {
						System.out.println("Welcome to " + Cineplex.getCineplexName()[cineplex - 1] + " movie.");
						System.out.println("""
								Please Select Action:
								(1)Browse Movie
								(2)Book Movie
								(0)Exit""");
						String choice = sc.nextLine();
						AssignScreening testAssignScreening = new AssignScreening();

						switch (choice) {
						case "1":
							listOfMoviesForCustomers.browseMovies(movieList);

							break;
						case "2":

							// Assign Movies and show times to each individual screenings(or Cinema Layouts)
							movieName = testAssignScreening.chooseMovie(movieList);
							int movieID = testAssignScreening.getMovieId(movieName, movieList);
							int chosenShowtime = testAssignScreening.chooseShowtime(movieID, movieList);
							// End of Assign Movies and show times to each individual screenings(or Cinema
							// Layouts)

							cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime)
									.setMovieTitle(movieName);

							cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime)
									.setDayOfWeek("Wednesday");

							cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime)
									.setTime(chosenShowtime);

							System.out.println("Choose your Cinema Class");
							String cinemaClass = sc.nextLine();

							cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime)
									.setCinemaClass(cinemaClass);

							cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime).cinemaLayout(0);

							System.out.println("Choose your seat");
							seatId = sc.nextInt();

							cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime)
									.setSeatId(seatId);

							seatId--;

							System.out.println("type in customer ID, name, phoneNo, email and age");
							int iD = sc.nextInt();
							newTransaction.buyTicket(iD, movieName, chosenCineplex);
							sc.nextLine();

							cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime).tickets[seatId]
									.setageOfCust(newTransaction.getAge(iD));

							System.out.println("Price: $" + cineplexScreeningList.get(chosenCineplex).get(movieID)
									.get(chosenShowtime).tickets[seatId].calculateAndGetPrice()); // print
							// out

							System.out.println();

							break;
						case "0":
							loop = false;
							break;
						}
					}
					break;
				case "2":
					System.out.println("What is your ID");
					int customerID = sc.nextInt();
					sc.nextLine();
					newTransaction.customerBookingHistory(customerID);
					System.out.println();
					break;
				case "0":
					loop = false;
					break;
				}
			}
		} else

		{
			// Login logic
			Admin inUse = null;
			boolean login = false;
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

			loop = true;
			while (loop) {
				System.out.println("""

						Select Action
						(1)Upload Movie
						(2)See All Movies
						(3)Update Movie Information
						(4)Remove Movie
						(5)Admin Account Related
						(6)Delete Admin Account (ONLY FOR MAIN ADMIN)
						(0)Exit""");
				String choice = sc.nextLine();
				switch (choice) {
				case "1": // Upload new movies via csv to simulate getting information from webscrapping
					inUse.uploadMovie(movieList);
					break;
				case "2": // Printing of movie information in 2 ways
					System.out.println("(1)Summarised\n(2)Detailed\n(3)Sorted by Ticket Sales\n(4)Sorted by Rating");
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
					} else {
						System.out.println("Invalid Selection");
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
				case "0": // Exit
					loop = false;
					break;
				}
			}
		}

		// Only if the program terminates properly
//		s.exportMovie(filenameMovie, movieList);
//		s.exportAdmin(filenameAdmin, adminList);
	}
}