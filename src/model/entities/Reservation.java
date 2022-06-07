package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation(){ }

	public Reservation(Integer roomNumber, Date checkin, Date checkout) { //com runtimeException n precisa de add throws exception como nos posteriores
		if (!checkout.after(checkin)) {
			throw new DomainException( "Error in reservation: Check-out date must be after check-In date");//usado em ambos, função ja existente no java
		}
		
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
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException { //propaga na assinatura do metodo, com o throws, chamando nossa classe de tratamento DomainException
		Date now = new Date();
		this.checkin = checkIn;
		this.checkout = checkOut;
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException( "Error in reservation: Reservation dates must be in future dates");//throws chama uma funçao de exception
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException( "Error in reservation: Check-out date must be after check-In date");//usado em ambos, função ja existente no java
		}
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
