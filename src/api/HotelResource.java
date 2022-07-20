package api;

import service.CustomerService;
import service.ReservationService;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    public static Customer getCustomer(String email){
       // CustomerService.getCustomer(email);
        return null;
    }
    public static void createACustomer(String email, String firstName, String lastName){
        CustomerService.addCustomer(email, firstName, lastName);
    }
    public static IRoom getRoom(String roomNumber){
        ReservationService.getARoom(roomNumber);
        return null;
    }
    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
       // ReservationService.getCustomerReservation();
        return null;

    }
    public static Collection<Reservation> getCustomerReservations(String customerEmail){
       // ReservationService.getCustomerReservation();
        return null;

    }
    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        //ReservationService.findRooms(checkIn, checkOut);
        return null;

    }
}
