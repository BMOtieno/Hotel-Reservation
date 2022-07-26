package model;

public class FreeRoom extends Room{

    //check the availability of the reserved room
    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
    }

    @Override
    public String toString() {
        return "Is room free? " + super.toString();
    }
}
