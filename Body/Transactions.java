package Body;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that handles the action of a customer buying a ticket.
 * Creates and contains the list of customers.
 * Also contains related methods such as displaying 
 * displaying a customer's booking history,
 * and updating a movie's rating after a customer has
 * rated it.
 */
abstract public class Transactions {
	static ArrayList<Customer> customerList = new ArrayList();
	private int arrayCount = 0;

	/**
	 * Create list of customers.
	 */
	public Transactions() {
		customerList = new ArrayList<Customer>();
	}

	/**
	 * Display a customer's booking history.
	 * @param iD the cutomer's ID.
	 */
	public void customerBookingHistory(int iD) {
		customerList.get(iD).checkBookingHistory();
	}

	/**
	 * Updates the customer's booking history and ticket ID.
	 * Has the customer input their details if they
	 * have not vought a ticket before.
	 * @param iD the customer's ID.
	 * @param movieTitle the movie's title.
	 * @param chosenCineplex cineplex the customer has chosen.
	 */
	public void buyTicket(int iD, String movieTitle, int chosenCineplex) {
		String Transact;
		Scanner sc = new Scanner(System.in);
		int phone;
		int age;

//		if (arrayCount < iD) { // create new element each time there is new iD
//
//			for (int i = arrayCount; i <= iD; i++) {
//				Customer c = new Customer();
//				customerList.add(c);
//			}
//		}

		if (customerList.get(iD).customerBoughtBefore() == true) { // check if customer has bought ticket before, if
																	// yes, skip the personal details
			System.out.println("Obtaining details...");
		} else {
			System.out.println("For First booking, Please Enter your Name, PhoneNo, Email and Age");
			System.out.println("Name: ");

			String name = sc.next();
			while (true) {
				try {
					System.out.println("Phone No: ");
					phone = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter a valid number");
					sc.nextLine();
					continue;
				}
			}
			System.out.println("Email: ");
			String email = sc.next();
			while (true) {
				try {
					System.out.println("Age: ");
					age = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Please enter a valid age");
					sc.nextLine();
					continue;
				}
			}

//			customerList.get(iD).setID(iD);
			customerList.get(iD).setName(name);
			customerList.get(iD).setPhoneNo(phone);
			customerList.get(iD).setEmail(email);
			customerList.get(iD).setAge(age);
			customerList.get(iD).boughtBefore = true;
		}

		System.out.println("Customer's ID: " + customerList.get(iD).getID());
		System.out.println("Customer's Name: " + customerList.get(iD).getName());
		System.out.println("Customer's Phone Number: " + customerList.get(iD).getPhoneNo());
		System.out.println("Customer's Email: " + customerList.get(iD).getEmail());
		System.out.println("Customer's Age: " + customerList.get(iD).getAge());
		customerList.get(iD).pastMoviesTitles.add(movieTitle); // update customer's watch history
		customerList.get(iD).pastTID.add(Transact = TransactionID.generateTID(iD, movieTitle)); // update Customer's TID
		customerList.get(iD).pastCineplex.add(chosenCineplex);

	}

	/**
	 * Get customer's age.
	 * @param iD customer's ID.
	 * @return customer's age.
	 */
	public int getAge(int iD) {
		return customerList.get(iD).getAge();
	};

	/**
	 * Adds new customers to the customer list and updates their ID.
	 * @param iD the customer's ID.
	 */
	public void setIDForFirstTimeUser(int iD) {
		if (arrayCount < iD) { // create new element each time there is new iD

			for (int i = arrayCount; i <= iD; i++) {
				Customer c = new Customer();
				customerList.add(c);
			}
		}
		customerList.get(iD).setID(iD);
	}

	/**
	 * Updates a movie's rating from a customer's rating.
	 * @param movieTitle the movie's title.
	 * @param iD the cutomer's ID.
	 * @param movieID the movie's ID.
	 * @param movieList the current list of movies.
	 */
	public static void rateMovie(String movieTitle, int iD, int movieID, ArrayList<Movie> movieList) {
		String ratingInString = "0";
		String ratingAndReview = customerList.get(iD).rankMovies(movieTitle);
		String ifRatingIsTen = ratingAndReview.substring(0, 2);
		if (ifRatingIsTen.equals("10")) {
			int rating = Integer.parseInt(ifRatingIsTen);
			movieList.get(movieID).calOverallRating(rating);
			return;
		}
		ratingInString = ratingAndReview.substring(0, 1);
		int rating = Integer.parseInt(ratingInString);
		movieList.get(movieID).calOverallRating(rating);
	}

}