package Body;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AssignScreening {
	String filenameMovie = "movie.txt";
	String filenameAdmin = "admin.txt";

	serialise s = new serialise();

	ArrayList<Movie> newMovieList = new ArrayList<Movie>();

	Scanner sc = new Scanner(System.in);

	public String chooseMovie() throws IOException, ClassNotFoundException {
		newMovieList = s.importMovie(filenameMovie);

		String movieName = null;

		System.out.println("Select Movies: ");
		for (int i = 0; i < newMovieList.size(); i++) {
			System.out.print(i + 1 + ": ");
			System.out.println(newMovieList.get(i).getName());
		}
		int selectedMovie = sc.nextInt();

		for (int i = 0; i < newMovieList.size(); i++) {
			if (selectedMovie == newMovieList.get(i).getMovieId()) {
				movieName = newMovieList.get(i).getName();
			}
		}

		return movieName;

	}

	public int getMovieId(String movieName) throws IOException, ClassNotFoundException {
		newMovieList = s.importMovie(filenameMovie);
		int movieID = 0;
		for (int i = 0; i < newMovieList.size(); i++) {
			if (newMovieList.get(i).getName().equals(movieName)) {

				movieID = newMovieList.get(i).getMovieId();
			}
		}

		return movieID - 1;

	}

	public int chooseShowtime(int selectedMovie) throws IOException, ClassNotFoundException {
		int k = 1;
		int count = 1;

		newMovieList = s.importMovie(filenameMovie);

		for (Integer element : newMovieList.get(selectedMovie).getShowtimes()) {
			System.out.print(k + ": " + element + " ");
			k++;
		}
		k = 0;
		System.out.println();
		int selectedShowtime = sc.nextInt();

		while (true) {
			for (Integer element : newMovieList.get(selectedMovie).getShowtimes()) {
				if (count == selectedShowtime) {
					return element;
				}
				count++;
			}
			break;
		}
		return 0;

	}

	public void browseMovies() throws IOException, ClassNotFoundException {
		newMovieList = s.importMovie(filenameMovie);
		System.out.println("Movie List: ");

		for (int i = 0; i < newMovieList.size(); i++) {
			System.out.println(newMovieList.get(i).getName());
		}
		System.out.println();
	}

}
