package Body;

import java.io.IOException;
import java.util.ArrayList;

public class listOfMoviesForCustomers {
	public static void browseMovies(ArrayList<Movie> movieList) throws IOException, ClassNotFoundException {
		int totalRating = 0;

//		newMovieList = s.importMovie(filenameMovie);
		System.out.println("Movie List: ");
		if (movieList.size() == 0) {
			System.out.println("There are no movies currently showing.");
			return;
		}

		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getStatus().equals("End Of Showing")) {
				System.out.print(movieList.get(i).getName() + ": End Of Showing");

			} else if (movieList.get(i).getStatus().equals("Coming Soon")) {
				System.out.println(movieList.get(i).getName() + ": Coming Soon!");
			} else if (movieList.get(i).getStatus().equals("Preview")) {
				System.out.println(movieList.get(i).getName() + ": Preview");
				for (int j = 0; j < movieList.get(i).getPastReview().size(); j++) {
					totalRating += movieList.get(i).getPastReview().get(j);
				}
				totalRating = totalRating / movieList.get(i).getPastReview().size();

				System.out.println(":  Total Rating:" + totalRating);
				totalRating = 0;
			} else {
				System.out.print(movieList.get(i).getName());
				for (int j = 0; j < movieList.get(i).getPastReview().size(); j++) {
					totalRating += movieList.get(i).getPastReview().get(j);
				}
				totalRating = totalRating / movieList.get(i).getPastReview().size();

				System.out.println(":  Total Rating:" + totalRating);
				totalRating = 0;

			}
		}
		System.out.println();
	}

}
