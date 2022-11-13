package Body;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Handles the configuration of holiday dates.
 */
public class PublicHoliday {
	/**
	 * List of holidays and what dates they correspond to.
	 */
	private static HashMap<LocalDate, String> holiday = new HashMap<LocalDate, String>();

	/**
	 * Main UI logic.
	 */
	public static void configureHoliday() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Please Select Action:" + "\n(1) View holiday" + "\n(2) Add holiday"
					+ "\n(3) Delete holiday" + "\n(0) Exit");
			int choice = sc.nextInt();
			sc.nextLine();
			System.out.println();
			if (choice == 0)
				break;
			else if (choice == 1)
				viewHoliday();
			else if (choice == 2)
				addHoliday();
			else if (choice == 3)
				deleteHoliday();
		}
	}

	/**
	 * View list of added holidays and their corresponding dates.
	 * @return false if list of holidays are empty, true otherwise.
	 */
	private static boolean viewHoliday() {
		if (holiday.isEmpty()) {
			System.out.println("There are no Holidays added yet ");
			return false;
		}

		holiday.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " " + entry.getValue());
		});
		return true;

	}

	/**
	 * Add a holiday to the list. Must input name and date of holiday.
	 * Also handles adding the eve of the holiday.
	 */
	private static void addHoliday() {
		Scanner sc = new Scanner(System.in);
		Date date1;
		int y, m, d;
		System.out.println("Enter name of holiday(eve will be added automatically):");
		String phname = sc.nextLine();
		while (true) {
			System.out.printf("Enter date of %s in dd/MM/yyyy format:\n", phname);
			String date = sc.nextLine();
			String[] parts = date.split("/"); // split the string to get dd, MM and YYYY individually
			try {
				d = Integer.parseInt(parts[0]);
				m = Integer.parseInt(parts[1]);
				y = Integer.parseInt(parts[2]);
				if (y < 0 || m < 1 || m > 12 || d < 1) { // invalid date years and months
					System.out.println("Please enter valid Date");
					continue;
				}
				YearMonth yearMonthObject = YearMonth.of(y, m);
				int daysInMonth = yearMonthObject.lengthOfMonth(); // check how many days in a particular month and year
				if (d > daysInMonth) {
					System.out.println("Please enter valid Date");
					continue;
				}
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Please enter valid Date");
				continue;
			}
			break;

		}
		LocalDate ld = LocalDate.of(y, m, d);
		holiday.put(ld, phname);
		String publicHolidayNameEve = phname + " eve"; // adding the eve of a holiday to it's name
		LocalDate ldEve;
		int dayEve = d - 1; // for date eve, date-1
		if (dayEve > 0) // if d-1>0 then it is a valid date
			ldEve = LocalDate.of(y, m, dayEve);
		else { // if d-1=0 then it is a not valid date, month-1 and find the max date of
				// month-1
			if (m - 1 > 0) { // when eve and day itself is within the same year
				YearMonth yearMonthObject = YearMonth.of(y, m - 1);
				int daysInMonth = yearMonthObject.lengthOfMonth(); // check how many days in a particular month and year
				ldEve = LocalDate.of(y, m - 1, daysInMonth);
			} else { // when eve and day itself is not in the same year example new year and new year
						// eve
				YearMonth yearMonthObject = YearMonth.of(y, 12);
				int daysInMonth = yearMonthObject.lengthOfMonth(); // check how many days in a particular month and year
				ldEve = LocalDate.of(y - 1, 12, daysInMonth);
			}
		}

		holiday.put(ldEve, publicHolidayNameEve); // adding the eve of a holiday to the hashmap

	}

	/**
	 * Delete a holiday from the list.
	 */
	private static void deleteHoliday() {
		if (!viewHoliday()) {
			return;
		}
		Scanner sc = new Scanner(System.in);
		int y, m, d;
		while (true) {
			while (true) {
				System.out
						.println("Enter the date to delete in dd/MM/yyyy format (eve will be automatically deleted):");
				String date = sc.nextLine();
				String[] parts = date.split("/"); // split the string to get dd, MM and YYYY individually
				try {
					d = Integer.parseInt(parts[0]);
					m = Integer.parseInt(parts[1]);
					y = Integer.parseInt(parts[2]);
					if (y < 0 || m < 1 || m > 12 || d < 1) { // invalid date years and months
						System.out.println("Please enter valid Date");
						continue;
					}
					YearMonth yearMonthObject = YearMonth.of(y, m);
					int daysInMonth = yearMonthObject.lengthOfMonth(); // check how many days in a particular month and
																		// year
					if (d > daysInMonth) {
						System.out.println("Please enter valid Date");
						continue;
					}
				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
					System.out.println("Please enter valid Date");
					continue;
				}
				break;

			}
			LocalDate ld = LocalDate.of(y, m, d);
			LocalDate ldEve;
			int dayEve = d - 1; // for date eve, date-1
			if (dayEve > 0) // if d-1>0 then it is a valid date
				ldEve = LocalDate.of(y, m, dayEve);
			else { // if d-1=0 then it is a not valid date, month-1 and find the max date of
					// month-1
				if (m - 1 > 0) { // when eve and day itself is within the same year
					YearMonth yearMonthObject = YearMonth.of(y, m - 1);
					int daysInMonth = yearMonthObject.lengthOfMonth(); // check how many days in a particular month and
																		// year
					ldEve = LocalDate.of(y, m - 1, daysInMonth);
				} else { // when eve and day itself is not in the same year example new year and new year
							// eve
					YearMonth yearMonthObject = YearMonth.of(y, 12);
					int daysInMonth = yearMonthObject.lengthOfMonth(); // check how many days in a particular month and
																		// year
					ldEve = LocalDate.of(y - 1, 12, daysInMonth);
				}
			}
			if (holiday.containsKey(ld)) {
				holiday.remove(ld);
				holiday.remove(ldEve);
				System.out.println("Remove is succesful");
				break;
			} else
				System.out.println("Date entered does not exist, remove unsuccessful");
		}
	}

	/**
	 * Check whether a given date lands on a holiday or its eve.
	 * @param ld the date.
	 * @return true if the date lands on a holiday or its eve,
	 * false otherwise.
	 */
	public static boolean checkForPHOrEve(LocalDate ld) {
		return holiday.containsKey(ld);
}
}