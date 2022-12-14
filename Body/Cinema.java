package Body;

import java.util.Scanner;

/**
 * Contains information of a cinema. Including cinema ID, 
 * number of seats, status. Able to print out the layout 
 * of the cinema.
 */
public class Cinema extends Cineplex {
	/**
	 * Cinema ID.
	 */
	private int cinemaId;
	/**
	 * Status of cinema.
	 */
	private int status; // 1 means vacant, 0 means taken
	/**
	 * Number of seats in the cinema.
	 */
	private static int seatCount = 50;
	/**
	 * An array of seats.
	 */
	private int layout[] = new int[100];
	Scanner sc = new Scanner(System.in);
	/**
	 * Create cinema seats based on the
	 * number of seats in the cinema.
	 */
	private CinemaSeats[] seat = new CinemaSeats[seatCount]; // if put static here will have the problem where selecting
	// selecting seats in one row, changes the value of other
	// elements in the same row
	// private static Ticket[] tickets = new Ticket[50];

	/**
	 * Cinema's class.
	 */
	private static String cinemaClass;
	/**
	 * Creates new cinema with given cinema ID and
	 * number of seats.
	 * @param cinemaId cinema's ID.
	 * @param seatCount number of seats.
	 */
	public Cinema(int cinemaId, int seatCount) {
		this.cinemaId = cinemaId;
		for (int i = 0; i < seatCount; i++) {
			seat[i] = new CinemaSeats(i);
		}
	}
	/**
	 * Gets cinema's ID.
	 * @return this cinema's ID.
	 */
	public int getCinemaId() {
		return cinemaId;
	}
	/**
	 * Sets cinema's ID.
	 * @param cinemaId cinema's ID.
	 */
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}
	/**
	 * Gets number of seats.
	 * @return this number of seats.
	 */
	public static int getSeatCount() {
		return seatCount;
	}
	/**
	 * Sets number of seats.
	 * @param seatCount number of seats.
	 */
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	/**
	 * Gets status of a cinema.
	 * @return this cinema's status.
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * Sets status of a cinema.
	 * @param status cinema's status.
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * Gets the class of a cinema.
	 * @return this cinema's class.
	 */
	public static String getCinemaClass() {
		return cinemaClass;
	}
	/**
	 * Sets the class of a cinema.
	 * @param cinemaClass cinema's class.
	 */
	public void setCinemaClass(String cinemaClass) {
		this.cinemaClass = cinemaClass;

	}
	/**
	 * Print the layout of the cinema based on the
	 * number of seats.
	 * @param seatId number of seats.
	 */
	public void cinemaLayout(int seatId) {
		int size = 50; // seatCount

		int s = 1;

//		int seatId = 26; // get from ticket class
		// Assigning seat numbers
		for (int i = 0; i < size; i++) {
			layout[i] = s++;
//			System.out.println(seat[seatId].isOccupied());
		}

		// Printing layout
		System.out.println("                Screen                ");
		System.out.println("--------------------------------------");
		System.out.print("|");
		for (int i = 0; i < size; i++) {

			if ((layout[i] == seatId) || (seat[i].isOccupied() == true)) {
				layout[i] = 00; // 00 means taken
			}

			if (layout[i] < 10) {
				System.out.print("0" + layout[i]);
			} else {
				System.out.print(layout[i]);

			}

			if ((i + 1) % 6 == 0) {
				System.out.print("   ");

			} else if (size - 14 < i + 1 && i % 2 == 0) {
				System.out.print(" ");
			} else {
				System.out.print("|");
			}

			if ((i + 1) % 12 == 0) {
				System.out.println();
				System.out.print("|");
			}

			/*
			 * if ((i + 1) % 10 == 0 && i + 1 != 50) { System.out.println();
			 * System.out.print("|"); }
			 */
		}
		System.out.print("\n");
	}
	/**
	 * Assigning of seats based on seatId.
	 * Able to check if the selected seat will leave a single
	 * blank seat, which is not allowed.
	 * If couple seats is chosen, 2 seats will be assigned.
	 * @param seatId seat ID
	 */
	public void assignSeat(int seatId) {
		while (true) {
			if (seat[seatId].isOccupied() == true) {
				System.out.println("Seat already assigned to a customer.");
				System.out.println("Please choose another seat.");
				cinemaLayout(0);
				seatId = sc.nextInt();
				seatId--;
				continue;

			} else if (seatId > 1 && seatId < 48) {
				if (seat[seatId - 1].isOccupied() == false && seat[seatId - 2].isOccupied() == true
						&& (seatId - 2) % 12 == 0 && seatId < (Cinema.getSeatCount() - 14)
						|| seat[seatId + 1].isOccupied() == false && seat[seatId + 2].isOccupied() == true
								&& (seatId + 2) % 12 == 1 && seatId < (Cinema.getSeatCount() - 14)
						|| seat[seatId - 1].isOccupied() == false && seat[seatId - 2].isOccupied() == true
								&& seatId < (Cinema.getSeatCount() - 14)
						|| seat[seatId + 1].isOccupied() == false && seat[seatId + 2].isOccupied() == true
								&& seatId < (Cinema.getSeatCount() - 14)
						|| seat[seatId + 1].isOccupied() == false && (seatId + 3) % 12 == 1
								&& seatId < (Cinema.getSeatCount() - 14)
						|| seat[seatId - 1].isOccupied() == false && (seatId - 1) % 12 == 0
								&& seatId < (Cinema.getSeatCount() - 14)
						|| seat[seatId + 1].isOccupied() == false && (seatId + 2) % 6 == 0 && (seatId + 3) % 2 == 1
								&& seatId < (Cinema.getSeatCount() - 14)
						|| seat[seatId - 1].isOccupied() == false && (seatId - 1) % 6 == 0 && (seatId) % 2 == 1
								&& seatId < (Cinema.getSeatCount() - 14)) {
					System.out.println("Invalid seat - do not leave a single seat empty");
					System.out.println("Please choose another seat.");
					cinemaLayout(0);
					seatId = sc.nextInt();
					seatId--;
					continue;
				}

				else if (seatId + 1 > (Cinema.getSeatCount() - 14)) {
					if ((seatId + 1) % 2 == 0) {
						seat[seatId].assign(seatId);
						seat[seatId - 1].assign(seatId);
						System.out.println("Couple seats assigned!");
					} else {
						seat[seatId].assign(seatId);
						seat[seatId + 1].assign(seatId);
						System.out.println("Couple seats assigned!");
					}
				} else {
					seat[seatId].assign(seatId);
					System.out.println("Seat Assigned!");
				}
			} else if (seatId != 0) {
				if (seat[seatId - 1].isOccupied() == false && (seatId - 1) % 12 == 0
						&& seatId < (Cinema.getSeatCount() - 14)) {
					System.out.println("Invalid seat - do not leave a single seat empty");
					System.out.println("Please choose another seat.");
					cinemaLayout(0);
					seatId = sc.nextInt();
					seatId--;
					continue;
				} else if (seatId + 1 > (Cinema.getSeatCount() - 14)) {
					if ((seatId + 1) % 2 == 0) {
						seat[seatId].assign(seatId);
						seat[seatId - 1].assign(seatId);
						System.out.println("Couple seats assigned!");
					} else {
						seat[seatId].assign(seatId);
						seat[seatId + 1].assign(seatId);
						System.out.println("Couple seats assigned!");
					}
				} else {
					seat[seatId].assign(seatId);
					System.out.println("Seat Assigned!");
				}
			} else {
				seat[seatId].assign(seatId);
				System.out.println("Seat Assigned!");

			}
			break;
		}
	}
}
