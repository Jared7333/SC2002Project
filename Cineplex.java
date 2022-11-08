package deonAssignment;

import java.io.IOException;

public class Cineplex 
{
	private static String[] cineplexName = {"Woodlands","Punggol","Changi"};
	private int noOfCinema=3;
	
	public static void showCineplex() throws IOException, ClassNotFoundException {
		System.out.println("Available cineplexes: ");

		for (int i = 0; i < cineplexName.length; i++) {
			System.out.println(cineplexName[i]);
		}
		System.out.println();
	}
}
