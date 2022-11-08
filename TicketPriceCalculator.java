public class TicketPriceCalculator {
	public static double calculatePrice(Ticket ticket) {
		String dayOfWeek = ticket.getdayOfWeek();
		boolean threeD = ticket.isthreeD();
		boolean blockbuster = ticket.isblockbuster();
		int time = ticket.gettime();
		int ageOfCust = ticket.getageOfCust();
		boolean publicHolidayOrEve = ticket.ispublicHolidayOrEve();

		double price = 0;
		boolean weekend = false;
		if (dayOfWeek == "Saturday" || dayOfWeek == "Sunday")
			weekend = true;

		if (threeD) { //3D
			price = 11;
			if (dayOfWeek == "Friday" || weekend || publicHolidayOrEve) // Friday, Weekend, PH or PH eve
				price = price + 4;
		}
		
		else { // no 3D
			price = 8.50;
			if (dayOfWeek == "Thurday" || (dayOfWeek == "Friday" && time < 1800)) // Thursday or Friday before 6pm
				price = price + 1;
			
			else if ((dayOfWeek == "Friday" && time >= 1800) || weekend || publicHolidayOrEve) // Friday after 6pm, Weekend, PH or PH eve
				price = price + 2.50;
	

			if (ageOfCust >= 55) //senior citizen price, there's is no student price for online booking(tried and tested)
				if (weekend == false && publicHolidayOrEve == false && time < 1800) 
					price = 4;
		}
		
		if (blockbuster)
			price = price + 1;

		//ticket.setPrice(price);
		return price;
		

	}

}
