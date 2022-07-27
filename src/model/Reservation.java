package model;

import java.util.Date;

public class Reservation {
    protected Customer customer;
    protected IRoom room;
    protected Date checkInDate;
    protected Date checkOutDate;

    //constructor
    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public IRoom getRoom() {
        return this.room;
    }

    public Date getCheckInDate() {
        return this.checkInDate;
    }

    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    String newline = System.lineSeparator();

    @Override
    public String toString() {
        return this.customer.toString() + newline + this.room.toString() +
                "\nCheck-in Date: " + checkInDate +
                "\nCheck-out Date: " + checkOutDate;
    }
}
