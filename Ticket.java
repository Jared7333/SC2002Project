
public class Ticket {
	private String movieTitle;
	private boolean threeD;
	private String movieType;
	private String cinemaClass;
	private String ageOfCust;
	private String dayOfWeek;
	private int time;
	private double price;

	public Ticket() {
	}

//	public Ticket(String movieTitle, boolean threeD, String movieType, String cinemaClass, String ageOfCust,
//			String dayOfWeek, int time) {
//		this.movieTitle = movieTitle;
//		this.threeD = threeD;
//		this.movieType = movieType;
//		this.cinemaClass = cinemaClass;
//		this.ageOfCust = ageOfCust;
//		this.dayOfWeek = dayOfWeek;
//		this.time = time;
//		this.price = 0;
//	}

	public String getmovieTitle() {
		return movieTitle;
	}

	public void setmovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public boolean getthreeD() {
		return threeD;
	}

	public void setthreeD(boolean threeD) {
		this.threeD = threeD;
	}

	public String getmovieType() {
		return movieType;
	}

	public void setmovieType(String movieType) { //Blockbuster, SneakPreview, Normal
		this.movieType = movieType;
	}

	public String getcinemaClass() {
		return cinemaClass;
	}

	public void setcinemaClass(String cinemaClass) { //Standard, Ultima, Elite, Platinum
		this.cinemaClass = cinemaClass;
	}

	public String getageOfCust() {
		return ageOfCust;
	}

	public void setageOfCust(String ageOfCust) { //SeniorCitizen, Adult, Student, Children
		this.ageOfCust = ageOfCust;
	}

	public String getdayOfWeek() { 
		return dayOfWeek;
	}

	public void setdayOfWeek(String dayOfWeek) { //Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday, PublicHoliday
		this.dayOfWeek = dayOfWeek;
	}
	
	public int gettime() {
		return time;
	}
	
	public void settime(int time) { //0000 hrs format
		this.time = time;
	}

	public void calculatePrice() {
		boolean weekend = false;
		if (dayOfWeek == "Saturday" || dayOfWeek == "Sunday"
				|| dayOfWeek == "PublicHoliday")
			weekend = true;
		// children free
		if (ageOfCust == "Children") {
			this.price = 0;
			return;
		}
		//platinum
		if (cinemaClass == "Platinum") {
			// block buster or Friday to Sunday or public holiday
			if (movieType == "Blockbuster" || weekend == true || dayOfWeek == "Friday") {
				this.price = 38; // standard price
				return;
			} else {
				this.price = 28; // standard price
				return;
			}
		}
		// 3D ticket
		if (threeD) {
			price = 16; // standard price
			return;
		}
		// Senior citizen, Monday to Friday, before 6pm, only standard class
		if (weekend == false && time < 1800 && ageOfCust == "SeniorCitizen"
				&& cinemaClass == "Standard") {
			this.price = 5;
			return;
		}
		// Student, Monday to Friday, before 6pm, only standard class
		if (weekend == false && time < 1800 && ageOfCust == "Student"
				&& cinemaClass == "Standard") {
			this.price = 7;
			return;
		}
		// Monday to Thursday, no promotion
		if (weekend == false && dayOfWeek != "Friday") {
			this.price = 10;
			if (cinemaClass != "Standard") { // ultima and elite
				this.price = price + 4;
			}
			if (movieType != "Normal") { // block buster and sneak preview
				this.price = price + 0.50;
			}
			return;
		}

		// Friday to Sunday or Public holiday
		if (weekend == true || dayOfWeek == "Friday") {
			this.price = 14.50;
			if (cinemaClass != "Standard") { // ultima and elite
				this.price = price + 1;
			}
			return;
		}
	}

	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return "Title: " + movieTitle + "\n3D: " + threeD + "\nType: " + movieType + "\nClass: " + cinemaClass
				+ "\nAge Group: " + ageOfCust + "\nDay: " + dayOfWeek + "\nTime: " + time + "\nPrice: $" + price;
	}

}
