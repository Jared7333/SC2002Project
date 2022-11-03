package MOBLIMA;

public class Ticket {
	private String movieTitle;
	private boolean threeD;
	private boolean blockbuster;
	private String cinemaClass;
	private String ageOfCust;
	private String dayOfWeek;
	private boolean publicHolidayOrEve;
	private int time;
	private int seatId;
	private double price;

	public Ticket() {
	}

	public Ticket(String movieTitle, boolean threeD, boolean blockbuster, String cinemaClass, String ageOfCust,
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

	public String getageOfCust() {
		return ageOfCust;
	}

	public void setageOfCust(String ageOfCust) { // SeniorCitizen, Adult, Student
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

	public void calculatePrice() {
		boolean weekend = false;
		if (dayOfWeek == "Saturday" || dayOfWeek == "Sunday")
			weekend = true;
		// weekend
		if (weekend) {
			if (threeD)
				price = 15;
			else
				price = 11;
		}
		// weekday
		else {
			// Monday to Wednesday
			if (dayOfWeek == "Monday" || dayOfWeek == "Tuesday" || dayOfWeek == "Wednesday") {
				if (threeD)
					price = 11;
				else
					price = 8.50;
			}

			// Thursday
			if (dayOfWeek == "Thursday") {
				if (threeD)
					price = 11;
				else
					price = 9.50;
			}

			// Friday
			if (dayOfWeek == "Friday") {
				if (threeD)
					price = 15;
				else {
					if (time < 1800) // before 6pm
						price = 9.50;
					else // from 6pm
						price = 11;
				}
			}

			// student discount
			if (ageOfCust == "Student" && publicHolidayOrEve == false && time < 1800) {
				if (threeD)
					price = 9;
				else
					price = 7;
			}

			// senior citizen discount(there is no 3D discount for them)
			if (ageOfCust == "SeniorCitizen" && publicHolidayOrEve == false && time < 1800 && threeD == false) {
				price = 4;
			}

		} // end weekday else

		// $1 extra for block buster
		if (blockbuster)
			price += 1;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Title: " + movieTitle + "\n3D: " + threeD + "\nBlockbuster: " + blockbuster + "\nClass: " + cinemaClass
				+ "\nAge Group: " + ageOfCust + "\nDay: " + dayOfWeek + "\nPublic Holiday or Eve: " + publicHolidayOrEve
				+ "\nTime: " + time + "\nSeat ID: " + seatId + "\nPrice: $" + price;
	}

}
