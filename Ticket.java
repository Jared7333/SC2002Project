package sc2002Project;

public class Ticket {
	private String movieTitle;
	private boolean threeD;
	private boolean blockbuster;
	private String cinemaClass;
	private int ageOfCust;
	private String dayOfWeek;
	private boolean publicHolidayOrEve;
	private int time;
	private int seatId;
	private double price;

	public Ticket() {
	}

	public Ticket(String movieTitle, boolean threeD, boolean blockbuster, String cinemaClass, int ageOfCust,
			String dayOfWeek, boolean publicHolidayOrEve, int time, int seatId) {
		this.movieTitle = movieTitle;
		this.threeD = threeD;
		this.blockbuster = blockbuster;
		this.cinemaClass = cinemaClass;
		this.ageOfCust = ageOfCust;
		this.dayOfWeek = dayOfWeek;
		this.publicHolidayOrEve = publicHolidayOrEve;
		this.time = time;
		this.seatId = seatId;
		this.price = 0;
	}

	public String getmovieTitle() {
		return movieTitle;
	}

	public void setmovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public boolean isthreeD() {
		return threeD;
	}

	public void setthreeD(boolean threeD) {
		this.threeD = threeD;
	}

	public boolean isblockbuster() {
		return blockbuster;
	}

	public void setblockbuster(boolean blockbuster) { // Blockbuster, Normal
		this.blockbuster = blockbuster;
	}

	public String getcinemaClass() {
		return cinemaClass;
	}

	public void setcinemaClass(String cinemaClass) {
		this.cinemaClass = cinemaClass;
	}

	public int getageOfCust() {
		return ageOfCust;
	}

	public void setageOfCust(int ageOfCust) { // SeniorCitizen, Adult, Child?
		this.ageOfCust = ageOfCust;
	}

	public String getdayOfWeek() {
		return dayOfWeek;
	}

	public void setdayOfWeek(String dayOfWeek) { // Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
		this.dayOfWeek = dayOfWeek;
	}

	public boolean ispublicHolidayOrEve() {
		return publicHolidayOrEve;
	}

	public void setpublicHolidayOrEve(boolean publicHolidayOrEve) {
		this.publicHolidayOrEve = publicHolidayOrEve;
	}

	public int gettime() {
		return time;
	}

	public void settime(int time) { // 0000 hrs format
		this.time = time;
	}

	public int getseatId() {
		return seatId;
	}

	public void setseatId(int seatId) {
		this.seatId = seatId;
	}

	public void setPrice(double price) {
		this.price=price;
	}
	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Title: " + movieTitle + "\n3D: " + threeD + "\nBlockbuster: " + blockbuster + "\nClass: " + cinemaClass
				+ "\nAge: " + ageOfCust + "\nDay: " + dayOfWeek + "\nPublic Holiday or Eve: " + publicHolidayOrEve
				+ "\nTime: " + time + "\nSeat ID: " + seatId + "\nPrice: $" + price;
	}

}
