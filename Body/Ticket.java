package Body;

/**
 * Contains ticket information. Able to calculate ticket price and display its
 * own information.
 */
public class Ticket {
	/**
	 * The movie's title.
	 */
	private String movieTitle;
	/**
	 * The movie's 3D status.
	 */
	private boolean threeD;
	/**
	 * The movie's blockbuster status.
	 */
	private boolean blockbuster;
	/**
	 * The movie's cinema class.
	 */
	private String cinemaClass;
	/**
	 * The age of the customer.
	 */
	private int ageOfCust;
	/**
	 * Whether the customer is a student.
	 */
	private boolean student;
	/**
	 * Whether the customer has a preferred credit or loyalty card.
	 */
	private boolean preferredCreditAndLoyaltyCards;
	/**
	 * The day of the week of the screening.
	 */
	private String dayOfWeek;
	/**
	 * Whether the screening is on a public holiday or eve.
	 */
	private boolean publicHolidayOrEve;
	/**
	 * The screening's time.
	 */
	private int time;
	/**
	 * The customer's seat ID.
	 */
	private int seatId;
	/**
	 * The ticket's price.
	 */
	private double price;

	/**
	 * Creates a ticket.
	 */
	public Ticket() {
	}

	/**
	 * Creates a ticket with all its attributes.
	 * 
	 * @param movieTitle                     Ticket's Movie Title.
	 * @param threeD                         Ticket for Movie 3D.
	 * @param blockbuster                    Ticket for Movie BlockBuster.
	 * @param cinemaClass                    Ticket for Cinema Class.
	 * @param ageOfCust                      Ticket for Age of Customer.
	 * @param student                        Ticket for Student.
	 * @param preferredCreditAndLoyaltyCards Ticket for credit and loyalty Card.
	 * @param dayOfWeek                      Ticket purchased on which day.
	 * @param publicHolidayOrEve             Ticket purchased on holiday.
	 * @param time                           Ticket purchased time.
	 * @param seatId                         Ticket's Seat ID information
	 */
	public Ticket(String movieTitle, boolean threeD, boolean blockbuster, String cinemaClass, int ageOfCust,
			boolean student, boolean preferredCreditAndLoyaltyCards, String dayOfWeek, boolean publicHolidayOrEve,
			int time, int seatId) {
		this.movieTitle = movieTitle;
		this.threeD = threeD;
		this.blockbuster = blockbuster;
		this.cinemaClass = cinemaClass;
		this.ageOfCust = ageOfCust;
		this.student = student;
		this.preferredCreditAndLoyaltyCards = preferredCreditAndLoyaltyCards;
		this.dayOfWeek = dayOfWeek;
		this.publicHolidayOrEve = publicHolidayOrEve;
		this.time = time;
		this.seatId = seatId;
		this.price = 0;
	}

	/**
	 * Get the movie's title.
	 * 
	 * @return the movie's title.
	 */
	public String getmovieTitle() {
		return movieTitle;
	}

	/**
	 * Set the movie's title.
	 * 
	 * @param movieTitle the movie's title.
	 */
	public void setmovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	/**
	 * Get the movie's 3D status.
	 * 
	 * @return movie's 3D status.
	 */
	public boolean isthreeD() {
		return threeD;
	}

	/**
	 * Set the movie's 3D status.
	 * 
	 * @param threeD movie's 3D status.
	 */
	public void setthreeD(boolean threeD) {
		this.threeD = threeD;
	}

	/**
	 * Get the movie's blockbuster status.
	 * 
	 * @return movie's blockbuster status.
	 */
	public boolean isblockbuster() {
		return blockbuster;
	}

	/**
	 * Set movie's blockbuster status.
	 * 
	 * @param blockbuster movie's blockbuster status.
	 */
	public void setblockbuster(boolean blockbuster) { // Blockbuster, Normal
		this.blockbuster = blockbuster;
	}

	/**
	 * Get movie's cinema class.
	 * 
	 * @return movie's cinema class.
	 */
	public String getcinemaClass() {
		return cinemaClass;
	}

	/**
	 * Set movie's cinema class
	 * 
	 * @param cinemaClass movie's cinema class.
	 */
	public void setcinemaClass(String cinemaClass) { // Platinum, Normal
		this.cinemaClass = cinemaClass;
	}

	/**
	 * Get age of customer.
	 * 
	 * @return age of customer.
	 */
	public int getageOfCust() {
		return ageOfCust;
	}

	/**
	 * Set age of customer.
	 * 
	 * @param ageOfCust age of customer.
	 */
	public void setageOfCust(int ageOfCust) { // SeniorCitizen, Adult
		this.ageOfCust = ageOfCust;
	}

	/**
	 * Return true if customer is student, false otherwise.
	 * 
	 * @return Whether customer is a student or not.
	 */
	public boolean isStudent() {
		return student;
	}

	/**
	 * Set customer to be a student or not.
	 * 
	 * @param student Whether customer is a student or not.
	 */
	public void setStudent(boolean student) {
		this.student = student;
	}

	/**
	 * Return true if customer has a preferred credit or loyalty card, false
	 * otherwise.
	 * 
	 * @return Whether customer has a preferred credit or loyalty card.
	 */
	public boolean isPreferredCreditAndLoyaltyCards() {
		return preferredCreditAndLoyaltyCards;
	}

	/**
	 * Set customer to have a preferred credit or loyalty card or not.
	 * 
	 * @param preferredCreditAndLoyaltyCards Whether customer has a preferred credit
	 *                                       or loyalty card.
	 */
	public void setPreferredCreditAndLoyaltyCards(boolean preferredCreditAndLoyaltyCards) {
		this.preferredCreditAndLoyaltyCards = preferredCreditAndLoyaltyCards;
	}

	/**
	 * Get day of the week of screening.
	 * 
	 * @return day of the week of screening.
	 */
	public String getdayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * Set day of the week of screening.
	 * 
	 * @param dayOfWeek day of the week of screening.
	 */
	public void setdayOfWeek(String dayOfWeek) { // Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * Get public holiday or eve status.
	 * 
	 * @return public holiday or eve status.
	 */
	public boolean ispublicHolidayOrEve() {
		return publicHolidayOrEve;
	}

	/**
	 * Set public holiday or eve status.
	 * 
	 * @param publicHolidayOrEve public holiday or eve status.
	 */
	public void setpublicHolidayOrEve(boolean publicHolidayOrEve) {
		this.publicHolidayOrEve = publicHolidayOrEve;
	}

	/**
	 * Get screening time.
	 * 
	 * @return the screening time.
	 */
	public int gettime() {
		return time;
	}

	/**
	 * Set screening time.
	 * 
	 * @param time the screening time.
	 */
	public void settime(int time) { // 0000 hrs format
		this.time = time;
	}

	/**
	 * Get seat ID.
	 * 
	 * @return the seat ID.
	 */
	public int getseatId() {
		return seatId;
	}

	/**
	 * Set seat ID.
	 * 
	 * @param seatId the seat ID.
	 */
	public void setseatId(int seatId) {
		this.seatId = seatId;
	}

	/**
	 * Calculate and return ticket price.
	 * 
	 * @return ticket price.
	 */
	public double calculateAndGetPrice() {
		if (price == 0) {
			this.price = TicketPriceCalculator.calculatePrice(this);
		}
		return price;

	}

	/**
	 * @return String
	 */
//	public double getPrice() {
//		return price;
//	}

	/**
	 * Display ticket information.
	 */
	public String toString() {
		return "Title: " + movieTitle + "\n3D: " + threeD + "\nBlockbuster: " + blockbuster + "\nClass: " + cinemaClass
				+ "\nAge: " + ageOfCust + "\nStudent: " + student + "\nCard: " + preferredCreditAndLoyaltyCards
				+ "\nDay: " + dayOfWeek + "\nPublic Holiday or Eve: " + publicHolidayOrEve + "\nTime: " + time
				+ "\nSeat ID: " + seatId + "\nPrice: $" + price;
	}

}
