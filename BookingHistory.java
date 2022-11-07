import java.util.ArrayList;

public class BookingHistory {

	public void pastBookings(ArrayList<String> pastMoviesTitles, ArrayList<String> pastTID) { // display past movies
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
			System.out.println(temp.substring(13, 15));
			System.out.println();
		}

	}

}
