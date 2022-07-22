package model;

public class FreeRoom extends Room{

    //check the availability of the reserved room
    public FreeRoom(String roomNumber, Double price, RoomType enumeration, boolean isFree) {
        super(roomNumber, 0.0, enumeration, isFree);
    }

    @Override
    public String toString() {
        if (isFree()) {
            return "This room is free";
        } else {
           return "This room is occupied";
        }
    }
}
