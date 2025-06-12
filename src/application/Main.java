package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

    // Esse é um exemplo muito ruim, não há tratamento de exceções, por isso foi acrecentado o throws ParseException.

    // O throws ParseException é necessário porque o método parse() pode lançar essa exceção se a string não estiver no formato esperado.

    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter room number: ");
        int number = scanner.nextInt();

        System.out.print("Check - in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(scanner.next());

        System.out.print("Check - out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(scanner.next());

        if (!checkOut.after(checkIn)) {

            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation : " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check - in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());

            System.out.print("Check - out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());


            // O método updateDate retorna uma String com a mensagem de erro, se houver.

            String error = reservation.updateDate(checkIn, checkOut);

            if (error != null) {

                System.out.println("Error in reservation :" + error);

            } else {

                System.out.println("Reservation: " + reservation);

            }
        }
    }
}