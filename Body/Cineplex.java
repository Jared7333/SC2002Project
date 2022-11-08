package Body;

import java.io.IOException;

public class Cineplex 
{
	private static String[] cineplexName = {"Woodlands","Punggol","Changi"};
	private int noOfCinema=3;
	
	public static void showCineplex() throws IOException, ClassNotFoundException {
		System.out.println("Available cineplexes: ");

		for (int i = 0; i < getCineplexName().length; i++) {
			System.out.println((i+1)+")"+getCineplexName()[i]);
		}
		System.out.println();
	}

	public static String[] getCineplexName() {
		return cineplexName;
	}

	public static void setCineplexName(String[] cineplexName) {
		Cineplex.cineplexName = cineplexName;
	}
}
