package Body;

/**
 * Contains information about a particular screening.
 */
public class Screening extends Cinema {
	/**
	 * Which cinema the screening is in.
	 */
	private int cinemaId;
	/**
	 * What time the screening is.
	 */
	private int time;
	/**
	 * What movie the screening will show.
	 */
	private String movieTitle;
	/**
	 * Whether the movie screened is in 3D.
	 */
	private boolean threeD;
	/**
	 * Whether the movie screened is a blockbuster.
	 */
	private boolean blockbuster;
//	private String cinemaClass;
//	private String ageOfCust;
	/**
	 * The day of the week the screening is held.
	 */
	private String dayOfWeek;
	/**
	 * Whether the screening is on a public holiday or its eve.
	 */
	private boolean publicHolidayOrEve;
	/**
	 * The seat ID.
	 */
	private int seatId;
//	private double price;

	// 3 cineplex total
	// each cineplex 3 or more cinema
//	Cinema newCinema = new Cinema(0, 50);
	/**
	 * List of tickets.
	 */
	public Ticket[] tickets = new Ticket[50];

	/**
	 * Creates a screening.
	 * @param cinemaId the screening's cinemaID.
	 * @param time the screening's time.
	 */
	public Screening(int cinemaId, int time) {
		super(cinemaId, 50);
		this.time = time;

		for (int i = 0; i < 50; i++) {
			tickets[i] = new Ticket();
		}
	}

	
	/** 
	 * Gets the cinema ID.
	 * @return the cinema's ID.
	 */
	// Cinema -> CinemaSeats
	// Screnning: Cinema + ticket
	// Booking: transaction + customer + ticket

	public int getCinemaId() {
		return cinemaId;
	}

	
	/** 
	 * Sets the cinema's ID.
	 * @param cinemaId the cinema's ID.
	 */
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}

	
	/** 
	 * Gets the screening time.
	 * @return the screening time.
	 */
	public int getTime() {
		return time;
	}

	
	/** 
	 * Sets the screening time.
	 * @param time the screening time.
	 */
	public void setTime(int time) {
		this.time = time;

	}

	
	/** 
	 * Get the movie's title.
	 * @return the movie's title.
	 */
	public String getMovieTitle() {
		return movieTitle;
	}

	
	/** 
	 * Sets the movie's title.
	 * @param movieTitle the movie's title.
	 */
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	
	/** 
	 * Get the movie's 3D status.
	 * @return movie's 3D status.
	 */
	public boolean isThreeD() {
		return threeD;
	}

	
	/** 
	 * Set movie's 3D status.
	 * @param threeD movie's 3D status.
	 */
	public void setThreeD(boolean threeD) {
		this.threeD = threeD;
	}

	
	/** 
	 * Get movie's blockbuster status.
	 * @return movie's blockbuster status.
	 */
	public boolean isBlockbuster() {
		return blockbuster;
	}

	
	/** 
	 * Set movie's blockbuster status.
	 * @param blockbuster movie's blockbuster status.
	 */
	public void setBlockbuster(boolean blockbuster) {
		this.blockbuster = blockbuster;
	}

	
	/** 
	 * Get day of the week of screening.
	 * @return day of the week of screening.
	 */
	public String getDayOfWeek() {
		return dayOfWeek;
	}

	
	/** 
	 * Set day of the week of screening.
	 * @param dayOfWeek day of the week of screening.
	 */
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	
	/** 
	 * Get public holiday or eve status.
	 * @return public holiday or eve status.
	 */
	public boolean isPublicHolidayOrEve() {
		return publicHolidayOrEve;
	}

	
	/** 
	 * Set public holiday or eve status.
	 * @param publicHolidayOrEve public holiday or eve status.
	 */
	public void setPublicHolidayOrEve(boolean publicHolidayOrEve) {
		this.publicHolidayOrEve = publicHolidayOrEve;
	}

	
	/** 
	 * get seat ID.
	 * @return the seat ID.
	 */
	public int getSeatId() {
		return seatId;
	}

	
	/** 
	 * Sets seat ID. Fills in the attributes of ticket 
	 * that corresponds to the seat ID.
	 * @param seatId the seat ID.
	 */
	public void setSeatId(int seatId) {
		seatId--;
		this.seatId = seatId;
		assignSeat(seatId);
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
