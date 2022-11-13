package Body;

/**
 * Assigning of cinema seats based on customer's ID.
 * Will be able to check if a seat is assigned or not.
 */
public class CinemaSeats {
	/**
	 * Seat number.
	 */
	private int seatId;
	/**
	 * Check if the seat is already assigned.
	 */
	private boolean assigned;
	/**
	 * Customer's ID.
	 */
	private int customerId;
	/**
	 * Create a new seat based on seat number.
	 * @param seat_id seat number.
	 */
	public CinemaSeats(int seat_id) {
		seatId = seat_id;
		this.assigned = false;
		this.customerId = 0;
	}
	/**
	 * Gets seat number.
	 * @return this seat number.
	 */
	public int getSeatId() {
		return seatId;
	}

//	public void setSeatId(int seatId) {
//		this.seatId = seatId;
//	}
//	public boolean isAssigned() {
//		return assigned;
//	}

	/**
	 * Sets assigned to be assigned
	 * 
	 * @param assigned assigned
	 */
	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}
	/**
	 * Gets Customer's ID.
	 * 
	 * @return this Customer's ID.
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * Sets Customer's ID.
	 * 
	 * @param customerId Customer's ID
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/**
	 * Check if seat is assigned.
	 * 
	 * @return <code>true</code> if seat has been assigned;
	 *         <code>false</code> otherwise.
	 */
	public boolean isOccupied() {
		if (this.assigned == false) {
			return false;
		} else {
			return true;
		}

	}
	/**
	 * Assign seat based on seat number.
	 * 
	 * @param seat_iD seat number.
	 */
	public void assign(int seat_iD) {
//		this.customerId = cust_id;
		this.seatId = seat_iD;
		this.assigned = true;
	}
	/**
	 * Unassign seat based on seat number
	 * 
	 */
	public void unAssigned() {
		this.customerId = 0;
		this.assigned = false;

	}

}
