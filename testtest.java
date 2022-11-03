package sc2002Project;

import java.util.Scanner;

public class testtest {
	public static void main(String[] args) {

		// Customer cust = new Customer();

		String testMovieName1 = "Edge of Tomorrow";
		String testMovieName2 = "Top Gun";
		String testMovieName3 = "Night at the Museum";
		String testMovieName4 = "Spiderman";
		int amountOfCustomers = 3;
		int seatId = 0;
		Transactions newTransaction = new Transactions();
		Scanner sc = new Scanner(System.in);
		int time = 2000;
		Screening newScreening = new Screening(1, time);
		
		while (amountOfCustomers > 0) {
			
			newScreening.cinemaLayout(0); //to display cinema layout
			newScreening.setDayOfWeek("Wednesday"); //hardcode wednesday
			
			//
			
			System.out.println("Choose your movie");
			String movieTitle = sc.nextLine();
			newScreening.setMovieTitle(movieTitle);
			
			System.out.println("Choose your Cinema Class");
			String cinemaClass = sc.nextLine();
			newScreening.setCinemaClass(cinemaClass);
			
			System.out.println("Choose your seat");
			seatId = sc.nextInt();
			newScreening.setSeatId(seatId);
			seatId--;

			System.out.println("type in customer ID, name, phoneNo, email and age");
			int iD = sc.nextInt();
			newTransaction.buyTicket(iD, movieTitle);
			amountOfCustomers--;
			sc.nextLine();
			newScreening.tickets[seatId].setageOfCust(newTransaction.getAge(iD)); //getting age from transaction class
			newScreening.tickets[seatId].calculatePrice(); 
			System.out.println(newScreening.tickets[seatId].toString()); //print out ticket info
			System.out.println(newTransaction.generateTID(movieTitle));
			System.out.println();
		


		}
		
		//to check customer past movie history
//		System.out.println("Enter id to check past movie");
//		int currentID= sc.nextInt();
//		newTransaction.pastMovies(currentID);
//		sc.nextLine();
//		System.out.println("Enter id to check past movie");
//		currentID= sc.nextInt();
//		newTransaction.pastMovies(currentID);

	}

}
