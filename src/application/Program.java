package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);

		System.out.println("Room number: ");
		int roomNum = sc.nextInt();
		System.out.println("Check-In: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-Out: ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-In date");
		} else {
			Reservation reservation = new Reservation(roomNum, checkIn, checkout);
			System.out.println("Reservation: " + reservation.toString() + "\n");

			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-In: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out: ");
			checkout = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkout);
			if (error != null) { // != nulo é porque deu erro
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation.toString() + "\n");
			}
		}

		sc.close();
	}

}
