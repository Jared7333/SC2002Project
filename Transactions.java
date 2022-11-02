import java.util.ArrayList;
import java.util.Scanner;

public class Transactions {
	ArrayList<Customer> customerList = new ArrayList();
	private int arrayCount = 0;

	public Transactions() {
		customerList = new ArrayList<Customer>();
	}

	public void pastMovies(int iD) { // display past movies that customers bought ticket for
		System.out.println("Customer has watched: ");
		for (int i = 0; i < customerList.get(iD).pastMoviesTitles.size(); i++) {
			System.out.println(customerList.get(iD).pastMoviesTitles.get(i));
		}

	}

	public void buyTicket(int iD, String movieTitle) {
		Scanner sc = new Scanner(System.in);

		if (arrayCount < iD) { // create new element each time there is new iD
			for (int i = arrayCount; i <= iD; i++) {
				Customer c = new Customer();
				customerList.add(c);
			}
		}

		if (customerList.get(iD).customerBoughtBefore() == true) { // check if customer has bought ticket before, if
																	// yes, skip the personal details
			System.out.println("Customer already existed");
		} else {
			String name = sc.next();
			int phone = sc.nextInt();
			String email = sc.next();
			int age = sc.nextInt();

			customerList.get(iD).setID(iD);
			customerList.get(iD).setName(name);
			customerList.get(iD).setPhoneNo(phone);
			customerList.get(iD).setEmail(email);
			customerList.get(iD).setAge(age);
			customerList.get(iD).boughtBefore = true;
		}

		System.out.println("Customer's ID: " + customerList.get(iD).getID());
		System.out.println("Customer's Name: " + customerList.get(iD).getName());
		System.out.println("Customer's Phone Number: " + customerList.get(iD).getPhoneNo());
		System.out.println("Customer's Email: " + customerList.get(iD).getEmail());
		System.out.println("Customer's Age: " + customerList.get(iD).getAge());
		customerList.get(iD).pastMoviesTitles.add(movieTitle); // update customer's watch history

	}

	public String generateTID(String movieTitle) { // generate TID, TID (3 letter code for Movie + date + hour + minute)

		String movie = "";
		int countForExcluding = 0;

		// Conversion of movie title to first letter of each word (up to 3 letters),
		// will repeat letter if not enough words
		for (int i = 0; i < movieTitle.length(); i++) {
			if (i == 0) {
				movie += Character.toUpperCase(movieTitle.charAt(i));
			} else if (movieTitle.charAt(i) == ' ') {
				movie += Character.toUpperCase(movieTitle.charAt(i + 1));
				countForExcluding++;
				if (countForExcluding == 2) {
					break;
				}
			}
			if (i + 1 == movieTitle.length()) {
				while (movie.length() != 3) {
					movie += movie.charAt(movie.length() - 1);
				}
			}
		}

		countForExcluding = 0;

		// Conversion of real date to String (and removal of '-')
		String date = "";
		String localDate = java.time.LocalDate.now().toString();
		for (int i = 0; i < localDate.length(); i++) {
			if (localDate.charAt(i) == '-') {
				continue;
			}
			date += localDate.charAt(i);
		}

		// Conversion of real time to String (and removal of ':')
		String time = "";
		String localTime = java.time.LocalTime.now().toString();
		for (int i = 0; i < localTime.length(); i++) {
			if (localTime.charAt(i) == ':') {
				if (countForExcluding == 1) {
					break;
				}
				countForExcluding++;
				continue;
			}
			time += localTime.charAt(i);
		}

		String moviePlusDatePlusTime = movie + date + time;
		return moviePlusDatePlusTime;
	}

}
