package model;

import java.util.Objects;

public class Room implements IRoom{

    private final String roomNumber;
    private final Double price;
    private final RoomType enumeration;

    //constructor
    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    //method to compare if two rooms have the same room number
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(getRoomNumber(), room.getRoomNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomNumber());
    }

    //override the methods from the interface class
    @Override
    public String getRoomNumber() {
        return this.roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return this.price;
    }

    @Override
    public RoomType getRoomType() {
        return this.enumeration;
    }

    @Override
    public boolean isFree() {
        return this.price != null && this.price.equals(0.0);
    }

    //override toString method
    @Override
    public String toString() {
        return "RoomNumber: " + this.roomNumber +
                "\nPrice: $" + this.price +
                "\nRoom Type: " + this.enumeration;
    }
}
