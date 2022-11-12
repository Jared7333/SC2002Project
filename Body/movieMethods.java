package Body;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class movieMethods {
	public static void create(ArrayList<Movie> movieList) throws FileNotFoundException {
		// reads csv and import movies
		String path = System.getProperty("user.dir") + "\\src\\Body\\" + "newMovies.txt";
		Scanner file = new Scanner(new File(path));
		while (file.hasNextLine()) {
			String str = file.nextLine();
			String[] info = str.split(":");
			System.out.println(str);
			for (String s : info) {
				System.out.println(s);
			}
			String[] casts1 = info[7].split(",");
			ArrayList<String> casts2 = new ArrayList<String>();
			for (String s : casts1) {
				casts2.add(s);
			}
			String[] pastReview1 = info[9].split(",");
			ArrayList<Integer> pastReview2 = new ArrayList<Integer>();
			for (String s : pastReview1) {
				if (!s.isEmpty()) {
					pastReview2.add(Integer.parseInt(s));
				}
			}
			String[] showTimes1 = info[11].split(",");
			ArrayList<Integer> showTimes2 = new ArrayList<Integer>();
			for (String s : showTimes1) {
				showTimes2.add(Integer.parseInt(s));
			}
			movieList.add(new Movie(info[0], Integer.parseInt(info[1]), Boolean.parseBoolean(info[2]),
					Boolean.parseBoolean(info[3]), info[4], info[5], info[6], casts2, info[8], pastReview2,
					Integer.parseInt(info[10]), showTimes2, Integer.parseInt(info[12])));
		}
	}

	public static void printSummarised(ArrayList<Movie> movieList) {
		System.out.println("List of Movies:");
		for (int i = 0; i < movieList.size(); i++) {
			System.out.printf("(%d): %s \n", i + 1, movieList.get(i).getName());
		}
		System.out.println();
	}

	public static void printDetailed(ArrayList<Movie> movieList) {
		Scanner sc = new Scanner(System.in);
		printSummarised(movieList);
		boolean loop = true;
		while (loop) {
			System.out.println("\nEnter '0' to Cancel\nSelect Row ID to Print Full Information: ");
			int rowID = sc.nextInt();
			sc.nextLine();
			if (rowID == 0) {
				loop = false;
			} else if (rowID < 0 || rowID > movieList.size()) {
				System.out.println("Invalid Row ID");
			} else {
				rowID--;
				movieList.get(rowID).printInfo();
			}
		}
	}

	public static void sortBySales(ArrayList<Movie> movieList) {
		ArrayList<Movie> tempList = new ArrayList<>(movieList);
		System.out.println("Sorted by Ticket Sales:");
		Collections.sort(tempList, Movie.byTicketSales);
		int index = 1;
		for (Movie mov : tempList) {
			System.out.printf("(%d) %s    | Sales: %d\n", index, mov.getName(), mov.getTicketSales());
			index++;
			if (index > 5) {
				break;
			}
		}
	}

	public static void sortByRating(ArrayList<Movie> movieList) {
		ArrayList<Movie> tempList = new ArrayList<>(movieList);
		System.out.println("Sorted by Rating:");
		Collections.sort(tempList, Movie.byRating);
		int index = 1;
		for (Movie mov : tempList) {
			System.out.printf("(%d) %s    | Rating: %.2f\n", index, mov.getName(), mov.getRatingStar());
			index++;
			if (index > 5) {
				break;
			}
		}
	}

	public static void deleteMovie(ArrayList<Movie> movieList) {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		printSummarised(movieList);
		while (loop) {
			System.out.println("Enter '0' to Cancel\nEnter Row ID to Remove: ");
			int rowID = sc.nextInt();
			sc.nextLine();
			if (rowID == 0) {
				loop = false;
			} else if (rowID < 0 || rowID > movieList.size()) {
				System.out.println("Invalid Row ID");
			} else {
				movieList.remove(rowID - 1);
				System.out.println("Deleted Successfully");
				printSummarised(movieList);
			}
		}
	}

	public static void updateInfo(ArrayList<Movie> movieList) {
		Scanner sc = new Scanner(System.in);
		printSummarised(movieList);
		int rowID = 0;
		boolean loop = true;
		if (movieList.size() == 0) {
			System.out.println("No movies in list");
			return;
		}
		while (loop) {

			System.out.println("Enter Row ID to Update: ");
			rowID = sc.nextInt();
			sc.nextLine();
			if (rowID <= 0 || rowID > movieList.size()) {
				System.out.println("Invalid Row ID");
			} else {
				rowID--;
				loop = false;
			}
		}
		System.out.println("""
				Enter Column to Update:
				(1)Movie Name
				(2)Movie ID
				(3)3D / Blockbuster
				(4)Movie Status
				(5)Synopsis
				(6)Director
				(7)Casts
				(8)Age Rating
				(9)Showtimes
				(10)Cinema Number
				(0)Exit""");
		String colName = sc.nextLine();
		switch (colName) {
		case "1": // movie name
			System.out.println("Current Name: " + movieList.get(rowID).getName());
			System.out.println("Enter '0' to Cancel\nEnter New Name: ");
			String newName = sc.nextLine();
			if (newName.equals("0")) {
				break;
			}
			movieList.get(rowID).setName(newName);
			break;
		case "2": // movie id
			System.out.println("Current Movie ID: " + movieList.get(rowID).getMovieId());
			System.out.println("Enter '0' to Cancel\nEnter New Movie ID: ");
			int newID = sc.nextInt();
			sc.nextLine();
			if (newID == 0) {
				break;
			}
			movieList.get(rowID).setMovieId(newID);
			break;
		case "3": // 3D or blockbuster
			String newThreeD = null;
			String newBlockbuster = null;
			System.out.println("Current Movie Type:");
			if (movieList.get(rowID).getThreeD()) {
				System.out.print("3D");
			} else {
				System.out.print("NOT 3D");
			}
			if (movieList.get(rowID).getBlockbuster()) {
				System.out.print(" and Blockbuster");
			} else {
				System.out.print(" and NOT Blockbuster");
			}
			System.out.println("Enter New Movie Type: ");
			while (!newThreeD.matches("y") || !newThreeD.matches("n")) {
				System.out.println("Is Movie 3D? [Y/N]");
				newThreeD = sc.nextLine();
				newThreeD.toLowerCase();
			}
			while (!newBlockbuster.matches("y") || !newBlockbuster.matches("n")) {
				System.out.println("Is Movie Blockbuster? [Y/N]");
				newBlockbuster = sc.nextLine();
				newBlockbuster.toLowerCase();
			}
			if (newThreeD.matches("y")) {
				newThreeD = "true";
			} else {
				newThreeD = "false";
			}
			if (newBlockbuster.matches("y")) {
				newBlockbuster = "true";
			} else {
				newBlockbuster = "false";
			}
			movieList.get(rowID).setThreeD(Boolean.parseBoolean(newThreeD));
			movieList.get(rowID).setBlockbuster(Boolean.parseBoolean(newBlockbuster));
			break;
		case "4": // status
			System.out.println("Current Status: " + movieList.get(rowID).getStatus());
			System.out.println("Enter New Status: ");
			System.out.println("(1) Showing");
			System.out.println("(2) Preview");
			System.out.println("(3) Coming Soon");
			System.out.println("(4) End of Showing");
			System.out.println("(0) Exit");

			int newStatusID = sc.nextInt();
			if (newStatusID == 0) {
				break;
			}
			String newStatus = "Now Showing";
			if (newStatusID == 1) {
				newStatus = "Showing";
			} else if (newStatusID == 2) {
				newStatus = "Preview";
			} else if (newStatusID == 3) {
				newStatus = "Coming Soon";
			} else if (newStatusID == 4) {
				newStatus = "End Of Showing";
			} else {
				System.out.println("Invalid Choice");
				break;
			}
			movieList.get(rowID).setStatus(newStatus);
			System.out.println(movieList.get(rowID).getName() + " is now set to " + newStatus + ".");
			break;
		case "5": // synopsis
			System.out.println("Current Synopsis: " + movieList.get(rowID).getSynopsis());
			System.out.println("Enter New Synopsis: ");
			String newSynopsis = sc.nextLine();
			if (newSynopsis.equals("0")) {
				break;
			}
			movieList.get(rowID).setSynopsis(newSynopsis);
			break;
		case "6": // director
			System.out.println("Current Director: " + movieList.get(rowID).getDirector());
			System.out.println("Enter New Director: ");
			String newDirector = sc.nextLine();
			if (newDirector.equals("0")) {
				break;
			}
			movieList.get(rowID).setDirector(newDirector);
			break;
		case "7": // casts
			ArrayList<String> currentCast;
			currentCast = movieList.get(rowID).getCasts();
			loop = true;
			while (loop) {
				System.out.printf("Current Cast:%s\n(1)Add\n(2)Remove\n(0)Exit\n", currentCast);
				String choice = sc.nextLine();
				choice.toLowerCase();
				switch (choice) {
				case "1", "add" -> {
					System.out.println("Enter Cast Name:");
					String newCast = sc.nextLine();
					currentCast.add(newCast);
				}
				case "2", "remove" -> {
					int removeCast = -1;
					while (removeCast < 0 || removeCast > currentCast.size() - 1) {
						for (int i = 0; i < currentCast.size(); i++) {
							System.out.printf("(%d) %s\n", i + 1, currentCast.get(i));
						}
						System.out.println("Enter Index of Cast to Remove:");
						removeCast = sc.nextInt();
						sc.nextLine();
						removeCast--;
					}
					currentCast.remove(removeCast);
				}
				case "0", "exit" -> {
					movieList.get(rowID).setCasts(currentCast);
					loop = false;
				}
				}
			}
			break;
		case "8": // age rating
			System.out.println("Current Age Rating: " + movieList.get(rowID).getAgeRating());
			System.out.println("Enter New Age Rating: ");
			String newAgeRating = sc.nextLine();
			if (newAgeRating.equals("0")) {
				break;
			}
			movieList.get(rowID).setAgerating(newAgeRating);
			break;
		case "9": // showtimes

			ArrayList<Integer> currentTimes;
			currentTimes = movieList.get(rowID).getShowtimes();

			int cinId = movieList.get(rowID).getCinemaNo(); // get cinemaId of the chosen movie

			ArrayList<Integer> takenTimes = new ArrayList<>(); // used to store all time slot of a cinemaNo
			ArrayList<Integer> spareList = new ArrayList<>(); // a temporary list used to aid adding all time slot to
																// takenTimes
			ArrayList<String> moviesWithinSameCinema = new ArrayList<String>(); // store movies within the same cinema
			loop = true;
			while (loop) {
				takenTimes.clear();
				moviesWithinSameCinema.clear();
				for (int i = 0; i < movieList.size(); i++) {
					if (movieList.get(i).getCinemaNo() == cinId) { // add all time slots of a cinemaNo into takenTimes
						spareList = movieList.get(i).getShowtimes();
						takenTimes.addAll(spareList);
						if (movieList.get(i).getShowtimes().size() > 0) { // add movie to list only if there is at least
																			// 1 time slot
							moviesWithinSameCinema.add(movieList.get(i).getName());
						}
					}
				}
				Collections.sort(takenTimes);
				System.out.printf("Current Showtimes in the same Cinema %s:%s\n(1) Add\n(2) Remove\n(0) Exit\n",
						moviesWithinSameCinema, takenTimes);
				if (movieList.get(rowID).getShowtimes().size() <= 0) // alert user that movie has no time slot
					System.out.printf("Note: %s currently has no time slot\n", movieList.get(rowID).getName());
				String choice = sc.nextLine();
				choice.toLowerCase();
				switch (choice) {
				case "1", "add" -> {
					while (true) {
						boolean invalidTimeSlot = false; // used to keep track whether there is a clash
						System.out.println("Enter New Showtime (must in an hour):\n(-1) Exit");
						int newTime = sc.nextInt();
						sc.nextLine();
						if (newTime <= -1)
							break;
						if(newTime%100!=0) {
							System.out.println("Time must be an hour!");
							continue;
						}
						newTime = newTime%2400;
						
						for (int i = 0; i < takenTimes.size(); i++) { // check if the entered time slot has any clash
							if ( newTime == (takenTimes.get(i)-200)%2400 ||newTime == (takenTimes.get(i)-100)%2400 || newTime == takenTimes.get(i) || newTime == (takenTimes.get(i) + 100)%2400 || newTime == (takenTimes.get(i) + 200)%2400) { // when the chosen time slot is within the 3
																		// hours window of another time slot
								invalidTimeSlot = true; // a clash is found
							}
						}
						if (invalidTimeSlot) { // there is a clash
							System.out.println("New Showtime cannot be added to this time slot");
							System.out.printf("Current Showtimes in the same Cinema:%s\n", takenTimes);
							continue;
						}
							currentTimes.add(newTime); // add time if chosen time slot has no clash
							Collections.sort(currentTimes); // sort time for better display
							movieList.get(rowID).setShowTimes(currentTimes);
							break;
					}
				}
				case "2", "remove" -> {
					if (movieList.get(rowID).getShowtimes().size() == 0) { // if current movie has time slot to remove
																			// then do not go into remove process
						System.out.printf("There is no time slot for %s to remove\n\n", movieList.get(rowID).getName());
					} else { // if current movie has at least 1 time slot to remove
						int removeTime = -1;
						while (removeTime < 0 || removeTime > currentTimes.size() - 1) {
							System.out.printf("%s Showtimes:\n", movieList.get(rowID).getName()); // display movie name
							for (int i = 0; i < currentTimes.size(); i++) {
								System.out.printf("(%d) %s\n", i + 1, currentTimes.get(i));
							}
							System.out.printf("(0) Exit\n");
							System.out.println("Enter Index of Showtime to Remove:");
							removeTime = sc.nextInt();
							sc.nextLine();
							if (removeTime == 0) {
								removeTime--;
								break;
							}
							removeTime--;
						}
						if (removeTime > -1) {
							currentTimes.remove(removeTime);
							Collections.sort(currentTimes);
							movieList.get(rowID).setShowTimes(currentTimes);
						}
					}
				}
				case "0", "exit" -> {
					movieList.get(rowID).setShowTimes(currentTimes);
					loop = false;
				}
				}
			}
			break;
		case "10": // cinema number
			System.out.println("Current Cinema No.: " + movieList.get(rowID).getCinemaNo());
			System.out.println("Enter '0' to Cancel\nEnter New Cinema No.: ");
			int newCinema = sc.nextInt();
			sc.nextLine();
			if (newCinema == 0) {
				break;
			}
			movieList.get(rowID).setCinemaNo(newCinema);
			break;
		case "0": // exit
			break;
		}
	}
}