
import java.util.ArrayList;
import java.util.Scanner;

public class testtest {
	public static void main(String[] args) {

		// Customer cust = new Customer();

		String testMovieName1 = "Spiderman";
		String testMovieName2 = "Avatar";
		String testMovieName3 = "Kingsmen";

//        ArrayList<Movie> newMovieList =  new ArrayList<Movie>();
//        Movie s = new Movie(testMovieName3, 1, "On-going", "About a Man bitten by Spider", "Spiderman's Director", null, testMovieName3, null, 0, null, 0);
//        newMovieList.add(testMovieName1);

//		  String testMovieName4 = "Spiderman";

		int showTime1 = 930, showTime2 = 1400, showTime3 = 1500, showTime4 = 1830, showTime5 = 2200;
		ArrayList<ArrayList<Screening>> screeningList = new ArrayList<ArrayList<Screening>>();
		ArrayList<Screening> screeningMovieList = new ArrayList<Screening>();
//		ArrayList<Screening> screeningList = new ArrayList<Screening>();

		int arrayCount = 0;
		int arrayMovieCount = 0;
		int cinemaId = 0;

		int movieValue = 0;

		int amountOfCustomers = 3;
		int seatId = 5;
		Transactions newTransaction = new TransactionID();
		Scanner sc = new Scanner(System.in);
		int time = 2000;

		while (amountOfCustomers > 0) {

			System.out.println("Choose your movie");
			String movieTitle = sc.nextLine();

			System.out.println("Choose show times");
			System.out.println("1." + showTime1 + " 2." + showTime2 + " 3." + showTime3);
			int chosenShowTime = sc.nextInt();
//			System.out.println(movieTitle);
//			System.out.println(chosenShowTime);
//			System.out.println(testMovieName1);
			if (chosenShowTime == showTime1 && movieTitle.equals(testMovieName1)
					|| chosenShowTime == showTime2 && movieTitle.equals(testMovieName2)
					|| chosenShowTime == showTime3 && movieTitle.equals(testMovieName3)) {
				cinemaId = 1;
				if (movieTitle.equals(testMovieName1)) {
					movieValue = 1;
				} else if (movieTitle.equals(testMovieName2)) {
					movieValue = 2;
				} else if (movieTitle.equals(testMovieName3)) {
					movieValue = 3;
				}
			} else if (chosenShowTime == showTime2 && movieTitle.equals(testMovieName1)
					|| chosenShowTime == showTime1 && movieTitle.equals(testMovieName3)
					|| chosenShowTime == showTime3 && movieTitle.equals(testMovieName2)) {
				cinemaId = 2;
				if (movieTitle.equals(testMovieName1)) {
					movieValue = 1;
				} else if (movieTitle.equals(testMovieName2)) {
					movieValue = 2;
				} else if (movieTitle.equals(testMovieName3)) {
					movieValue = 3;
				}
			} else if (chosenShowTime == showTime3 && movieTitle.equals(testMovieName1)
					|| chosenShowTime == showTime2 && movieTitle.equals(testMovieName3)
					|| chosenShowTime == showTime1 && movieTitle.equals(testMovieName2)) {
				cinemaId = 3;
				if (movieTitle.equals(testMovieName1)) {
					movieValue = 1;
				} else if (movieTitle.equals(testMovieName2)) {
					movieValue = 2;
				} else if (movieTitle.equals(testMovieName3)) {
					movieValue = 3;
				}
			}

			if (arrayCount < cinemaId || arrayMovieCount < movieValue) { // create new element each time there is new iD
//				for (int i = arrayCount; i <= cinemaId; i++) {
//					Screening s = new Screening(cinemaId, chosenShowTime);
//					screeningList.add(s);
//				}
				for (int i = arrayCount; i <= cinemaId; i++) {

					for (int j = arrayMovieCount; j <= movieValue; j++) {
						if (arrayMovieCount < movieValue) {

							Screening s = new Screening(cinemaId, chosenShowTime);
							screeningMovieList.add(s);
						}

//						screeningList.get(cinemaId).set(movieValue, s);

					}
					if (arrayCount < cinemaId) {
						screeningList.add(screeningMovieList);
					}
				}

				arrayCount = cinemaId;
				arrayMovieCount = movieValue;
			}
			System.out.println(cinemaId);
			System.out.println(movieValue);

//			newScreening.setMovieTitle(movieTitle);
//			screeningList.get(cinemaId).setMovieTitle(movieTitle);
			screeningList.get(cinemaId).get(movieValue).setMovieTitle(movieTitle);

//			newScreening.setDayOfWeek("Wednesday"); // hardcode wednesday
//			screeningList.get(cinemaId).setDayOfWeek("Wednesday");
			screeningList.get(cinemaId).get(movieValue).setDayOfWeek("Wednesday");

//			newScreening.setTime(showTime1);
//			screeningList.get(cinemaId).setTime(showTime1);
			screeningList.get(cinemaId).get(movieValue).setTime(showTime1);

			System.out.println("Choose your Cinema Class");
			String cinemaClass = sc.nextLine();
//			newScreening.setCinemaClass(cinemaClass);
//			screeningList.get(cinemaId).setCinemaClass(cinemaClass);
			screeningList.get(cinemaId).get(movieValue).setCinemaClass(cinemaClass);

//			newScreening.cinemaLayout(0); // to display cinema layout
//			screeningList.get(cinemaId).cinemaLayout(0);
			screeningList.get(cinemaId).get(movieValue).cinemaLayout(0);

			System.out.println("Choose your seat");
			seatId = sc.nextInt();
//			newScreening.setSeatId(seatId);
//			screeningList.get(cinemaId).setSeatId(seatId);
			screeningList.get(cinemaId).get(movieValue).setSeatId(seatId);

			seatId--;

			System.out.println("type in customer ID, name, phoneNo, email and age");
			int iD = sc.nextInt();
			newTransaction.buyTicket(iD, movieTitle);
			amountOfCustomers--;
			sc.nextLine();

//			newScreening.tickets[seatId].setageOfCust(newTransaction.getAge(iD)); // getting age from transaction class
//			screeningList.get(cinemaId).tickets[seatId].setageOfCust(newTransaction.getAge(iD));
			screeningList.get(cinemaId).get(movieValue).tickets[seatId].setageOfCust(newTransaction.getAge(iD));

//			newScreening.tickets[seatId].calculatePrice();
//			screeningList.get(cinemaId).tickets[seatId].calculatePrice();
			screeningList.get(cinemaId).get(movieValue).tickets[seatId].calculatePrice();

//			System.out.println(newScreening.tickets[seatId].toString()); // print out ticket info
//			System.out.println(screeningList.get(cinemaId).tickets[seatId].toString()); // print out ticket info
			System.out.println(screeningList.get(cinemaId).get(movieValue).tickets[seatId].toString()); // print out
																										// ticket info

			newTransaction.generateTID(iD, movieTitle);

//			System.out.println(newTransaction.generateTID(iD, movieTitle));
			newTransaction.pastMovies(iD);
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
