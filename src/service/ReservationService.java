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
        Room room = new Room(roomId, new Room().getRoomPrice(), new Room().getRoomType());
        System.out.println("Here is the room " + room.getRoomNumber());
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
        Room roomObject = new Room(new Room().getRoomNumber(), new Room().getRoomPrice(), new Room().getRoomType());
        findRoom.add(roomObject);

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
        Reservation reserved = new Reservation(customer, new Reservation().getRoom(), new Reservation().getCheckInDate(), new Reservation().getCheckOutDate());
        reservation.add(reserved);

        for(Reservation r : reservation){
            System.out.println("Here is the customer's reservation details: " + r);
        }
        return reservation;
    }

    //method to print all reservations to the console
    public static void printAllReservation(){

        Queue<Reservation> getReservations = new LinkedList<>();
        Reservation allReserved = new Reservation(new Reservation().getCustomer(), new Reservation().getRoom(), new Reservation().getCheckInDate(), new Reservation().getCheckOutDate());
        getReservations.add(allReserved);

        System.out.println("Here are all the reservations: ");

        while(!getReservations.isEmpty()){
            System.out.println(getReservations.poll());
        }
    }
}
