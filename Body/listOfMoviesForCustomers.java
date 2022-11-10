package Body;

import java.io.IOException;
import java.util.ArrayList;

public class listOfMoviesForCustomers {
	public static void browseMovies(ArrayList<Movie> movieList) throws IOException, ClassNotFoundException {

//		newMovieList = s.importMovie(filenameMovie);
		System.out.println("Movie List: ");
		if (movieList.size() == 0) {
			System.out.println("There are no movies currently showing.");
			return;
		}

		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getStatus().equals("Coming Soon")) {
				System.out.println(movieList.get(i).getName() + ": Coming Soon!");
			} else {
				System.out.println(movieList.get(i).getName());
			}
		}
		System.out.println();
	}

}
