package api;

import model.Customer;
import model.IRoom;
import api.HotelResource;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class AdminResource {

    public static Customer getCustomer(String email) {
        Customer customer = new Customer(new Customer().getFirstName(), new Customer().getLastName(), email);
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
        Room rooms = new Room(new Room().getRoomNumber(), new Room().getRoomPrice(), new Room().getRoomType());
        allRooms.add(rooms);
        System.out.println("All Rooms: ");
        while(!allRooms.isEmpty()){
            System.out.println(allRooms.poll());
        }
        return allRooms;
    }

    public static Collection<Customer> getAllCustomers() {
        List<Customer> customer = new ArrayList<>();
        Customer newCustomer = new Customer(new Customer().getFirstName(), new Customer().getLastName(), new Customer().getEmail());
        customer.add(newCustomer);
        //calling static method from CustomerService class
        CustomerService.getAllCustomers();
        return customer;
    }

    public static void displayAllReservations(){
        //calling static method from Reservation class
        ReservationService.printAllReservation();
    }
}
