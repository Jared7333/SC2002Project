package sc2002Project;

public class CinemaSeats {

	private int seatId;
	private boolean assigned;
	private int customerId;

	public CinemaSeats(int seat_id) {
		seatId = seat_id;
		this.assigned = false;
		this.customerId = 0;
	}

	public int getSeatId() {
		return seatId;
	}

//	public void setSeatId(int seatId) {
//		this.seatId = seatId;
//	}
//	public boolean isAssigned() {
//		return assigned;
//	}
	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public boolean isOccupied() {
		if (this.assigned == false) {
			return false;
		} else {
			return true;
		}

	}

	public void assign(int seat_iD) {
//		this.customerId = cust_id;
		this.seatId = seat_iD;
		this.assigned = true;
	}

	public void unAssigned() {
		this.customerId = 0;
		this.assigned = false;

	}

}
