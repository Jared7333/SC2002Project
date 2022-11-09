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

	public String chooseMovie(ArrayList<Movie> movieList) throws IOException, ClassNotFoundException {
//		newMovieList = s.importMovie(filenameMovie);

		String movieName = null;

		System.out.println("Select Movies: ");
		for (int i = 0; i < movieList.size(); i++) {
			System.out.print(i + 1 + ": ");
			System.out.println(movieList.get(i).getName());
		}
		int selectedMovie = sc.nextInt();

		for (int i = 0; i < movieList.size(); i++) {
			if (selectedMovie == movieList.get(i).getMovieId()) {
				movieName = movieList.get(i).getName();
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

//		newMovieList = s.importMovie(filenameMovie);

		for (Integer element : movieList.get(selectedMovie).getShowtimes()) {
			System.out.print(k + ": " + element + " ");
			k++;
		}
		k = 0;
		System.out.println();
		int selectedShowtime = sc.nextInt();

		while (true) {
			for (Integer element : movieList.get(selectedMovie).getShowtimes()) {
				if (count == selectedShowtime) {
					return element;
				}
				count++;
			}
			break;
		}
		return 0;

	}

	public static ArrayList<ArrayList<ArrayList<Screening>>> allScreenings(int chosenShowtime, int movieID,
			ArrayList<Movie> movieList) {
//		ArrayList<ArrayList<Screening>> screeningList = new ArrayList<ArrayList<Screening>>();
//		ArrayList<Screening> screeningMovieList = new ArrayList<Screening>();
		ArrayList<ArrayList<ArrayList<Screening>>> cineplexScreeningList = new ArrayList<ArrayList<ArrayList<Screening>>>();

		int totalMovies = 4;
		int count = 0;

		int totalShowtimes = 2360;

		while (count < 3) {
			ArrayList<ArrayList<Screening>> screeningList = new ArrayList<ArrayList<Screening>>();
			ArrayList<Screening> screeningMovieList = new ArrayList<Screening>();

			for (int i = arrayMovieCount; i <= totalMovies; i++) {
				for (int j = 0; j <= totalShowtimes; j++) {
					Screening newScreening = new Screening(movieID, chosenShowtime);
					screeningMovieList.add(newScreening);
				}
				screeningList.add(new ArrayList<Screening>(screeningMovieList));
				screeningMovieList.removeAll(screeningMovieList);

			}
			cineplexScreeningList.add(new ArrayList<ArrayList<Screening>>(screeningList));
			screeningList.removeAll(screeningMovieList);
			count++;

//			arrayMovieCount = totalMovies;
//			arrayShowtimes = totalShowtimes;
		}

		return cineplexScreeningList;
	}

}
