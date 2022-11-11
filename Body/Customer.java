
package Body;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains Customer's information. Customers can choose to give ratings to
 * movies. Customers can check their booking history.
 */
public class Customer {

	/**
	 * Customer's ID.
	 */
	private int ID;
	/**
	 * Customer's name.
	 */
	private String name;
	/**
	 * Customer's Phone Number.
	 */
	private int phoneNo;
	/**
	 * Customer's Email.
	 */
	private String email;
	/**
	 * Customer's Age.
	 */
	private int age;
	/**
	 * Check if customer has bought tickets before.
	 */
	public boolean boughtBefore;

	/**
	 * Customer's list of movies they bought before.
	 */
	ArrayList<String> pastMoviesTitles = new ArrayList();
	/**
	 * Customer's list of generated TID for tickets they bought.
	 */
	public ArrayList<String> pastTID = new ArrayList();

	/**
	 * Customer's list of place they bought from.
	 */
	public ArrayList<Integer> pastCineplex = new ArrayList();
	/**
	 * Customer's booking history.
	 */

	BookingHistory checkBookingHistory = new BookingHistory();

	/**
	 * Creates a new Customer with given ID.
	 */
	public Customer() {
		this.ID = 0;
		this.boughtBefore = false;
	}

	/**
	 * Gets Customer's ID.
	 * 
	 * @return this Customer's ID.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets the Customer's ID.
	 * 
	 * @param iD Customer's ID.
	 */

	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Gets Customer's name.
	 * 
	 * @return this Customer's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Customer's name.
	 * 
	 * @param name Customer's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the Customer's Phone Number.
	 * 
	 * @return this Customer's Phone Number
	 */
	public int getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the Customer's Phone Number.
	 * 
	 * @param phoneNo Customer's Phone Number.
	 */
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Gets the Customer's Email Address.
	 * 
	 * @return this Customer's Email Address.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the Customer's Email Address.
	 * 
	 * @param email Customer's Email Address.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the Customer's Age.
	 * 
	 * @return this Customer's Age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the Customer's Age.
	 * 
	 * @param age Customer's Age.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Check if Customer has bought tickets before
	 * 
	 * @return <code>true</code> if Customer has bought tickets before;
	 *         <code>false</code> otherwise.
	 */
	public boolean customerBoughtBefore() {
		if (this.boughtBefore == false) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Allow Customers to rate and give review for the selected Movie Title.
	 * 
	 * @param movieTitle Selected Movie that Customers is rating and reviewing.
	 * @return Rating and Review of the selected Movie Title in String.
	 */
	public String rankMovies(String movieTitle) {
		Scanner sc = new Scanner(System.in);
		int rating;
		String review, ratingAndReview;
		while (true) {
			System.out.println("How would you rate " + movieTitle + "? (Please give rating from 1 to 10)");
			rating = sc.nextInt();
			if (rating < 0 || rating > 10) {
				System.out.println("Invalid rating, please rate again.");
				continue;
			} else {
				break;
			}
		}
		System.out.println("Enter your review for " + movieTitle + ".");
		review = sc.next();
		review = review + sc.nextLine();
		ratingAndReview = rating + "\n" + review;
		return ratingAndReview;
	}

	/**
	 * Allow Customers to check for their booking history.
	 */
	public void checkBookingHistory() {
		checkBookingHistory.pastBookings(pastMoviesTitles, pastTID, pastCineplex);
	}

}