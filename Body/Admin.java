package Body;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements Serializable {
	private String name;
	private String loginID;
	private String password;
	private boolean loop;

	public Admin(String name, String loginID, String password) {
		this.name = name;
		this.loginID = loginID;
		this.password = password;
		this.loop = true;
	}

	public void createAdmin(String name, String loginID, String password, ArrayList<Admin> adminList) {
		adminMethods.newAdmin(name, loginID, password, adminList);
	}

	public String getName() {
		return this.name;
	}

	public String getLoginID() {
		return this.loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void printInfo() {
		String info = "Name: " + name + "    | Username: " + loginID + "    | Password: " + password;
		System.out.println(info + '\n');
	}

	public void uploadMovie(ArrayList<Movie> movieList) throws FileNotFoundException {
		// reads csv and import movies
		movieMethods.create(movieList);
	}

	public void printMovies(ArrayList<Movie> movieList) {
		movieMethods.printSummarised(movieList);
	}

	public void printMovieDetailed(ArrayList<Movie> movieList) {
		movieMethods.printDetailed(movieList);
	}

	public void printMovieSales(ArrayList<Movie> movieList) {
		movieMethods.sortBySales(movieList);
	}

	public void printMovieRating(ArrayList<Movie> movieList) {
		movieMethods.sortByRating(movieList);
	}

	public void updateMovie(ArrayList<Movie> movieList) {
		movieMethods.updateInfo(movieList);
	}

	public void removeMovie(ArrayList<Movie> movieList) {
		movieMethods.deleteMovie(movieList);
	}

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
				System.out.println("Enter New Admin Name:");
				String createName = sc.nextLine();
				System.out.println("Enter New Admin Username:");
				String createUsername = sc.nextLine();
				System.out.println("Enter New Admin Password:");
				String createPassword = sc.nextLine();
				createAdmin(createName, createUsername, createPassword, adminList);
				loop = false;
			}
			default -> {
			}
			}
		}
	}
}
