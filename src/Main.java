import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);


        try {
            System.out.print("Room number: ");
            int number = scanner.nextInt();
            System.out.print("Check-in date (DD/MM/YYYY): ");
            LocalDate checkIn = LocalDate.parse(scanner.next(), fmt);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            LocalDate checkOut = LocalDate.parse(scanner.next(), fmt);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println("\n Enter data to update the reservation:");
            System.out.print("Check-in date (DD/MM/YYYY): ");
            checkIn = LocalDate.parse(scanner.next(), fmt);
            System.out.print("Check-out date (DD/MM/YYYY): ");
            checkOut = LocalDate.parse(scanner.next(), fmt);

            reservation.updateDates(checkIn, checkOut);
        }
        catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (DateTimeParseException e){
            System.out.println("Data inserida de forma incorreta");
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        scanner.close();
    }
}