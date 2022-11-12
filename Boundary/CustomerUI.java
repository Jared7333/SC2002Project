package Boundary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Body.AssignScreening;
import Body.Cineplex;
import Body.Movie;
import Body.Screening;
import Body.TransactionID;
import Body.Transactions;
import Body.listOfMoviesForCustomers;

public class CustomerUI {
	int sayNoToReinitilisationAgain = 0;
	Transactions newTransaction = new TransactionID();
//	ArrayList<ArrayList<ArrayList<Screening>>> cineplexScreeningList = null;
	ArrayList<ArrayList<ArrayList<Screening>>> dayScreeningList = null;

	ArrayList<ArrayList<ArrayList<ArrayList<Screening>>>> cineplexDayScreeningList = null;

	public void main(int CustomerID, ArrayList<Movie> movieList) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);

		String movieName = null;
		int movieID = 0;
		int seatId;
		String chosenDay = null;
		int chosenDayID = 0;
		newTransaction.setIDForFirstTimeUser(CustomerID);
		String filenameMovie = "newMovie.txt";
		File f = new File(filenameMovie);

		System.out.println("Welcome Customer!");

		boolean loop = false;
		boolean loop1 = true;

		if (sayNoToReinitilisationAgain == 0) {
			try {
				cineplexDayScreeningList = AssignScreening.allScreenings(1000, 1, movieList);
			} catch (NullPointerException e) {
				sayNoToReinitilisationAgain--;
			}
			sayNoToReinitilisationAgain++;
		}

		while (loop1) {
			int chosenCineplex;
			System.out.println("""
					Welcome To Movie.com
					Please Select Action:
					(1) Choose Cineplex
					(2) Check Past Booking
					(0) Logout""");
			String choice1 = sc.nextLine();
			switch (choice1) {
			case "1":
				Cineplex.showCineplex();
				System.out.println("Choose your Cineplex");
				int cineplex = sc.nextInt();
				sc.nextLine();
				chosenCineplex = cineplex - 1;

				loop = true;
				while (loop) {
					System.out.println("Welcome to " + Cineplex.getCineplexName()[cineplex - 1] + " movie.");
					System.out.println("""
							Please Select Action:
							(1) Browse Movie
							(2) Book Movie
							(3) Rate Movie
							(0) Exit""");
					String choice = sc.nextLine();
					AssignScreening testAssignScreening = new AssignScreening();

					switch (choice) {
					case "1":
						listOfMoviesForCustomers.browseMovies(movieList);

						break;
					case "2":

						// Assign Movies and show times to each individual screenings(or Cinema Layouts)
						chosenDayID = testAssignScreening.chooseDayID();
						chosenDay = testAssignScreening.getChosenDay(chosenDayID);
						movieName = testAssignScreening.chooseMovie(movieList);
						if (movieName.equals("Movie not Available")) {
							continue;
						}
						String cinemaClass = testAssignScreening.chooseClass(movieName, movieList);
						movieID = testAssignScreening.getMovieId(movieName, movieList, cinemaClass);
						int chosenShowtime = testAssignScreening.chooseShowtime(movieID, movieList);
						// End of Assign Movies and show times to each individual screenings(or Cinema
						// Layouts)

						cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID).get(chosenShowtime)
								.setMovieTitle(movieName);

						cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID).get(chosenShowtime)
								.setDayOfWeek(chosenDay);

						cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID).get(chosenShowtime)
								.setTime(chosenShowtime * 100);

						cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID).get(chosenShowtime)
								.setCinemaClass(cinemaClass);

						if (movieList.get(movieID).getCinemaNo() == 3) {
							System.out.println("Platinum Class : Cinema ID " + movieList.get(movieID).getCinemaNo());
						} else {
							System.out.println("Normal Class : Cinema ID " + movieList.get(movieID).getCinemaNo());
						}
						System.out.println(chosenDay + " at " + Cineplex.getCineplexName()[cineplex - 1] + " Cineplex");

						cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID).get(chosenShowtime)
								.cinemaLayout(0);

						System.out.println("Choose your seat");
						seatId = sc.nextInt();
						sc.nextLine();
						cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID).get(chosenShowtime)
								.setSeatId(seatId);

						seatId--;

						System.out.println("Are you a Student?" + "\n(1) Yes" + "\n(2) No");
						choice = sc.nextLine();
						switch (choice) {
						case "1":
							cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID)
									.get(chosenShowtime).tickets[seatId].setStudent(true);
							break;
						case "2":
							cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID)
									.get(chosenShowtime).tickets[seatId].setStudent(false);
							break;
						}

						System.out
								.println("Do you have a preferred credit or loyalty card?" + "\n(1) Yes" + "\n(2) No");
						choice = sc.nextLine();
						switch (choice) {
						case "1":
							cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID)
									.get(chosenShowtime).tickets[seatId].setPreferredCreditAndLoyaltyCards(true);
							break;
						case "2":
							cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID)
									.get(chosenShowtime).tickets[seatId].setPreferredCreditAndLoyaltyCards(false);
							break;
						}

						newTransaction.buyTicket(CustomerID, movieName, chosenCineplex);
						// sc.nextLine();

						cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID).get(movieID)
								.get(chosenShowtime).tickets[seatId].setageOfCust(newTransaction.getAge(CustomerID));

						System.out.println("Price: $" + cineplexDayScreeningList.get(chosenCineplex).get(chosenDayID)
								.get(movieID).get(chosenShowtime).tickets[seatId].calculateAndGetPrice()); // print

						// out

						System.out.println();

						break;

					case "3":
						movieName = testAssignScreening.chooseMovie(movieList);
						if (movieName.equals("Movie not Available")) {
							continue;
						}
						movieID = testAssignScreening.getMovieId(movieName, movieList, "normal");
						Transactions.rateMovie(movieName, CustomerID, movieID, movieList);

						break;
					case "0":
						loop = false;
						break;
					}
				}
				break;
			case "2":
				newTransaction.customerBookingHistory(CustomerID);
				System.out.println();
				break;
			case "0":
				loop1 = false;
				System.out.println("Logging out");
				break;
			}
		}
	}
}