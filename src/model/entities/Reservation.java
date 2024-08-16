package model.entities;

import model.exceptions.DomainException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
        if (checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now()) || checkOut.isBefore(checkIn)){
            throw new DomainException("As datas informadas não são congruentes");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration (){
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)){
            throw new DomainException("Reservation dates for update must be future dates");
        }
        if (!checkOut.isAfter(checkIn)){
            throw new DomainException("Error in reservation: check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber +
                ", checkIn: " + checkIn.format(fmt) +
                ", checkOut: " + checkOut.format(fmt) +
                ", " + duration() + " nights";
    }
}
