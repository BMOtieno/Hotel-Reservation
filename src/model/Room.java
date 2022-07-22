package model;

import java.util.Objects;

public class Room implements IRoom{

    private String roomNumber;
    private Double price;
    private RoomType enumeration;
    private boolean isFree;

    //constructor
    public Room(String roomNumber, Double price, RoomType enumeration, boolean isFree) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
        this.isFree = isFree;
    }

    //empty constructor
    public Room(){

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
        return this.isFree;
    }

    //override toString method
    @Override
    public String toString() {
        return "RoomNumber: " + getRoomNumber() +
                "\nPrice: " + getRoomPrice() +
                "\nRoom Type: " + getRoomType() +
                "\nVacant: " + isFree();
    }
}
