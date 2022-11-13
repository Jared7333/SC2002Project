package Body;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains Admin information. Admin can choose to upload new movies,
 * update existing movies and remove movies.
 * Admin can also change their password and create new admins.
 */
public class Admin implements Serializable {

	/**
	 * Admin name.
	 */
	private String name;

	/**
	 * Admin LoginID / Username.
	 */
	private String loginID;

	/**
	 * Admin Password.
	 */
	private String password;

	/**
	 * variable to use in while loops.
	 */
	private boolean loop;

	/**
	 * Declare Admin Object
	 *
	 * @param name
	 * @param loginID
	 * @param password
	 */
	public Admin(String name, String loginID, String password) {
		this.name = name;
		this.loginID = loginID;
		this.password = password;
		this.loop = true;
	}

	/**
	 * Allow existing Admin to create new Admin.
	 *
	 * @param name
	 * @param loginID
	 * @param password
	 * @param adminList
	 */
	public void createAdmin(String name, String loginID, String password, ArrayList<Admin> adminList) {
		adminMethods.newAdmin(name, loginID, password, adminList);
	}

	/**
	 * Gets Admin Name.
	 *
	 * @return this Admin name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets Admin loginID / Username.
	 *
	 * @return this Admin loginID / Username.
	 */
	public String getLoginID() {
		return this.loginID;
	}

	/**
	 * Sets the Admin loginID / Username.
	 *
	 * @param loginID Admin loginID.
	 */
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	/**
	 * Gets Admin Password.
	 *
	 * @return this Admin password.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the Admin Password.
	 *
	 * @param password Admin password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Prints current Admin information in a format.
	 */
	public void printInfo() {
		String info = "Name: " + name + "    | Username: " + loginID + "    | Password: " + password;
		System.out.println(info + '\n');
	}

	/**
	 * Allows Admin to upload new movies in a form of delimited file format.
	 *
	 * @param movieList adds newly added movie(s).
	 * @throws FileNotFoundException
	 */
	public void uploadMovie(ArrayList<Movie> movieList) throws FileNotFoundException {
		// reads csv and import movies
		movieMethods.create(movieList);
	}

	/**
	 * Allows Admin to print list of movie information in a summarised format.
	 *
	 * @param movieList access the movie objects stored to print it's information.
	 */
	public void printMovies(ArrayList<Movie> movieList) {
		movieMethods.printSummarised(movieList);
	}

	/**
	 * Allows Admin to print list of movie information in a detailed format.
	 *
	 * @param movieList access the movie objects stored to print it's information.
	 */
	public void printMovieDetailed(ArrayList<Movie> movieList) {
		movieMethods.printDetailed(movieList);
	}

	/**
	 * Allows Admin to print top movies sorted by sales.
	 *
	 * @param movieList create a copy for printing which is sorted by sales.
	 */
	public void printMovieSales(ArrayList<Movie> movieList) {
		movieMethods.sortBySales(movieList);
	}

	/**
	 * Allows Admin to print top movies sorted by rating.
	 *
	 * @param movieList create a copy for printing which is sorted by rating.
	 */
	public void printMovieRating(ArrayList<Movie> movieList) {
		movieMethods.sortByRating(movieList);
	}

	/**
	 * Allows Admin to update information of existing / uploaded movies.
	 *
	 * @param movieList to call setters to update selected movie's information.
	 */
	public void updateMovie(ArrayList<Movie> movieList) {
		movieMethods.updateInfo(movieList);
	}

	/**
	 * Allows Admin to remove movies from existing movies.
	 *
	 * @param movieList to remove the selected movie.
	 */
	public void removeMovie(ArrayList<Movie> movieList) {
		movieMethods.deleteMovie(movieList);
	}

	/**
	 * Allows Admin to select if they want to change password or create new admin
	 *
	 * @param adminList either to access current Admin account or add new Admin account to it.
	 */
	public void configureSettings(ArrayList<Admin> adminList) { // Change password or create new admin account
		Scanner sc = new Scanner(System.in);
		System.out.println("System Settings");
		loop = true;
		while (loop) {
			System.out.println("Select Action\n(1) Change Password\n(2) Add New Admin");
			int setting = sc.nextInt();
			sc.nextLine();
			switch (setting) {
			case 1 -> { // Change Password
				adminMethods.changePassword(adminList, this);
				loop = false;
			}
			case 2 -> { // Create new admin account
//				System.out.println("Enter New Admin Name:");
//				String createName = sc.nextLine();
				System.out.println("Enter New Admin Username:");
				String createUsername = sc.nextLine();
				System.out.println("Enter New Admin Password:");
				String createPassword = sc.nextLine();
				String createName = createUsername;
				createAdmin(createName, createUsername, createPassword, adminList);
				loop = false;
			}
			default -> {
			}
			}
		}
	}
}
