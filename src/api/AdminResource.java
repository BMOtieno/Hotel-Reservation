package api;

import model.Customer;
import model.IRoom;
import api.HotelResource;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class AdminResource {

    public static Customer getCustomer(String email) {
        Customer customer = new Customer();
        //calling static method from HotelResource class
        HotelResource.getCustomer(email);
        return customer;
    }

    public static void addRoom(List<IRoom> rooms){
        for(IRoom room: rooms){
            //calling static method from Reservation class
            ReservationService.addRoom(room);
        }
    }

    public static Collection<IRoom> getAllRooms(){
        Queue<IRoom> allRooms = new LinkedList<>();

        System.out.println("All Rooms: ");
        while(!allRooms.isEmpty()){
            System.out.println(allRooms.poll());
        }
        return allRooms;
    }

    public static Collection<Customer> getAllCustomers() {
        List<Customer> customer = new ArrayList<>();
        //calling static method from CustomerService class
        customer.addAll(CustomerService.getAllCustomers());
        //CustomerService.getAllCustomers();
        return customer;
    }

    public static void displayAllReservations(){
        //calling static method from Reservation class
        ReservationService.printAllReservation();
    }
}
