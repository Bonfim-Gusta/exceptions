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
        System.out.print("Check-out date (DD/MM/YYYY): ");
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
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(scanner.next(), fmt);

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null){
                System.out.println("Error in reseervation: " + error);
            }
            else {
                System.out.println("Reservation: " + reservation);
            }
        }




        scanner.close();
    }
}