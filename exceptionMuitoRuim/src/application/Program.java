package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.CANADA);
		Scanner read = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		Integer room = read.nextInt();

		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(read.next());

		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(read.next());

		if (!checkout.after(checkin)) {
			System.out.print("Error in reservation: Check-out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(room, checkin, checkout);
			System.out.print(reservation);

			System.out.println();
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(read.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(read.next());

			Date now = new Date();

			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (checkout.after(checkin)) {
				System.out.print("Error in reservation: Check-out date must be after check-in date.");
			} else {
				reservation.updateDates(checkin, checkout);
				System.out.print(reservation);
			}

		}

		read.close();
	}

}