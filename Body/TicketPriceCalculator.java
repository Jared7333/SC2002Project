package Body;

/**
 * Utility class for calculating the price of a ticket.
 */
public class TicketPriceCalculator {
	/**
	 * Calculate a ticket's price based on various factors such as 
	 * the day of the week,
	 * public holiday status,
	 * movie attributes,
	 * customer attributes,
	 * and seat number.
	 * @param ticket ticket for which price to be calculated
	 * @return ticket price
	 */
	public static double calculatePrice(Ticket ticket) {
		String dayOfWeek = ticket.getdayOfWeek();
		boolean threeD = ticket.isthreeD();
		boolean blockbuster = ticket.isblockbuster();
		String cinemaClass = ticket.getcinemaClass();
		int time = ticket.gettime();
		int ageOfCust = ticket.getageOfCust();
		boolean student = ticket.isStudent();
		boolean card = ticket.isPreferredCreditAndLoyaltyCards();
		boolean publicHolidayOrEve = ticket.ispublicHolidayOrEve();
		int seatId = ticket.getseatId();

		double price = 0;
		boolean weekend = false;
		if (dayOfWeek.equals("Saturday") || dayOfWeek.equals("Sunday"))
			weekend = true;

		if (threeD) { //3D
			price = 11;
			if (dayOfWeek.equals("Friday") || weekend || publicHolidayOrEve) // Friday, Weekend, PH or PH eve
				price = price + 4;
			if(student && weekend == false && publicHolidayOrEve == false && time < 1800 && !cinemaClass.equals("Platinum")) // Student price, Mon-Fri before 6pm 
				price = 9;
		}
		
		else { // no 3D
			price = 8.50;
			if (dayOfWeek.equals("Thurday") || (dayOfWeek.equals("Friday") && time < 1800) && !publicHolidayOrEve) // Thursday or Friday before 6pm
				price = price + 1;
			
			else if ((dayOfWeek.equals("Friday") && time >= 1800) || weekend || publicHolidayOrEve) // Friday after 6pm, Weekend, PH or PH eve
				price = price + 2.50;
			
			if(card) 
				price = 7;
			
			if (weekend == false && publicHolidayOrEve == false && time < 1800 && !cinemaClass.equals("Platinum")) { //Mon-Fri before 6pm 
				if (ageOfCust >= 55) //senior citizen price
					price = 4;
				if(student)
					price = 7;
			}
		}
		if(cinemaClass.equals("Platinum"))
			price = price + 5;
		
		if (blockbuster)
			price = price + 1;
		
		if(seatId + 1 > (Cinema.getSeatCount() - 14)) //couple seat
			price = price*2;

		//ticket.setPrice(price);
		return price;
		

	}

}
