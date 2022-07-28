package service;

import model.*;
import java.util.*;

public class ReservationService {

    //Use Singleton Design Patterns
    private static ReservationService reservationSingletonObject = new ReservationService();

    private ReservationService(){

    }

    public static ReservationService getReservationSingletonObject(){
        return reservationSingletonObject;
    }

    private static final int ROOMS_DEFAULT_RECOMMENDED_OUTSIDE_DATE  = 7;

    Map<String, IRoom> allRooms = new HashMap<>();
    Map<String, Collection<Reservation>> allReservations = new HashMap<>();

    //method to add a new room
    public void addRoom(IRoom room){
        allRooms.put(room.getRoomNumber(), room);
    }

    //method that gets the room through the provided roomId
    public IRoom getARoom(String roomId){
        return allRooms.get(roomId);
    }

    //method to reserve a room
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reserve = new Reservation(customer, room, checkInDate, checkOutDate);
        Collection<Reservation> reservationsMade = getCustomerReservation(customer);

        if(reservationsMade == null){
            reservationsMade = new LinkedList<>();
        }

        reservationsMade.add(reserve);
        allReservations.put(customer.getEmail(), reservationsMade);

        return reserve;
    }

    // method to get all rooms
     public Collection<IRoom> getAllRooms(){
        return allRooms.values();
    }

    //method to find rooms
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<Reservation> totalReservations = getEveryReservation();
        Collection<IRoom> unAvailableRooms = new LinkedList<>();

        for(Reservation reservation: totalReservations){
            if(checkInDate.before(reservation.getCheckOutDate()) && checkOutDate.after(reservation.getCheckInDate())){
                unAvailableRooms.add(reservation.getRoom());
            }
        }

        //for(IRoom room: allRooms.values()){
           // for(IRoom emptyRoom: unAvailableRooms){
               // if(room.equals(emptyRoom)){
                   // unAvailableRooms.remove(emptyRoom);
               // }
           // }
        //}
        return unAvailableRooms;
    }

    public Collection<IRoom> lookForAlternativeRooms(Date checkIn, Date checkOut){
        return findRooms(addDays(checkIn), addDays(checkOut));
    }

    //method to get customer's reservation
    public Collection<Reservation> getCustomerReservation(Customer customer){
        return allReservations.get(customer.getEmail());
    }

    //default method to add seven days to the original checkIn and checkout dates
    Date addDays(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, ROOMS_DEFAULT_RECOMMENDED_OUTSIDE_DATE);
        return calendar.getTime();
    }

    //method to print all reservations to the console
    public void printAllReservation(){
        Collection<Reservation> outputAllReservations = getEveryReservation();

        if(outputAllReservations.isEmpty()){
            System.out.println("There are no reservations made.");
        }else{
            for(Reservation reserve: outputAllReservations){
                System.out.println(reserve + "\n");
            }
        }
    }

    private Collection<Reservation> getEveryReservation(){
        Collection<Reservation> everyReservation = new LinkedList<>();

        for(Collection<Reservation> allReservations: allReservations.values()){
            everyReservation.addAll(allReservations);
        }
        return everyReservation;
    }

}

