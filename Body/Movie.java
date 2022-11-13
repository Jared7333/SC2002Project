package Body;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Contains Movie Information, the getters and setters, and printing method.
 */

public class Movie implements Serializable {
	/*
	 * enum Status{ COMING_SOON, PREVIEW, NOW_SHOWING, END_OF_SHOWING }
	 * 
	 * enum AgeRating{ PG, M18, R21 }
	 * 
	 */

	/**
	 * Movie's name.
	 */
	private String name;

	/**
	 * Movie's ID.
	 */
	private int movieId;

	/**
	 * Movie's 3D status.
	 */
	private boolean threeD;

	/**
	 * Movie's Blockbuster status.
	 */
	private boolean blockbuster;

	/**
	 * Movie's Showing status.
	 */
	private String status;

	/**
	 * Movie's blockbuster Synopsis.
	 */
	private String synopsis;

	/**
	 * Movie's Director.
	 */
	private String director;

	/**
	 * Movie's Casts.
	 */
	private ArrayList<String> casts;

	/**
	 * Movie's Age Rating.
	 */
	private String ageRating;

	/**
	 * Movie's Overall Rating.
	 */
	private double overallRating;

	/**
	 * Movie's Past Reviews by Customers.
	 */
	private ArrayList<Integer> pastReview;

	/**
	 * Movie's Ticket Sales.
	 */
	private int ticketSales;

	/**
	 * Movie's Showtime.
	 */
	private ArrayList<Integer> showTimes;

	/**
	 * Which Cinema is the Movie playing in.
	 */
	private int cinema;

	/**
	 * Which Dates does the Movie have showtime.
	 */
	private ArrayList<LocalDate> date;

	/**
	 * Declares Movie Object
	 *
	 * @param name        Name of Movie.
	 * @param movieId     Movie ID.
	 * @param threeD      Check if movie is 3D.
	 * @param blockbuster Check if movie is BlockBuster.
	 * @param status      Movie Status
	 * @param synopsis    Movie Synopsis.
	 * @param director    Movie's Director.
	 * @param casts       Movie's list of Cast.
	 * @param ageRating   Movie's Age Rating.
	 * @param pastReview  Movie's Past Reviews.
	 * @param ticketSales Movie's ticket sales.
	 * @param showTimes   Movie's show times.
	 * @param cinema      Movie's cinema ID.
	 * @param date        Movie's list of date shown.
	 */
	public Movie(String name, int movieId, boolean threeD, boolean blockbuster, String status, String synopsis,
			String director, ArrayList<String> casts, String ageRating, ArrayList<Integer> pastReview, int ticketSales,
			ArrayList<Integer> showTimes, int cinema, ArrayList<LocalDate> date) {
		this.name = name;
		this.movieId = movieId;
		this.threeD = threeD;
		this.blockbuster = blockbuster;
		this.status = status;
		this.synopsis = synopsis;
		this.director = director;
		this.casts = casts;
		this.ageRating = ageRating;
		this.overallRating = 0.0;
		this.pastReview = pastReview;
		this.ticketSales = ticketSales;
		this.showTimes = showTimes;
		this.cinema = cinema;
		this.date = date;
	}

	/**
	 * Sets the Movie's Name.
	 *
	 * @param name Movie's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets Movie's Name.
	 *
	 * @return this Movie's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Movie's ID.
	 *
	 * @param movieId Movie's movieId.
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * Gets Movie ID.
	 *
	 * @return this Movie's movieId.
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * Gets Movie 3D status.
	 *
	 * @return if this Movie is a 3D film.
	 */
	public boolean getThreeD() {
		return threeD;
	}

	/**
	 * Sets the Movie 3D status.
	 *
	 * @param threeD Movie if 3D or not.
	 */
	public void setThreeD(boolean threeD) {
		this.threeD = threeD;
	}

	/**
	 * Gets Movie Blockbuster status.
	 *
	 * @return if this Movie is a blockbuster film.
	 */
	public boolean getBlockbuster() {
		return blockbuster;
	}

	/**
	 * Sets the Movie Blockbuster status.
	 *
	 * @param blockbuster Movie if blockbuster or not.
	 */
	public void setBlockbuster(boolean blockbuster) {
		this.blockbuster = blockbuster;
	}

	/**
	 * Gets Movie Satus.
	 *
	 * @return this Movie status.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the Movie Status.
	 *
	 * @param status Movie's status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets Movie Synopsis.
	 *
	 * @return this Movie Synopsis.
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * Sets the Movie's Synopsis.
	 *
	 * @param synopsis Movie's synopsis.
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	/**
	 * Gets Movie Director.
	 *
	 * @return this Movie Director.
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Sets the Movie's Director.
	 *
	 * @param director Movie's director.
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * Gets Movie Casts.
	 *
	 * @return this Movie Casts.
	 */
	public ArrayList<String> getCasts() {
		return casts;
	}

	/**
	 * Sets the Movie's Casts.
	 *
	 * @param casts Movie's casts.
	 */
	public void setCasts(ArrayList<String> casts) {
		this.casts = casts;
	}

	/**
	 * Gets Movie Age Rating.
	 *
	 * @return this Movie Age Rating.
	 */
	public String getAgeRating() {
		return ageRating;
	}

	/**
	 * Sets the Movie's Age Rating.
	 *
	 * @param ageRating Movie's age rating.
	 */
	public void setAgerating(String ageRating) {
		this.ageRating = ageRating;
	}

	/**
	 * Gets Movie Showtime.
	 *
	 * @return this Movie Showtime.
	 */
	public ArrayList<Integer> getShowtimes() {
		return showTimes;
	}

	/**
	 * Sets the Movie's Showtime.
	 *
	 * @param showTimes Movie's showtimes.
	 */
	public void setShowTimes(ArrayList<Integer> showTimes) {
		this.showTimes = showTimes;
	}

	/**
	 * Gets Movie Ticket Sales.
	 *
	 * @return this Movie Ticket Sales.
	 */
	public int getTicketSales() {
		return ticketSales;
	}

	/**
	 * Sets the Movie's Ticket Sales.
	 *
	 * @param ticketSales Movie's ticket sales.
	 */
	public void setTicketSales(int ticketSales) {
		this.ticketSales = ticketSales;
	}

	/**
	 * Gets Movie Past Reviews.
	 *
	 * @return this Movie Past Reviews.
	 */
	public ArrayList<Integer> getPastReview() {
		return pastReview;
	}

	/**
	 * Gets Movie Rating.
	 *
	 * @return this Movie Rating.
	 */
	public double getRatingStar() {
		return overallRating;
	}

	/**
	 * Gets which Cinema is Movie Showing in.
	 *
	 * @return the Cinema Number that the movie is Showing in.
	 */
	public int getCinemaNo() {
		return cinema;
	}

	/**
	 * Sets the Movie's Cinema Number.
	 *
	 * @param cinema Movie's cinema number.
	 */
	public void setCinemaNo(int cinema) {
		this.cinema = cinema;
	}

	/**
	 * Gets which Dates are the Movie showing.
	 *
	 * @return the Dates that the Movie is showing.
	 */
	public ArrayList<LocalDate> getDate() {
		return date;
	}

	/**
	 * Sets the Movie's Dates.
	 *
	 * @param date Movie's dates.
	 */
	public void setDate(ArrayList<LocalDate> date) {
		this.date = date;
	}

	/**
	 * To allow customer to rate movie and calculate the average rating score thus
	 * far.\
	 *
	 * @param customerRating the rating customer gave to the movie.
	 */
	public void calOverallRating(int customerRating) {
		pastReview.add(customerRating);
		if (overallRating == 0)
			overallRating = customerRating;
		else {
			overallRating = (overallRating * (pastReview.size() - 1) + customerRating) / pastReview.size();
		}
	}

	/**
	 * Prints all of the movie information.
	 */
	public void printInfo() {
		System.out.println("name: " + this.name + "\nmovieId: " + this.movieId + "\nthreeD: " + this.threeD
				+ "\nblockbuster: " + this.blockbuster + "\nstatus: " + this.status + "\nsynopsis: " + this.synopsis
				+ "\ndirector: " + this.director + "\ncasts: " + this.casts + "\nageRating: " + this.ageRating
				+ "\noveralRating: " + this.overallRating + "\npastReview: " + this.pastReview + "\nticketSales: "
				+ this.ticketSales + "\nshowTimes: " + this.showTimes + "\ncinema: " + this.cinema + "\ndates: "
				+ this.date);
	}

	/**
	 * To allow the movies to be sorted by Ticket Sales.
	 */
	public static Comparator<Movie> byTicketSales = new Comparator<Movie>() {

		public int compare(Movie m1, Movie m2) {

			int ticketSales1 = m1.getTicketSales();
			int ticketSales2 = m2.getTicketSales();

			/* For ascending order */
			// return ticketSales1-ticketSales2;

			/* For descending order */
			return ticketSales2 - ticketSales1;
		}
	};

	/**
	 * To allow the movie to be sorted by Rating.
	 */
	public static Comparator<Movie> byRating = new Comparator<Movie>() {

		public int compare(Movie m1, Movie m2) {

			/* For ascending order */
			// return Double.compare(m1.getRatingStar(), m2.getRatingStar());

			/* For descending order */
			return Double.compare(m2.getRatingStar(), m1.getRatingStar());
		}
	};
}