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
	ArrayList<ArrayList<ArrayList<Screening>>> cineplexScreeningList = null;

	public void main(int CustomerID, ArrayList<Movie> movieList) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);

		String movieName = null;
		int seatId;
		newTransaction.setIDForFirstTimeUser(CustomerID);
		String filenameMovie = "newMovie.txt";
		File f = new File(filenameMovie);

		System.out.println("Welcome Customer!");

		boolean loop = false;
		boolean loop1 = true;

		if (sayNoToReinitilisationAgain == 0) {
			cineplexScreeningList = AssignScreening.allScreenings(1000, 1, movieList);
			sayNoToReinitilisationAgain++;
		}

		while (loop1) {
			int chosenCineplex;
			System.out.println("""
					Welcome To Movie.com
					Please Select Action:
					(1)Choose Cineplex
					(2)Check Past Booking
					(0)Logout""");
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
							(1)Browse Movie
							(2)Book Movie
							(0)Exit""");
					String choice = sc.nextLine();
					AssignScreening testAssignScreening = new AssignScreening();

					switch (choice) {
					case "1":
						listOfMoviesForCustomers.browseMovies(movieList);

						break;
					case "2":

						// Assign Movies and show times to each individual screenings(or Cinema Layouts)
						movieName = testAssignScreening.chooseMovie(movieList);
						if (movieName.equals("Movie not Available")) {
							continue;
						}
						int movieID = testAssignScreening.getMovieId(movieName, movieList);
						int chosenShowtime = testAssignScreening.chooseShowtime(movieID, movieList);
						// End of Assign Movies and show times to each individual screenings(or Cinema
						// Layouts)

						cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime)
								.setMovieTitle(movieName);

						cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime)
								.setDayOfWeek("Wednesday");

						cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime)
								.setTime(chosenShowtime);

						System.out.println("Choose your Cinema Class");
						String cinemaClass = sc.nextLine();

						cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime)
								.setCinemaClass(cinemaClass);

						cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime).cinemaLayout(0);

						System.out.println("Choose your seat");
						seatId = sc.nextInt();

						cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime).setSeatId(seatId);

						seatId--;

						newTransaction.buyTicket(CustomerID, movieName, chosenCineplex);
						sc.nextLine();

						cineplexScreeningList.get(chosenCineplex).get(movieID).get(chosenShowtime).tickets[seatId]
								.setageOfCust(newTransaction.getAge(CustomerID));

						System.out.println("Price: $" + cineplexScreeningList.get(chosenCineplex).get(movieID)
								.get(chosenShowtime).tickets[seatId].calculateAndGetPrice()); // print
						// out

						System.out.println();

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