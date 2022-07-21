package model;

public class FreeRoom extends Room{

    //check the availability of the reserved room
    public FreeRoom(String roomNumber, double price, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
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
