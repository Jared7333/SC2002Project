package Body;

import java.io.IOException;

/**
 * Contains name of cineplex owned by vendor.
 * Able to show all the cineplex available.
 */
public class Cineplex 
{
	/**
	 * List of cineplex owned by vendor
	 */
	private static String[] cineplexName = {"Woodlands","Punggol","Changi"};
	/**
	 * Number of cinema per cineplex
	 */
	private int noOfCinema=3;
	/**
	 * Display all the available cineplex
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void showCineplex() throws IOException, ClassNotFoundException {
		System.out.println("Available cineplexes: ");

		for (int i = 0; i < getCineplexName().length; i++) {
			System.out.println((i+1)+")"+getCineplexName()[i]);
		}
		System.out.println();
	}
	/**
	 * Gets cineplex name
	 * 
	 * @return this cineplex's name
	 */
	public static String[] getCineplexName() {
		return cineplexName;
	}
	/**
	 * Sets the cineplex name
	 * 
	 * @param cineplexName cineplex's name
	 */
	public static void setCineplexName(String[] cineplexName) {
		Cineplex.cineplexName = cineplexName;
	}
}
