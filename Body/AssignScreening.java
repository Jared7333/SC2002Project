package Body;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignScreening {
	String filenameMovie = "movie.txt";
	String filenameAdmin = "admin.txt";
	public static int arrayMovieCount = 1;
	public static int arrayShowtimes = 1;

	serialise s = new serialise();

	ArrayList<Movie> newMovieList = new ArrayList<Movie>();

	Scanner sc = new Scanner(System.in);

	public int chooseDayID() {
		while (true) {
			System.out.println("Select which day do you want to watch: ");
			System.out.println("1: Monday, 2: Tuesday, 3: Wednesday, 4: Thursday, 5: Friday, 6: Saturday, 7: Sunday");
			int pickDay = sc.nextInt();
			return (pickDay - 1);

		}
	}

	public String getChosenDay(int ChosenDay) {
		if (ChosenDay == 0) {
			return "Monday";
		} else if (ChosenDay == 1) {
			return "Tuesday";
		} else if (ChosenDay == 2) {
			return "Wednesday";
		} else if (ChosenDay == 3) {
			return "Thursday";
		} else if (ChosenDay == 4) {
			return "Friday";
		} else if (ChosenDay == 5) {
			return "Saturday";
		}
		return "Sunday";
	}

	public String chooseMovie(ArrayList<Movie> movieList) throws IOException, ClassNotFoundException {
//		newMovieList = s.importMovie(filenameMovie);

		String movieName = null;
		int selectedMovie = 0;
		if (movieList.size() == 0) {
			System.out.println("There are no movies currently showing.");
			return "Movie not Available";
		}
		while (true) {
			System.out.println("Select Movies: ");
			for (int i = 0; i < movieList.size(); i++) {
				if (movieList.get(i).getStatus().equals("Coming Soon")) {
					continue;
				} else {
					System.out.print(i + 1 + ": ");
					System.out.println(movieList.get(i).getName());
				}
			}
			selectedMovie = sc.nextInt();
			try { // Error exception if User typed a non-existent movieID
				movieList.get(selectedMovie - 1).getStatus();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Please select a valid Movie");
				continue;
			}

			if (movieList.get(selectedMovie - 1).getStatus().equals("Coming Soon")) { // If user typed a movieID of
																						// Status: Coming Soon,
				System.out.println("Please select a valid Movie");
				continue;
			} else {
				for (int i = 0; i < movieList.size(); i++) {
					if (selectedMovie == movieList.get(i).getMovieId()) {
						movieName = movieList.get(i).getName();
					}
				}
				break;
			}
		}

		return movieName;

	}

	public int getMovieId(String movieName, ArrayList<Movie> movieList) throws IOException, ClassNotFoundException {
//		newMovieList = s.importMovie(filenameMovie);
		int movieID = 0;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getName().equals(movieName)) {

				movieID = movieList.get(i).getMovieId();
			}
		}

		return movieID - 1;

	}

	public int chooseShowtime(int selectedMovie, ArrayList<Movie> movieList)
			throws IOException, ClassNotFoundException {
		int k = 1;
		int count = 1;
		int countShowTimes = 0;
		int selectedShowtime = 0;

//		newMovieList = s.importMovie(filenameMovie);
		System.out.println("Select Showtime: ");
		for (Integer element : movieList.get(selectedMovie).getShowtimes()) {
			if (element == 0) {
				System.out.print(k + ": 000" + element + " ");
			} else if (element < 1000) {
				System.out.print(k + ": 0" + element + " ");
			} else {
				System.out.print(k + ": " + element + " ");
			}
			k++;
		}
		k = 0;
		System.out.println();
		while (true) {
			selectedShowtime = sc.nextInt();
			if (selectedShowtime < 0) {
				System.out.println("Please choose a valid show time.");
				sc.nextLine();
				continue;
			} else if ((selectedShowtime + 1) > movieList.get(selectedMovie).getShowtimes().size()) {
				System.out.println("Please choose a valid show time.");
				sc.nextLine();
				continue;
			} else {
				break;
			}
		}

		while (true) {
			for (Integer element : movieList.get(selectedMovie).getShowtimes()) {
				if (count == selectedShowtime) {
					for (int i = 0; i < 2360; i += 100) {
						if (element.equals(i)) {
							return countShowTimes;
						}
						countShowTimes++;
					}
				}
				count++;
			}
			break;
		}
		return 0;

	}

	public static ArrayList<ArrayList<ArrayList<ArrayList<Screening>>>> allScreenings(int chosenShowtime, int movieID,
			ArrayList<Movie> movieList) {
		ArrayList<Screening> screeningMovieList = null;
		ArrayList<ArrayList<Screening>> screeningList = null;
		ArrayList<ArrayList<ArrayList<Screening>>> dayScreeningList = null;
		ArrayList<ArrayList<ArrayList<ArrayList<Screening>>>> cineplexDayScreeningList = new ArrayList<ArrayList<ArrayList<ArrayList<Screening>>>>();

		int totalMovies = movieList.size();
		int countForDays = 0;
		int countForCineplex = 0;
		int totalShowtimes = 24;

		while (countForCineplex < 3) {
			dayScreeningList = new ArrayList<ArrayList<ArrayList<Screening>>>();

			while (countForDays < 7) {
				screeningList = new ArrayList<ArrayList<Screening>>();

				for (int i = arrayMovieCount; i <= totalMovies; i++) {
					screeningMovieList = new ArrayList<Screening>();

					for (int j = 0; j <= totalShowtimes; j++) {
						Screening newScreening = new Screening(movieID, chosenShowtime);
						screeningMovieList.add(newScreening);
					}
					screeningList.add(new ArrayList<Screening>(screeningMovieList));
					screeningMovieList.removeAll(screeningMovieList);

				}
				dayScreeningList.add(new ArrayList<ArrayList<Screening>>(screeningList));
				screeningList.removeAll(screeningMovieList);
				countForDays++;
			}
			countForDays = 0;
			cineplexDayScreeningList.add(new ArrayList<ArrayList<ArrayList<Screening>>>(dayScreeningList));
			dayScreeningList.removeAll(screeningList);
			countForCineplex++;
		}

		return cineplexDayScreeningList;
	}

}