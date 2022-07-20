package model;

import java.util.Objects;

public class Room implements IRoom{

    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    public RoomType getEnumeration() {
        return enumeration;
    }

    public void setEnumeration(RoomType enumeration) {
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
        return false;
    }

    @Override
    public String toString() {
        return "RoomNumber: " + getRoomNumber() +
                "\nPrice: " + getRoomPrice() +
                "\nRoom Type: " + getRoomType() +
                "\nVacant: " + isFree();
    }
}
