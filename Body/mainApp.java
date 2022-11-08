package Body;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class mainApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		String name = "Spider-Man: No Way Home";
		int movieId = 1;
		boolean threeD = false;
		boolean blockbuster = false;
		String status = "Now Showing";
		String synopsis = "After Quentin Beck frames Peter Parker for his murder and reveals Parker's identity as Spider-Man,[N 1] Parker, his girlfriend Michelle \"MJ\" Jones-Watson, best friend Ned Leeds, and aunt May are interrogated by the Department of Damage Control. Lawyer Matt Murdock gets Parker's charges dropped, but the group grapples with negative publicity. After Parker, MJ, and Ned's MIT applications are rejected, Parker goes to the New York Sanctum to ask Stephen Strange for help. Strange casts a spell that would make everyone forget Parker is Spider-Man, but it is corrupted when Parker repeatedly requests alterations to let his loved ones retain their memories. Strange contains the spell to stop it and makes Parker leave.";
		String director = "Jon Watts";

		ArrayList<String> casts = new ArrayList<String>();
		casts.add("Tom Holland");
		casts.add("Zendaya");
		casts.add("Benedict Cumberbatch");
		casts.add("Jacob Batalon");
		casts.add("Jon Favreau");
		casts.add("Jamie Foxx");
		casts.add("Andrew Garfield");
		casts.add("Tobey Maguire");

		String ageRating = "Rated PG";

		ArrayList<Integer> pastReview = new ArrayList<Integer>();
		pastReview.add(1);
		pastReview.add(2);

		int ticketSales = 500;

		ArrayList<Integer> showTimes = new ArrayList<Integer>();
		showTimes.add(900);
		showTimes.add(1000);
		showTimes.add(1030);
		showTimes.add(1400);
		showTimes.add(1530);
		showTimes.add(1800);
		showTimes.add(2100);
		showTimes.add(2330);

		int cinema = 1;

		Movie m = new Movie(name, movieId, threeD, blockbuster, status, synopsis, director, casts, ageRating,
				pastReview, ticketSales, showTimes, cinema);

		ArrayList<Movie> movieList = new ArrayList<Movie>();

		movieList.add(m);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

//		name = "Avatar: The Way of Water";
//		movieId = 2;
//		threeD = false;
//		blockbuster = false;
//		status = "Now Showing";
//		synopsis = "Set more than a decade after the events of the first film, Avatar: The Way of Water begins to tell the story of the Sully family, the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.";
//		director = "James Cameron";
//
//		casts = new ArrayList<String>();
//		casts.add("Sam Worthington");
//		casts.add("Zoe Saldaña");
//		casts.add("Sigourney Weaver");
//		casts.add("Stephen Lang");
//		casts.add("Kate Winslet");
//
//		ageRating = "Rated PG";
//
//		pastReview = new ArrayList<Integer>();
//		pastReview.add(1);
//		pastReview.add(2);
//
//		ticketSales = 500;
//
//		showTimes = new ArrayList<Integer>();
//		showTimes.add(900);
//		showTimes.add(1130);
//		showTimes.add(1230);
//		showTimes.add(1400);
//		showTimes.add(1530);
//		showTimes.add(1835);
//		showTimes.add(2130);
//		showTimes.add(2330);
//
//		cinema = 2;
//
//		m = new Movie(name, movieId, threeD, blockbuster, status, synopsis, director, casts, ageRating, pastReview,
//				ticketSales, showTimes, cinema);
//
//		movieList.add(m);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		name = "The King's Man";
		movieId = 3;
		threeD = false;
		blockbuster = false;
		status = "Now Showing";
		synopsis = "In 1902, aristocrat Orlando, Duke of Oxford, his wife Emily, and their young son Conrad visit a concentration camp in South Africa while working for the British Red Cross. Emily is mortally wounded during a Boer sniper attack on the camp. Before passing, she makes Orlando promise never to let their son see war again.";
		director = "Matthew Vaughn";

		casts = new ArrayList<String>();
		casts.add("Ralph Fiennes");
		casts.add("Gemma Arterton");
		casts.add("Rhys Ifans");
		casts.add("Matthew Goode");
		casts.add("Tom Hollander");
		casts.add("Harris Dickinson");
		casts.add("Daniel Brühl");
		casts.add("Djimon Hounsou");
		casts.add("Charles Dance");

		ageRating = "Rated NC16";

		pastReview = new ArrayList<Integer>();
		pastReview.add(1);
		pastReview.add(2);

		ticketSales = 500;

		showTimes = new ArrayList<Integer>();
		showTimes.add(900);
		showTimes.add(1000);
		showTimes.add(1230);
		showTimes.add(1300);
		showTimes.add(1600);
		showTimes.add(1835);
		showTimes.add(2130);
		showTimes.add(2300);

		cinema = 3;

		m = new Movie(name, movieId, threeD, blockbuster, status, synopsis, director, casts, ageRating, pastReview,
				ticketSales, showTimes, cinema);

		movieList.add(m);
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

		// on start
		ArrayList<ArrayList<Screening>> screeningList = new ArrayList<ArrayList<Screening>>();
		ArrayList<Screening> screeningMovieList = new ArrayList<Screening>();
		Customer newCustomer = new Customer();

//		int arrayCount = 0, totalCinemas = 3, cinemaId = 0;
		int arrayMovieCount = 0, totalMovies = 3;

		int arrayShowtimes = 0, totalShowtimes = 2360, chosenShowtime = 0;

		int movieID = 0;

		String movieName = null;

		int seatId = 5;
		Transactions newTransaction = new TransactionID();
		Scanner sc = new Scanner(System.in);
		int time = 2000;

//		ArrayList<Movie> movieList;
		ArrayList<Admin> adminList;

		String filenameMovie = "movie.txt";
		String filenameAdmin = "admin.txt";

		// checks if file exits and if not create
		File f = new File(filenameMovie);
		f.createNewFile();
		File f2 = new File(filenameAdmin);
		f2.createNewFile();

		serialise s = new serialise();
		s.exportMovie(filenameMovie, movieList);
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
			while(loop1) {
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
					loop = true;
					while (loop) {
						System.out.println("Welcome to " + Cineplex.getCineplexName()[cineplex-1] + " movie.");
						System.out.println("""
								Please Select Action:
								(1)Browse Movie
								(2)Book Movie
								(0)Exit""");
						String choice = sc.nextLine();
						AssignScreening testAssignScreening = new AssignScreening();
		
						switch (choice) {
						case "1":
							testAssignScreening.browseMovies();
		
							break;
						case "2":
		
							// Assign Movies and show times to each individual screenings(or Cinema Layouts)
							movieName = testAssignScreening.chooseMovie();
							movieID = testAssignScreening.getMovieId(movieName);
							chosenShowtime = testAssignScreening.chooseShowtime(movieID);
							// End of Assign Movies and show times to each individual screenings(or Cinema
							// Layouts)
		
							// Initialize all the Screenings available
							if (arrayMovieCount < totalMovies || arrayShowtimes < totalShowtimes) {
		
								for (int i = arrayMovieCount; i <= totalMovies; i++) {
									for (int j = 0; j <= totalShowtimes; j++) {
										Screening newScreening = new Screening(movieID, chosenShowtime);
										screeningMovieList.add(newScreening);
									}
									screeningList.add(new ArrayList<Screening>(screeningMovieList));
									screeningMovieList.removeAll(screeningMovieList);
		
								}
		
								arrayMovieCount = totalMovies;
								arrayShowtimes = totalShowtimes;
							}
							// End of Initialize all the Screenings available
		
							screeningList.get(movieID).get(chosenShowtime).setMovieTitle(movieName);
		
							screeningList.get(movieID).get(chosenShowtime).setDayOfWeek("Wednesday");
		
							screeningList.get(movieID).get(chosenShowtime).setTime(chosenShowtime);
		
							System.out.println("Choose your Cinema Class");
							String cinemaClass = sc.nextLine();
		
							screeningList.get(movieID).get(chosenShowtime).setCinemaClass(cinemaClass);
		
							screeningList.get(movieID).get(chosenShowtime).cinemaLayout(0);
		
							System.out.println("Choose your seat");
							seatId = sc.nextInt();
		
							screeningList.get(movieID).get(chosenShowtime).setSeatId(seatId);
		
							seatId--;
		
							System.out.println("type in customer ID, name, phoneNo, email and age");
							int iD = sc.nextInt();
							newTransaction.buyTicket(iD, movieName);
							sc.nextLine();
		
							screeningList.get(movieID).get(chosenShowtime).tickets[seatId]
									.setageOfCust(newTransaction.getAge(iD));
		
							System.out.println("Price: $"
									+ screeningList.get(movieID).get(chosenShowtime).tickets[seatId].calculateAndGetPrice()); // print
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
					inUse.updateMovie(movieList);
					break;
				case "2": //Printing of movie information in 2 ways
                    System.out.println("(1)Summarised\n(2)Detailed\n(3)Sorted by Ticket Sales\n(4)Sorted by Rating");
                    int printChoice = sc.nextInt(); sc.nextLine();
                    if(printChoice == 1){
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