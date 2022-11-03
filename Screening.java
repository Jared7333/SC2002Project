package sc2002Project;

public class Screening extends Cinema {
//	private int cinemaId;
	private int time;
	private String movieTitle;
	private boolean threeD;
	private boolean blockbuster;
//	private String cinemaClass;
//	private String ageOfCust;
	private String dayOfWeek;
	private boolean publicHolidayOrEve;
	private int seatId;
//	private double price;

	// 3 cineplex total
	// each cineplex 3 or more cinema
//	Cinema newCinema = new Cinema(0, 50);
	Ticket[] tickets = new Ticket[50];

	public Screening(int cinemaId, int time) {
		super(cinemaId, 50);
		this.time = time;
		for (int i = 0; i < 50; i++) {
			tickets[i] = new Ticket();
		}
	}

	// Cinema -> CinemaSeats
	// Screnning: Cinema + ticket
	// Booking: transaction + customer + ticket
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;

	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public boolean isThreeD() {
		return threeD;
	}

	public void setThreeD(boolean threeD) {
		this.threeD = threeD;
	}

	public boolean isBlockbuster() {
		return blockbuster;
	}

	public void setBlockbuster(boolean blockbuster) {
		this.blockbuster = blockbuster;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public boolean isPublicHolidayOrEve() {
		return publicHolidayOrEve;
	}

	public void setPublicHolidayOrEve(boolean publicHolidayOrEve) {
		this.publicHolidayOrEve = publicHolidayOrEve;
	}

	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		seatId--;
		this.seatId = seatId;
		Screening.assignSeat(seatId);
		tickets[seatId].setseatId(seatId);
		tickets[seatId].settime(getTime());
		tickets[seatId].setmovieTitle(getMovieTitle());
		tickets[seatId].setthreeD(isThreeD());
		tickets[seatId].setblockbuster(isBlockbuster());
		tickets[seatId].setcinemaClass(Screening.getCinemaClass());
		tickets[seatId].setdayOfWeek(getDayOfWeek());
		tickets[seatId].setpublicHolidayOrEve(isPublicHolidayOrEve());
	}

}
