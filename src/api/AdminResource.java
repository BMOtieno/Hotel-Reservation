package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class AdminResource {
    //Use Singleton Design Patterns for AdminResource Class
    private static AdminResource adminResourceObject = new AdminResource();

    private AdminResource(){

    }
    public static AdminResource getAdminResourceObject(){
        return adminResourceObject;
    }

    private final CustomerService customerService = CustomerService.getSingletonObject();
    private final ReservationService reservationService = ReservationService.getReservationSingletonObject();

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        for(IRoom room: rooms){
            reservationService.addRoom(room);
        }
    }

    public Collection<IRoom> getAllRooms(){
        return reservationService.getAllRooms();
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations(){
        //calling method from Reservation class
        reservationService.printAllReservation();
    }
}
