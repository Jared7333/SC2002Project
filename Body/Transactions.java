package Body;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class Transactions {
	ArrayList<Customer> customerList = new ArrayList();
	private int arrayCount = 0;

	public Transactions() {
		customerList = new ArrayList<Customer>();
	}

	public void customerBookingHistory(int iD) {
		try {
			customerList.get(iD).checkBookingHistory();
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Customer does not exist");
			return;
		}
	}

	public void buyTicket(int iD, String movieTitle, int chosenCineplex) {
		Scanner sc = new Scanner(System.in);

//		if (arrayCount < iD) { // create new element each time there is new iD
//
//			for (int i = arrayCount; i <= iD; i++) {
//				Customer c = new Customer();
//				customerList.add(c);
//			}
//		}

		if (customerList.get(iD).customerBoughtBefore() == true) { // check if customer has bought ticket before, if
																	// yes, skip the personal details
			System.out.println("Obtaining details...");
		} else {
			System.out.println("For First booking, Please Enter your Name, PhoneNo, Email and Age");
			String name = sc.next();
			int phone = sc.nextInt();
			String email = sc.next();
			int age = sc.nextInt();

//			customerList.get(iD).setID(iD);
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
		TransactionID newTID = new TransactionID();
		customerList.get(iD).pastTID.add(newTID.generateTID(iD, movieTitle)); // update Customer's TID
		customerList.get(iD).pastCineplex.add(chosenCineplex);

	}

	public int getAge(int iD) {
		return customerList.get(iD).getAge();
	};

	public void setIDForFirstTimeUser(int iD) {
		if (arrayCount < iD) { // create new element each time there is new iD

			for (int i = arrayCount; i <= iD; i++) {
				Customer c = new Customer();
				customerList.add(c);
			}
		}
		customerList.get(iD).setID(iD);
	}

}