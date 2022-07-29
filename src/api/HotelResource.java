package api;

import service.CustomerService;
import service.ReservationService;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class HotelResource {
    //Apply Singleton Design Patterns for HotelResource Class
    private static HotelResource hotelResourceSingletonObject = new HotelResource();

    private HotelResource(){

    }

    public static HotelResource getHotelResourceSingletonObject(){
        return hotelResourceSingletonObject;
    }

    private final CustomerService customerService = CustomerService.getSingletonObject();
    private final ReservationService reservationService = ReservationService.getReservationSingletonObject();

    public Customer getCustomer(String email){
        //calling method to get customer from CustomerService class
        return customerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
        //calling method to create a new customer from CustomerService class
        customerService.addCustomer(email,firstName, lastName);
    }

    public IRoom getRoom(String roomNumber){
        //calling method to get room from ReservationService class
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        //calling method to book a room from ReservationService class
        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);

    }

    public Collection<Reservation> getCustomerReservations(String customerEmail){
        //calling method to get customer reservation from ReservationService class
        return reservationService.getCustomerReservation(getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        //method to find room from ReservationService class
        return reservationService.findRooms(checkIn, checkOut);
    }

    public Collection<IRoom> findAlternativeRooms(Date checkIn, Date checkOut){
        return reservationService.lookForAlternativeRooms(checkIn, checkOut);
    }

    public Date addDefaultDays(Date date){
        //adds 7 default days to check for available rooms
        return reservationService.addDays(date);
    }

}
