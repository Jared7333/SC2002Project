public class Cinema extends Cineplex{
	private int cinemaId;
	private int status; // 1 means vacant, 0 means taken
	private static int seatCount = 50;
	private int layout[] = new int[100];

	private CinemaSeats[] seat = new CinemaSeats[seatCount]; // if put static here will have the problem where selecting
														// selecting seats in one row, changes the value of other
														// elements in the same row
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

	public static int getSeatCount() {
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

			if ((i+1)%6==0) {
				System.out.print("   ");

			}else if(size-14<i+1 && i%2==0) {
				System.out.print(" ");
			}else {
				System.out.print("|");
			}

			if((i+1)%12==0) {
				System.out.println();
				System.out.print("|");
			}
			
			/*if ((i + 1) % 10 == 0 && i + 1 != 50) {
				System.out.println();
				System.out.print("|");
			}*/
		}
		System.out.print("\n");
	}

	public void assignSeat(int seatId) 
	{
		if (seat[seatId].isOccupied() == true) 
		{
			System.out.println("Seat already assigned to a customer.");
			return;
		}
		else if(seatId>1 && seatId<48 )
		{
			if(seat[seatId-1].isOccupied()==false && seat[seatId-2].isOccupied()==true && (seatId-2)%12==0 && seatId<(Cinema.getSeatCount()-14) ||
			   seat[seatId+1].isOccupied()==false && seat[seatId+2].isOccupied()==true && (seatId+2)%12==1 && seatId<(Cinema.getSeatCount()-14) ||
			   seat[seatId-1].isOccupied()==false && seat[seatId-2].isOccupied()==true && seatId<(Cinema.getSeatCount()-14) ||
			   seat[seatId+1].isOccupied()==false && seat[seatId+2].isOccupied()==true && seatId<(Cinema.getSeatCount()-14) ||
			   seat[seatId+1].isOccupied()==false && (seatId+3)%12==1 && seatId<(Cinema.getSeatCount()-14) ||
			   seat[seatId-1].isOccupied()==false && (seatId-1)%12==0 && seatId<(Cinema.getSeatCount()-14) ||
			   seat[seatId+1].isOccupied()==false && (seatId+2)%6==0 && (seatId+3)%2==1 && seatId<(Cinema.getSeatCount()-14) ||
			   seat[seatId-1].isOccupied()==false && (seatId-1)%6==0 && (seatId)%2==1 && seatId<(Cinema.getSeatCount()-14)) 
			{
				System.out.println("Invalid seat - do not leave a single seat empty");
				return;
			}
			
			else if(seatId+1>(Cinema.getSeatCount()-14)) 
			{
				if((seatId+1)%2==0) 
				{
					seat[seatId].assign(seatId);
					seat[seatId-1].assign(seatId);
					System.out.println("Couple seats assigned!");
				}
				else 
				{
					seat[seatId].assign(seatId);
					seat[seatId+1].assign(seatId);
					System.out.println("Couple seats assigned!");
				}
			}
			else
			{
				seat[seatId].assign(seatId);
				System.out.println("Seat Assigned!");	}
		}
		else if(seatId!=0)
		{
			if(seat[seatId-1].isOccupied()==false && (seatId-1)%12==0 && seatId<(Cinema.getSeatCount()-14)) 
					{
						System.out.println("Invalid seat - do not leave a single seat empty");
						return;
					}
			else if(seatId+1>(Cinema.getSeatCount()-14)) 
			{
				if((seatId+1)%2==0) 
				{
					seat[seatId].assign(seatId);
					seat[seatId-1].assign(seatId);
					System.out.println("Couple seats assigned!");
				}
				else 
				{
					seat[seatId].assign(seatId);
					seat[seatId+1].assign(seatId);
					System.out.println("Couple seats assigned!");
				}
			}
			else
			{
				seat[seatId].assign(seatId);
				System.out.println("Seat Assigned!");
			}
		}
		else
		{
			seat[seatId].assign(seatId);
			System.out.println("Seat Assigned!");
		}
	}
}
