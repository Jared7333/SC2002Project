package Body;

import java.util.ArrayList;

/**
 * Handles displaying booking history of customers.
 */
public class BookingHistory {

	/**
	 * Displays past bookings for movies that customers made.
	 * For each booking, display the movie title,
	 * transaction ID,
	 * purchase date and time, and
	 * location bought (cineplex). 
	 * @param pastMoviesTitles list of past movies booked.
	 * @param pastTID list of past ticket IDs.
	 * @param pastCineplex list of past cineplexes.
	 */
	public void pastBookings(ArrayList<String> pastMoviesTitles, ArrayList<String> pastTID,
			ArrayList<Integer> pastCineplex) { // display past movies
		// that
		// customers bought ticket
		// for
		String temp;

		System.out.println("Booking History: ");
		for (int i = 0; i < pastMoviesTitles.size(); i++) {
			System.out.println(pastMoviesTitles.get(i));

			System.out.print("Transaction ID: ");
			System.out.println(pastTID.get(i));
			temp = pastTID.get(i);

			System.out.println("Ticket was purchased on");
			System.out.print(temp.substring(9, 11));
			System.out.print("/");
			System.out.print(temp.substring(7, 9));
			System.out.print("/");
			System.out.print(temp.substring(3, 7));
			System.out.print(" at ");
			System.out.print(temp.substring(11, 13));
			System.out.print(":");
			System.out.print(temp.substring(13, 15));
			System.out.print(" at ");
			if (pastCineplex.get(i) == 0) {
				System.out.println("Woodlands Cineplex");
			} else if (pastCineplex.get(i) == 1) {
				System.out.println("Punggol Cineplex");

			} else if (pastCineplex.get(i) == 2) {
				System.out.println("Changi Cineplex");
			}
			System.out.println();
		}

	}

}
