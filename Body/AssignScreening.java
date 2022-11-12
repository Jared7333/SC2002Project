package Body;

import java.io.IOException;
import java.time.LocalDate;
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
			System.out.println("Select which date do you want to watch: ");
			System.out.println("(1) 31st December 2021(Monday)" + "\n(2) 1st January 2022(Tuesday)"
					+ "\n(3) 2nd January 2022(Wednesday) " + "\n(4) 3rd January 2022(Thursday)"
					+ "\n(5) 4th January 2022(Friday)" + "\n(6) 5th January 2022(Saturday)"
					+ "\n(7) 6th January 2022(Sunday)");
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

	public LocalDate getChosenDate(int ChosenDay) {
		LocalDate ld;
		if (ChosenDay == 0) {
			return ld = LocalDate.of(2021, 12, 31);
		} else if (ChosenDay == 1) {
			return ld = LocalDate.of(2022, 01, 01);
		} else if (ChosenDay == 2) {
			return ld = LocalDate.of(2022, 01, 02);
		} else if (ChosenDay == 3) {
			return ld = LocalDate.of(2022, 01, 03);
		} else if (ChosenDay == 4) {
			return ld = LocalDate.of(2022, 01, 04);
		} else if (ChosenDay == 5) {
			return ld = LocalDate.of(2022, 01, 05);
		}
		return ld = LocalDate.of(2022, 01, 06);
	}

	public String chooseMovie(ArrayList<Movie> movieList, LocalDate date) throws IOException, ClassNotFoundException {

		String movieName = null;
		int selectedMovie = 0;
		int someInt = 0;
		if (movieList.size() == 0) {
			System.out.println("There are no movies currently showing.");
			return "Movie not Available";
		}
		while (true) {
			System.out.println("Select Movies: ");
			for (int i = 0; i < movieList.size(); i++) {

				if (movieList.get(i).getStatus().equals("End Of Showing")) {
					if (date.isAfter(movieList.get(i).getDate().get(movieList.get(i).getDate().size() - 1))) {
						continue;
					}
				}

				if (movieList.get(i).getStatus().equals("Coming Soon")) {
					continue;
				} else {
					if (movieList.get(i).getStatus().equals("Preview")) {
						System.out.print("(" + (i + 1) + ") ");
						System.out.println(movieList.get(i).getName() + ": Preview");
					} else {
						System.out.print("(" + (i + 1) + ") ");
						System.out.println(movieList.get(i).getName());
					}
				}
			}
			selectedMovie = sc.nextInt();
			try { // Error exception if User typed a non-existent movieID
				movieList.get(selectedMovie - 1).getStatus();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Please select a valid Movie");
				continue;
			}

			if (movieList.get(selectedMovie - 1).getStatus().equals("Coming Soon")) {
				System.out.println("Please select a valid Movie");
				continue;
			} else {
				int movieDateSize = (movieList.get(selectedMovie - 1).getDate().size() - 1);

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

	public int getMovieId(String movieName, ArrayList<Movie> movieList, String cinemaClass)
			throws IOException, ClassNotFoundException {
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

		System.out.println("Select Showtime: ");
		System.out.println(movieList.get(selectedShowtime).getName());
		for (Integer element : movieList.get(selectedMovie).getShowtimes()) {
			if (element == 0) {
				System.out.print("(" + k + ")" + " 000" + element + " ");
			} else if (element < 1000) {
				System.out.print("(" + k + ")" + " 0" + element + " ");
			} else {
				System.out.print("(" + k + ")" + " " + element + " ");
			}
			k++;
		}
		k = 0;
		System.out.println();
		while (true) {
			selectedShowtime = sc.nextInt();
			if (selectedShowtime < 1) {
				System.out.println("Please choose a valid show time.");
				sc.nextLine();
				continue;
			} else if ((selectedShowtime) > movieList.get(selectedMovie).getShowtimes().size()) {
				System.out.println(selectedShowtime);
				System.out.println(movieList.get(selectedMovie).getShowtimes().size());
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

	public String chooseClass(String movieName, ArrayList<Movie> movieList) {

		for (int i = 0; i < movieList.size(); i++) {
			if (movieName.equals(movieList.get(i).getName())) {
				if (movieList.get(i).getCinemaNo() == 3) {
					return "Platinum";
				} else {
					return "Normal";
				}
			}

		}
		return "Normal";

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