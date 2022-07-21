package api;

import model.Customer;
import model.IRoom;
import api.HotelResource;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdminResource {

    public static Customer getCustomer(String email) {
        //calling static method from HotelResource class
        HotelResource.getCustomer(email);
        return null;
    }

    public static void addRoom(List<IRoom> rooms){
        for(IRoom room: rooms){
            //calling static method from Reservation class
            ReservationService.addRoom(room);
        }
    }

    public static Collection<IRoom> getAllRooms(){
        Queue<IRoom> allRooms = new LinkedList<>();

        while(!allRooms.isEmpty()){
            System.out.println(allRooms.poll());
        }
        return null;
    }

    public static Collection<Customer> getAllCustomers() {
        //calling static method from CustomerService class
        CustomerService.getAllCustomers();
        return null;
    }

    public static void displayAllReservations(){
        //calling static method from Reservation class
        ReservationService.printAllReservation();
    }
}
