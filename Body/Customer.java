package Body;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

	private int ID;
	private String name;
	private int phoneNo;
	private String email;
	private int age;
	public boolean boughtBefore;

	ArrayList<String> pastMoviesTitles = new ArrayList();
	public ArrayList<String> pastTID = new ArrayList();
	public ArrayList<Integer> pastCineplex = new ArrayList();

	BookingHistory checkBookingHistory = new BookingHistory();

	public Customer() {
		this.ID = 0;
		this.boughtBefore = false;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean customerBoughtBefore() {
		if (this.boughtBefore == false) {
			return false;
		} else {
			return true;
		}
	}

	public ArrayList<String> getPastMoviesTitles() {
		return pastMoviesTitles;
	}

	public void setPastMovieTitles(ArrayList<String> pastMovieTitles) {
		this.pastMoviesTitles = pastMovieTitles;
	}

	public ArrayList<String> getPastTID() {
		return pastTID;
	}

	public void setPastTID(ArrayList<String> pastTID) {
		this.pastTID = pastTID;
	}

	public ArrayList<Integer> getPastCineplex() {
		return pastCineplex;
	}

	public void setPastCineplex(ArrayList<Integer> pastCineplex) {
		this.pastCineplex = pastCineplex;
	}

	public boolean isBoughtBefore() {
		return boughtBefore;
	}

	public void setBoughtBefore(boolean boughtBefore) {
		this.boughtBefore = boughtBefore;
	}

	public String rankMovies(String movieTitle) { // get customer to give rating and review of the movie they just
													// watched
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

	public void checkBookingHistory() {
		checkBookingHistory.pastBookings(pastMoviesTitles, pastTID, pastCineplex);
	}

}