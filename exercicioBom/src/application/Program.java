package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomaninException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.CANADA);
		Scanner read = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			Integer room = read.nextInt();

			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(read.next());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(read.next());
			read.close();

			Reservation reservation = new Reservation(room, checkin, checkout);
			System.out.print(reservation);

			System.out.println();
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(read.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(read.next());

			reservation.updateDates(checkin, checkout);
			System.out.print("Reservation: " + reservation);
		} catch (ParseException e) {
			System.err.println("Invalid date format");
			e.printStackTrace();
		} catch (DomaninException e) {
			System.err.println("Error in reservation: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}

}