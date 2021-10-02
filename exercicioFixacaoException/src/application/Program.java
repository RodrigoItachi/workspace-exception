package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.AccountException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.CANADA);
		Scanner read = new Scanner(System.in);

		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			Integer number = read.nextInt();

			System.out.print("Holder: ");
			read.nextLine();
			String holder = read.nextLine();

			System.out.print("Initial balance: ");
			Double balance = read.nextDouble();

			System.out.print("Withdraw limite: ");
			Double withdrawLimit = read.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.print("Enter the withdraw amount: ");
			Double amount = read.nextDouble();

			account.withdraw(amount);
			System.out.printf("New balace: $%.2f", account.getBalance());
		} catch (AccountException e) {
			System.err.println(e.getMessage());
		} catch (RuntimeException e) {
			System.err.println("Unexpected error!");
		}
		read.close();
	}

}