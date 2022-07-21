package api;

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
        return null;
    }

    public static void createACustomer(String email, String firstName, String lastName){
        //calling static method to create a new customer from CustomerService class
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public static IRoom getRoom(String roomNumber){
        //calling static method to get room from ReservationService class
        ReservationService.getARoom(roomNumber);
        return null;
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){

        List<Customer> customer = new ArrayList<>();

        for(Customer customerObject: customer){
            Map<String, Customer> map = new HashMap<>();
            map.put(customerEmail, customerObject);

            if(map.containsKey(customerEmail)){
                //calling static method to book a room from ReservationService class
                ReservationService.reserveARoom(customerObject, room, checkInDate, checkOutDate);
            }
        }
        return null;
    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail){

        List<Customer> customer = new ArrayList<>();

        for(Customer res: customer){
            Map<String, Customer> map = new HashMap<>();
            map.put(customerEmail, res);

            if(map.containsKey(customerEmail)){
                //calling static method to get customer reservation from ReservationService class
                ReservationService.getCustomerReservation(res);
            }
        }
        return null;
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        //static method to find room from ReservationService class
        ReservationService.findRooms(checkIn, checkOut);
        return null;
    }
}
