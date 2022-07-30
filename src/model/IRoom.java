package model;

/**
 * Interface class for room requirements
 * @author Brian Odhiambo
 */

public interface IRoom {
    String getRoomNumber();
    Double getRoomPrice();
    RoomType getRoomType();
    boolean isFree();
}
