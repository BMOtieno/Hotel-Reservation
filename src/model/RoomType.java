package model;

/**
 * Rooms can be either single occupant or double occupant
 * @author Brian Odhiambo
 */

public enum RoomType {
    SINGLE, DOUBLE;

    public static RoomType getTypeByOrdinal(int ordinal){
        for(RoomType roomType: RoomType.values()){
            if(roomType.ordinal() == ordinal){
                return roomType;
            }
        }
        return null;
    }
}
