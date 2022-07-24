package api;

import model.Room;
import service.CustomerService;
import service.ReservationService;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class HotelResource {

    public static Customer getCustomer(String email){
        //calling static method to get customer from CustomerService class
        CustomerService.getCustomer(email);
        return new Customer(new Customer().getFirstName(), new Customer().getLastName(), email);
    }

    public static void createACustomer(String email, String firstName, String lastName){
        //calling static method to create a new customer from CustomerService class
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public static IRoom getRoom(String roomNumber){
        //calling static method to get room from ReservationService class
        ReservationService.getARoom(roomNumber);
        return new Room(roomNumber, new Room().getRoomPrice(), new Room().getRoomType());
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        //calling static method to book a room from ReservationService class
        Customer customer = new Customer(new Customer().getFirstName(), new Customer().getLastName(), customerEmail);
        ReservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
        return new Reservation(customer, room, checkInDate, checkOutDate);

    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail){
        ArrayList<Reservation> reserve = new ArrayList<>();
        Reservation reserved = new Reservation(new Reservation().getCustomer(), new Reservation().getRoom(), new Reservation().getCheckInDate(), new Reservation().getCheckOutDate());
        reserve.add(reserved);
        //calling static method to get customer reservation from ReservationService class
        ReservationService.getCustomerReservation(new Customer(new Customer().getFirstName(), new Customer().getLastName(), customerEmail));
        return reserve;
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        //static method to find room from ReservationService class
        List<IRoom> room = new ArrayList<>();
        Room foundRoom = new Room(new Room().getRoomNumber(), new Room().getRoomPrice(), new Room().getRoomType());
        room.add(foundRoom);
        ReservationService.findRooms(checkIn, checkOut);
        return room;
    }
}
