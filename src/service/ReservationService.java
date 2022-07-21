package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    //method to add a new room
    public static void addRoom(IRoom room){
        String newRoom = room.getRoomNumber();
        Map<IRoom, String> map = new HashMap<>();
        map.put(room, newRoom);
        System.out.println(newRoom + " is an added room");
    }

    //method that gets the room through the provided roomId
    public static IRoom getARoom(String roomId){
        List<IRoom> getRoom = new ArrayList<>();
        for(IRoom room: getRoom){
            if(roomId.equals(room.getRoomNumber())){
                System.out.println("Room you were looking for: " + room);
            }else{
                System.out.println("Sorry cannot find a room by the given ID.");
            }
        }
        return null;
    }

    //method to reserve a room
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reserve = new Reservation(customer, room, checkInDate, checkOutDate);
        return reserve;
    }

    //method to find rooms
    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){

        List<IRoom> findRoom = new ArrayList<>();

        for(IRoom room : findRoom){
            Map<Date, IRoom> map = new HashMap<>();
            map.put(checkInDate, room);
            map.put(checkOutDate, room);

            if(map.containsKey(checkInDate) && map.containsKey(checkOutDate)){
                System.out.println("Here are the rooms available: " + map.values());
            }else{
                System.out.println("Sorry no rooms are available by the given dates");
            }
        }
        return null;
    }

    //method to get customer's reservation
    public static Collection<Reservation> getCustomerReservation(Customer customer){

        List<Reservation> reservation = new ArrayList<>();

        for(Reservation reserve: reservation){
            Map<Customer, Reservation> map = new HashMap<>();
            map.put(customer, reserve);

            if(map.containsKey(customer)){
                System.out.println("Here are the customer reservation details: " + map.values());
            }else{
                System.out.println("Sorry customer hasn't made any reservations.");
            }
        }
        return null;
    }

    //method to print all reservations to the console
    public static void printAllReservation(){

        Queue<Reservation> getReservations = new LinkedList<>();

        while(!getReservations.isEmpty()){
            System.out.println(getReservations.poll());
        }
    }
}
