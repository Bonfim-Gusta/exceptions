import model.entities.Reservation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);


        System.out.print("Room number: ");
        int number = scanner.nextInt();
        System.out.print("Check-in date (DD/MM/YYYY): ");
        LocalDate checkIn = LocalDate.parse(scanner.next(), fmt);
        System.out.print("Check-in date (DD/MM/YYYY): ");
        LocalDate checkOut = LocalDate.parse(scanner.next(), fmt);

        if (!checkOut.isAfter(checkIn)){
            System.out.println("Error in reservation:  CheckOut date must be after checkIn");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("\n Enter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(scanner.next(), fmt);
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(scanner.next(), fmt);

            LocalDate now = LocalDate.now();
            if (checkIn.isBefore(now) || checkOut.isBefore(now)){
                System.out.println("Error in reservation: Reservatio dates...");
            }
            else if (!checkOut.isAfter(checkIn)){
                System.out.println("Error in reservation: Reservatio dates...");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }

        }




        scanner.close();
    }
}