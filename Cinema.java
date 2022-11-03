package sc2002Project;

public class Cinema {
	private int cinemaId;
	private int status; // 1 means vacant, 0 means taken
	private int seatCount = 50;
	private static int layout[] = new int[100];

	private static CinemaSeats[] seat = new CinemaSeats[50];
//	private static Ticket[] tickets = new Ticket[50];
	// private int availSeats;
	// private int unavailSeats;
	// private String cinemaLocation;
	private static String cinemaClass;

	public Cinema(int cinemaId, int seatCount) {
		this.cinemaId = cinemaId;
		for (int i = 0; i < seatCount; i++) {
			seat[i] = new CinemaSeats(i);
		}
	}

	public int getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int status) {
		this.seatCount = seatCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public static String getCinemaClass() {
		return cinemaClass;
	}

	public void setCinemaClass(String cinemaClass) {
		this.cinemaClass = cinemaClass;
		
	}

	public static void cinemaLayout(int seatId) {
		int size = 50; // seatCount

		int s = 1;

//		int seatId = 26; // get from ticket class
		// Assigning seat numbers
		for (int i = 0; i < size; i++) {
			layout[i] = s++;
//			System.out.println(seat[seatId].isOccupied());
		}

		// Printing layout
		System.out.println("             Screen             ");
		System.out.println("--------------------------------");
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

			if ((i + 1) % 10 != 0 && (i + 1) % 5 == 0) {
				System.out.print(" ");

			} else {
				System.out.print("|");
			}

			if ((i + 1) % 10 == 0 && i + 1 != 50) {
				System.out.println();
				System.out.print("|");
			}

		}
		System.out.print("\n");
	}

	public static void assignSeat(int seatId) {
		if (seat[seatId].isOccupied() == true) {
			System.out.println("Seat already assigned to a customer.");
			return;
		}
		seat[seatId].assign(seatId);
		System.out.println("Seat Assigned!");
//		tickets[seatId].setseatId(seatId);
	}
	

}
