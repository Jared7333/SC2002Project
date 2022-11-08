import java.io.IOException;
import java.util.ArrayList;

public class listOfMoviesForCustomers {
	public static void browseMovies(ArrayList<Movie> movieList) throws IOException, ClassNotFoundException {

//		newMovieList = s.importMovie(filenameMovie);
		System.out.println("Movie List: ");

		for (int i = 0; i < movieList.size(); i++) {
			System.out.println(movieList.get(i).getName());
		}
		System.out.println();
	}

}
