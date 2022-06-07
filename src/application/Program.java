package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);

		try {
			System.out.println("Room number: ");
			int roomNum = sc.nextInt();
			System.out.println("Check-In: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out: ");
			Date checkout = sdf.parse(sc.next());
		
			Reservation reservation = new Reservation(roomNum, checkIn, checkout);
			System.out.println("Reservation: " + reservation.toString() + "\n");
		
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-In: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out: ");
			checkout = sdf.parse(sc.next());
		
			reservation.updateDates(checkIn, checkout);
			System.out.println("Reservation: " + reservation.toString() + "\n");
		}
		catch (ParseException e) {
			System.out.println("Invalid date format!" + e.getMessage());
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error, call IT administration");
		}

		sc.close();
	}

}
/*if (!checkout.after(checkIn)) {
	System.out.println("Error in reservation: Check-out date must be after check-In date");
} else {

		if (error != null) { // != nulo é porque deu erro
			System.out.println("Error in reservation: " + error);
		} else {
*/
