package Body;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

abstract public class Transactions {
	static ArrayList<Customer> customerList = new ArrayList();
	private int arrayCount = 0;

	public Transactions() {
		customerList = new ArrayList<Customer>();
	}

	public void customerBookingHistory(int iD) {
		customerList.get(iD).checkBookingHistory();
	}

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

	public int getAge(int iD) {
		return customerList.get(iD).getAge();
	};

	public void setIDForFirstTimeUser(int iD) {
		if (arrayCount < iD) { // create new element each time there is new iD

			for (int i = arrayCount; i <= iD; i++) {
				Customer c = new Customer();
				customerList.add(c);
			}
		}
		customerList.get(iD).setID(iD);
	}

	public static void rateMovie(String movieTitle, int iD, int movieID, ArrayList<Movie> movieList) {
		String ratingAndReview = customerList.get(iD).rankMovies(movieTitle);
		String ratingInString = ratingAndReview.substring(0, 1);
		int rating = Integer.parseInt(ratingInString);
		movieList.get(movieID).calOverallRating(rating);
	}

}