package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {
    public static void addRoom(IRoom room){
        String newRoom = room.getRoomNumber();
        System.out.println(newRoom + " is an added room");
    }
    public static IRoom getARoom(String roomId){
        List<IRoom> getRoom = new ArrayList<>();
        for(IRoom room: getRoom){
            if(roomId.equals(room.getRoomNumber())){
                System.out.println("Room you were looking for: " + room);
            };
        }
        return null;
    }
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reserve = new Reservation(customer, room, checkInDate, checkOutDate);
        return reserve;
    }
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Map<IRoom, Date> map = new HashMap<>();
        
        return null;
    }
    public static Collection<Reservation> getCustomerReservation(Customer customer){
        return null;

    }
    public static void printAllReservation(){

        Queue<Reservation> getReservations = new LinkedList<>();

        while(!getReservations.isEmpty()){
            System.out.println("All reservations ------> " + getReservations.poll());
        }

    }
}
