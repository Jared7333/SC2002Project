
import java.util.ArrayList;
import java.util.Scanner;

abstract public class Transactions {
	ArrayList<Customer> customerList = new ArrayList();
	private int arrayCount = 0;

	public abstract String generateTID(int iD, String movieTitle);

	public Transactions() {
		customerList = new ArrayList<Customer>();
	}

	public void pastMovies(int iD) { // display past movies that customers bought ticket for
		System.out.println("Customer has watched: ");
		for (int i = 0; i < customerList.get(iD).pastMoviesTitles.size(); i++) {
			System.out.println(customerList.get(iD).pastMoviesTitles.get(i));
		}
		for (int i = 0; i < customerList.get(iD).pastTID.size(); i++) {
			System.out.println(customerList.get(iD).pastTID.get(i));
		}

	}

	public void buyTicket(int iD, String movieTitle) {
		Scanner sc = new Scanner(System.in);

		if (arrayCount < iD) { // create new element each time there is new iD

			// arraycount did not ++

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

	public int getAge(int iD) {
		return customerList.get(iD).getAge();
	};

}
