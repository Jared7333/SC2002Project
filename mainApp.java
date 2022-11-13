import java.io.IOException;

import Boundary.MainMenuUI;

/**
 * The start of the app. Creates a main menu object and calls it
 */
public class mainApp {
	/**
	 * Creates Main Menu
	 * 
	 * @param args args.
	 * @throws ClassNotFoundException Error Check.
	 * @throws IOException            Error Check.
	 */
	public static void main(String args[]) throws ClassNotFoundException, IOException {
		MainMenuUI mm = new MainMenuUI();
		mm.main();
	}
}