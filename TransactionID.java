public class TransactionID extends Transactions { // Implement a design pattern known as template method

	public String generateTID(int iD, String movieTitle) { // generate TID, TID (3
		// letter code for Movie
		// + date + hour +
		// minute)

		String movie = "";
		int countForExcluding = 0;

		// Conversion of movie title to first letter of each word (up to 3 letters),
		// will repeat letter if not enough words
		for (int i = 0; i < movieTitle.length(); i++) {
			if (i == 0) {
				movie += Character.toUpperCase(movieTitle.charAt(i));
			} else if (movieTitle.charAt(i) == ' ') {
				movie += Character.toUpperCase(movieTitle.charAt(i + 1));
				countForExcluding++;
				if (countForExcluding == 2) {
					break;
				}
			}
			if (i + 1 == movieTitle.length()) {
				while (movie.length() != 3) {
					movie += movie.charAt(movie.length() - 1);
				}
			}
		}

		countForExcluding = 0;

		// Conversion of real date to String (and removal of '-')
		String date = "";
		String localDate = java.time.LocalDate.now().toString();
		for (int i = 0; i < localDate.length(); i++) {
			if (localDate.charAt(i) == '-') {
				continue;
			}
			date += localDate.charAt(i);
		}

		// Conversion of real time to String (and removal of ':')
		String time = "";
		String localTime = java.time.LocalTime.now().toString();
		for (int i = 0; i < localTime.length(); i++) {
			if (localTime.charAt(i) == ':') {
				if (countForExcluding == 1) {
					break;
				}
				countForExcluding++;
				continue;
			}
			time += localTime.charAt(i);
		}

		String moviePlusDatePlusTime = movie + date + time;
		customerList.get(iD).pastTID.add(moviePlusDatePlusTime); // update customer's watch history
		return moviePlusDatePlusTime;
	}

}
