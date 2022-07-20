package model;

public class FreeRoom extends Room{
    //check the availability of the reserved room

    boolean isFree;

    public FreeRoom(String roomNumber, double price, RoomType enumeration, boolean isFree) {
        super(roomNumber, 0.0, enumeration);

        this.isFree = isFree;
    }

    @Override
    public String toString() {
        if (isFree) {
            return "This room is free";
        } else {
           return "This room is occupied";
        }
    }
}
