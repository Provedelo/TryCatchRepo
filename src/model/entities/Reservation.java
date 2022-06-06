package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation(){ }

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //estatico para nao instanciar um a cada novo objeto

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte miliseconds em dias
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		this.checkin = checkIn;
		this.checkout = checkOut;	
		
		Date now = new Date();
		if (checkIn.before(now) || checkout.before(now)) {
			return "Error in reservation: Reservation dates must be in future dates";
		}
		if (!checkout.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-In date";
		}
		this.checkin = checkIn;
		this.checkout = checkOut;
		return null; //se retornar nulo é porque n deu erro
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", Check-In: "
				+ sdf.format(checkin)
				+ ", Check-Out: "
				+ sdf.format(checkout)
				+ ", "
				+ duration()
				+ " nights";
	
	}
}
