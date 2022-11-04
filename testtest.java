
import java.util.ArrayList;
import java.util.Scanner;

public class testtest {
	public static void main(String[] args) {

		// Customer cust = new Customer();

		String testMovieName1 = "Spiderman";
		String testMovieName2 = "Avatar";
		String testMovieName3 = "Kingsmen";
//		String testMovieName4 = "Spiderman";

		int showTime1 = 930, showTime2 = 1400, showTime3 = 1500, showTime4 = 1830, showTime5 = 2200;
		ArrayList<Screening> screeningList = new ArrayList();
		int arrayCount = 0;
		int cinemaId = 0;

		int amountOfCustomers = 3;
		int seatId = 5;
		Transactions newTransaction = new Transactions();
		Scanner sc = new Scanner(System.in);
		int time = 2000;

		while (amountOfCustomers > 0) {

			System.out.println("Choose your movie");
			String movieTitle = sc.nextLine();

			System.out.println("Choose show times");
			System.out.println("1." + showTime1 + " 2." + showTime2 + " 3." + showTime3);
			int chosenShowTime = sc.nextInt();
			System.out.println(movieTitle);
			System.out.println(chosenShowTime);
			System.out.println(testMovieName1);
			if (chosenShowTime == showTime1 && movieTitle.equals(testMovieName1)
					|| chosenShowTime == showTime2 && movieTitle.equals(testMovieName2)
					|| chosenShowTime == showTime3 && movieTitle.equals(testMovieName3)) {
				System.out.println("hihi");
				cinemaId = 1;
			} else if (chosenShowTime == showTime2 && movieTitle.equals(testMovieName1)
					|| chosenShowTime == showTime1 && movieTitle.equals(testMovieName3)
					|| chosenShowTime == showTime3 && movieTitle.equals(testMovieName2)) {
				cinemaId = 2;
			} else if (chosenShowTime == showTime3 && movieTitle.equals(testMovieName1)
					|| chosenShowTime == showTime2 && movieTitle.equals(testMovieName3)
					|| chosenShowTime == showTime1 && movieTitle.equals(testMovieName2)) {
				cinemaId = 3;
			}

			if (arrayCount < cinemaId) { // create new element each time there is new iD
				for (int i = arrayCount; i <= cinemaId; i++) {
					Screening s = new Screening(cinemaId, chosenShowTime);
					screeningList.add(s);
				}
				arrayCount = cinemaId;
			}

//			newScreening.setMovieTitle(movieTitle);
			screeningList.get(cinemaId).setMovieTitle(movieTitle);

//			newScreening.setDayOfWeek("Wednesday"); // hardcode wednesday
			screeningList.get(cinemaId).setDayOfWeek("Wednesday");

//			newScreening.setTime(showTime1);
			screeningList.get(cinemaId).setTime(showTime1);

			System.out.println("Choose your Cinema Class");
			String cinemaClass = sc.nextLine();
//			newScreening.setCinemaClass(cinemaClass);
			screeningList.get(cinemaId).setCinemaClass(cinemaClass);

//			newScreening.cinemaLayout(0); // to display cinema layout
			screeningList.get(cinemaId).cinemaLayout(0);

			System.out.println("Choose your seat");
			seatId = sc.nextInt();
//			newScreening.setSeatId(seatId);
			screeningList.get(cinemaId).setSeatId(seatId);

			seatId--;

			System.out.println("type in customer ID, name, phoneNo, email and age");
			int iD = sc.nextInt();
			newTransaction.buyTicket(iD, movieTitle);
			amountOfCustomers--;
			sc.nextLine();

//			newScreening.tickets[seatId].setageOfCust(newTransaction.getAge(iD)); // getting age from transaction class
			screeningList.get(cinemaId).tickets[seatId].setageOfCust(newTransaction.getAge(iD));

//			newScreening.tickets[seatId].calculatePrice();
			screeningList.get(cinemaId).tickets[seatId].calculatePrice();

//			System.out.println(newScreening.tickets[seatId].toString()); // print out ticket info
			System.out.println(screeningList.get(cinemaId).tickets[seatId].toString()); // print out ticket info

			System.out.println(newTransaction.generateTID(movieTitle));
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
