package Body;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class testtest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String testMovieName1 = "Spiderman";
		String testMovieName2 = "Avatar";
		String testMovieName3 = "Kingsmen";

		int showTime1 = 930, showTime2 = 1400, showTime3 = 1500, showTime4 = 1830, showTime5 = 2200;
		ArrayList<ArrayList<Screening>> screeningList = new ArrayList<ArrayList<Screening>>();
		ArrayList<Screening> screeningMovieList = new ArrayList<Screening>();
		Customer newCustomer = new Customer();

//		int arrayCount = 0, totalCinemas = 3, cinemaId = 0;
		int arrayMovieCount = 0, totalMovies = 3;

		int arrayShowtimes = 0, totalShowtimes = 2360, chosenShowtime = 0;

		int movieId = 0;
		String movieName = null;

		int amountOfCustomers = 3;
		int seatId = 5;
		Transactions newTransaction = new TransactionID();
		Scanner sc = new Scanner(System.in);
		int time = 2000;

		while (amountOfCustomers > 0) {

			// Assign Movies and show times to each individual screenings(or Cinema Layouts)
			AssignScreening testAssignScreening = new AssignScreening();
			movieName = testAssignScreening.chooseMovie();
			movieId = testAssignScreening.getMovieId(movieName);
			chosenShowtime = testAssignScreening.chooseShowtime(movieId);
			// End of Assign Movies and show times to each individual screenings(or Cinema
			// Layouts)

			// Initialize all the Screenings available
			if (arrayMovieCount < totalMovies || arrayShowtimes < totalShowtimes) {

				for (int i = arrayMovieCount; i <= totalMovies; i++) {
					for (int j = 0; j <= totalShowtimes; j++) {
						Screening s = new Screening(movieId, chosenShowtime);
						screeningMovieList.add(s);
					}
					screeningList.add(new ArrayList<Screening>(screeningMovieList));
					screeningMovieList.removeAll(screeningMovieList);

				}

				arrayMovieCount = totalMovies;
				arrayShowtimes = totalShowtimes;
			}
			// End of Initialize all the Screenings available

			screeningList.get(movieId).get(chosenShowtime).setMovieTitle(movieName);

			screeningList.get(movieId).get(chosenShowtime).setDayOfWeek("Wednesday");

			screeningList.get(movieId).get(chosenShowtime).setTime(chosenShowtime);

			System.out.println("Choose your Cinema Class");
			String cinemaClass = sc.nextLine();

			screeningList.get(movieId).get(chosenShowtime).setCinemaClass(cinemaClass);

			screeningList.get(movieId).get(chosenShowtime).cinemaLayout(0);

			System.out.println("Choose your seat");
			seatId = sc.nextInt();

			screeningList.get(movieId).get(chosenShowtime).setSeatId(seatId);

			seatId--;

			System.out.println("type in customer ID, name, phoneNo, email and age");
			int iD = sc.nextInt();
			newTransaction.buyTicket(iD, movieName);
			amountOfCustomers--;
			sc.nextLine();

			screeningList.get(movieId).get(chosenShowtime).tickets[seatId].setageOfCust(newTransaction.getAge(iD));

			System.out.println(
					"Price: $" + screeningList.get(movieId).get(chosenShowtime).tickets[seatId].calculateAndGetPrice()); // print
			// out

			newTransaction.customerBookingHistory(iD);
			System.out.println();

		}

		// to check customer past movie history
//		System.out.println("Enter id to check past movie");
//		int currentID= sc.nextInt();
//		newTransaction.pastMovies(currentID);
//		sc.nextLine();
//		System.out.println("Enter id to check past movie");
//		currentID= sc.nextInt();
//		newTransaction.pastMovies(currentID);

	}

}