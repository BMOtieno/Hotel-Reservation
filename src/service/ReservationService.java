package service;

import model.*;

import java.util.*;

public class ReservationService {

    //method to add a new room
    public static void addRoom(IRoom room){
        String newRoom = room.getRoomNumber();
        System.out.println("New room added: ");
        System.out.println(newRoom);
    }

    //method that gets the room through the provided roomId
    public static IRoom getARoom(String roomId){

        Room room = new Room();

        String searchedRoom = room.getRoomNumber();

        if(roomId.equals(searchedRoom)){
            System.out.println("We found this room: ");
            System.out.println(roomId);
        }
        return room;
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
            Map<Date, IRoom> mapOne = new HashMap<>();
            Map<Date, IRoom> mapTwo = new HashMap<>();
            mapOne.put(checkInDate, room);
            mapTwo.put(checkOutDate, room);

            if(mapOne.containsKey(checkInDate) && mapTwo.containsKey(checkOutDate)){
                System.out.println("Here are the rooms available: ");
                System.out.println(mapOne.values());
                System.out.println(mapTwo.values());
            }else{
                System.out.println("Sorry no rooms are available by the given dates");
            }
        }
        return findRoom;
    }

    //method to get customer's reservation
    public static  Collection<Reservation> getCustomerReservation(Customer customer){

        List<Reservation> reservation = new ArrayList<>();

        for(Reservation reserve: reservation){
            Map<Customer, Reservation> map = new HashMap<>();
            map.put(customer, reserve);

            if(map.containsKey(customer)){
                System.out.println("Here are the customer reservation details: ");
                System.out.println(map.values());
            }else{
                System.out.println("Sorry customer hasn't made any reservations.");
            }
        }
        return reservation;
    }

    //method to print all reservations to the console
    public static void printAllReservation(){

        Queue<Reservation> getReservations = new LinkedList<>();

        while(!getReservations.isEmpty()){
            System.out.println(getReservations.poll());
        }
    }
}
