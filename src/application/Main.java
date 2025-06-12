package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.DomainException;
import model.entities.Reservation;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.print("Enter room number: ");
            int number = scanner.nextInt();

            System.out.print("Check - in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(scanner.next());

            System.out.print("Check - out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(scanner.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation : " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check - in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());

            System.out.print("Check - out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());

            // O método updateDate retorna uma String com a mensagem de erro, se houver.

            reservation.updateDate(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

        } catch (ParseException e) {
            System.out.println("Invalid date format");

        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
    }
}