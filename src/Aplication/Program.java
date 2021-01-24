package Aplication;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import domain.exception.DomainException;
import entities.Reservation;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		try {
			System.out.print("Romm number: ");
			int number = sc.nextInt(); 
			System.out.print("Check-in date (dd/MM/yyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyy)");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyy)");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyy)");
			checkOut = sdf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}catch(ParseException e) {
			System.out.println("Invalid date format");
		}catch(DomainException e) {
			System.out.println("Error in reservation " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Error inexpected");
		}
		
		sc.close();

	}

}
